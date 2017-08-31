package com.foolcage.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by xuanqi on 17-7-18.
 */
@Getter
@Setter
@NoArgsConstructor
public class IncomeStatement {
    private String id;
    private Date reportDate;
    private String securityId;
    private String code;

    /*营业总收入*/
    //营业收入
    private float operatingRevenue;
    /*营业总成本*/
    private float OperatingTotalCosts;
    //营业成本
    private float OperatingCosts;
    //营业税金及附加
    private float businessTaxesAndSurcharges;
    //销售费用
    private float sellingExpenses;
    //管理费用
    private float ManagingCosts;
    //财务费用
    private float financingExpenses;
    //资产减值损失
    private float assetsDevaluation;
    //公允价值变动收益
    private float incomeFromChangesInFairValue;
    //投资收益
    private float investmentIncome;
    //其中:对联营企业和合营企业的投资收益
    private float investmentIncomeFromRelatedEnterpriseAndJointlyOperating;
    //汇兑收益
    private float exchangeGains;
    /*营业利润*/
    private float salesProfit;
    //加:营业外收入
    private float nonOperatingIncome;
    //减：营业外支出
    private float nonOperatingExpenditure;
    //其中：非流动资产处置损失
    private float disposalLossOnNonCurrentLiability;
    /*利润总额*/
    private float totalProfits;
    //减：所得税费用
    private float incomeTaxExpense;
    /*净利润*/
    private float netProfit;
    //归属于母公司所有者的净利润
    private float netProfitAttributedToParentCompanyOwner;
    //少数股东损益
    private float minorityInterestIncome;
    /*每股收益*/
    //基本每股收益(元/股)
    private float basicEarningsPerShare;
    //稀释每股收益(元/股)
    private float fullyDilutedEarningsPerShare;
    /*其他综合收益*/
    private float otherComprehensiveIncome;
    /*综合收益总额*/
    private float accumulatedOtherComprehensiveIncome;
    //归属于母公司所有者的综合收益总额
    private float attributableToOwnersOfParentCompany;
    //归属于少数股东的综合收益总额
    private float attributableToMinorityShareholders;
}
