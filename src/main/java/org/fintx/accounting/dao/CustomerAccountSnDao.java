package org.fintx.accounting.dao;

import org.fintx.accounting.entity.CustomerAccountSn;

/**
 * @author zhangweirong
 *
 */
public interface CustomerAccountSnDao {

	/**
	 * 初始插入客户账户序号
	 * 
	 * @param record
	 * @return
	 */
	public int insert(CustomerAccountSn record) throws Exception;

	/**
	 * 更新客户账户序号
	 * 
	 * @param custAccount
	 * @throws Exception
	 */
	public void updateCustomer(CustomerAccountSn custAccount) throws Exception;
}
