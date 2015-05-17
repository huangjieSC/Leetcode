public class Solution {
        /**
         * 这道题跟NQueens的解法完全一样，只不过要求的返回值不同了。。所以要记录的result稍微改一下就好了。
因为涉及到递归，result传进去引用类型（List，数组之类的）才能在层层递归中得以保存，所以这里使用一个长度为1的数组帮助计数
当然，也可以使用一个全局变量来帮助计数。
         * */
         
    public int totalNQueens(int n) {  
        int[] res = {0};
        if(n<=0)
            return res[0];
            
        int [] columnVal = new int[n];
        
        DFS_helper(n,res,0,columnVal);
        return res[0];
    }
    
    public void DFS_helper(int nQueens, int[] res, int row, int[] columnVal){
        if(row == nQueens){
            res[0] += 1;
        }else{
            for(int i = 0; i < nQueens; i++){
                columnVal[row] = i;
                
                if(isValid(row,columnVal))
                    DFS_helper(nQueens, res, row+1, columnVal);
            }
        }
    }
    
    public boolean isValid(int row, int [] columnVal){
        for(int i = 0; i < row; i++){
            if(columnVal[row] == columnVal[i]
               ||Math.abs(columnVal[row]-columnVal[i]) == row-i)
               return false;
        }
        return true;
    }
}
