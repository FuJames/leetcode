package main.java.math;

/**
 * @author fuqianzhong
 * @date 2020/9/8
 *  * Print a given matrix in couter-clock spiral form
 *  *
 *  * Example I:
 *  * Input:  1    2   3   4
 *  *         5    6   7   8
 *  *         9   10  11  12
 *  *         13  14  15  16
 *  *
 *  * Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 *  *
 *  * Example II:
 *  * Input:  1   2   3   4  5   6
 *  *         7   8   9  10  11  12
 *  *         13  14  15 16  17  18
 *  *
 *  * Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 */
public class PrintMetricByClock {
    public static void main(String[] args) {
        int a[][] = new int[3][4];
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                a[i][j]=i+j;
            }
        }
        print(a,3,4);
    }

    public static void print(int a[][],int r,int c){
        //边界判定
        if(a==null||r<=0||c<=0){
            return;
        }
        //第一圈是从(0,0)->(0,c)->(r,c)->(r,0)；将左上角和右下角，沿着对角线方向一动一格，并循环打印第二圈，依次执行；
        //使用4个变量分表代表矩阵的4个角，rmin=0,rmax=r-1,cmin=0,cmax=c-1
        int rmin=0,rmax=r-1,cmin=0,cmax=c-1;
        while (rmin<=rmax&&cmin<=cmax){
            for (int i=cmin;i<=cmax;i++){
                System.out.println(a[rmin][i]);
            }
            //错误点5：从左向右遍历完成后，需要判断rmin+1==rmax是否成立，如果成立，则表示行已经溢出，停止打印
            //错误点8：从左向右遍历完成后，需要判断rmin+1>=rmax是否成立，如果成立，则表示行已经溢出，停止打印
            if(rmin+1>=rmax){
                break;
            }
            //错误点2：从上到下打印后，需要避免重复打印！！！
            for(int j=rmin+1;j<=rmax;j++){
                System.out.println(a[j][cmax]);
            }
            //错误点6：从上到下打印后，需要判断cmax-1==cmin是否成立，如果成立，则表示列已经溢出，停止打印
            //错误点7：从上到下打印后，需要判断cmax-1<=cmin是否成立，如果成立，则表示列已经溢出，停止打印
            if(cmax-1<=cmin){
                break;
            }
            //错误点3：从右到左打印后，需要避免重复打印！！！
            for(int i=cmax-1;i>=cmin;i--){
                System.out.println(a[rmax][i]);
            }
            //错误点4：从下到上打印后，需要避免重复打印！！！
            for(int j=rmax-1;j>=rmin+1;j--){
                System.out.println(a[j][cmin]);
            }
            //错误点1：遗漏了临界条件，导致了死循环 ！！！ 将左上角和右下角，沿着对角线方向一动一格
            rmin++;cmin++;
//            System.out.println("after:"+rmin);
//            System.out.println("after:"+cmin);
            rmax--;cmax--;
//            System.out.println("after:"+rmax);
//            System.out.println("after:"+cmax);
        }
    }
}
