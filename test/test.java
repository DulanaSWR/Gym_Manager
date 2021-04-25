import CWK02.Date;
import CWK02.defaultMember;
import CWK02.over60Member;
import CWK02.studentMember;

import static org.junit.Assert.assertEquals;

public class test {
    //test date
    @org.junit.Test
    public void Date() {
        Date date = new Date(14,12,5050);
        String expDateInString = date.toString();
        String expDateInStringExpected = "14/12/5050";
        assertEquals(expDateInStringExpected, expDateInString);
    }
    //test contact number
    @org.junit.Test
    public void contactNo() {
        defaultMember mem = new defaultMember("s123","Dulana",new Date(2,2,2020),"Male","0718099275");
        String contactNumber = mem.getMemberContactNumber();
        assertEquals("0718099275", contactNumber);
    }
    //test age
    @org.junit.Test
    public void age() {
        over60Member mem = new over60Member("12","Siri",new Date(5,7,2019),"Male","0112608529",63);
        int age = mem.getMemberAge();
        assertEquals(63, age);
    }
    //test school
    @org.junit.Test
    public void school() {
        studentMember mem = new studentMember("78","Latha",new Date(18,8,2010),"Female","0784563219","Visakha Vidyalaya","0754896123");
        String school = mem.getStudentSchool();
        assertEquals("Visakha Vidyalaya", school);
    }


}
