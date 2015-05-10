package org.leetcode.main;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BestTimetoBuyandSellStockIII {
	//这个可以应用到I中
	public int maxProfit(int[] prices) {
		int buy0 = Integer.MIN_VALUE, buy1 = Integer.MIN_VALUE;
		int sell0 = 0, sell1 = 0;
		for (int price : prices) {
			sell1 = Math.max(sell1, buy1 + price);
			buy1 = Math.max(buy1, sell0 - price);
			sell0 = Math.max(sell0, buy0 + price);
			buy0 = Math.max(buy0, -price);
		}
		return sell1;
	}

}
