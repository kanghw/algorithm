package algo;

/**
 * Created by we on 2016. 5. 27..
 */
public class StackQue {
    StackInt a = new StackInt();
    StackInt b = new StackInt();
    boolean isPushed = true;

    public void push(int num){
        if( isPushed ){
            // 직전이 푸시였을 경우. 현재 사이즈가 0이 아닌 쪽에 푸시.
            if( a.size() > 0 ){
                a.push(num);
            } else {
                b.push(num);
            }
        } else {
            // 직전이 팝이었을 경우. 현재 사이즈가 0인 쪽으로 모두 바꾼 후 거기에 푸시.
            if( change() == 1 ){
                b.push(num);
            } else {
                a.push(num);
            }
        }
        isPushed = true;
    }

    // 두 스택을 바꾼 후 사이즈가 0인 것을 반환.
    // 둘 다 0일 경우 1을 반환. -> 어느 것을 반환해도 결과가 동일하기 때문.
    // 1 = a, 2 = b
    private int change() {
        if( a.size() == 0 ){
            while( b.size() != 0 ){
                a.push(b.pop());
            }
            return 2;
        } else {
            while( a.size() != 0 ){
                b.push(a.pop());
            }
        }
        return 1;
    }

    public int pop(){
        if( a.size() == 0 && b.size() == 0 ){
            return -1;
        }
        int result = -1;
        if( isPushed ){
            // 직전이 푸시였을 경우. 현재 사이즈가 0인 쪽으로 모두 바꾼 후 거기서 팝.
            if( change() == 1 ){
                result = b.size() == 0 ? result : b.pop();
            } else {
                result = a.pop();
            }
        } else {
            // 직전이 파이었을 경우. 현재 사이즈가 0이 아닌 쪽에서 팝.
            if( a.size() > 0 ){
                result = a.pop();
            } else {
                result = b.size() == 0 ? result : b.pop();
            }
        }
        isPushed = false;
        return result;
    }
}
