public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        
        int[] rowZero = new int[matrix.length];
        int[] colZero = new int[matrix[0].length];
        int a=0;
        for(a=0; a<matrix.length;a++)
            rowZero[a]=-1;
        for(a=0; a<matrix[0].length;a++)
            colZero[a]=-1;
        
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    rowZero[i]=0;
                    colZero[j]=0;
                }
            }
        }
        
        for(int k=0; k< matrix.length; k++){
            for(int l=0; l<matrix[0].length; l++){
                if(rowZero[k]==0 || colZero[l]==0){
                    matrix[k][l]=0;
                }
            }
        }
    }
}
