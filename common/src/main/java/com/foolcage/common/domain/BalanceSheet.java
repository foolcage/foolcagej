package com.foolcage.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by xuanqi on 17-7-14.
 */
@Getter
@Setter
@NoArgsConstructor
public class BalanceSheet {
    private String id;
    private Date reportDate;
    private String securityId;
    private String code;
    //货币资金
    private float moneyFunds;
    //交易性金融资产
    private float heldForTradingFinancialAssets;
    //衍生金融资产
    private float derivative;
    //应收票据
    private float billsReceivable;
    //应收账款
    private float accountsReceivable;
    //预付款项
    private float prepaidAccounts;
    //应收利息
    private float interestReceivable;
    //应收股利
    private float dividendReceivable;
    //其他应收款
    private float otherReceivables;

    //买入返售金融资产
    private float buyingBackTheSaleOfFinancialAssets;
    //存货
    private float inventory;
    //划分为持有待售的资产
    private float assetsForSale;
    //一年内到期的非流动资产
    private float nonCurrentAssetsDueWithinOneYear;

    //待摊费用
    private float unamortizedExpenditures;
    //待处理流动资产损益
    private float waitDealIntangibleAssetsLossOrIncome;

    //其他流动资产
    private float otherCurrentAssets;
    //流动资产合计
    private float totalCurrentAssets;

    //非流动资产

    //发放贷款及垫款
    private float loansAndPaymentsOnBehalf;

    //可供出售金融资产
    private float availableForSaleFinancialAssets;
    //持有至到期投资
    private float heldToMaturityInvestment;
    //长期应收款
    private float longTermReceivables;
    //长期股权投资
    private float longTermEquityInvestment;
    //投资性房地产
    private float investmentRealEstate;
    //固定资产净额
    private float NetfixedAssets;
    //在建工程
    private float constructionInProcess;
    //工程物资
    private float engineerMaterial;
    //固定资产清理
    private float fixedAssetsInLiquidation;
    //生产性生物资产
    private float productiveBiologicalAssets;
    //公益性生物资产
    private float nonProfitLivingAssets;
    //油气资产
    private float oilAndGasAssets;
    //无形资产
    private float intangibleAssets;
    //开发支出
    private float developmentExpenditure;
    //商誉
    private float goodwill;
    //长期待摊费用
    private float longTermDeferredExpenses;
    //递延所得税资产
    private float deferredIncomeTaxAssets;
    //其他非流动资产
    private float OtherNonCurrentAssets;
    //非流动资产合计
    private float nonCurrentAssets;
    //资产总计
    private float totalAssets;

    /*流动负债*/
    //短期借款
    private float shortTermBorrowing;
    //交易性金融负债
    private float transactionFinancialLiabilities;
    //应付票据
    private float billsPayable;
    //应付账款
    private float accountsPayable;
    //预收款项
    private float accountsReceivedInAdvance;
    //应付手续费及佣金
    private float handlingChargesAndCommissionsPayable;
    //应付职工薪酬
    private float employeeBenefitsPayable;
    //应交税费
    private float taxesAndSurchargesPayable;
    //应付利息
    private float interestPayable;
    //应付股利
    private float dividendpayable;
    //其他应付款
    private float otherPayables;
    //预提费用
    private float withholdingExpenses;
    //一年内的递延收益
    private float deferredIncomeWithinOneYear;
    //应付短期债券
    private float shortTermDebenturesPayable;
    //一年内到期的非流动负债
    private float nonCurrentLiabilitiesMaturingWithinOneYear;
    //其他流动负债
    private float otherCurrentLiability;
    //流动负债合计
    private float totalCurrentLiabilities;

    /*非流动负债*/
    //长期借款
    private float LongTermBorrowing;
    //应付债券
    private float bondPayable;
    //长期应付款
    private float longTermPayables;
    //长期应付职工薪酬
    private float longTermEmployeeBenefitsPayable;
    //专项应付款
    private float specialPayable;
    //预计非流动负债
    private float expectedNonCurrentLiabilities;
    //递延所得税负债
    private float deferredIncomeTaxLiabilities;
    //长期递延收益
    private float longTermDeferredRevenue;
    //其他非流动负债
    private float otherNonCurrentLiabilities;
    //非流动负债合计
    private float totalNonCurrentLiabilities;
    //负债合计
    private float totalLiabilities;

    /*所有者权益*/
    //实收资本(或股本)
    private float registeredCapital;

    //资本公积
    private float capitalSurplus;
    //减：库存股
    private float treasuryStock;
    //其他综合收益
    private float otherComprehensiveIncome;
    //专项储备
    private float theSpecialReserve;

    //盈余公积
    private float surplusReserves;
    //一般风险准备
    private float generalRiskPreparation;
    //未分配利润
    private float undistributedProfits;
    //归属于母公司股东权益合计
    private float consolidatedIncomeBelongingToParentCompany;

    //少数股东权益
    private float minorityStockholderInterest;

    //所有者权益(或股东权益)合计
    private float totalInvestorsEquity;

    //负债和所有者权益(或股东权益)总计
    private float totalLiabilitiesAndOwnersEquity;
}
