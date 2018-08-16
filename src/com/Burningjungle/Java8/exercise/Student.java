package Java8.exercise;

import java.time.LocalDate;
import java.util.Locale;

public class Student {

    public enum Gender{
        FEMALE,MALE
    }
    public enum Department{
        CS,CN,EE,AM,CL,EL;
    }
    private long id;
    private String name;
    private Gender gender;
    private Integer credit;
    private LocalDate time;
    private  Department department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student(long id, String name, Gender gender, Integer credit, LocalDate time, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.credit = credit;
        this.time = time;
        this.department = department;
    }

    public boolean isFemale() {
        return this.gender == Gender.FEMALE;
    }

    @Override
    public String toString(){
        return "Student {" +
                "id = " + id +
                "name = " + name +
                "gender = " + gender +
                "credit = " + credit +
                "time = " + time +
                "department = " + department + "}";
    }
}
