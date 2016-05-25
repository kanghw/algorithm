package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by we on 2016. 5. 23..
 */
public class StackLimitList{
    List<StackInt> list = new ArrayList<>();
    int count = 0;
    int limit = 10;

    public StackLimitList(int limit) {
        this.limit = limit;
    }

    void push(int num){
        if( count >= limit || list.size() == 0 ){
            count = 0;
            list.add(new StackInt());
        }
        list.get(list.size() - 1).push(num);
        count++;
    }

    int pop(){
        if( list.size() == 0 ){
            return -1;
        }
        int result = list.get(list.size() - 1).pop();

        if( list.get(list.size() - 1).peek() == null ){
            System.out.println(" >>>>> " + result + " <<<<< list index = list[" + list.size() + "]" );
            list.remove(list.size() - 1);
        }
        return result;
    }

    int popAt(int index){
        int result = -1;
        StackInt stack = list.get(index);
        if( stack != null ){
            result = stack.pop();
        }
        return result;
    }
}
