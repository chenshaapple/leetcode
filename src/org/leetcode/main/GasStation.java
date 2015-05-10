package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    		int size = gas.length;
        for(int start = 0; start < size; ) {
        		boolean isBack = true;
        		int tank = 0;
        		for(int step = 0; step < size; step++) {
        			tank += (gas[(start + step) % size] - cost[(start + step) % size]);
        			if(tank < 0) {
        				isBack = false;
        				start += Math.max(1, step);
        				break;
        			}
        		}
        		if(isBack) {
        			return start;
        		}
        }
    		return -1;
    }
    
    //it is not correct
    public int canCompleteCircuitGreedy(int[] gas, int[] cost) {
    		int opt = -1, maxGas = Integer.MIN_VALUE;
    		int size = gas.length;
			for(int i = 0; i < size; i++) {
    			maxGas = Math.max(maxGas, gas[i] - cost[i]);
    			opt = i;
    		}
    		int tank = gas[opt];
    		for(int i = 1; i < size; i++) {
    			if(tank < cost[(opt + i - 1) % size]) {
    				return - 1;
    			}
    			tank += (gas[(opt + i) % size] - cost[(opt + i - 1) % size]);
    		}
    		return opt;
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
