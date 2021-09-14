package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class userOperationsimpl implements userOperations {

	Scanner input = new Scanner(System.in);
	boolean loopBreak = true;

	// User operations
	public void createUser(Users newuser) {
		System.out.println("enter name");
		newuser.setfullName(input.next());
		System.out.println("enter your address ");
		newuser.setAddress(input.next());
		System.out.println("Enter your email");
		newuser.setEmail(input.next());

		// return newuser;
	}

	public void updateUser(Users updateUser) {

	}

	// User type specific methods
	public void createIndividualUser(IndividualUser newuser) {
		System.out.println("Enter your Cnic");
		newuser.setCnic(input.next());

	}

	public void createCorporateUser(CorporateUser newuser) {

		System.out.println("enter number of employess ");

		do {
			try {
				newuser.setNoOfEmployess(input.nextInt());
				loopBreak = false;
			} catch (InputMismatchException e) {
				System.out.print("Incorrect format, Please enter again (number only) : ");
				input.next();
			}
		} while (loopBreak);

		System.out.println("Is your company government approve ? \t True / False ? ");
		do {
			loopBreak = true;
			try {
				newuser.setGovtApproved(input.nextBoolean());
				loopBreak = false;
			} catch (InputMismatchException exception) {
				System.out.print("Incorrect format, Please enter again is Govt approved True / False ? ");
				input.next();
			}

		} while (loopBreak);

		System.out.println("Is it local company ?  \t True / False ?");
		do {
			loopBreak = true;
			try {
				newuser.setLocal(input.nextBoolean());
				loopBreak = false;
			} catch (InputMismatchException exception) {
				System.out.print("Incorrect format, Please enter again is local company  True / False ? ");
				input.next();
			}

		} while (loopBreak);

	}

}
