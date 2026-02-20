class Producer extends Thread{
    private SharedResource resource;
    Producer(SharedResource resource){
        this.resource = resource;
    }
    @Override
    public void run(){
        try{
            for(int i=1; i<=5; i++){
                resource.produce(i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}