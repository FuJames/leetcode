package RemoveDuplicatesFromSortedArray;

import junit.framework.TestCase;


/**
 * Author: qianzhong.fu
 * Date: 2015/3/4
 * Time: 10:34
 */
public class SolutionTest extends TestCase {
    Solution solution = new Solution();
    public void testNull(){
        solution.removeDuplicates(null);
    }
    public void testOneNode(){
        int a[] = {1};
        int length = solution.removeDuplicates(a);
        printArray(a,length);
    }
    public void testTwoNodes(){
        int a[] = {1,1};
        int length = solution.removeDuplicates(a);
        printArray(a,length);
    }
    public void testMultipleNodes(){
        int a[] = {1,1,1,1,2,3};
        int length = solution.removeDuplicates(a);
        printArray(a,length);
    }
    public void testThreeDifferentNodes(){
        int a[] = {1,2,3};
        int length = solution.removeDuplicates(a);
        printArray(a,length);
    }
    public void printArray(int a[],int start){
        for(int i = 0;i < start;i++)
            System.out.println(a[i]);
    }
}
