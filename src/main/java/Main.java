/**
 * @author fuqianzhong
 * @date 2020/8/31
 * 输入一个数组和目标值，返回数组中任意数字之和为目标值的序列个数，
 * 如输入[1,2]和4，那么可能的序列为，
 * [1,1,1,1],[1,1,2],[2,2]，因此返回3
 * 递归的核心：
 * 1. 递归表达式 2. 边界返回
 */
public class Main {
    private static int count = 0;
    public static void main(String[] args) {
        //边界判定
        //map保存每个数据的关系
        //遍历数组，对于每个a[i]，是否存在n-a[i]这个数字的组合，递归
        int a[] = new int[]{1,2};
        int n = 2;
        judge(a,n,0);
        System.out.println(count);
    }

    public static int judge(int a[],int n,int k){
        if(k>=a.length||n<0){
            return 0;
        }
        if(n==0){
//            count++;
            return 1;
        }
        for(int i = k; i < a.length ; i++){
            count = judge(a,n-a[i],k) + judge(a,n,k+1);
        }
        return count;
    }
}
