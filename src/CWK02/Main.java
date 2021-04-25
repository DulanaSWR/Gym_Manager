package CWK02;

import java.util.Scanner;

public class Main{

    private static defaultMember member;
    private static defaultMember membershipNo;

    public static void application() {
        MyGymManager myGymManager = new MyGymManager();

        Scanner sc = new Scanner(System.in);        //Scanner object for take inputs from user
        System.out.println("------------------------------------------------------------------");
        //Option numbers
        System.out.println("GYM management system");
        System.out.println("1) Enter a new member  ");
        System.out.println("2) Delete a member  ");
        System.out.println("3) Print the members ");
        System.out.println("4) Sort the members ");
        System.out.println("5) Save File ");
        System.out.println("6) Open Application");
        System.out.print("Enter your option : ");
        int userOption = sc.nextInt();              //convert user input as an integer
        //Validating user input
        if (userOption >6) {                //If user enter a option number above 6 there is no option for that number.
            System.out.println("Invalid option number.");
            System.out.println("Please try again!");
            application();
        }
        else {
            //option numbers connected to relevant method
            switch (userOption) {
                case 1:
                    myGymManager.addAMember(member);
                    break;
                case 2:
                    myGymManager.deleteMember(membershipNo);
                    break;
                case 3:
                    myGymManager.printList();
                    break;
                case 4:
                    myGymManager.sortFile();
                    break;
                case 5:
                    myGymManager.saveFile();
                    break;
                case 6:
                    myGymManager.openApplication();
                    break;
            }
            System.out.println("------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {

        application();

    }

}

