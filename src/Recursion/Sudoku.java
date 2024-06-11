package Recursion;

public class Sudoku {
    static boolean solve(int grid[][],int row,int col,int val)
    {
        for(int i=0;i<9;i++)
        {
            if(grid[i][col]==val)return false;//check in row for value
            if(grid[row][i]==val)return false;//check in col for value
            if(grid[(3*(row/3))+(i/3)][(3*(col/3))+(i%3)]==val )return false;//check in that 3*3 cell
        }
        return true;
    }
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(grid[i][j]==0)//if field is zero
                {
                    for(int k=1;k<=9;k++)//try all values
                    {
                        if(solve(grid,i,j,k)) {
                            grid[i][j] = k;
                            if (SolveSudoku(grid)) return true;//if everything succesfull return true


                            grid[i][j] = 0;
                        }
                    }
                    return false;//if cant then bactrack
                }
            }
        }
        return true;
    }

    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(grid[i][j]+" ");

            }

        }
    }
}
