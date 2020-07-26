package main.java.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fuqianzhong
 * @date 2020/7/26
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //边界处理 <= 1
        if(s == null){
            return 0;
        } else if(s.length() <= 1 ){
            return s.length();
        }

        //定义Map和len，来记录已经遍历过的字符串和当前最大长度
        Map<Character, Integer> map = new HashMap();
        int len = 0;
        //遍历字符串，如果当前字符在map中不存在，则插入到map中；如果map已经存在，则比较len与map长度，如果map长度大于len，则更新map长度为len，移动遍历的浮标，变为与当前字符位置相同字符的位置+1,map清空；
        int cursor = 0;
        while (cursor < s.length()) {
            char c = s.charAt(cursor);
            if(map.containsKey(c)){
                if(map.size() > len){
                    len = map.size();
                }
                cursor = map.get(c) + 1;
                map.clear();
            }else {
                map.put(c, cursor);
                cursor++;
            }
        }
        //错误点1：无重复字符时，未对len赋值
        //错误点2：对错误点1的补充，当map不为空时(无重复字符，遍历完成字符串，没有对len做赋值)，比较len与map长度大小；
//        if(len == 0){
        if(len < map.size()){
            len = map.size();
        }
        //返回len
        return len;
    }
}
