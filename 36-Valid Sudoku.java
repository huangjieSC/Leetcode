public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length == 0) return true;
        
        if(!checkRow(board)) return false;
        if(!checkCol(board)) return false;
        if(!checkCell(board)) return false;
        
        return true;
    }
    
    public boolean checkRow(char[][] board){
        int row = board.length;
        Set<Character> set = new HashSet<Character>();
        
        for(int i=0; i<row; i++){
            set.clear();
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }
        return true;
    }
    
    public boolean checkCol(char[][] board){
        int col = board[0].length;
        Set<Character> set = new HashSet<Character>();
        
        for(int i=0; i<col; i++){
            set.clear();
            for(int j=0; j<board.length; j++){
                if(board[j][i]=='.') continue;
                if(set.contains(board[j][i])) return false;
                else set.add(board[j][i]);
            }
        }
        return true;
    }
    
    public boolean checkCell(char[][] board){
        int row = board.length;
        int col = board[0].length;
        Set<Character> set = new HashSet<Character>();
        
        for(int i=0; i<row; i=i+3){
            for(int j=0; j<col; j=j+3){
                set.clear();
                for(int x=0; x<3; x++){
                    for(int y=0; y<3; y++){
                        if(board[i+x][j+y]=='.') continue;
                        if(set.contains(board[i+x][j+y])) return false;
                        else set.add(board[i+x][j+y]);
                    }
                }
            }
        }
        return true;
    }
}
