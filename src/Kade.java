import java.util.ArrayList;




public class Kade {

    ArrayList<Container> kadeplek = new ArrayList<Container>();

    public Kade() {

    }

    // checkt of er plek vrij is op de kade
    public boolean FreeSpace(){
        if(kadeplek.size() < 5){
            return true;
        }
        else{
            return false;
        }
    }

    // Als plek vrij is wordt de container door kraan op de kade geplaatst
    // en wordt toegevoegd aan lijst op de kade
    public boolean addContainer(Container container){
        synchronized (kadeplek) {

            if (FreeSpace()) {
                System.out.println("Kade heeft Container: \t" + container.volgNummer);
                kadeplek.add(container);
                return true;
            } else {
                return false;
            }

        }

    }

    // Geeft container vrij aan vrachtwagen
    // en verwijdert deze uit de lijst op de kade
    public Container releaseContainer() {
        synchronized (kadeplek) {
            if (!kadeplek.isEmpty()) {
                Container container = kadeplek.remove(0);

                return container;

            } else {

                return null;
            }
        }
    }



}
