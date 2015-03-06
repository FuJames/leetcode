package MedianOfTwoSortedArrays;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/6
 * Time: 16:35
 * 有序数组中查找第K大的元素
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length,lengthB = B.length;
        int k = (lengthA + lengthB) / 2 - 1;
        int i=0,j=0;
        while(true){
            while(i < lengthA && (j == lengthB || A[i] <= B[j])){
                if((i + j) == k)
                    return A[i];
                i++;
            }
            while(j < lengthB && (i == lengthA || B[j] <= A[i])){
                if((i+j) == k)
                    return B[j];
                j++;
            }
        }
    }
}
