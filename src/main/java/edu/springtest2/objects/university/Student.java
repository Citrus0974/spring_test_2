package edu.springtest2.objects.university;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Student {
    private String name = "";
    private List<Integer> marks = new ArrayList<>();
    private Predicate<Integer> range;
    private List<ActionUndo> actions = new ArrayList<>();

    public Student(String name, Predicate<Integer> range, int...marks){
        this.name = name;
        this.range = range;
        addMarks(marks);
    }


    public  Student(Student student){
        if(student==null) throw new NullPointerException("cannot copy null object");
        this.name = student.name;
        this.marks = student.marks;
        this.range = student.range;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void addMark(int mark){
        if(range.test(mark)) marks.add(mark);
        this.actions.add(()->this.marks.removeLast());
     }

    public void addMarks(int...marks){
        List<Integer> newMarks = new ArrayList<>();
        for(int i=0; i<marks.length; i++){
            if (range.test(marks[i])){
                newMarks.add(marks[i]);
            } else throw new WrongMarkException("mark " + marks[i] + " for student "   + name + " is not compatible");
        }
        this.marks.addAll(newMarks);
        this.actions.add(() -> {
            for(int i=marks.length-1; i>=0; i--){
                this.marks.removeLast();
            }
        });
    }

    public void setMarks(List<Integer> marks) {
        for(Integer mark : marks){
            if (!range.test(mark)) throw new WrongMarkException(this.name);
        }
        List OldMarks = this.marks;
        this.marks = marks;
        actions.add(()-> this.marks = OldMarks);
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        actions.add(() -> this.name = oldName);
    }

    public double averageMark(){
        if(this.marks.isEmpty()){
            return 0;
        }
        int all=0;
        int sz=marks.size();
        for (Integer mark : marks) all += mark;
        return (double) all/sz;
    }

    public boolean isExcellent(){
        if(this.marks.isEmpty()) return false;
        for (Integer mark : this.marks) {
            if (mark < 5) return false;
        }
        return true;
    }

    public void Undo(){
        actions.removeLast().undo();
    }

    public void Save(){

    }


    @Override
    public String toString() {
        if (this.marks == null || this.marks.isEmpty()) return name;
        return "name: " + name + "; marks: " + marks + "; range: " + range;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(averageMark(), student.averageMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, averageMark());
    }

    public <T> int compare(T value) {
        Student newStudent = (Student) value;
        if(this.averageMark() == newStudent.averageMark()) return 0;
        if(this.averageMark() > newStudent.averageMark()) return 1; else return -1;
//        return Double.compare(this.averageMark(), newStudent.averageMark());

    }
}
