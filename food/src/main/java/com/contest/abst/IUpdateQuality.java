package com.contest.abst;

import com.contest.exception.ExpiredException;

/**
 *@TODO
 * @date  2019年3月11日 下午7:44:14
 * @author yangshen
 */
public interface IUpdateQuality {
	
	/**
	 * 根据商品特性更新产品价值和销售有效期
	 * @throws ExpiredException
	 */
	void updateQuality() throws ExpiredException;
	
}
