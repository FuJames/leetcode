import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.Stack;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 *
 *  思路：
 *  1、暴力解题：在数组2中，自左向右查找，寻找相同元素，并顺序向右再找到第一个比它大的元素。
 *  int []r = new int[nums1.len]
 *  for i=0;i<nums1.len;i++
 *      int max=0;boolean find=false;
 *      for j=0;j<nums2.len;j++
 *          if(!find && nums2[j] == nums1[i])
 *              find = true;
*           if(find && nums2[j] > nums1[i]){
 *              max = nums2[j];
 *              break;
 *          }
*       r[i] = max;
 *  2、On解题：从左向右找的解法，需要对比右边的每个元素，将思路调整为从右向左找，操作第i个元素的时候，
 *  i元素右边的所有元素都已经比对过，我们可以把已经比对过的元素记录下来（类似回溯思想），记录哪些元素？
 *  题目是寻找比i元素大的第一个元素，或者是第i+1个元素（i+1元素大于i元素），或者是比i+1大的元素之一，
 *  因此，我们只需要记录{第i+1个元素，比i+1元素大的元素}即可。
 *  用什么DS来记录？ 遍历是从右向左的顺序，而结果是从左向右的第一个大的元素，因此是先进后出-栈结构。
 */
public class NextGreaterNumber {
    public static void main(String[] args) {
        int[] nums1=new int[]{4,1,2};int[] nums2=new int[]{5,2,1,7,6,8,10,9,11,0};
//        for(int i :nextGreaterElement(nums1,nums2)){
//            System.out.println(i);
//        }
//        for(int i :nextGreaterElement2(nums2)){
//            System.out.println(i);
//        }
        for(int i :nextGreaterElement3(nums2)){
            System.out.println(i);
        }
    }

    /**
     * 暴力解法(On^2)
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return null;
        }
        if(nums2 == null || nums2.length == 0){
            return null;
        }

        int []r = new int[nums1.length];
        for (int i=0;i<nums1.length;i++){
            int max=-1;boolean find=false;
            for (int j=0;j<nums2.length;j++){
                if(!find && nums2[j] == nums1[i]){
                    find = true;
                }else if(find && nums2[j] > nums1[i]){
                    max = nums2[j];
                    break;
                }
            }
            r[i]=max;
        }
        return r;
    }

    /**
     * On版解法
     * 输入nums数组，如[1,2,4,3]
     * 输出结果数组，第i元素代表nums[i]元素右边第一个比它大的元素值，如果没有填充-1，如[2,4,-1,-1]
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        int []r = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
            //从s中寻找第一个比i元素大的值，即为目标值
            int e = -1;
            while (!s.isEmpty()){
                if(s.peek() > nums[i]){
                    e = s.peek();
                    break;
                }else {
                    s.pop();//只记录比i大的元素
                }
            }
            s.push(nums[i]);
            r[i] = e;
        }
        return r;
    }

    /**
     * 循环数组场景下，
     * {5,2,1,7,6,8,10,9,11,0}->{7,7,7,8,8,10,11,11,-1,5}
     * 循环数据的场景下，不是只看右边，左边的元素也会看。
     * 思路：将原数组翻倍，后面接上原数组，再调用nextGreaterElement2算法即可
     * {5,2,1,7,6,8,10,9,11,0}->{5,2,1,7,6,8,10,9,11,0,5,2,1,7,6,8,10,9,11,0}->从右向左遍历，
     * 注意：结果数组的小标=数组下标i%n
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement3(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int r[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 2*nums.length-1; i >= 0; i--) {
            int j = i%nums.length;//计算翻倍数组i在nums中的索引j
            int e = -1;
            while (!s.isEmpty()){
                if(s.peek() > nums[j]){
                    e = s.peek();
                    break;
                }
                s.pop();
            }
            s.push(nums[j]);
            r[j] = e;
        }
        return r;
    }
}
