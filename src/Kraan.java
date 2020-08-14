import java.util.Random;

public class Kraan implements Runnable {
   int kraanNummer;
   Containerschip boot = Program.boot;
   Kade kade = Program.kade;
   Random random = new Random();




    public Kraan(int kraanNummer) {

        this.kraanNummer = kraanNummer;

    }

    public void run(){
        while(true){
            getContainer();
        }
    }

    // Haalt container van de boot en zet deze op de kant.

    public void getContainer(){
        System.out.println("kraan\t" + kraanNummer + "\t wil container halen");
        Container container =  boot.releaseContainer();

       if(container != null){
           int time = (random.nextInt(5000) + 1000);
           try {
               Thread.sleep(time);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("kraan\t" + kraanNummer + " \theeft container \t" + container.volgNummer );
           releaseContainer(container);

       }
    }

   // Zoland er geen plek vrij is op de kant wacht de kraan.
    public synchronized void releaseContainer(Container container){
        boolean dropped = false;

        while(dropped == false) {
            dropped = kade.addContainer(container);

        }
    }









}
