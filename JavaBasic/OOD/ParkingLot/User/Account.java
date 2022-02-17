package JavaBasic.OOD.ParkingLot.User;

import JavaBasic.OOD.ParkingLot.DataEntity.Person;

public class Account {
    // should this extends Person ? Nope, just have a person
    private String userName;
    private String password;
    private AccountStatus status;
    // missing from the diagram
    private Person person;
}
