package JavaProgs;

import java.util.Arrays;

class rotateMatrix90 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
        for (int[] i: matrix)
            System.out.println(Arrays.toString(i));
    }
    public static void rotate(int[][] matrix) {
        if (matrix.length == 1) return;
        reverseEachRowOfMatrix(matrix);
        transpose(matrix);
        
    }
    
    private static  void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
    
    private static void reverseEachRowOfMatrix(int[][] matrix) {
        for (int[] i: matrix) {
            for (int j = 0, k = i.length - 1; j < k; j++,k--) {
                int temp = i[j];
                i[j] = i[k];
                i[k] = temp;
            }
        }
    }
}