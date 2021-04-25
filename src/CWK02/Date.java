package CWK02;

import java.time.format.DateTimeFormatter;

public class Date {

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date(int day, int month, int year) {

        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public String toString() {
        return (day + "/" + month + "/" + year);
    }

    public static void validDate (String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            formatter.parse(date);
            System.out.println("Valid CWK02.date");
        }
        catch (Exception e){
            System.out.println("Invalid Date");
        }

    }
}
