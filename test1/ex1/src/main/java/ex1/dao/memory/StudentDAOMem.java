package ex1.dao.memory;

import ex1.core.Student;
import ex1.dao.ISortStrategy;
import ex1.dao.SelectionSortStrategy;
import ex1.dao.iStudentDAO;

public class StudentDAOMem implements iStudentDAO {
    public final int MAX = 100;
    private Student[] students;
    private int count;
    private ISortStrategy sortStrategy;

    public StudentDAOMem(){
        this.count = 0;
        this.students = new Student[MAX];
        this.sortStrategy = new SelectionSortStrategy();
    }

    @Override
    public void addStudent(Student student){
        //TODO
    }

    @Override
    public Student remove(int code){
        //TODO
        return null;
    }

    @Override
    public void display(){
        //TODO
    }

    @Override
    public void sort(){
        //TODO
    }

    @Override
    public void setSortStrategy(ISortStrategy iSortStrategy){
        this.sortStrategy = sortStrategy;
    }
}
