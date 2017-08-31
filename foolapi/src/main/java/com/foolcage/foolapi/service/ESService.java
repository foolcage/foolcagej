package com.foolcage.foolapi.service;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;

import java.io.IOException;

/**
 * Created by xuanqi on 17-7-26.
 */
public interface ESService {

    SearchResponse query(String[] indices, String[] types, QueryBuilder queryBuilder);

    void createIndex(String index, String type, String mappingFile) throws IOException;

    void createIndex(String index);
}