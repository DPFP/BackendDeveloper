package JavaBasic.OOD.DogDoor;

public class Remote {
    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton(){
        if(this.door.isOpen()){
            this.door.close();
        }else{
            this.door.open();
        }
    }
}
