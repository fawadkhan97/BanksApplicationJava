package com.company;


import java.util.Scanner;

public class userOperationsimpl implements userOperations {

    Scanner input = new Scanner(System.in);

    // User operations
    public void createUser(Users newuser) {

        System.out.println("enter name");
        newuser.setfullName(input.next());
        System.out.println("enter your address ");
        newuser.setAddress(input.next());
        System.out.println("Enter your email");
        newuser.setEmail(input.next());


        //  return newuser;
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
        newuser.setNoOfEmployess(input.nextInt());

        System.out.println("Is your company government approve ? ");
        newuser.setGovtApproved(input.nextBoolean());
        System.out.println("Is it local company ? ");
        newuser.setLocal(input.nextBoolean());
    }


}







