package com.contest;

import static org.junit.Assert.assertEquals;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.Assert;
import org.junit.Test;

import com.contest.exception.ExpiredException;

/**
 *@TODO 剧场后台通行证
 * @date  2019年3月11日 下午7:59:44
 * @author yangshen
 */
@SuppressWarnings("unused")
public class BackstagePassesTest {
	
	@Test
	public void should_add_one_quality_before_tendays_when_pass_a_day_given_backstagepasses() throws ExpiredException{
		
		Item[] items = new Item[] { new Item("BackstagePasses", 20, 20) };
		BackstagePasses  backstagePasses = new BackstagePasses(items);
		
		int quality = 20;
		int sellIn = 20;
		for (int i = 0; i < 5; i++) {
			backstagePasses.updateQualityBeforeTendays();
			++quality;
			--sellIn;
			assertEquals(quality, (backstagePasses.getItems()[0]).quality);
			assertEquals(sellIn, (backstagePasses.getItems()[0]).sellIn);
		}
	}
	
	@Test
	public void  should_add_two_qualitys_between_fivedays_and_tendays_when_pass_a_day_given_backstagepasses(){
		
		Item[] items = new Item[] { new Item("BackstagePasses", 8, 8) };
		BackstagePasses  backstagePasses = new BackstagePasses(items);
		
		int quality = 8;
		int sellIn = 8;
		for (int i = 0; i < 5; i++) {
			backstagePasses.updateQualityBetweenTenAndFiveDays();
			quality += 2;
			--sellIn;
			assertEquals(quality, (backstagePasses.getItems()[0]).quality);
			assertEquals(sellIn, (backstagePasses.getItems()[0]).sellIn);
		}
	}
	
	@Test
	public void  should_add_three_qualitys_between_onedays_and_fivedays_when_pass_a_day_given_backstagepasses(){
		Item[] items = new Item[] { new Item("BackstagePasses", 5, 5) };
		BackstagePasses  backstagePasses = new BackstagePasses(items);
		
		int quality = 5;
		int sellIn = 5;
		for (int i = 0; i < 5; i++) {
			backstagePasses.updateQualityBetweenFiveAndOneDays();
			quality += 3 ;
			--sellIn;
			assertEquals(quality, (backstagePasses.getItems()[0]).quality);
			assertEquals(sellIn, (backstagePasses.getItems()[0]).sellIn);
		}
	}
	
	@Test
	public void  should_invalid_when_expired_given_backstagepasses() throws ExpiredException{
		Item[] items = new Item[] { new Item("BackstagePasses", 1, 1) };
		BackstagePasses  backstagePasses = new BackstagePasses(items);
		try {
			
			backstagePasses.updateQualityAfterTheShow();
		} catch (ExpiredException e) {
		}
	}
	
	}