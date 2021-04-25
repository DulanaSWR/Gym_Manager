package CWK02;

import javafx.application.Application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class MyGymManager implements gymManager{
    //Array list for store user inputs
    public static ArrayList<defaultMember> memberList = new ArrayList<>();

    //add member method
    @Override
    public void addAMember(defaultMember member) {
        int filledSlots = (memberList.size());
        int emptySlots = (100 - memberList.size());
        System.out.println("Number of filled slots : " + filledSlots);
        System.out.println("Number of empty slots for new members: " + emptySlots);

        if (emptySlots > 100) {
            System.out.print("No empty slot for a new member");
            return;
        }
        Scanner input = new Scanner(System.in);         //Scanner object for get user inputs

        System.out.println("Member types;");
        System.out.println("");
        System.out.println("1)Default member ");
        System.out.println("2)Student member ");
        System.out.println("3)Over60 member  ");
        System.out.println("");
        System.out.print("Enter the option : ");

        int option = input.nextInt();
        if (option > 3) {               //Validate the user inputs. If only user input 3 or below it works. otherwise error message will displayed
            System.out.println("Invalid option number.");
            System.out.println("Please try again!");
            addAMember(member);
        }
        else {
            System.out.println("");

            defaultMember mem = null;
            Date date = null;
            Scanner scanner = new Scanner(System.in);       //Scanner object for get user inputs

            System.out.print("Enter the id : ");
            String id = scanner.nextLine();
            System.out.print("Enter the name : ");
            String name = scanner.nextLine();
            System.out.print("Enter the gender : ");
            String gender = scanner.nextLine();
            System.out.print("Enter the contact number : ");
            String conNumber = scanner.nextLine();

            System.out.println(" ");
            System.out.println("Set the date; ");
            Scanner scannerdate = new Scanner(System.in);       //Scanner object for get user inputs


            //validate the date
            System.out.print("Enter the year : ");
            int yyyy = scannerdate.nextInt();
            while (yyyy <= 1980 && yyyy > 2021) {
                System.out.println("Invalid! Please re enter Correct year");
                System.out.print("Enter the year : ");
                yyyy = scannerdate.nextInt();
            }

            System.out.print("Enter the month : ");
            int mm = scannerdate.nextInt();
            while (mm > 12 && mm <= 0) {
                System.out.println("Invalid! Please re enter Correct month");
                mm = scannerdate.nextInt();
            }
            if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
                System.out.print("Enter the day : ");
                int d = scannerdate.nextInt();
                while (d > 31 && d <= 0) {
                    System.out.println("Invalid! Please re enter Correct day");
                    d = scannerdate.nextInt();
                }
            } else if (mm == 2) {
                System.out.print("Enter the day : ");
                int d = scannerdate.nextInt();
                while (d > 28 && d <= 0) {
                    System.out.println("Invalid! Please re enter Correct day");
                    d = scannerdate.nextInt();
                }
            } else {
                System.out.print("Enter the day : ");
                int d = scannerdate.nextInt();
                while (d > 31 && d <= 0) {
                    System.out.println("Invalid! Please re enter Correct day");
                    d = scannerdate.nextInt();

                }

                date = new Date(d, mm, yyyy);
                System.out.println("");
            }

            //options for relevant user input
            switch (option) {
                case 1:
                    mem = new defaultMember(id, name, date, gender, conNumber);
                    break;
                case 2:
                    Scanner schoolSc = new Scanner(System.in);
                    System.out.print("Enter the school name : ");
                    String school = schoolSc.nextLine();
                    System.out.print("Enter the Guardian contact number : ");
                    String contactNum = schoolSc.nextLine();
                    mem = new studentMember(id, name, date, gender, conNumber, school, contactNum);
                    break;
                case 3:
                    Scanner over60Sc = new Scanner(System.in);
                    System.out.print("Enter the Age  : ");
                    int age = over60Sc.nextInt();
                    if (age >= 60) {
                        mem = new over60Member(id, name, date, gender, conNumber, age);
                        break;
                    } else {
                        System.out.println("Invalid age!");
                        System.out.println("Re enter Correct details about member");
                        System.out.println("-------------------------------------------------------------------------");
                    }


                default:
                    addAMember(member);
            }
            memberList.add(mem);
            Main.application();
        }
    }

    //delete member method
    @Override
    public void deleteMember(defaultMember membershipNo) {
        try {
            if (memberList.size() == 0) {
                System.out.println("No members to delete");
                return;
            }

            Scanner deleteMember = new Scanner(System.in);          //Scanner object for get user inputs

            System.out.println("");
            System.out.print("Enter the id num : ");
            int memID = deleteMember.nextInt();
            System.out.println("delete a member");

            Iterator<defaultMember> itr = memberList.iterator();
            while (itr.hasNext()) {
                defaultMember mem = itr.next();
                int MemberID = Integer.parseInt(mem.getMembershipNo());
                if (MemberID == memID) {
                    itr.remove();
                }
            }
        } catch(InputMismatchException ex) {
            System.out.println("Invalid");
            deleteMember(membershipNo);
        }

        System.out.println("Successfully deleted the member");
        Main.application();
    }

//print list method
    public void printList() {
        if (memberList.size() == 0){
            System.out.println("NO ANY USER TO DISPLAY");
            return;
        }
        Iterator<defaultMember> iterator = memberList.iterator();
        System.out.println("*****************************************************************************");
        while (iterator.hasNext()){
            defaultMember member =iterator.next();
            member.print();
            System.out.println("-------------------------------------------------------------------------------------");
        }
        Main.application();


    }

//sort file method
    @Override
    public List<CWK02.defaultMember> sortFile() {
        if (memberList.size() > 0) {
            Collections.sort(memberList, new Comparator<defaultMember>() {
                public int compare(defaultMember s1, defaultMember s2) { // inner function to sort objects
                return s1.getMemberName().compareToIgnoreCase(s2.getMemberName());
                }
            });
            System.out.println("Successfully Sorted");
            System.out.println("");
        }
        else {
            System.out.println("No data to sort.");
        }
        Main.application();
        return memberList;
        }



//save file method
    public static void saveList() {

        if(memberList.size()  !=0){
            try {
                ObjectOutputStream saveFile = new ObjectOutputStream(new FileOutputStream("memberList.txt"));
                for (defaultMember i : memberList) {
                    saveFile.writeObject(i);
                }
                saveFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Empty");
        }
    }

    @Override
    public void saveFile() {
        if (memberList.size() !=0) {
            saveList();
        }
        else {
            System.out.println("No data to save");
        }

    }

    @Override
    public List<defaultMember> getMemberList() {
        return null;
    }

    @Override
    public defaultMember getMemberByMembershipNo(String membershipNo) {
        return null;
    }

    @Override
    public defaultMember[] getMemberByName(String memberName) {
        return new defaultMember[0];
    }
    public void openApplication(){
        Application.launch(gui.class, null);
    }

}
