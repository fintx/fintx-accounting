package org.fintx.accounting.dao;

import java.util.Map;

import org.fintx.accounting.entity.TransactionEntry;


public interface TransactionEntryDao {
    int save(TransactionEntry record);

    int recordDetailAccount(Map<String, Object> map);

//    /*
//     * 计算日间流水中的借贷金额和和借贷笔数
//     */
//    List<TransactionEntry> calculateByAcctTitleCode(@Param("txnDate") String txnDate);
//
//    /*
//     * 比较日间流水中的账号的借贷发生额 和 分组账中的借贷发生额
//     */
//    List<TransactionEntry> differDetailDrCrAmtFromAcctDrCrAmt(@Param("acctTitleCode") String acctTitleCode, @Param("txnDate") String txnDate,
//            @Param("acctNo") String acctNo);
//
//    /*
//     * 生成流水表：判断表名是否存在
//     */
//    String getTableName(@Param("tableName") String tableName);
//
//    /*
//     * 如果生成表名存在：则删除该表
//     */
//    void dropTabelName(@Param("tableName") String tableName);
//
//    /**
//     * 交易查询，确认
//     * 
//     * @param mapkey :txnDate,channelBizSN
//     * @return
//     */
//    List<TransactionEntry> selectDetailByDateAndBizSn(Map<String, String> map);
//
//    /**
//     * 交易流水查询
//     * 
//     * @param paramMap
//     * @return
//     */
//    List<Map<String, Object>> selectDetailByParam(Map<String, Object> paramMap);
//
//    int selectDetailSizeByParam(Map<String, Object> paramMap);
//
//    /**
//     * 账号交易流水查询-按科目及账号（用于银行-商户）
//     * 
//     * @param paramMap
//     * @return
//     */
//    List<Map<String, Object>> selectAcctTitleCodeDatailByParam(Map<String, Object> paramMap);
//
//    int selectAcctTitleCodeDatailByParamSize(Map<String, Object> paramMap);
//
//    /**
//     * 科目交易流水查询-按科目
//     * 
//     * @param paramMap
//     * @return
//     */
//    List<Map<String, Object>> queryDetByAcctTitleCode(Map<String, Object> paramMap);
//
//    /**
//     * 科目交易流水查询数目-按科目-用于分页
//     * 
//     * @param paramMap
//     * @return
//     */
//    int queryDetSizeByAcctTitleCode(Map<String, Object> paramMap);
//
//    /**
//     * 分录流水科目1查询
//     * 
//     * @param paramMap
//     * @return
//     */
//    List<Map<String, Object>> querydrAcctCode(Map<String, Object> paramMap);
//
//    /**
//     * 分录流水科目2查询
//     * 
//     * @param paramMap
//     * @return
//     */
//    List<Map<String, Object>> querycrAcctCode(Map<String, Object> paramMap);
//
//    /**
//     * 分录流水查询数目-数量-用于分页
//     * 
//     * @param paramMap
//     * @return
//     */
//    int queryTxnCodeSize(Map<String, Object> paramMap);
}
