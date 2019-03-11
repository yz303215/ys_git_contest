package com.contest;

import com.contest.abst.AbstractItems;
import com.contest.exception.ExpiredException;

/**
 *@TODO 剧场后台通行证
 * @date  2019年3月11日 下午8:07:27
 * @author yangshen
 */
public class BackstagePasses extends AbstractItems {

	public BackstagePasses(Item[] items) {
		this.items = items;
	}

	@Override
	public void updateQuality() throws ExpiredException {
		
		if (items[0].sellIn>10) {
			updateQualityBeforeTendays();
			
		}else if( items[0].sellIn>5  &&  (items[0].sellIn)<=10){
			updateQualityBetweenTenAndFiveDays();
			
		}else if (items[0].sellIn>0  &&  (items[0].sellIn)<=5) {
			updateQualityBetweenFiveAndOneDays();
			
		}else {
			updateQualityAfterTheShow();
			
		}
		
	}
	
	/**
	 * `Quality`在剧场开演前10天以外，每天增1
	 */
	public void updateQualityBeforeTendays(){
		
		if (items[0].quality < 50) {
			items[0].quality++;
		}else {
			items[0].quality = 50;
		}
		
		items[0].sellIn--;
		
		printQualityAndSellIn(items[0].sellIn, items[0].quality);
	}

	/**
	 * 当离开演不足10天（含10天）时，品质`Quality`每天增2
	 */
	public void updateQualityBetweenTenAndFiveDays(){
		
		if (items[0].quality<48) {
			items[0].quality += 2;
		}else {
			items[0].quality += 2;
		}
		
		items[0].sellIn -- ;
		
		printQualityAndSellIn(items[0].sellIn,  items[0].quality);
	}
	
	/**
	 * 当离开演不足5天（含5天）时，品质`Quality`每天增3
	 */
	public void updateQualityBetweenFiveAndOneDays(){
		
		if (items[0].quality<46) {
			items[0].quality += 3;
		}else {
			items[0].quality  = 50;
		}
		
		items[0].sellIn --;
		
		printQualityAndSellIn(items[0].sellIn,  items[0].quality);
		
	}
	
	/**
	 * 但一旦演出结束，品质就会降为0
	 * @throws ExpiredException 
	 */
	public void updateQualityAfterTheShow() throws ExpiredException{
		
		items[0].sellIn=0;
		items[0].quality=0;
		printQualityAndSellIn(items[0].sellIn,  items[0].quality);
		
		throw new ExpiredException();
	}
}
