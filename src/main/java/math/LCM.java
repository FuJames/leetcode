package math;

/**
 * 最小公约数(least common multiple)
 * 思路：假设两个数字a，b，lcm(a,b)=a*b/gcd(a,b).
 */
public class LCM {
    public static void main(String[] args) {
        LCM lcm=new LCM();
        System.out.println(lcm.lcm(87571,9988));
    }
    public int lcm(int a,int b){
        if(a==0||b==0){
            return 0;
        }
        GCD gcd=new GCD();
        return a*b/gcd.gcd(a,b);
    }
}
