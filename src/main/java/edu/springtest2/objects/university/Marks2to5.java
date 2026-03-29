package edu.springtest2.entities.university;

public class Marks2to5  implements MarkCriteria{
    @Override
    public boolean isMarkCorrect(int mark) {
        if(mark>5 || mark<2) return false;
        else return true;
    }
}
