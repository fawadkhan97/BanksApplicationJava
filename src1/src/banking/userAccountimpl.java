package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class userAccountimpl implements accountOperations {
	Scanner input = new Scanner(System.in);
	double balance;
	double amount;
	boolean loopBreaker = true;

	@Override

	public void createAccount(Account newAccount) {
		System.out.println("enter account title");
		newAccount.setAccountTitle(input.next());

		do {
			try {
				System.out.println("enter account id");
				newAccount.setAccountId(input.nextInt());
				System.out.println("enter account balance");
				newAccount.setBalance(input.nextDouble());
				loopBreaker = false;
			} catch (InputMismatchException e) {
				System.out.println("\nInput was incorrect please enter again\n");
				input.next();

			}
		} while (loopBreaker);

	}

	public void createIndividualAccount(String choice, String userChoice, userAccountimpl accountoperations,
			IndividualUser individualUser, CorporateUser corporateUser) {
		do {

			// create account of Individual user
			System.out.println(" Create a new account ");
			System.out.println("Select account type \n1. Current\n2. Savings ");
			userChoice = input.next();
			// create account
			switch (userChoice) {
			// create current account
			case "1":
				CurrentAccount currentAccount = new CurrentAccount();
				accountoperations = new userAccountimpl();
				accountoperations.createAccount(currentAccount);
				currentAccount.setType("Current");
				currentAccount.setStatus("Active");
				System.out.println(" Current account has been created ");
				System.out.println("------------------\n");
				System.out.println(
						" userName : " + individualUser.getfullName() + "\t Cnic : " + individualUser.getCnic());
				System.out.println("\nAccount Title: " + currentAccount.getAccountTitle() + "\t Balance : "
						+ currentAccount.getBalance() + "\t ID: " + currentAccount.getAccountId());
				System.out.println("\n-------------------------\n");

				// print details and perform operations(withdraw , deposit,check balance) on
				// account
				accountoperations.currentAccountOperations(userChoice, currentAccount, accountoperations,
						individualUser, corporateUser);
				break;
			// create saving account
			case "2":
				SavingAccount savingAccount = new SavingAccount();
				double balance;
				accountoperations = new userAccountimpl();
				accountoperations.createAccount(savingAccount);
				savingAccount.setType("Savings");
				savingAccount.setStatus("Active");
				balance = savingAccount.getBalance() + (savingAccount.getBalance() * savingAccount.getIntrest());
				savingAccount.setBalance(balance);
				System.out.println("Savings account has been created");
				System.out.println("------------------\n");
				System.out.println(
						" userName : " + individualUser.getfullName() + "\t Cnic : " + individualUser.getCnic());
				System.out.println("\nAccount Title: " + savingAccount.getAccountTitle() + "\t Balance : "
						+ savingAccount.getBalance() + "\t ID: " + savingAccount.getAccountId());
				System.out.println("\n-------------------------\n");
				// print details and perform operations(withdraw , deposit,check balance) on
				// account
				accountoperations.savingAccountOperations(userChoice, savingAccount, accountoperations, corporateUser,
						individualUser);
				break;
			default:
				System.out.println("please enter correct option again ");

			}

		} while (!(choice.equals("0")));
	}

	public void createCorporateAccount(String choice, String userChoice, userAccountimpl accountoperations,
			CorporateUser corporateUser, IndividualUser individualUser) {
		System.out.println("Create a new account");

		do {

			// create account of corporate user
			System.out.println("Select account type \n1. Current\n2. Savings ");
			userChoice = input.next();
			// create account
			switch (userChoice) {
			// create current account
			case "1":
				CurrentAccount currentAccount = new CurrentAccount();
				accountoperations = new userAccountimpl();
				accountoperations.createAccount(currentAccount);
				currentAccount.setType("Current");
				currentAccount.setStatus("Active");
				System.out.println("Current account has been created");
				System.out.println(" userName : " + corporateUser.getfullName() + "\t Number of Employess : "
						+ corporateUser.getNoOfEmployess());
				System.out.println("\nAccount Title: " + currentAccount.getAccountTitle() + "\t Balance : "
						+ currentAccount.getBalance());
				System.out.println("\n-------------------------\n");
				// print details and perform operations(withdraw , deposit,check balance) on
				// account
				accountoperations.currentAccountOperations(userChoice, currentAccount, accountoperations,
						individualUser, corporateUser);
				break;

			// create saving account
			case "2":
				SavingAccount savingAccount = new SavingAccount();
				accountoperations = new userAccountimpl();
				accountoperations.createAccount(savingAccount);
				savingAccount.setType("Savings");
				savingAccount.setStatus("Active");
				System.out.println("Savings account has been created");
				System.out.println(" userName : " + corporateUser.getfullName() + "\t Number of employess : "
						+ corporateUser.getNoOfEmployess());
				System.out.println("\nAccount Title: " + savingAccount.getAccountTitle() + "\t Balance : "
						+ savingAccount.getBalance());
				System.out.println("\n-------------------------\n");
				// print details and perform operations(withdraw , deposit,check balance) on
				// account
				accountoperations.savingAccountOperations(userChoice, savingAccount, accountoperations, corporateUser,
						individualUser);

				break;
			default:
				System.out.println("please enter correct option again ");

			}
			break;
		} while (choice != "0");
	}

	@Override
	public void updateAccount(Account updateAccount) {
		System.out.println("is updating ");
	}

	@Override
	public void checkBalance(Account account) {
		System.out.println("\n ------------------------------------");
		System.out.println("Balance : " + account.getBalance());
		System.out.println("\n ------------------------------------");

	}

	@Override
	public void Deposit(Account account) {
		balance = account.getBalance();
		do {
			try {
				System.out.println("\nEnter amount to deposit ");
				amount = input.nextInt();
				balance += amount;
				account.setBalance(balance);
				System.out.println("\n ------------------------------------");
				System.out.println("Balance after deposit : " + account.getBalance());
				System.out.println("----------------------------");
				loopBreaker = false;

			} catch (InputMismatchException exception) {

				System.out.println("Invalid amount was entered \n");
				input.next();

			}

		} while (loopBreaker);

	}

	@Override
	public void withDraw(Account account) {
		balance = account.getBalance();
		boolean amountBalanceCheck = true;
		System.out.print("enter amount to withdraw:  ");
		do {
			try {
				do {
					amount = input.nextInt();
					if (amount > balance) {
						System.out.print("\nEntered Amount: " + amount + " is greater than balance: " + balance
								+ "\n \t\tplease enter lower amount: ");
						amountBalanceCheck = true;
					} else {
						amountBalanceCheck = false;
					}
				} while (amountBalanceCheck);
				balance -= amount;
				account.setBalance(balance);
				System.out.println("\n\t ------------------------------------");
				System.out.println("\t\tBalance after withdrawal : " + account.getBalance());
				System.out.println("\n\t\t------------------------------------");
				loopBreaker = false;

			} catch (InputMismatchException exception) {
				loopBreaker = true;
				input.next();
				System.out.print("invalid amount was entered PLease Enter Again:  ");

			}

		} while (loopBreaker);

	}

	// Print account details perform account operations
	public void currentAccountOperations(String userChoice, CurrentAccount currentAccount,
			userAccountimpl accountoperations, IndividualUser individualUser, CorporateUser corporateUser) {
		label: do {
			System.out.println("------------------------------------");
			System.out.println(" Choose your operation \n1. Print User details\n"
					+ "2. Print Account details \n3. Perform Account operations");
			userChoice = input.next();
			System.out.println("------------------------------------");
			// print user details
			switch (userChoice) {
			case "1":
				if (individualUser != null) {
					System.out.println("------------------\n");
					System.out.println(
							" userName : " + individualUser.getfullName() + "\t Cnic : " + individualUser.getCnic());
					System.out.println("------------------\n");
				} else {
					System.out.println("------------------\n");
					System.out.println(" userName : " + corporateUser.getfullName() + "\t Number of employes : "
							+ corporateUser.getNoOfEmployess());
					System.out.println("------------------\n");
				}
				break;
			// print account details
			case "2":
				System.out.println("\nAccount Title: " + currentAccount.getAccountTitle() + "\t Balance : "
						+ currentAccount.getBalance());
				break;
			// Perform Account operations (check balance , withdraw , deposit)
			case "3":

				if (currentAccount == null) {
					System.out.println("No account exist please create user and account first ");
					break label;
				} else
					System.out.println("------------------------------------");

				System.out.println("\n select operation type \n1. Balance \n2. Withdraw \n3. Deposit");
				userChoice = input.next();
				switch (userChoice) {
				case "1":
					accountoperations.checkBalance(currentAccount);
					break;

				case "2":
					accountoperations.withDraw(currentAccount);
					break;

				case "3":
					accountoperations.Deposit(currentAccount);
					break;
				}
				break;
			}
		} while (userChoice != "0");
	}

	// Print account details perform account operations
	public void savingAccountOperations(String userChoice, SavingAccount savingAccount,
			userAccountimpl accountoperations, CorporateUser corporateUser, IndividualUser individualUser) {
		do {
			System.out.println("------------------------------------");
			System.out.println(" Choose your operation \n1. Print User details\n"
					+ "2. Print Account details \n3. Perform Account operations");
			userChoice = input.next();

			System.out.println("------------------------------------");
			// Print user details
			if (userChoice.equals("1")) {
				if (individualUser != null) {
					System.out.println("------------------\n");
					System.out.println(
							" userName : " + individualUser.getfullName() + "\t Cnic : " + individualUser.getCnic());
					System.out.println("------------------\n");
				} else {
					System.out.println("------------------\n");
					System.out.println(" userName : " + corporateUser.getfullName() + "\t Number of employes : "
							+ corporateUser.getNoOfEmployess());
					System.out.println("------------------\n");
				}
			}
			// Print Account details
			else if (userChoice.equals("2")) {
				System.out.println("\nAccount Title: " + savingAccount.getAccountTitle() + "\t Balance : "
						+ savingAccount.getBalance());
			}
			// Perform Account operations
			else if (userChoice.equals("3")) {

				if (savingAccount == null) {
					System.out.println("No account exist please create user and account first ");
					break;
				} else
					System.out.println("------------------------------");

				System.out.println("\n select operation type \n1. Balance \n2. Withdraw \n3. Deposit");
				userChoice = input.next();
				switch (userChoice) {
				case "1":
					System.out.println("\n ------------------------------------");
					System.out.println("Balance : " + savingAccount.getBalance());
					System.out.println("----------------------------");
					break;

				case "2":

					accountoperations.withDraw(savingAccount);

					break;

				case "3":

					accountoperations.Deposit(savingAccount);

					break;
				}
			}
		} while (userChoice != "0");
	}

}
