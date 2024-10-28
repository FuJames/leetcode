package math;

/**
 * The greatest common divisor (GCD) of two or more numbers is the greatest common factor
 * number that divides them, exactly.
 * 最大公约数
 */
public class GCD {
    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(123456,7890));
    }
    /**
     * 返回最大公约数，基于欧几里得原理：gcd(a,b)=gcd(b,a mod b)。
     * 举例：
     * gcd(4,6)=gcd(4,2)=gcd(2,0)，最终返回2。
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a,int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        int max=a,min=b;
        if(a<b){
            max=b;
            min=a;
        }
        return gcd(min,max%min);
    }
}
