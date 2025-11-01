package Trie.Implementation.problems;

public class MinimumXor {

    public static void main(String[] args) {

        int num1=25,num2=72;
        int setBits=0;
        for(int i=31;i>=0;i--){
            setBits+=((num2&(1<<i))==0?0:1);
        }
        //0001 1100
        int number=0;
        for(int i=31;i>=0;i--){
            //if setBit>0 and msb is 1 for num1 then need to add that number
            if(i+1==setBits){
                setBits--;
                number|=(1<<i);
                continue;
            }
            boolean isBitSet=(num1&(1<<i))!=0;
            if(setBits>0&&isBitSet){
                setBits--;
                number+=(1<<i);
            }
        }
        System.out.println(number);
    }
}
