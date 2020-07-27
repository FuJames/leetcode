package main.java.string;

/**
 * @author fuqianzhong
 * @date 2020/7/26
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 */
public class LongestPalindromicSubstring {
    //提交失败版本，o(n^3)
    public String longestPalindrome(String s) {
        //边界检查 <=1
        if(s == null || s.length() <= 1){
            return s;
        }
        //定义字符串：[a,b)
        //base：[a,a)和[a,a+1)是回文串，
        //rule：如果[a+1,b-1)是回文串且a==b-1，则[a,b)是回文串
        //使用矩阵分析，a可以取的区间是[0,s.length-1]，b可以取的区间是[0,s.length]，只需要对矩阵的右上部分做遍历即可，因为左下部分
        //对于每一行，取最大的回文子串
        String max = "";
        for(int i = 0 ; i < s.length() ; i ++){
            for(int j = i + 1 ; j < s.length() ; j ++){
                String subStr = s.substring(i,j);
                if(isPalindrom(subStr) && (j - i + 1) > max.length()){
                    max = subStr;
                }
            }
        }
        return max;
    }

    private boolean isPalindrom(String subStr) {
        String reverse = new StringBuilder(subStr).reverse().toString();
        return subStr.equals(reverse);
    }


}
