public class ArithmeticThread extends Thread {
    private int variant;
    private long nMin;
    private long nMax;
    private long result;

    public ArithmeticThread(int variant, long nMin, long nMax){
        this.variant = variant;
        this.nMin = nMin;
        this.nMax = nMax;
    }

    @Override
    public void run(){
        long res = 0;
        for(long i = nMin; i<= nMax; i++){
            res += variant*i;
        }
        result = res;
    }

    public long getResult() {
        return result;
    }
}
