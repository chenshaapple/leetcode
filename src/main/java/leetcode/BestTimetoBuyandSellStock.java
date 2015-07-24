package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int price : prices) {
            sell = Math.max(sell, buy + price);
            buy = Math.max(buy, -price);
        }
        return sell;
	}
	
	/**
	 * �������п��ܵ�����ʱ��
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		int buy = Integer.MIN_VALUE, sell = 0;
		for(int price : prices) {
			sell = Math.max(sell, buy + sell);
			buy = Math.max(buy, -price);
		}
		return sell;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
