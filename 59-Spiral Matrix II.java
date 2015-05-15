public class Solution {
    public int[][] generateMatrix(int n) {
        if(n==0)
            return new int[0][0];
        
        int total=(int)Math.pow(n,2);
        int rowS=0, colS=0;
        int rowE=n, colE=n;
        int[][] matrix = new int[n][n];
        int val=1;
        int i=0,j=0;
        
        while(total>0){
            while(total>0 && j>=colS && j<colE){
                matrix[i][j]=val;
                val++;
                j++;
                total--;
            }
            j--;
            i++;
            
            while(total>0 && i>=rowS && i<rowE){
                matrix[i][j]=val;
                val++;
                i++;
                total--;
            }
            i--;
            j--;
            
            while(total>0 && j>=colS && j<colE){
                matrix[i][j]=val;
                val++;
                j--;
                total--;
            }
            i--;
            j++;
            
            while(total>0 && i>rowS && i<rowE){ // pay attention to i>rowS, not i>=rowS
                matrix[i][j]=val;
                val++;
                i--;
                total--;
            }
            i++;
            j++;
            
            rowS++;
            colS++;
            rowE--;
            colE--;
        }
        
        return matrix;
    }
}
