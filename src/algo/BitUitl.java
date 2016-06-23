package algo;

/**
 * Created by we on 2016. 6. 20..
 */
public class BitUitl {

    // num 에서 i 번째 bit 가 0이면 false, 1이면 true 반환.
    public static boolean getBit(int num, int i){
        return ((num & (1 << i)) != 0);
    }

    // num 에서 i 번째 bit 를 1 로 변환한다.
    public static int setBit(int num, int i){
        return num | (1 << i);
    }

    // num 에서 i 번째 bit 를 0 으로 변환한다.
    public static int cleanBit(int num, int i ){
        int mask = ~(1 << i);
        return num & mask;
    }

    // MSB(Most Significant Bit) 부터 i번째 비트까지를 전부 지우고 싶을 경우 사용.
    public static int clearBitsMSBthroughI(int num, int i){
        int mask = (1 << i) - 1;
        return num & mask;
    }

    // i 번째 비트부터 0번비트까지를 전부 지우고 싶을 경우 사용.
    public static int clearBitsIthrought0(int num, int i){
        int mask = ~(-1 >>> (31 - i));
        return num & mask;
    }

    // 양의 정수일 때 2진수의 길이 반환.
    public static int getLengthBit( int num ){
        for( int i = 0; i < 64; i++ ){
            if( num < Math.pow(2, i) ){
                return i;
            }
        }
        return 0;
    }

}
