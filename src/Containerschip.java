import java.util.ArrayList;
import java.util.List;



public class Containerschip {

  public ArrayList<Container> containers = new ArrayList<Container>();

  //Maakt 100 containers aan

  public  Containerschip(){
      for(int i = 0; i <= 99; i++){
          containers.add(new Container(i));
        System.out.println("container\t" + i +  "\tgemaakt");
      }
    }

    //Als lijst containers groter is dan 0 geeft boot 1 container vrij aan kranen
    // en verwijdert deze uit de lijst van de containers op de bank.
    // Als lijst containers 0 is, is het schip leeg en zal het programma stoppen.
    public Container releaseContainer(){
      synchronized (containers) {
        if (containers.size() > 0) {
          Container container = containers.get(containers.size() - 1);
          System.out.println("Schip: \tcontainer \t" + container.volgNummer + "\tvrij gegeven");
          removeContainer(container);
          return container;
        } else {
          System.out.println("Schip is leeg");
           System.exit(0);
            return null;
        }
      }
    }

    //verwijdert containers uit lijst op boot
    public void removeContainer(Container container){
      containers.remove(container);
    }

}
