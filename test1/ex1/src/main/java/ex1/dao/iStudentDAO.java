package ex1.dao;

import ex1.core.Student;

public interface iStudentDAO {
    void addStudent(Student student);

    Student remove(int code);

    void display();

    void sort();

    void setSortStrategy(ISortStrategy iSortStrategy);
}
