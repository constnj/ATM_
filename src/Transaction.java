import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private double amount_of_money;
    private String date_of_the_transaction;
    private Account who_sent_the_money;
    private String who_get_the_money;

    public Transaction(double am, Account ac, String receiver) {
        this.amount_of_money = am;
        this.who_sent_the_money = ac;
        this.who_get_the_money = receiver;
        this.date_of_the_transaction = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public void show_details() {
        System.out.printf("you sent %,.2f on %s", this.amount_of_money, this.date_of_the_transaction);
    }
}
