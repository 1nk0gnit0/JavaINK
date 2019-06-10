package Five;

public class App {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    private static void arrFill( ) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1f;
        }
    }

    private static long newValueArr( ){
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        return (b - a);
    }

    private static long multyArr() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a1, 0, arr, 0, h);
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int j = h;
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                    j++;
                }
                System.arraycopy(a2, 0, arr, h, h);
            }
        });

        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long b = System.currentTimeMillis();
        return (b - a);
    }

    public static void main(String[] args) {
        arrFill();
        System.out.println("Первый метод проходит за " + newValueArr() + " ms.");
        arrFill();
        System.out.println("Второй метод проходит за " + multyArr() + " ms.");
    }
}
