
class Runner {
    int cnt=0;
    private final int LIMIT = 10;
    synchronized public void show() throws InterruptedException{
        while(cnt<LIMIT) {
            cnt++;
            System.out.print(" "+cnt);
        }
    }

    static void main() {
        Runner rc = new Runner();
        Thread t1 = new Thread(() -> {
            try {
                rc.show();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                rc.show();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();


    }
}

