package JavaBasic.OOD.DogDoor;

import java.util.List;

public class BarkRecognizer {
    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark){
        List<Bark> allowedBarks = this.door.getAllowedBarks();
        System.out.println("BarkRecognizer: Heard a " + bark.getSound());
        for(Bark allowedBark : allowedBarks){
            if(bark.equals(allowedBark)){
                this.door.open();
                return;
            }
        }
        System.out.println("This dog is not allowed. ");
    }
}
