import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank the_bank = new Bank("pinkoff");
        Client new_client = new Client("Ivan Pavlov", 1234, the_bank);
        Account new_account = new Account(the_bank, new_client);
        new_client.add_new_account(new_account);
        the_bank.add_new_account(new_account);
        
        Client test_client = ATM.authenticate(Bank the_bank, Scanner scanner);

    }
}
