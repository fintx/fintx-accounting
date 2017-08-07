package org.fintx.accounting.dao;

import org.fintx.accounting.entity.InnerAccountNo;


/**
 * <p>
 * 内部账户Service。
 * <p>
 *
 * 创建日期 2015年9月10日<br>
 * 
 * @author 刘俊(wop_liu@163.com) <br>
 */
public interface InnerAccountNoDao {
    int insert(InnerAccountNo record);

    /**
     * 返回内部账户信息
     * 
     * @param orgNo 机构码
     * @param acctTi 科目号
     * @return
     */
    public InnerAccountNo selectInnerByOrgCodeAndAcctTi(String orgCode, String acctTi, String productNo);

    /**
     * inner exist ?>=1
     * 
     * @param orgCode
     * @param productNo
     * @return
     */
    public int countInnerByOrgCodeAndProductNo(String orgCode, String productNo);
}
