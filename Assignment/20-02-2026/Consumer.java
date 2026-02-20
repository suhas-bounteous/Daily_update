package Daily_update.Assignment;

class Consumer extends Thread {
    private SharedResource resource;

    Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                resource.consume();
                Thread.sleep(1500); 
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted: " + e);
        }
    }
}