import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnableTask implements Runnable{
    @Override
    public void run() {
        System.out.println("This is a runnable class");
    }
}

class CallableTask implements Callable<String> {
    private final int number;

    public CallableTask(int number) {
        this.number = number;
    }

    @Override
    public String call() throws Exception {
        System.out.println("This is callable class");
        return "Task finished: Result is " + (number * 2);
    }
}

class Executor{
    static void main() throws InterruptedException, ExecutionException {

        RunnableTask runnableTask = new RunnableTask();
        Thread thread = new Thread(runnableTask);
        thread.start();
        thread.join();

        System.out.println("Starting callable class");

        ExecutorService ex = Executors.newSingleThreadExecutor();
        CallableTask callableTask = new CallableTask(5);
        Future<String> future = ex.submit(callableTask);
        String res = future.get();
        System.out.print(res);
        ex.shutdown();
        
    }
}

