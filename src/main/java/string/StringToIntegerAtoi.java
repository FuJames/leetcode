package main.java.string;

/**
 * @author fuqianzhong
 * @date 2020/7/27
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，
 * 即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        StringToIntegerAtoi s=new StringToIntegerAtoi();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

//        System.out.println(s.strToInt("  -42"));
//        System.out.println(s.strToInt("-2a"));
//        System.out.println(s.strToInt("2147483646"));
        System.out.println(s.strToInt("2147483648"));
//        System.out.println(s.strToInt("-2147483648"));
    }

    /**
     * 思路：
     * 1、字符串为空，返回0
     * 2、寻找第一个非空字符，如果不存在，返回0；
     * 3、第一个非空字符为+或-，记录正负数标志；否则，开始遍历；
     * 4、【关键算法】遍历字符串，当前为数字，计算数字总和，result*10+s[i]；当前为非数字，结束遍历。
     * 5、【关键算法】每次计算总和时，结果都可能会溢出，需要判断是否可溢出的条件，因为result*10+s[i]会溢出，
     * 所以不能直接用result*10+s[i]来与max比较，使用result与max/10比较，max=2^31-1=2147483647，
     * max/10=214748364，如果result>max/10返回max，因为result>max/10时，result至少是214748365，
     * result*10肯定溢出；如果result=max/10=214748364，比较result*10+7与max，如果大于，溢出返回max，
     * 如果小于，可继续；如果result<max/10，result最大是214748363，result*10+s[I]肯定不会溢出，可继续。
     * Integer最小值：-2147483648=-2^31，最大值：-2147483647=2^31-1。
     *  @param str
     * @return
     */
    public int strToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        //1、寻找第一个非空字符
        int i=0;
        while (i<str.length()&&str.charAt(i)==' '){
            i++;
        }
        if(i==str.length()){//字符串全部都是空格
            return 0;
        }
        //2、记录+-标记
        int sign = 1;
        if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(str.charAt(i)=='+'){
            sign=1;
            i++;
        }
        //3、统计数字
        int result=0;
        int target=Integer.MAX_VALUE/10;
        while (i<str.length()){
            char c = str.charAt(i);
            int t =c-'0';
            if(t>=0&&t<=9){//有效的数字
                if(result>target||(result==target&&t>7)){//t>=7时：输入-2147483647，结果是-2147483648
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                    //Integer.MAX_VALUE+3：Integer是有符号整数，溢出后，首位变成了1，所以会是负数。
                }
                result=result*10+t;
            }else {
                break;
            }
            i++;
        }
        return sign==1?result:sign*result;
    }
    public int myAtoi(String str) {
        //用long类型来防止越界
        long r = 0;
        //边界判断，null
        if(str == null){
            return (int)r;
        }
        //去除空字符串
        int i = 0,len = str.length();
        //错误点3：先使用charAt，再使用i<len，导致溢出
//        while (str.charAt(i) == ' ' && i < len) {
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        if(i >= len){
            return 0;
        }
        boolean isPositive = true;
        char c = str.charAt(i);
        //正负值判断
        if(c == '+'){
            isPositive = true;
            i++;
        }else if(c == '-'){
            isPositive = false;
            i++;
        }
        //构造连续整数，去除非整型字符
        while (i < len){
            if((c = str.charAt(i)) < '0' || c > '9'){
                break;
            }
            //将字符转化为整数
            //错误点1：字符转换为整数时，没有-'0'
            int num = c - '0';
            r = r*10 + num;
            //错误点4：long整数相加时，未考虑到最大值溢出，当最大值溢出时，加法结果会变成不可预测的值！！
            //错误点5：提前判断r是否超过int长度，防止后面long类型溢出
            if(r >= Integer.MAX_VALUE){
                if(isPositive) {
                    return Integer.MAX_VALUE;
                }else {
                    //错误点6：int整数区间为[-2^31,2^31-1]，当输入-2^31时，返回了Integer.MIN_VALUE
//                    return Integer.MIN_VALUE;
                    if(r == Integer.MAX_VALUE){
                        return (int)r*-1;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            i++;
        }
        //错误点2：判断r是否越界时，没有带上符号位
        r = isPositive ? r : r*-1;
        //判断是否越界
        if(r > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(r < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)r;
    }


}
