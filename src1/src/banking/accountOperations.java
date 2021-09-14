package banking;

import banking.Account;

public interface accountOperations {
    void createAccount(Account newAccount);

    void updateAccount(Account updateAccount);

    void Deposit(Account account);

    void withDraw(Account account);

    void checkBalance(Account account);

}
