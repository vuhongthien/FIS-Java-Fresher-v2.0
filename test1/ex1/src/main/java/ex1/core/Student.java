package ex1.core;

import java.util.Date;

public class Student {
    private int code;
    private String name;
    private Date birthDate;

    public Student(int code, String name, Date birthDate) {
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) throws IllegalArgumentException{
        if(!isValidBirthDate(birthDate))
            throw new IllegalArgumentException();
        this.birthDate = birthDate;
    }
    private boolean isValidBirthDate(Date birthDate){
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (code != student.code) return false;
        if (!name.equals(student.name)) return false;
        return birthDate.equals(student.birthDate);
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + name.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }
}
