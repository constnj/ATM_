import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name_of_the_bank;
    private ArrayList<Account> accounts;
    private ArrayList<Client> clients;

    public Bank(String name) {
        this.name_of_the_bank = name;
        this.accounts = new ArrayList<Account>();
        this.clients = new ArrayList<Client>();
    }

    public void add_new_account(Account account) {
        this.accounts.add(account);
    }

    public void add_new_client(Client client) {
        this.clients.add(client);
    }

    public long create_new_account_Id() {

        long new_account_id;
        boolean number_is_not_unique;

        Random r = new Random();

        do {

//            new_account_id = r.nextLong(9_000_000_000) + 1_000_000_000;
            new_account_id = r.nextLong(1_000_000_0, 10_000_000_0);
            System.out.println(new_account_id);
            number_is_not_unique = false;
            for (Account a : this.accounts) {
                if(new_account_id == a.get_the_account_id()) {
                    break;
                }
            }
        } while (number_is_not_unique);

        return new_account_id;
    }

    public long create_new_client_Id() {

        long new_client_id;
        boolean number_is_not_unique;

        Random r = new Random();

        do {

            new_client_id =  r.nextLong(1_000_000_0, 10_000_000_0);
            number_is_not_unique = false;
            for (Client c : this.clients) {
                if(new_client_id == c.get_the_client_id()) {
                    break;
                }
            }
        } while (number_is_not_unique);

        return new_client_id;
    }

    public Client authorization(String client_name, int password) {
        for (Client c : this.clients) {
            if (c.get_the_client_name() == client_name && c.get_the_password() == password) {
                return c;
            }
        }
        return null;
    }



}
