package com.contest;

import org.junit.Assert;
import org.junit.Test;

import com.contest.abst.AbstractItems;
import com.contest.exception.ExpiredException;

import static org.junit.Assert.assertEquals;

/**
 *@TODO 游戏中的魔法锤道具
 * @date  2019年3月11日 下午7:37:59
 * @author yangshen
 */
public class SulfurasTest {

	@Test
	public void should_keep_the_quality_and_be_valid_forever_when_pass_a_day_one_by_one_given_a_sulfuras() throws ExpiredException{
		
		Item[] items = new Item[] { new Item("Sulfuras", 20, 80) };
		AbstractItems sulfuras = new Sulfuras(items);
		
		for (int i = 0; i < 10; i++) {
			
			sulfuras.updateQuality();
			
			assertEquals(80, (sulfuras.getItems()[0]).quality);
			Assert.assertTrue((sulfuras.getItems()[0]).sellIn>0);
		}
		
	}
}
