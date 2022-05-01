import java.util.Date;

public class Transaction {
    // date
    // from
    // to
    // amount_of_money

    private double amount_of_money;
    private Date date_of_the_transaction;
    private Account who_sent_the_money;

    public Transaction(double am, Account ac) {
        this.amount_of_money = am;
        this.who_sent_the_money = ac;
        this.date_of_the_transaction = new Date();
    }
}
