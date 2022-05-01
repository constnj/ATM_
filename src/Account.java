import java.util.ArrayList;

public class Account {
    // balance

    //send_the_money -> is_there_enough_money -> create Transaction
    //withdraw -> is_there_enough_money -> create Transaction
    //check_the_balance

    private Client owner;
    private double balance;
    private Bank emitentBank;
    private ArrayList<Transaction> transactions;
    private long accountId;


    public Account(Bank bn, Client cl, double bl) {
        this.owner = cl;
        this.emitentBank = bn;
        this.balance = bl;
        this.transactions = new ArrayList<Transaction>();
        this.accountId = this.emitentBank.create_new_account_Id();

        owner.add_new_account(this);
        emitentBank.add_new_account(this);

    }

    public long get_the_account_id() {
        return this.accountId;
    }

    public double get_the_balance() {
        return this.balance;
    }

    public void increase_the_balance(double sum) {
        this.balance += sum;
    }

    public void decrease_the_balance(double sum) {
        this.balance -= sum;
    }

    public void add_the_transaction(Transaction a) {
        this.transactions.add(a);
    }

    public void show_history_of_account_transactions() {
        for(Transaction t: this.transactions) {
            t.show_details();
        }
    }
}
