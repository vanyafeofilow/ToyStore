// Main.java

public class Main {
    public static void main(String[] args) {
        RaffleToys raffleToys = new RaffleToys();

        raffleToys.addToy(1, "Конструктор", 5, 20);
        raffleToys.addToy(2, "Робот", 5, 10);
        raffleToys.addToy(3, "Кукла", 5, 60);

        raffleToys.updateFrequency(2, 20);

        raffleToys.drawToys(10);
    }
}