package CWK02;

import java.io.Serializable;

public class defaultMember {
    private String membershipNo;
    private String memberName;
    private Date membershipStartDate;
    private String memberGender;
    private String memberContactNumber;

    //super class
    public defaultMember(String membershipNo, String memberName,
                         Date membershipStartDate, String memberGender,
                         String memberContactNumber){
        super();
        this.membershipNo = membershipNo;
        this.memberName = memberName;
        this.membershipStartDate = membershipStartDate;
        this.memberGender = memberGender;
        this.memberContactNumber = memberContactNumber;

    }

    public defaultMember(defaultMember member) {
    }


    public String memberType() {
        return "Default member";
    }

    //getters and setters for methods
    public String getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(String membershipNo) {
        this.membershipNo = membershipNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getMemberContactNumber() {
        return memberContactNumber;
    }

    public void setMemberContactNumber(String memberContactNumber) {
        this.memberContactNumber = memberContactNumber;
    }

    // member details as lines
    public void print() {
        System.out.println("Membership No: " + getMembershipNo() +
                "   Name: " + getMemberName() +
                "   Membership Start Date: " + getMembershipStartDate()+
                "   Gender: " + getMemberGender() +
                "   Contact No: " +getMemberContactNumber());
    }
}
