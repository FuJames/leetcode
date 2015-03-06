package MedianOfTwoSortedArrays;

import junit.framework.TestCase;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/4
 * Time: 10:34
 */
public class SolutionTest extends TestCase {
    Solution solution = new Solution();
    public void testTheK() {
        int a[] = {1};
        int b[] = {5,6,7,8};
        System.out.println(solution.findMedianSortedArrays(a,b));
    }
}
