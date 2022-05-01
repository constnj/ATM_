import java.util.Scanner;

public class ATM {

    public ATM() {
        return;
    }


    public static Client authenticate(Bank bn, Scanner sc){

        String client_name;
        int password;
        Client client;

        do {
            System.out.println("Insert the card");
            System.out.println("Enter your id");
            client_name = sc.nextLine();
            System.out.println("Insert your password");
            password = sc.nextInt();
            client = bn.authorization(client_name, password);
            if (client == null) {
                System.out.println("This combination is incorrect. Try again");
            }
        } while (client == null);

        return client;
    }

    public static void main_menu(Client client, Scanner sc) {
        int chosen;

        do  {
            System.out.println("What do you need?");
            System.out.println("1 - history of transactions");
            System.out.println("2 - put money to the account");
            System.out.println("3 - withdraw money");
            System.out.println("4 - make a transaction");
            System.out.println("5 - show the current amount");
            System.out.println("6 - exit");
            System.out.println("__________________________");
            System.out.println("Enter the number: ");
            chosen = sc.nextInt();
        } while (chosen < 0 || chosen > 6);

        switch (chosen) {
            case 1:
                client.show_history_of_all_client_transactions();
                break;
            case 2:
                double a = enter_the_sum(sc);
                client.put_the_money_to_the_account(sc, a);
                break;
            case 3:
                double b = enter_the_sum(sc);
                client.get_the_money_from_the_account(sc, b);
                break;
            case 4:
                double c = enter_the_sum(sc);
                client.withdraw_the_money(sc, c);
            case 5:
                client.show_the_total_amount();
                break;
        }

        if (chosen != 6) {
            main_menu(client, sc);
        }
    }

    public static double enter_the_sum(Scanner sc) {
        System.out.println("Enter the sum: ");
        double res = sc.nextDouble();
        return res;
    }

}
