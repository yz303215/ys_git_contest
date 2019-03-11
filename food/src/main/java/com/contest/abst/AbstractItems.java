package com.contest.abst;

import com.contest.Item;

/**
 *@TODO 抽象公共属性
 * @date  2019年3月11日 下午7:42:39
 * @author yangshen
 */
public abstract class AbstractItems implements IUpdateQuality{
	
	protected   Item[] items;
	
	/**
	 * 输出质量和有效期
	 * @param sellIn
	 * @param quality
	 */
	protected void printQualityAndSellIn(int sellIn ,int quality){
		System.out.println("当前商品质量：" + quality+";有效期："+sellIn);
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	
	
}
