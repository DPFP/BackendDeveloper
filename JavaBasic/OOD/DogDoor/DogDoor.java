package JavaBasic.OOD.DogDoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
    private boolean open;
    private List<Bark> allowedBarks;

    public DogDoor() {
        this.open = false;
        this.allowedBarks = new ArrayList<>();
    }

    public void open(){
        this.open = true;
        System.out.println("The dog door opens.");

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        },5000);

    }

    public void close(){
        this.open = false;
        System.out.println("The dog door closes.");
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void addAllowedBark(Bark bark){
        this.allowedBarks.add(bark);
    }

    public List<Bark> getAllowedBarks(){
        return this.allowedBarks;
    }
}
