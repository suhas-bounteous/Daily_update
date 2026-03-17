import java.util.Random;

public class Producer extends Thread {

    Random random = new Random();

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(500);

                String id = "EMP-" + random.nextInt(5);
                Example emp = new Example(id);

                synchronized (Main.list) {
                    Main.list.add(emp);
                    System.out.println("Produced: " + emp.getId() + " -> " + emp.getUniqueId());
                    Main.list.notify();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
