package math;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //解题一：暴力解法，计算每根柱子的面积，取最大值；x取差值最大，y取2个y值中最小的
//        int max = 0;
//        for(int i = 0 ; i < height.length ; i ++){
//            for(int j = i+1 ; j < height.length ; j ++){
//                max = Math.max(max, Math.min(height[i], height[j])*(j-i));
//            }
//        }
//        return max;
        //解题二：双指针法，面积取决于
        //1. x差值最大 2. y值中较小的限制了面积大小
        //思路：双指针指向最左和最右的柱子，此时x差值最大，比较y值，固定y值较大的柱子，移动y值较小的柱子，直到左右指针相遇
        //why固定y值较大的柱子？ 因为x值是不断缩小的，如果固定y值较小的柱子，那么影响面积的y值只会不变或更小，导致x*y更小
        int max = 0, i = 0, j = height.length - 1;
        while (i < j){
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            if(height[i] <= height[j]){
                i ++;
            }else {
                j --;
            }
        }
        return max;
    }
}
