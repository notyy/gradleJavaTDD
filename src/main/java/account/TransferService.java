package account;

public class TransferService {
    public void transfer(Account srcAccount, Account targetAccount, double money) {
        srcAccount.dec(money);
        targetAccount.inc(money);
    }
}
