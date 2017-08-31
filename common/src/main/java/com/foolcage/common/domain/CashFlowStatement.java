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
public class CashFlowStatement {
    private String id;
    private Date reportDate;
    private String securityId;
    private String code;
    /*一、经营活动产生的现金流量*/
    //销售商品、提供劳务收到的现金
    private float cashFromSellingCommoditiesOrOfferingLabor;
    // 收到的税费返还
    private float refundOfTaxAndFeeReceived;
    //收到的其他与经营活动有关的现金
    private float cashReceivedRelatingToOtherOperatingActivities;
    //经营活动现金流入小计
    private float subTotalOfCashInflowsFromOperatingActivities;
    //购买商品、接受劳务支付的现金
    private float cashPaidForGoodsAndServices;
    //支付给职工以及为职工支付的现金
    private float cashPaidToAndOnBehalfOfemployees;
    //支付的各项税费
    private float paymentsOfTaxesAndSurcharges;
    //支付的其他与经营活动有关的现金
    private float cashPaidRelatingToOtherOperatingActivities;
    //经营活动现金流出小计
    private float subTotalOfCashOutflowsFromOperatingActivities;
    //经营活动产生的现金流量净额
    private float netCashFlowsFromOperatingActivities;
    /*二、投资活动产生的现金流量*/
    //收回投资所收到的现金
    private float cashReceivedFromDisposalOfInvestments;
    //取得投资收益所收到的现金
    private float cashReceivedFromReturnsOnIvestments;
    //处置固定资产、无形资产和其他长期资产所收回的现金净额
    private float netCashReceivedFromDisposalAssets;
    //处置子公司及其他营业单位收到的现金净额
    private float netCashReceivedFromDisposalSubsidiaries;
    //收到的其他与投资活动有关的现金
    private float cashReceivedFromOtherInvesting;
    //投资活动现金流入小计
    private float subTotalOfCashInflowsFromInvesting;
    //购建固定资产、无形资产和其他长期资产所支付的现金
    private float cashPaidToAcquireFixedAssets;
    //投资所支付的现金
    private float cashPaidToAcquireInvestments;
    //取得子公司及其他营业单位支付的现金净额
    private float netCashPaidToAcquireSubsidiaries;
    //支付的其他与投资活动有关的现金
    private float cashPaidRelatingToOtherInvesting;
    //投资活动现金流出小计
    private float subTotalOfCashOutflowsFromInvesting;
    //投资活动产生的现金流量净额
    private float netCashFlowsFromInvesting;
    /*三、筹资活动产生的现金流量*/
    //吸收投资收到的现金
    private float cashReceivedFromCapitalContributions;
    //其中：子公司吸收少数股东投资收到的现金
    private float cashReceivedFromMinorityShareholdersOfSubsidiaries;
    //取得借款收到的现金
    private float cashReceivedFromBorrowings;
    //发行债券收到的现金
    private float cashReceivedFromIssuingBonds;
    //收到其他与筹资活动有关的现金
    private float cashReceivedRelatingToOtherFinancingActivities;
    //筹资活动现金流入小计
    private float subTotalOfCashInflowsFromFinancingActivities;
    //偿还债务支付的现金
    private float cashRepaymentsOfBorrowings;
    //分配股利、利润或偿付利息所支付的现金
    private float cashPaymentsForInterestExpensesAndDistributionOfDividendsOrProfits;
    //其中：子公司支付给少数股东的股利、利润
    private float cashPaymentsForDividendsOrProfitToMinorityShareholders;
    //支付其他与筹资活动有关的现金
    private float cashPaymentsRelatingToOtherFinancingActivities;
    //筹资活动现金流出小计
    private float subTotalOfCashOutflowsFromFinancingActivities;
    //筹资活动产生的现金流量净额
    private float netCashFlowsFromFinancingActivities;
    /*四、汇率变动对现金及现金等价物的影响*/
    private float effectOfForeignExchangeRate;
    /*五、现金及现金等价物净增加额*/
    private float netIncreaseInCash;
    //加:期初现金及现金等价物余额
    private float cashAtBeginningOfyear;
    /*六、期末现金及现金等价物余额*/
    private float cashAtEndOfyear;
    /*附注*/
    //净利润
    private float netProfit;
    //少数股东权益
    private float minorityStockholderInterest;
    //未确认的投资损失
    private float unrealisedInvestmentLosses;
    //资产减值准备
    private float allowanceForAssetDevaluation;
    //固定资产折旧、油气资产折耗、生产性物资折旧
    private float depreciationOfFixedAssets;
    //无形资产摊销
    private float amorizationOfIntangibleAssets;
    //长期待摊费用摊销
    private float longTermDeferredExpenses;
    //待摊费用的减少
    private float decreaseOfDeferredExpenses;
    //预提费用的增加
    private float IncreaseOfwithholdingExpenses;
    //处置固定资产、无形资产和其他长期资产的损失
    private float lossOnDisposalOfFixedAssets;
    //固定资产报废损失
    private float lossOnFixedAssetsDamaged;
    //公允价值变动损失
    private float lossOnFairValueChange;
    //递延收益增加（减：减少）
    private float changeOnDeferredRevenue;
    //预计负债
    private float estimatedLiabilities;
    //财务费用
    private float financingExpenses;
    //投资损失
    private float investmentLoss;
    //递延所得税资产减少
    private float decreaseOnDeferredIncomeTaxAssets;
    //递延所得税负债增加
    private float increaseOnDeferredIncomeTaxLiabilities;
    //存货的减少
    private float decreaseInInventories;
    //经营性应收项目的减少
    private float decreaseInReceivablesUnderOperatingActivities;
    //经营性应付项目的增加
    private float increaseInReceivablesUnderOperatingActivities;
    //已完工尚未结算款的减少(减:增加)
    private float decreaseOnAmountDue;
    //已结算尚未完工款的增加(减:减少)
    private float increaseOnSettlementNotYetCompleted;
    //其他
    private float other;
    //经营活动产生现金流量净额
    private float netCashFlowFromOperatingActivities;
    //债务转为资本
    private float debtsTransferToCapital;
    //一年内到期的可转换公司债券
    private float oneYearDueConvertibleBonds;
    //融资租入固定资产
    private float financingRentToFixedAsset;
    //现金的期末余额
    private float cashAtTheEndOfPeriod;
    //现金的期初余额
    private float cashAtTheBeginningOfPeriod;
    //现金等价物的期末余额
    private float cashEquivalentsAtTheEndOfPeriod;
    //现金等价物的期初余额
    private float cashEquivalentsAtTheBeginningOfPeriod;
    //现金及现金等价物的净增加额
    private float netIncreaseInCashAndCashEquivalents;
}
