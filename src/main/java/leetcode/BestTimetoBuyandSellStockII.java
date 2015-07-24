package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimetoBuyandSellStockII {
	public int maxProfit2(int[] prices) {
		int buy = Integer.MAX_VALUE, sell = 0;
		for(int price : prices) {
			if(price > buy) sell += price - buy;
			buy = price;
		}
		return sell;
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
