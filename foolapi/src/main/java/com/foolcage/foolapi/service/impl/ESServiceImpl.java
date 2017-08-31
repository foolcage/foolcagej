package com.foolcage.foolapi.service.impl;

import com.foolcage.foolapi.service.ESService;
import org.apache.commons.io.IOUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xuanqi on 17-7-26.
 */
@Service
public class ESServiceImpl implements ESService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ESServiceImpl.class);

    private TransportClient client;

    private IndicesAdminClient indicesAdminClient;

    public ESServiceImpl() {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
            indicesAdminClient = client.admin().indices();
        } catch (UnknownHostException e) {
            LOGGER.error("could not init es client");
        }
    }

    @Override
    public SearchResponse query(String[] indices, String[] types, QueryBuilder queryBuilder) {
        return client.prepareSearch(indices).setTypes(types).setQuery(queryBuilder).get();
    }

    @Override
    public void createIndex(String index) {
        client.admin().indices().prepareCreate(index).get();
    }

    public void createIndex(String index, String type, String mappingFile) throws IOException {
        CreateIndexRequestBuilder createIndexRequestBuilder = indicesAdminClient.prepareCreate(index);
        String jsonString = IOUtils.toString(this.getClass()
                .getResourceAsStream(mappingFile));

        LOGGER.info("mapping:{}", jsonString);

        createIndexRequestBuilder.addMapping(type, jsonString);

        CreateIndexResponse indexResponse = createIndexRequestBuilder.execute().actionGet();

        LOGGER.info("createIndex:" + indexResponse.isAcknowledged());
    }

    public static void main(String[] args) {
        ESServiceImpl esService = new ESServiceImpl();
        try {
            esService.createIndex("test", "stock", "/mapping/stock.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
