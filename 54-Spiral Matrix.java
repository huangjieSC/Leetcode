public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0 || matrix[0].length==0)
            return list;
            
        int rowE=matrix.length;
        int colE=matrix[0].length;
        int total=matrix.length*matrix[0].length;
        int i=0, j=0;
        int colS=0, rowS=0;
        
        while(total>0){
            while(j<colE && total>0){  // forgot to add total>0 in each of the sub-while loop!!!
                list.add(matrix[i][j]);
                j++;
                total--;
            }
            j--;
            i++;
            
            while(i<rowE && total>0){
                list.add(matrix[i][j]);
                i++;
                total--;
            }
            i--;
            j--;
            
            while(j>=colS && total>0){
                list.add(matrix[i][j]);
                j--;
                total--;
            }
            j++;
            i--;
            
            while(i>rowS && total>0){
                list.add(matrix[i][j]);
                i--;
                total--;
            }
            i++;
            j++;
            
            colS++;
            rowS++;
            colE--;
            rowE--;
        }
        
        return list;
    }
}
