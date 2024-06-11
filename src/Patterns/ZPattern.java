package Patterns;

public class ZPattern {
    public static int isPossible(int n)
    {
        int newn=n/2,remainder=n%2;
        while(newn>remainder)
        {
            if(newn-2==remainder)return newn;
            remainder+=2;
            newn--;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str="zohocorporati";
        int n=str.length();
        int row=0;
        if( (row=isPossible(n))==-1)return ;
        int index=0;
        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=row;j++)
            {
                if(i==1||i==row||j==row-i+1)
                {
                    System.out.print(str.charAt(index++)+" ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
