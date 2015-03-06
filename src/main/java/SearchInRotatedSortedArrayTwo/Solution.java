package SearchInRotatedSortedArrayTwo;

/**
 * Author: qianzhong.fu
 * Date: 2014/11/19
 * Time: 11:38
 *
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.

 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 分析：
 有重复存在，不能通过middle>=left来判定middle在哪个区域，分为以下两个判断：
 middle > left:
    继续分
 middle = left：
    left ++;//left向右移动，直到能区分
 */

public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length < 1)
            return false;
        int left = 0;
        int right = A.length - 1;
        while(right >= left){
            int middle = (left + right) / 2;
            if(A[middle] == target)
                return true;
            if(A[middle] > A[left]){
                if(target >= A[left] && target < A[middle])//等于号很重要
                    right = middle - 1;
                else
                    left = middle + 1;
            }else if(A[middle] == A[left])
                left++;
            else{
                if(target > A[middle] && target <= A[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }
        return false;
    }
}
