package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> elementSet = new HashSet<Integer>();
    	Set<Integer> commonElements = new HashSet<Integer>();
    	
    	for (int i = 0; i < nums1.length; i++) {
    		elementSet.add(nums1[i]);
    	}
    	for(int i = 0; i < nums2.length; i++) {
    		if (elementSet.contains(nums2[i])) {
    			commonElements.add(nums2[i]);
    		}
    	}
    	int[] result = new int[commonElements.size()];
    	int i = 0;
    	for(Integer element: commonElements) {
    		result[i++] = element;
    	}
    	
        return result;
    }
    
}
