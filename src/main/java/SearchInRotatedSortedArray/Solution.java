package SearchInRotatedSortedArray;

/**
 * Author: qianzhong.fu
 * Date: 2014/11/19
 * Time: 11:38
 *
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 分析:
 使用左右游标来进行二分查找，伪代码如下，
 middle在left右边：//注意等于号的情况！
    target数值位于left和middle之间：
        右游标=middle-1
    否则：
        左游标=middle+1
 否则：
    target数值位于middle和right之间：
        左游标=middle+1
    否则：
        右游标=middle-1

 */

public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length < 1)
            return -1;
        int left = 0;
        int right = A.length - 1;
        while(right >= left){
            int middle = (left + right) / 2;
            if(A[middle] == target)
                return middle;
            if(A[middle] >= A[left]){
                if(target >= A[left] && target < A[middle])//等于号很重要
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            else{
                if(target > A[middle] && target <= A[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }
        return -1;
    }
}
