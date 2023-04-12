package juzhen;

/**
 * https://leetcode.cn/problems/rotate-matrix-lcci/description/
 * leetcode：90度顺时针旋转旋转矩阵
 */
public class XuanZhuanJuZhen {
    public static void main(String[] args) {
        //二维数组初始化
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(a[0][3]);//会数组越界
        //方案一：分析矩阵旋转之后相同元素的位置变化，旋转转换方程。a[i][j]->a[j][rows-i-1]
        XuanZhuanJuZhen s = new XuanZhuanJuZhen();
        s.rotate(a);
        for(int i = 0 ;i < 3; i++){
            for(int j = 0; j < 3 ; j++){
//                System.out.println(a[i][j]);
            }
        }
        a = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        //方案二：互换+旋转，第一步，以行为维度首尾互换a[i]=a[rows-i-1]，第二步，以正对角线为准互换元素a[i][j]=a[j][i]
        rotate2(a);
        for(int i = 0 ;i < 4; i++){
            for(int j = 0; j < 4 ; j++){
                System.out.println(a[i][j]);
            }
        }
    }

    private static void rotate2(int[][] matrix) {
        int rows = 0 ;
        if(matrix == null || (rows = matrix.length) == 0){
            return;
        }
        int columns = matrix[0].length;
        //行首尾互换
        for(int i = 0;i<rows/2;i++){
            for(int j=0;j<columns;j++){
                int tmp = matrix[rows-i-1][j];
                matrix[rows-i-1][j]=matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //对角线互换
        for(int i=0;i<rows;i++){
            for(int j=0;j<i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

    public void rotate(int[][] matrix) {
        int rows = 0;
        //获取二维数组的行数
        if(matrix == null || (rows = matrix.length) == 0){
            return ;
        }
        //获取二维数组的列数
        int columns = matrix[0].length;
        int [][]temp = new int[rows][columns];
        for(int i = 0 ;i < rows; i++){
            for(int j = 0; j < columns ; j++){
                temp[j][rows-i-1] = matrix[i][j];
            }
        }
        for(int i = 0 ;i < rows; i++){
            for(int j = 0; j < columns ; j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }

}


