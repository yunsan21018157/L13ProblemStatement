package sg.edu.rp.c346.id21018157.l13problemstatement;

public class Enrolment {
    private int enrolment;
    private int year;

    public Enrolment (int enrolment, int year) {
        this.enrolment = enrolment;
        this.year = year;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Enrolment:" + enrolment + "\nYear: " + year;
    }
}
