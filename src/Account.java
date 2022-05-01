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

//    private String name;
//    private String uuid;

    public Account(Bank bn, Client cl) {
        this.owner = cl;
        this.emitentBank = bn;
        this.transactions = new ArrayList<Transaction>();
        this.accountId = this.emitentBank.create_new_account_Id();

        owner.add_new_account(this);
        emitentBank.add_new_account(this);

    }

    public long get_the_account_id() {
        return this.accountId;
    }
}
