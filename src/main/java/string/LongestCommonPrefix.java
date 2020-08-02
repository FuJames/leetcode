package string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //边界处理
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        //定义stringbuilder记录最长公共前缀；
        //定义char变量fc，记录第一个字符串中的当前字符；定义index记录当前比较的位置；
        StringBuilder sb = new StringBuilder();
        int index = 0;
        //错误点1：没有判断空字符串
//        char fc = strs[0].charAt(index);
        if(strs[0].equals("")){
            return "";
        }
        char fc = strs[0].charAt(index);
        //遍历数组中的所有字符串，比较index位置处的字符，如果位置不存在或者字符不同，则退出循环；否则，将字符串加入到stringbuilder中
        while (true){
            boolean continueCompare = true;
            for(int i = 1;i < strs.length; i ++){
                String s = strs[i];
                //错误点2：没有判断空字符串，没有判断字符串是否越界
                if(s == null || index >= s.length()){
                    continueCompare = false;
                    break;
                }
                if(fc != s.charAt(index)){
                    continueCompare = false;
                    break;
                }
            }
            if(!continueCompare){
                break;
            }
            sb.append(fc);
            index ++;
            //错误点3：没有判断字符串是否越界
            if(index >= strs[0].length()){
                break;
            }
            fc = strs[0].charAt(index);
        }
        return sb.toString();
    }
}
