package CWK02;

import java.util.Scanner;

public class over60Member extends defaultMember {       //this sub class inherited with default member super class

    private Integer memberAge;

    public String memberType() {
        return "Over60 member";
    }

    public over60Member(String membershipNo, String memberName, Date membershipStartDate, String memberGender, String memberContactNumber, Integer memberAge) {
        super(membershipNo, memberName, membershipStartDate, memberGender, memberContactNumber);
        setMemberAge(memberAge);
    }

    //getters and setters
    public Integer getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(Integer memberAge) {
        //validation
        if (memberAge >= 60) {
            this.memberAge = memberAge;
        }
        else {
            System.out.println("Invalid Age!");
            Scanner scAge = new Scanner(System.in);
            System.out.println("Enter Correct Age: ");
            memberAge = scAge.nextInt();
        }
    }


    //print each member details in one line
    public void print() {
        super.print();
        System.out.println("    Age: " + (getMemberAge()));
    }
}
