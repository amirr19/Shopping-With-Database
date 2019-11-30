package ir.maktab32.ex4.q2;

public class userAccount {
    private String name;
    private String lastName;
    private String username;
    private int phoneNumber;
    private String email;
    private String street;
    private String city;
    private int zipcode;
    public userAccount(String name, String lastName, String username, int phonrNumber, String email, String street,String city,int zipcode){
        this.name=name;
        this.lastName=lastName;
        this.username= username;
        this.phoneNumber = phonrNumber;
        this.street = street;
        this.email = email;
        this.city= city;
        this.zipcode=zipcode;
    }

}
