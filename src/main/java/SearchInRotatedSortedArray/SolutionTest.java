package SearchInRotatedSortedArray;

import junit.framework.TestCase;


/**
 * Author: qianzhong.fu
 * Date: 2015/3/4
 * Time: 10:34
 */
public class SolutionTest extends TestCase {
    Solution solution = new Solution();
    public void testNull(){
        System.out.println(solution.search(null,0));
    }
    public void testEmpty(){
        int a[] = {};
        System.out.println(solution.search(a,0));
    }
    public void testOneNode1(){
        int a[] = {1};
        System.out.println(solution.search(a,0));
    }
    public void testOneNode(){
        int a[] = {1};
        System.out.println(solution.search(a,1));
    }
    public void testTwoNodes(){
        int a[] = {3,1};
        System.out.println(solution.search(a,0));
    }
    public void testTwoNodes2(){
        int a[] = {1,2};
        System.out.println(solution.search(a,1));
    }
    public void testMultipleNodes(){
        int a[] = {4,5,6,7,8,0,1,2,3};
        System.out.println(solution.search(a,3));
    }

}
