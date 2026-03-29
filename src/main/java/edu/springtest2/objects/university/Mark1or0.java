package edu.springtest2.entities.university;

public class Mark1or0 implements MarkCriteria{
    @Override
    public boolean isMarkCorrect(int mark) {
        if(mark!=0 && mark!=1) return false;
        else return true;
    }
}
