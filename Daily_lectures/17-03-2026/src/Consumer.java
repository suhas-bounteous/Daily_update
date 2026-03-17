import java.util.*;

public class Consumer extends Thread {

    @Override
    public void run() {

        while (true) {
            try {

                synchronized (Main.list) {

                    while (Main.list.isEmpty()) {
                        Main.list.wait();
                    }

                    Example emp = Main.list.get(0);
                    Main.list.remove(0);

                    Main.map.putIfAbsent(emp.getId(), new ArrayList<>());
                    Main.map.get(emp.getId()).add(emp.getUniqueId());

                    System.out.println("Consumed: " + emp.getId() + " -> " + emp.getUniqueId());
                    System.out.println("Map: " + Main.map);
                }

                Thread.sleep(800);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
