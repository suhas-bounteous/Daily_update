class SharedResource {
    private int data;
    private boolean available = false; 

    
    synchronized void produce(int value) throws InterruptedException {
        
        while (available) {
            wait();
        }

        this.data = value;
        this.available = true; 
        System.out.println("Produced: " + value);

        notify(); 
    }

    
    synchronized int consume() throws InterruptedException {
        
        while (!available) {
            wait();
        }

        this.available = false; 
        System.out.println("Consumed: " + data);

        notify(); 
        return data;
    }
}