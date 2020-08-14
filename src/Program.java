public class Program {

    public static Containerschip boot = new Containerschip();
    public static Kade kade = new Kade();

    public static void main(String[] args) {

        // wagens worden aangemaakt
        Thread wagen1 = new Thread(new Vrachtwagen(1));
        Thread wagen2 = new Thread(new Vrachtwagen(2));
        Thread wagen3 = new Thread(new Vrachtwagen(3));

        //kranen worden aangemaakt
        Thread kraan1 = new Thread(new Kraan(1));
        Thread kraan2 = new Thread(new Kraan(2));

        // laat threads starten.
        kraan1.start();
        kraan2.start();

        wagen1.start();
        wagen2.start();
        wagen3.start();


    }
}
