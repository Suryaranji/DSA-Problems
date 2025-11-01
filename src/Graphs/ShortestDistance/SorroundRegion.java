package Graphs.ShortestDistance;

public class SorroundRegion {
    public void surround(int row,int col,char board[][]){
        if(row<0||col<0||col>=board[0].length||row>=board.length){
            return ;
        }
        if(board[row][col]=='X'||board[row][col]=='-')return ;
        board[row][col]='-';
        surround(row,col-1,board);
        surround(row,col+1,board);
        surround(row-1,col,board);
        surround(row+1,col,board);
    }
    public void solve(char[][] board) {
        //first and last column
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                surround(i,0,board);
            }
            if(board[i][m-1]=='O'){
                surround(i,m-1,board);
            }
        }
        //first and last row
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                surround(0,i,board);
            }
            if(board[n-1][i]=='O'){
                surround(n-1,i,board);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='-'){
                    board[i][j]='O';
                }
            }
        }




    }

    public static void main(String[] args) {
        SorroundRegion obj=new SorroundRegion();
        char board[][]={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        obj.solve(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
