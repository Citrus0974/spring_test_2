package edu.springtest2.beans;

import edu.springtest2.objects.university.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class StudentBuilder {
    @Autowired
    @Qualifier("normalMarksRange")
    Predicate<Integer> range;
    public Student build(String name, int...marks){
        return new Student(name, range, marks);
    }
}
