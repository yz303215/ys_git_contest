package com.contest;

import com.contest.abst.AbstractItems;
import com.contest.exception.ExpiredException;

/**
 *@TODO
 * @date  2019年3月11日 下午8:55:49
 * @author yangshen
 */
public class GeneralGoods  extends AbstractItems{

	public GeneralGoods(Item[] items) {
		  this.items = items;
	}

	@Override
	public void updateQuality() throws ExpiredException {
		
		if (this.items[0].quality<50) {
			this.items[0].quality++;
		}
		
		if (this.items[0].sellIn>1) {
			this.items[0].sellIn--;
		}else if(this.items[0].sellIn==0 && this.items[0].quality>2){
			this.items[0].quality = this.items[0].quality -2;
		}else if(this.items[0].sellIn==0 && this.items[0].quality>0){
			this.items[0].quality =0;
		}
		
		super.printQualityAndSellIn(this.items[0].sellIn , this.items[0].quality);
		
	}

}
