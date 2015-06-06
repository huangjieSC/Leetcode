public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int area = countArea(matrix,i,j);
                if(area>max)
                    max = area;
            }
        }
        return max;
    }
    
    public static int countArea(char[][] matrix, int row, int col){
        int area = 0, i=0; 
        if(row>=matrix.length || col>=matrix[0].length) return 0;
        if(matrix[row][col] == '0') return 0;
        
        for(i=0;row+i<matrix.length && col+i<matrix[0].length;i++){
           if(isAllOne(matrix, row, col, i)){
            //    if(i==0) area = 1;
                area = (int)Math.pow(i+1,2);
           }
           else
                break;
        }
        return area;
    }
    
    public static boolean isAllOne(char[][] matrix, int row, int col, int i){
        if(matrix[row][col]=='0') return false;
      
        for(int rIndex = 0; rIndex<=i; rIndex++){
            for(int cIndex = 0; cIndex<=i; cIndex++ ){
                if(matrix[row+rIndex][col+cIndex]!='1') return false;
            }
        }
        return true;
    }
}
