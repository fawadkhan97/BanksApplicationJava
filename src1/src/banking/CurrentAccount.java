package banking;

import banking.Account;

public class CurrentAccount extends Account {

    private final int minimumBalance = 10000;

    public int getMinimumBalance() {
        return minimumBalance;
    }
}
