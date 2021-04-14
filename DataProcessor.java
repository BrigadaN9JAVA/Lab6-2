import java.util.ArrayList;
import java.util.List;

public class DataProcessor {
    public long calculateArithmeticProgress(int variant, long n, int threadsCount){
        long res = 0;
        long nMax = 0;
        long nMin = 0;

        long m = n/threadsCount;
        long mlast = n/threadsCount + n%threadsCount;
        List<ArithmeticThread> threads = new ArrayList<>(threadsCount);

        ArithmeticThread at;
        for (int i = 0; i < threadsCount; i++) {
            nMin = nMax+1;
            nMax = (nMin - 1) + (i==threadsCount-1 ? mlast : m);

            at = new ArithmeticThread(variant, nMin, nMax);
            threads.add(at);
            at.start();
        }

        for(ArithmeticThread t : threads){
            try {
                t.join();
                res+=t.getResult();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return res;
    }

    public long formulaCalculate(int variant, long n){
        return ((variant + (variant*n))*n)/2;
    }
}
