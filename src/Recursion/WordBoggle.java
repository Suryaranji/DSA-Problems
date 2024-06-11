package Recursion;

import java.util.ArrayList;

public class WordBoggle {
    /*
    Given a dictionary of distinct words and an M x N board where every cell has one character. Find all possible words from the dictionary that can be formed by a sequence of adjacent characters on the board. We can move to any of 8 adjacent characters

Note: While forming a word we can move to any of the 8 adjacent cells. A cell can be used only once in one word.


Example 1:

Input:
N = 1
dictionary = {"CAT"}
R = 3, C = 3
board = {{C,A,P},{A,N,D},{T,I,E}}
Output:
CAT
Explanation:
C A P
A N D
T I E
Words we got is denoted using same color.
     */
    public boolean isExist(char[][]arr,String word,int row,int col,int j)
    {
        if(j==word.length())return true;

        //have all 8 directions
        int [][] dir={
                {-1,1},
                {-1,0},
                {1,1},
                {0,1},
                {1,-1},
                {1,0},
                {-1,-1},
                {0,-1}
        };
        for(int i=0;i<dir.length;i++)
        {
            //pick one direction
            int r=row,c=col;
            int x1=dir[i][0],y1=dir[i][1];
            //check if that direction consist of that word
            if(r>=0&&r<arr.length&&c>=0&&c<arr[0].length&&j<word.length()&&arr[r][c]==word.charAt(j))
            {
                arr[r][c]='.';
                if( isExist(arr,word,row+x1,col+y1,j+1))
                {
                    arr[r][c]=word.charAt(j);
                    return true;
                }
                arr[r][c]=word.charAt(j);


            }
        }
        return false;
    }
    public String[] wordBoggle(char grid[][], String[] dictionary)
    {
        ArrayList<String> answer=new ArrayList<String>();
        for(int k=0;k<dictionary.length;k++)
        {
            boolean flag=false;
            for(int i=0;i<grid.length;i++)
            {

                for(int j=0;j<grid[i].length;j++)
                {
                    if(dictionary[k].charAt(0)==grid[i][j]&&isExist(grid,dictionary[k],i,j,0))
                    {
                        answer.add(dictionary[k]);
                        flag=true;
                        break;
                    }
                }
                if(flag)break;
            }
        }
        String[] array = new String[answer.size()];
        int count=0;
        for(String str:answer)array[count++]=str;
        return array;

    }
}
