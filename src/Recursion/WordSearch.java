package Recursion;

public class WordSearch {
    public static boolean wordPresent(char[][]board,String word,int row,int col,int index)
    {
        if(index==word.length())return true;
        char c=word.charAt(index);
        if(row==board.length||col==board[0].length||row<0||col<0||c!=board[row][col]||board[row][col]=='!')
        {
            return false;
        }
        boolean answer=false;
        char temp=board[row][col];
        System.out.println(board[row][col]+ " Index   " + c);
        board[row][col]='!';


        boolean right=wordPresent(board,word,row,col+1,index+1);
        boolean bottom= wordPresent(board,word,row+1,col,index+1);
        boolean left =wordPresent(board,word,row,col-1,index+1);
        boolean top=wordPresent(board,word,row-1,col,index+1);
        answer=right||bottom||left||top;
        board[row][col]=temp;

        return answer;

    }
    public static boolean present(char [][]board, String word, int n, int m) {
        boolean answer=false;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0)&& wordPresent(board,word,i,j,0))
                {
                    answer=true;
                    break;
                }
            }
            if(answer)break;
        }
        return answer;
    }
}
