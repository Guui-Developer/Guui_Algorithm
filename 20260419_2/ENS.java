import java.util.HashMap;
import java.util.Map;

public class Bank {

    public static final Long MAX_MONEY = 1000000000000L;
    Map<Integer, Long> accounts = new HashMap<>();

    public Bank(long[] balance) {
        for (int i = 0; i < balance.length; i++) {
            accounts.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        Long sender = accounts.get(account1);
        Long reciver = accounts.get(account2);

        if (reciver == null) {
            return false;
        }

        if (sender == null) {
            return false;
        }


        if (sender - money < 0) {
            return false;
        }

        sender -= money;
        accounts.put(account1, sender);

        Long target = accounts.get(account2);

        target += money;
        accounts.put(account2, target);
        return true;
    }

    public boolean deposit(int account, long money) {
        Long depositer = accounts.get(account);

        if (depositer == null) {
            return false;
        }

        depositer += money;

        if (depositer > MAX_MONEY) {
            return false;
        }

        accounts.put(account, depositer);

        return true;
    }

    public boolean withdraw(int account, long money) {

        Long withdrawer = accounts.get(account);

        if (withdrawer == null) {
            return false;
        }

        withdrawer -= money;

        if (withdrawer < 0) {
            return false;
        }

        accounts.put(account, withdrawer);
        return true;
    }
}
