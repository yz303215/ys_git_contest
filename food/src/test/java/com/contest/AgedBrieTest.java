package com.contest;

import junit.framework.Assert;

import org.junit.Test;

import com.contest.abst.AbstractItems;
import com.contest.exception.ExpiredException;

import static org.junit.Assert.assertEquals;

/**
 *@TODO "Aged Brie"（法国干酪）
 * @date  2019年3月11日 下午7:06:19
 * @author yangshen
 */
@SuppressWarnings("deprecation")
public class AgedBrieTest {
	@Test
	public void should_add_one_quality_when_pass_a_day_given_agedbrie() throws ExpiredException{
		
		Item[] items = new Item[] { new Item("AgedBrie", 20, 20) };
		AbstractItems agedBrie = new AgedBrie(items);
		int sellIn = 20;
		int quality = 20;
		
		for (int i = 0; i < 10; i++) {
			
			agedBrie.updateQuality();
			
			assertEquals(--sellIn, (agedBrie.getItems()[0]).sellIn);
			assertEquals(++quality, (agedBrie.getItems()[0]).quality);
			Assert.assertTrue((agedBrie.getItems()[0]).quality<=50);
			Assert.assertTrue((agedBrie.getItems()[0]).sellIn>-1);
		}
		
	}
}
