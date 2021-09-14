package banking;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String choice = "";
        String userChoice = "-1";
        int breakLoop = 1;
        userOperationsimpl userOperations = null;
        userAccountimpl accountoperations = null;
        IndividualUser individualUser = null;
        CorporateUser corporateUser = null;
        CurrentAccount currentAccount = null;
        SavingAccount savingAccount = null;

        do {
            System.out.println("\n\n   -------------------------\n \t 1. Create new user\n   -------------------------");
            choice = input.next();


            switch (choice) {
                // to create user type
                case "1":

                    do {
                        System.out.println("\t---------------------\n\t\t1. Create Individual User\n\t\t2. Create CorporateUser user \n\t--------------------- ");
                        userChoice = input.next();
                        // create user type
                        switch (userChoice) {
                            // create individualUser user
                            case "1":
                                individualUser = new IndividualUser();
                                userOperations = new userOperationsimpl();
                                // get user general/common properties
                                userOperations.createUser(individualUser);
                                // get User type specific property
                                userOperations.createIndividualUser(individualUser);

                                // print created user
                                System.out.println("\n-------------------\n");
                                System.out.println("User has been created \n");
                                System.out.println("UserName: " + individualUser.getfullName() +
                                        "\t Userid:  " + individualUser.getUserid() + "\t userCnic: " + individualUser.getCnic());
                                System.out.println("\n--------------------- \n");
                                accountoperations = new userAccountimpl();
                                accountoperations.createIndividualAccount(choice, userChoice, accountoperations, individualUser, corporateUser);
                                break;
                            case "2":
                                corporateUser = new CorporateUser();
                                userOperations = new userOperationsimpl();
                                // get user general properties
                                userOperations.createUser(corporateUser);
                                // get User type specific property
                                userOperations.createCorporateUser(corporateUser);
                                // print created user
                                System.out.println("Corporate user has been created \n");

                                System.out.println(" Name: " + corporateUser.getfullName() + "\t Is govtApproved: "
                                        + corporateUser.isGovtApproved());
                                accountoperations = new userAccountimpl();
                                accountoperations.createCorporateAccount(choice, userChoice, accountoperations, corporateUser, individualUser);

                                break;

                            default:
                                System.out.println("please enter correct option ");
                        }

                    } while (choice != "0");
                    // show created users

                default:

                    System.out.println("Please enter correct option from below\n");

                    break;
            }


        } while (breakLoop != 0);

    }
}
