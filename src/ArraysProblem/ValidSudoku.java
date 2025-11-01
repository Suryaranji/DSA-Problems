package ArraysProblem;

public class ValidSudoku {
    class Solution {
        int N = 9;

        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        public boolean isValidSudoku(char[][] board) {
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    if(board[r][c] == '.') continue;

                    int val = board[r][c] - '1';
                    int mask = 1 << val;

                    int b = r/3 * N/3 + c/3;
                    if((rows[r] & mask) != 0) return false;
                    if((cols[c] & mask) != 0) return false;
                    if((boxes[b] & mask) != 0) return false;

                    rows[r] |= mask;
                    cols[c] |= mask;
                    boxes[b] |= mask;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution obj = new ValidSudoku().new Solution();
        char[][] board = { {'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'} };
        System.out.println("Is Valid Sudoku: " + obj.isValidSudoku(board));
    }
}
