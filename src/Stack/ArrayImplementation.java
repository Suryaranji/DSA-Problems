package Stack;

public class ArrayImplementation implements stack<Integer>{
    int top=-1;
    int size;
    int arr[];
    public ArrayImplementation(int size)
    {
        arr=new int[size];
        this.size=size;
    }
    @Override
    public void push(Integer element) {
        if(top==size){
            System.out.println("Stack Full");
            return;
        }
        arr[++top]=element;
    }

    @Override
    public Integer pop() {
        if(top==-1)
        {
            System.out.println("No elements");
            return -1;
        }
        return arr[top];
    }

    @Override
    public Integer peek() {
        return arr[top];
    }

    @Override
    public int size() {
        return top+1;
    }
}
