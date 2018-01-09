package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 * For example, 
 * Given the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 4, 5, 6 ],
 * 	[ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5]
 */

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> output = new ArrayList<Integer>();
    	if (matrix.length == 0)
    		return output;
    	
    	int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
    	int dir = 0;
    	while (top <= bottom && left <= right) {
    		switch(dir) {
    		case 0:
    			for(int i = left; i <= right; i++) {
    				output.add(matrix[top][i]);
    			}
    			top++;
    			dir = 1;
    			break;
    			
    		case 1:
    			for(int i = top; i <= bottom; i++) {
    				output.add(matrix[i][right]);
    			}
    			right--;
    			dir = 2;
    			break;
    			
    		case 2:
    			for (int i = right; i >= left; i--) {
    				output.add(matrix[bottom][i]);
    			}
    			bottom--;
    			dir = 3;
    			break;
    			
    		case 3:
    			for (int i = bottom; i >= top; i--) {
    				output.add(matrix[i][left]);
    			}
    			left++;
    			dir = 0;
    			break;
    		}
    	}
        return output;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {
			{2, 3, 4}
		};
		
		List<Integer> output = spiralOrder(matrix);
		for(int number: output) {
			System.out.println(number);
		}
	}

}
