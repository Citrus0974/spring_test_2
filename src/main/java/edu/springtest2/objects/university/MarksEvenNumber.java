package edu.springtest2.entities.university;

public class MarksEvenNumber implements MarkCriteria{

    @Override
    public boolean isMarkCorrect(int mark) {
        if(mark%2==1) return false;
        else return true;
    }
}
