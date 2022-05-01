import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private String name_of_the_client;
    private int password;
    private ArrayList<Account> accounts;
    private long client_id;
    private Bank bank;

    public Client(String name, int password, Bank bn) {
        this.name_of_the_client = name;
        this.password = password;
        this.bank = bn;
        this.client_id = this.bank.create_new_client_Id();
        this.accounts = new ArrayList<Account>();
}

    public void add_new_account(Account account) {
        this.accounts.add(account);
    }

    public long get_the_client_id() {
        return this.client_id;
    }

    public String get_the_client_name() {
        return this.name_of_the_client;
    }

    public int get_the_password() {
        return password;
    }

    public void show_the_total_amount() {
        double result = 0;
        for (int i = 0; i < accounts.size(); i++) {
            result += accounts.get(i).get_the_balance();
        }
        System.out.println(result);
    }

    public void show_history_of_all_client_transactions() {
        for(Account a: this.accounts) {
            a.show_history_of_account_transactions();
        }
    }

    public void put_the_money_to_the_account(Scanner sc, double sum) {
        Account ac = choose_the_account(sc);
        ac.increase_the_balance(sum);
    }

    public void get_the_money_from_the_account(Scanner sc, double sum) {
        Account ac = choose_the_account(sc);
        if(check_the_account_balance(ac, sum)) {
            ac.decrease_the_balance(sum);
        }
    }

    public void withdraw_the_money(Scanner sc, double sum) {
        Account ac = choose_the_account(sc);
        if (check_the_account_balance(ac, sum)) {
            String receiver = choose_the_receiver(sc);
            ac.add_the_transaction(new Transaction(sum, ac, receiver));
        }
    }

    private String choose_the_receiver(Scanner sc) {
        String result;
        System.out.println("Enter the name of the receiver: ");
        result = sc.nextLine();
        return result;
    }

    private Account choose_the_account(Scanner sc) {
        int a;

        for (int i = 0; i < this.accounts.size(); i++) {
            System.out.printf("%i - %i", i, this.accounts.get(i).get_the_account_id());
        }

        System.out.println("Choose the account id: ");
        a = sc.nextInt();
        return this.accounts.get(a);
    }

    private boolean check_the_account_balance(Account ac, double sum) {
        if (ac.get_the_balance() - sum > 0) {
            return true;
        }
        System.out.println("You haven't got enough");
        return false;
    }
}
