package com.contest;

import com.contest.abst.AbstractItems;
import com.contest.exception.ExpiredException;

/**
 *@TODO 永不到期，也不会降低品质
 * @date  2019年3月11日 下午7:41:07
 * @author yangshen
 */
public class Sulfuras extends AbstractItems {

	public Sulfuras(Item[] items) {
		this.items = items;
	}

	@Override
	public void updateQuality() throws ExpiredException {
		
		this.printQualityAndSellIn(items[0].sellIn, items[0].quality);
	}

	@Override
	protected void printQualityAndSellIn(int sellIn, int quality) {
		// TODO Auto-generated method stub
		System.out.println("当前商品质量：" + 80+";有效期：无期限");
	}

}
