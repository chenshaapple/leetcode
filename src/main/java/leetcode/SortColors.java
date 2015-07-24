package leetcode;

public class SortColors {
    public void sortColors(int[] A) {
    	int[] colorCount = new int[3];
    	for(int color : A) {
    		colorCount[color]++;
    	}
    	colorCount[1] += colorCount[0];
    	colorCount[2] += colorCount[1];
    	for(int color = 0, index = 0; color < colorCount.length; color++) {
    		for(; index < colorCount[color]; index++) {
    			A[index] = color;
    		}
    	}
    }
}
