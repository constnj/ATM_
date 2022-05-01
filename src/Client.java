import java.util.ArrayList;

public class Client {

    private String name_of_the_client;
    private int password;
    private ArrayList<Account> accounts;
    private long client_id;
    private Bank bank;

//    private String uuid;
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

    public int get_the_password() {
        return password;
    }
}
