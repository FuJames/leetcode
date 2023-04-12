package juzhen;

/**
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class ShunShiZhenDaYinJuZhen {
    public static void main(String[] args) {
        int a[][] =  new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //方案：先顺时针遍历完最外层矩阵回到起点，然后起点向正对角线方向移动一次。
        ShunShiZhenDaYinJuZhen s=new ShunShiZhenDaYinJuZhen();
        int r[] = s.spiralOrder(a);
        for(int e:r){
            System.out.print(e);
        }
        System.out.println();

    }

    public int[] spiralOrder(int[][] matrix) {
        int rows = 0;
        if(matrix == null || (rows=matrix.length)==0){
            return new int[0];
        }
        int columns = matrix[0].length;
        int start=0,end=0;
        int r[]=new int[rows*columns];
        int c=0,l=rows*columns;
        while(c<l){
            int i=start,j=end;
            //从左向右遍历
            while(j<columns){
                r[c++]=matrix[i][j++];
            }
            if(c>=l){//很重要，没有加这个判断，会触发数组越界异常，调试1h；原因很简单，非对称矩阵，比如一维数组，正常遍历一次即可，while查询里面逻辑没有运行，导致后续j--或i++的时候，触发越界。
                break;
            }
            i++;
            j--;
            while(i<rows){
                r[c++]=matrix[i++][j];
            }
            if(c>=l){
                break;
            }
            i--;j--;
            while(j>=end){
                r[c++]=matrix[i][j];
                j--;
            }
            if(c>=l){
                break;
            }
            i--;j++;
            while(i>start){//这里出错了，错误写成了i>=start，导致调试了20分钟。
                r[c++]=matrix[i--][j];
            }
            if(c>=l){
                break;
            }
            start++;
            end++;
            rows=rows-1;//每一次遍历，行和列缩小1圈
            columns=columns-1;
        }
        return r;

    }



}
