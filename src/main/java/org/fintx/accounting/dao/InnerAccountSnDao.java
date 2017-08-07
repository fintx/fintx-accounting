package org.fintx.accounting.dao;

import org.fintx.accounting.entity.InnerAccountSn;


/**
 * @author zhangweirong
 *
 */
public interface InnerAccountSnDao {

	/**
	 * 初始插入客户账户序号
	 * 
	 * @param record
	 * @return
	 */
	public int insert(InnerAccountSn record) throws Exception;

	/**
	 * 更新客户账户序号
	 * 
	 * @param custAccount
	 * @throws Exception
	 */
	public void updateCustomer(InnerAccountSn custAccount) throws Exception;
}
