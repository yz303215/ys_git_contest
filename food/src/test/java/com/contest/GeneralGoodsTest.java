package com.contest;

import org.junit.Test;

import com.contest.abst.AbstractItems;
import com.contest.exception.ExpiredException;

/**
 *@TODO 普通商品一旦销售期限过期，品质值`Quality`会每天减2；
 * @date  2019年3月11日 下午8:31:14
 * @author yangshen
 */
public class GeneralGoodsTest {
	
	@Test
	public void should_reduce_two_qualitys_when_pass_a_day_given_a_generalgoods() throws ExpiredException{
		Item[] items = new Item[] { new Item("BackstagePasses", 20, 20) };
		AbstractItems generalgoods = new GeneralGoods(items);
		generalgoods.updateQuality();
	}
}
