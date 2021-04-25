package CWK02;

public class studentMember extends defaultMember{       //this sub class inherited with default member super class

    private String studentSchool;
    private String  studentGuardianContactNo;

    public String memberType() {
        return "Student member";
    }

    public studentMember(String membershipNo, String memberName, Date membershipStartDate, String memberGender, String memberContactNumber, String studentSchool, String studentGuardianContactNo) {
        super(membershipNo, memberName, membershipStartDate, memberGender, memberContactNumber);
        setStudentSchool(studentSchool);
        setStudentGuardianContactNo(studentGuardianContactNo);
    }

    //getters and setters for methods
    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }

    public String getStudentGuardianContactNo() {
        return studentGuardianContactNo;
    }

    public void setStudentGuardianContactNo(String studentGuardianContactNo) {
        this.studentGuardianContactNo = studentGuardianContactNo;
    }

    //print each member details in one line
    public void print() {
        super.print();
        System.out.println("    School: " + (getStudentSchool()) + "    Gurdian No: " + (getStudentGuardianContactNo()));

    }
}
