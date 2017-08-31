package com.foolcage.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class FinancialIndicator implements Serializable {
    private String id;
    private Date reportDate;
    private String securityId;
    private String code;

    //摊薄每股收益(元)
    private float dilutedEps;
    //加权每股收益(元)
    private float eps;
    //每股收益_调整后(元)
    private float adjustedEps;
    //扣除非经常性损益后的每股收益(元)
    private float excludeExtraEps;
    //每股净资产_调整前(元)
    private float bps;
    //每股净资产_调整后(元)
    private float adjustedBps;
    //每股经营性现金流(元)
    private float opCashFlowPerShare;
    //每股资本公积金(元)
    private float capitalReservePerShare;
    //每股未分配利润(元)
    private float retainedEarningsPerShare;

    //总资产利润率(%)
    private float returnOnTotalAssetsRatio;

    //主营业务利润率(%)
    private float OPE;
    //总资产净利润率(%)
    private float profitRateToNetWorth;

    //成本费用利润率(%)
    private float ratioOfProfitsToCost;
    //营业利润率(%)
    private float operatingProfitRatio;
    //主营业务成本率(%)
    private float primeOperatingCostRatio;
    //销售净利率(%)
    private float netProfitRate;
    //股本报酬率(%)
    private float returnOnEquity;
    //净资产报酬率(%)
    private float RONA;

    //资产报酬率(%)
    private float ROA;
    //销售毛利率(%)
    private float grossMargin;
    //三项费用比重
    private float threeCostRatio;
    //非主营比重
    private float nonCoreRatio;
    //主营利润比重
    private float coreProfitRatio;
    //股息发放率(%)
    private float dividendPayoutRatio;

    //投资收益率(%)
    private float ROI;
    //主营业务利润(元)
    private float incomeFromMainOperation;

    //净资产收益率(%)
    private float rawROE;
    //加权净资产收益率(%)
    private float ROE;
    //扣除非经常性损益后的净利润(元)
    private float netProfitExcludeExtra;


    //主营业务收入增长率(%)
    private float icreaseRateOfMainBusinessRevenue;
    //净利润增长率(%)
    private float netProfitGrowthRate;

    //净资产增长率(%)
    private float netAssetsGrowthRate;

    //总资产增长率(%)
    private float totalAssetsGrowthRate;


    //应收账款周转率(次)
    private float receivablesTurnoverRatio;

    //应收账款周转天数(天)
    private float averageCollectionPeriod;

    //存货周转天数(天)
    private float daysSalesOfInventory;
    //存货周转率(次)
    private float inventoryTurnoverRatio;
    //固定资产周转率(次)
    private float fixedAssetsTurnover;

    //总资产周转率(次)
    private float totalAssetsTurnover;

    //总资产周转天数(天)
    private float totalAssetsTurnoverDays;

    //流动资产周转率(次)
    private float currentAssetsTurnover;

    //流动资产周转天数(天)
    private float currentAssetsTurnoverDays;

    //股东权益周转率(次)
    private float equityTurnover;

    //偿债及资本结构
    //流动比率
    private float currentRatio;
    //速动比率
    private float acidTestRatio;

    //现金比率(%)
    private float cashRatio;
    //利息支付倍数
    private float interestCoverageRatio;

    //长期债务与营运资金比率(%)
    private float longTermDebtToWorkingCapitalRatio;

    //股东权益比率(%)
    private float equityRatio;

    //长期负债比率(%)
    private float longTermLiabilityRate;

    //股东权益与固定资产比率(%)
    private float equityToFixedAssetsRatio;

    //负债与所有者权益比率(%)
    private float debtToEquityRatio;

    //长期资产与长期资金比率(%)
    private float fixedAssetsToPermanentCapitalRatio;

    //资本化比率(%)
    private float capitalizationRates;

    //固定资产净值率(%)
    private float fixedAssetsNetValue;

    //资本固定化比率(%)
    private float capitalFixedRate;

    //产权比率(%)
    private float propertyRatio;

    //清算价值比率(%)
    private float liquidationRatio;

    //固定资产比重(%)
    private float fixedAssetsRatio;

    //资产负债率(%)
    private float debtAssetRatio;

    //总资产(元)
    private float totalAssets;

    //现金流量
    //经营现金净流量对销售收入比率(%)
    private float operatingCashFlowToSalesRevenueRatio;


    //资产的经营现金流量回报率(%)
    private float CashFlowReturnOnInvestment;

    //经营现金净流量与净利润的比率(%)
    private float cashToNetProfitRatio;

    //经营现金净流量对负债比率(%)
    private float cashCoverageRatio;

    //现金流量比率(%)
    private float operatingCashFlowRatio;

    //其他指标
    //短期股票投资(元)
    private float shortTermStockInvestment;

    //短期债券投资(元)	
    private float shortTermBondInvestment;

    //短期其它经营性投资(元)	
    private float shortTermOtherOperatingInvestment;

    //长期股票投资(元)
    private float longTermStockInvestment;

    //长期债券投资(元)
    private float longTermBondInvestment;


    //长期其它经营性投资(元)
    private float longTermOtherOperatingInvestment;

    //x_y年以内应收帐款(元)
    private float accountsReceivable1;
    private float accountsReceivable1_2;
    private float accountsReceivable2_3;
    private float accountsReceivable3;

    //x_y年以内预付货款(元)
    private float advancePayment1;
    private float advancePayment1_2;
    private float advancePayment2_3;
    private float advancePayment3;

    //x_y年以内其它应收款(元)
    private float otherReceivable1;
    private float otherReceivable1_2;
    private float otherReceivable2_3;
    private float otherReceivable3;
}
