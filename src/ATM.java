import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class ATM {


    public static Client authenticate(Bank bn, Scanner sc){

        long client_id;
        int password;
        Client client;

        do {
            System.out.println("Insert the card");
            System.out.println("Enter your id");
            client_id = sc.nextLong();
            System.out.println("Insert your password");
            password = sc.nextInt();
            client = bn.authorization(client_id, password);
            if (client == null) {
                System.out.println("This combination is incorrect. Try again");
            }
        } while (client == null);

        return client;
    }

//    public void process_the_card() {
//
//    }
//
//    private void validate_the_card(int identifier, int password) {
//    }
//
//    private void insert_the_card() {
//
//    }


}
