package sg.edu.nus.iss;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\tRunnable..." + i);
                }
            }

        });
        // thread1.start();

        MyRunnableImplementation mRI = new MyRunnableImplementation("task 1");
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("task 2");
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("task 3");
        MyRunnableImplementation mRI4 = new MyRunnableImplementation("task 4");
        MyRunnableImplementation mRI5 = new MyRunnableImplementation("task 5");
        // Thread thread2 = new Thread(mRI);
        // thread2.start();

        // Thread thread3 = new Thread(mRI);
        // thread3.start();

        //single thread exercuteable
        // ExecutorService exercutorService = Executors.newSingleThreadExecutor();
        // exercutorService.execute(mRI);
        // exercutorService.execute(mRI2);
        // exercutorService.shutdown();

        // ExecutorService exercutorService = Executors.newFixedThreadPool(3);
        // exercutorService.execute(mRI);
        // exercutorService.execute(mRI2);
        // exercutorService.execute(mRI3);
        // exercutorService.execute(mRI4);
        // exercutorService.execute(mRI5);
        // exercutorService.shutdown();
        
        ExecutorService exercutorService = Executors.newCachedThreadPool();
        exercutorService.execute(mRI);
        exercutorService.execute(mRI2);
        exercutorService.execute(mRI3);
        exercutorService.execute(mRI4);
        exercutorService.execute(mRI5);
        exercutorService.shutdown();
        
        

    }
}
