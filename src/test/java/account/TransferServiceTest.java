package account;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TransferServiceTest {

    @Test
    public void can_transfer_money_from_one_account_to_another(){
        Account srcAccount = new Account("xxUser", 100.0D);
        Account targetAccount = new Account("yyUser", 50.0D);
        TransferService transferService = new TransferService();
        transferService.transfer(srcAccount, targetAccount, 50.0D);
        assertThat(srcAccount.getBalance(), is(50.0D));
        assertThat(targetAccount.getBalance(), is(100.0D));
    }
}