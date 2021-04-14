public class Client {
    public static void main(String[] args) {
        DataProcessor dp = new DataProcessor();
        int[] arrThreadsCounts = {1, 2, 4, 8, 16, 32};
        long timeStart;
        long timeEnd;
        long res;
        for(int thCount : arrThreadsCounts){
            timeStart = System.nanoTime();
            res = dp.calculateArithmeticProgress(9, 1000000000, thCount);
            timeEnd = System.nanoTime();
            System.out.println("Результат: " + res + " | кол-во потоков " + thCount + " расчитан за " + (timeEnd-timeStart) + " нс");
        }
        timeStart = System.nanoTime();
        res = dp.formulaCalculate(9, 1000000000);
        timeEnd = System.nanoTime();
        System.out.println("Результат: " + res + " расчитан за " + (timeEnd-timeStart) + " нс");
    }
}
