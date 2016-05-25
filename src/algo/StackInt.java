package algo;

/**
 * Created by we on 2016. 5. 23..
 */
public class StackInt {
    NodeInt top;
    int count = 0;
    String name = "";

    public StackInt(String name) {
        this.name = name;
    }

    public StackInt() {
    }

    int pop(){
        if( top != null ){
            int item = top.data;
            top = top.next;
            count--;
            return item;
        }
        return 0;
    }

    void push(int num){
        NodeInt t = new NodeInt(num);
        t.next = top;
        top = t;
        count++;
    }

    int size(){
        return count;
    }

    NodeInt peek(){
        return top;
    }

}
