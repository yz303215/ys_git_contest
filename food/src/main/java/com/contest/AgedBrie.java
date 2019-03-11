package com.contest;

import com.contest.abst.AbstractItems;
import com.contest.exception.ExpiredException;

/**
 *@TODO "Aged Brie"（法国干酪)
 * @date  2019年3月11日 下午7:10:47
 * @author yangshen
 */
public class AgedBrie  extends AbstractItems{

	
	public AgedBrie(Item[] items) {
		this.items = items;
	}

	/**
	 * `Quality`会每天增1
	 * @throws ExpiredException 
	 */
	@Override
	public void updateQuality() throws ExpiredException {
		
		if (this.items[0].quality<50) {
			this.items[0].quality++;
		}
		
		if (this.items[0].sellIn>1) {
			this.items[0].sellIn--;
		}else {
			throw new ExpiredException();
		}
		
		super.printQualityAndSellIn(this.items[0].sellIn , this.items[0].quality);
	}

	
	/**
	 * 输出产品信息
	 * @param sellIn
	 * @param quality
	 */
/*	private void commodityMessage(int sellIn ,int quality){
		System.out.println("当前商品质量：" + quality+";有效期："+sellIn);
	}
	*/
	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

}
