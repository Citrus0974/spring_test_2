package edu.springtest2.entities.university;

public class WrongMarkException extends RuntimeException{
    public WrongMarkException(){}
    public WrongMarkException(String s){
        super(s);
    }
//    public WrongMarkException(Throwable cause){
//        super(cause);
//    }
//    public WrongMarkException(String s, Throwable cause){
//        super(s, cause);
//    }
}
