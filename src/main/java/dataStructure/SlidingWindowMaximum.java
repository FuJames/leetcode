package dataStructure;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int n[] = new int[]{-7,-8,7,5,7,1,6,0};//[7,7,7,7,7]
        int k = 4;
        for(int i : maxSlidingWindow(n,k)){
            System.out.println(i);
        }
    }

    /**
     * 使用单调队列来实现On时间复杂度，
     * 单调队列：首先是个队列，且队列中的元素是单调递增或递减；每步操作通过删除队列中的元素来实现单调性；
     * 伪代码：
     * 插入一个元素时，删除掉比此元素小的元素（减少比对次数），队列从头至尾是单调递减的。
     * pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
     * push(value)：如果push的元素value大于队列尾部的元素，那么就将队列尾部的元素弹出，直到队列里的元素都不小于value
     * @param nums
     * @param k
     * @return
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(k<=0||k>nums.length){
            return null;
        }
        int r[] = new int[nums.length-k+1];//总共结果数量
        LinkedList<Integer> q = new LinkedList<>();
        //将前k-1个数字先压到单调队列中，队列从头到尾是单调递减的
        for (int i = 0; i < k-1; i++) {
            pushBack(q,nums[i]);
        }
        for (int j = k-1; j < nums.length; j++) {
            int index = j-(k-1);
            pushBack(q,nums[j]);
            r[index] = max(q);
            popElement(q,nums[j-k+1]);
        }
        return r;

    }
    private static void pushBack(LinkedList<Integer> q,Integer e){
        //删除比e小的元素，从后向前遍历
        while (!q.isEmpty()){
            if(q.getLast()<e){//注意此处不是<=
                q.removeLast();
            }else {
                break;
            }
        }
        q.offer(e);
    }
    private static void popElement(LinkedList<Integer> q,Integer e){
        //删除e元素
        if(q.getFirst().equals(e)){
            q.removeFirst();
        }
    }
    private static Integer max(LinkedList<Integer> q){
        return q.getFirst();
    }
}
