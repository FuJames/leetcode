package RemoveDuplicatesFromSortedArray;

/**
 * Author: qianzhong.fu
 * Date: 2014/11/19
 * Time: 11:38
 *
 Given A sorted array, remove the duplicates in place such that each element appear only once
 and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
 For example, Given input array A = [1,1,2],
 Your function should return length = 2, and A is now [1,2]

 */

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length <= 0)
            return 0;
        int i = 0,start = 0, end = 1;
        while(end < A.length){
            if(A[start] == A[end]){
                while(end < A.length && A[start] == A[end])
                    end ++;
                start = end;
                if(end < A.length)
                    A[++i] = A[end++];
            }else{
                A[++i] = A[end++];
                start ++;
            }
        }
        return i+1;
    }
}
