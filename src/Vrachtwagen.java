import java.util.Random;

public class Vrachtwagen implements Runnable {
 int wagenNummer;


 Kade kade = Program.kade;


 Random random = new Random();



 public Vrachtwagen(int wagenNummer){

     this.wagenNummer = wagenNummer;

    }


    public void run(){
        while(true){
            getContainer();
        }
    }

    // Wanneer er een container op de kade staat wordt deze opgehaald door de vrachtwagen.
    public void getContainer(){
     Container temp = kade.releaseContainer();
        if(temp!=null){

            System.out.println("Vrachtwagen:\t" + wagenNummer + " heeft container\t " + temp.volgNummer + " \topgepikt");

            int time = (random.nextInt(1000) + 4000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
