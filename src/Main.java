import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank the_bank = new Bank("pinkoff");
        Client new_client = new Client("Ivan Pavlov", 1234, the_bank);
        Account new_account = new Account(the_bank, new_client, 10000);
        new_client.add_new_account(new_account);
        the_bank.add_new_account(new_account);
        the_bank.add_new_client(new_client);
        ATM new_atm = new ATM();

        Client test_client = new_atm.authenticate(the_bank, scanner);
        new_atm.main_menu(test_client, scanner);


    }
}
