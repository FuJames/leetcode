package dataStructure;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 举例：
 * (){}[] 合法
 * {()} 合法
 * {(}) 不合法，没有按顺序闭合
 */
public class ValidParentheses20 {

    /**
     * 思路：对于每个右括号，左边相邻的符合必须是对应的左括号，否则就是不匹配。 如何记录左边相邻的左括号？ 先进后出-栈结构
     * 遍历字符串，如果是左括号，则入栈，如果是右括号，出栈，比较栈顶元素是否匹配，如果不匹配则false。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s==null||s.length()<=1){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(c==')' && !pop.equals('(')){
                    return false;
                }
                if(c==']' && !pop.equals('[')){
                    return false;
                }
                if(c=='}' && !pop.equals('{')){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
