package Stack;

import java.util.Stack;

public class Celebrity {

    /*
    *Find the Celebrity who was known by everyone, but he doesn't know anyone
    * @param M[][]-relationship matrix if 1 then row knows column else dont know
    * @param n-No of people
    *@return celebrity
    * Approach:
    * ->Initialize stack with all peoples
    * -> Pop two peoples then evaluate known relationship push the unknown person
    * ->do until stack has a single people
    * ->finally check if the single person didn't know everyone and everyone knows him
    *
    * https://www.geeksforgeeks.org/problems/the-celebrity-problem/1?page=1&category=Stack&sortBy=submissions

     */
    int celebrity(int M[][], int n)
    {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)stack.push(i);

        while(stack.size()>1)
        {
            int a=stack.pop();
            int b=stack.pop();
            if(M[a][b]==1)stack.push(b);
            else stack.push(a);
        }
        int celeb=stack.pop();
        int answer=0;
        for(int i=0;i<n;i++)
        {
            if(i!=celeb&&(M[celeb][i]==1||M[i][celeb]==0))
            {
                answer=-1;
                break;
            }
        }
        if(answer==-1)return -1;
        return celeb;

    }
}
