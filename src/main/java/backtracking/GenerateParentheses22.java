package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenerateParentheses22 {
    List<String> result=new ArrayList<>();
    StringBuilder tracking=new StringBuilder();

    public static void main(String[] args) {
        GenerateParentheses22 g = new GenerateParentheses22();
        g.generateParenthesis(3);
        System.out.println(g.result);
    }
    /**
     * 思路一：回溯法，trackinglist+resultlist+回溯（撤销选择），
     * 有左括号就选做括号，如果没有左括号了，就选择右括号；回溯递归树的时候，左括号会被释放，此时当右括号数量大于左括号时，说明前面选择了更多的左括号，
     * 需要选择右括号才能对称上；如果右括号<=左括号时，总是优先选择左括号。
     * 选择左：条件是左数量大于0，只要有左括号，就选左括号
     * 选择右：条件是右数量大于左数量（右小于或等于左时，先选右，剩余的左数量无法匹配右）
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n,n,0,2*n);
        return result;
    }

    /**
     *
     * @param ln 左括号剩余数量
     * @param rn 右括号剩余数量
     * @param size 当前string长度
     * @param len string目标长度
     */
    public void generateParenthesis(int ln,int rn,int size,int len) {
        if(size==len){
            result.add(tracking.toString());
            return;
        }
        if(ln>0){
            tracking.append('(');
            generateParenthesis(ln-1,rn,size+1,len);
            tracking.deleteCharAt(size);
        }
        if(rn>ln){
            tracking.append(')');
            generateParenthesis(ln,rn-1,size+1,len);
            tracking.deleteCharAt(size);
        }
    }
}
