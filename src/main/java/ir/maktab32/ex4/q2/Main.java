import ir.maktab32.ex4.q2.userAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keepGoing = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        System.out.println("name:");
        String name = sc.nextLine();
        System.out.println("lastname:");
        String lastname = sc.nextLine();
        System.out.println("username:");
        String username = sc.nextLine();
        System.out.println("email:");
        String email = sc.nextLine();
        System.out.println("city:");
        String city = sc.nextLine();
        System.out.println("street:");
        String street = sc.nextLine();
        System.out.println("zipcode:");
        int zipcode = sc.nextInt();
        System.out.println("phone:");
        int phone = sc.nextInt();
        userAccount user = new userAccount(name, lastname, username, phone, email, street, city, zipcode);



//construct store:
        {
            Store store = new Store();
            //tv 1
            Product SamsungTV = new Tv("Samsung tv", "electric", 10_000, 5);
            Store.stores.add(SamsungTV);
            //tv 2
            Product LGTV = new Tv("LGTV", "electric", 10_000, 5);
            Store.stores.add(LGTV);
            //radio 1
            Product radioPanasonic = new Radio("panasonic radio", "electric", 10_000, 5);
            Store.stores.add(radioPanasonic);
            //shoes 1
            Product officialShoes = new Shoes("melli shoes", "Shoes", 10_000, 5);
            Store.stores.add(officialShoes);
            //shoes 2
            Product sportShoes = new Shoes("nike shoes", "Shoes", 10_000, 5);
            Store.stores.add(sportShoes);
            //news paper 1
            Product iranNewspaper = new Newspaper("iran Newspaper", "readable", 10_000, 5);
            Store.stores.add(iranNewspaper);
            //news paper 2
            Product newYorkTimes = new Newspaper("newYorkTimes", "readable", 10_000, 5);
            Store.stores.add(newYorkTimes);
        }
//Start to buy:-----------------------
        //Constructing user basket
        Basket userBasket = new Basket();
        //show the lists!
        printStores();
        do {
            System.out.println("Type 1 for add another stuff \nType 0 for remove from the basket (if u have bought something)");
            // adding and removing
            int addOrRemove = sc.nextInt();
            //adding
            if (addOrRemove == 1) {
                if (userBasket.basket.size() < 5) {
                    System.out.println("Please inter the Item number of stuff which you want to buy:");
                    int item = sc.nextInt();
                    //show what the user have been bought:
                    if (Store.stores.get(item - 1).getQuantity() != 0) {
                        System.out.println("You have Chosen "
                                + Store.stores.get(item - 1).getName()
                                + " in "
                                + Store.stores.get(item - 1).getField()
                                + " field."
                                + "\n"
                                + "the Cost is: " + Store.stores.get(item - 1).getCost()
                        );
                        Store.stores.get(item - 1)
                                .setQuantity
                                        (Store.stores.get(item - 1).getQuantity() - 1);
                        userBasket.basket.add(Store.stores.get(item - 1));
                        printBasket(userBasket);
                    } else if (Store.stores.get(item - 1).getQuantity() == 0) {
                        System.out.println("We Do not have it , Sorry!");
                    }
                } else {
                    System.out.println("!-!-!-!-!-!-!-!");
                    System.out.println("Ur basket is full... u should delete something");
                }
            }
            //removing
            else if (addOrRemove == 0) {
                System.out.println("please inter the item number which u wanna remove");
                int removeItem = sc.nextInt();
                System.out.println(userBasket.basket.get(removeItem - 1).getName() + " removed");
                for (int r = 0; r < Store.stores.size(); r++) {
                    if(Store.stores.get(r).getName().equals(userBasket.basket.get(removeItem - 1).getName())){
                        Store.stores.get(r).setQuantity(Store.stores.get(r).getQuantity()+1);
                    }

                }
                userBasket.basket.remove(removeItem - 1);
            }
            printStores();
            System.out.println("do u wanna continue? Type 1 for yes and 0 for no");
        } while (keepGoing.nextInt() == 1);
        int price = 0;
        for (int a = 0; a < userBasket.basket.size(); a++) {
            price += userBasket.basket.get(a).getCost();
        }
        System.out.println("shop has been finished." +
                "\n The Total Price is: " +
                price);
        printBasket(userBasket);
        System.out.println("verify Your Shopping by typing 1");
        if (sc.nextInt() == 1) {
            for (Product item : userBasket.basket
            ) {
                userBasket.basket.remove(item);
            }
        }
    }

    private static void printStores() {
        //show the lists!
        int i = 1;
        for (Product product : Store.stores) {

            System.out.println("Item." + i + "\t" + product.name + "\t from" + product.field + "\n" + "Price:\t" + product.cost +
                    "\t Quantity:\t" + product.quantity);
            System.out.println("========================");
            i++;
        }

    }

    private static void printBasket(Basket userBasket) {
        System.out.println("_________$$$___________");
        System.out.println("Ur basket Consists of: ");
        for (int k = 0; k < userBasket.basket.size(); k++) {
            System.out.println((k + 1) + ". " + userBasket.basket.get(k).getName());
        }
        System.out.println("________$$$____________");

    }
}