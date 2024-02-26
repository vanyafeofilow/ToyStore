// T.java

import java.util.PriorityQueue;
import java.io.FileWriter;
import java.io.IOException;

public class RaffleToys {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> Double.compare(t2.getFrequency(), t1.getFrequency()));

    public void addToy(int id, String name, int quantity, double frequency) {
        for (int i = 0; i < quantity; i++) {
            Toy toy = new Toy(id, name, quantity, frequency);
            toyQueue.add(toy);
        }
    }

    public void updateFrequency(int id, double frequency) {
        for (Toy toy : toyQueue) {
            if (toy.getId() == id) {
                toy.setFrequency(frequency);
                break;
            }
        }
    }

    public void drawToys(int times) {
        try (FileWriter writer = new FileWriter("result.txt")) {
            for (int i = 0; i < times; i++) {
                Toy drawnToy = toyQueue.poll();
                if (drawnToy != null && drawnToy.getQuantity() > 0) {
                    decreaseQuantityById(drawnToy.getId());
                    writer.write("Выбранная игрушка: " + drawnToy.getName() + "\n");
                } else {
                    writer.write("Нет доступных игрушек\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void decreaseQuantityById(int id) {
        for (Toy toy : toyQueue) {
            if (toy.getId() == id) {
                toy.decreaseQuantity();
                break;
            }
        }
    }
}
