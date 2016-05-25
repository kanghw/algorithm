package algo;

/**
 * Created by we on 2016. 5. 10..
 */
public class MinStack {
    NodeInt top;
    StackInt ori = new StackInt();
    StackInt minS = new StackInt();

    NodeInt pop(){
        if( top != null ){
            if( top.data == minS.peek().data ){
                minS.pop();
            }
            NodeInt item = top;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(int num){
        if( minS.peek() == null ){
            minS.push(num);
        }
        if( minS.peek().data >= num ){
            minS.push(num);
        }
        ori.push(num);

        NodeInt t = new NodeInt(num);
        t.next = top;
        top = t;
    }

    NodeInt peek(){
        return top;
    }

    NodeInt min(){
        if( minS == null ){
            return null;
        }
        return minS.peek();
    }

}
