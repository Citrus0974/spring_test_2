package edu.springtest2.beans.configs;


import edu.springtest2.objects.university.Human;
import edu.springtest2.objects.university.Review;
import edu.springtest2.objects.university.Student;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class FirstConfig {

    @Bean
    String hello(){
        return "Hello world!";
    }



    @Bean
    @Scope("singleton")
    @Lazy
    Date firstDate(){
        return new Date();
    }

    @Bean
    @Qualifier("normalMarksRange")
    Predicate<Integer> range(){
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 2 && integer < 5;
            }
        };
    }

    @Bean
    @Qualifier("max")
    int max(){
        return 5;
    }

    @Bean
    @Qualifier("min")
    int min(){
        return 1;
    }

    @Bean
    public Review goodReview(){
        return new Review("очень хорошо", 4);
    }

    @Bean
    public Review averageReview(){
        return new Review("сойдёт", 3);
    }

    @Bean
//    @Scope("prototype")
    public Review randomReview(@Qualifier("randomIntInRange") int random){
        return new Review("сложно сказать", random);
    }

    @Bean
    @Scope("prototype")
    public Review highestReview(List<Review> reviews){
        int max=Integer.MIN_VALUE;
        Review highest = null;
        for(Review review: reviews){
            int mark = review.getMark();
            if(mark>max){
                max = mark;
                highest = review;
            }
        }
        if(highest==null) throw new BeanCreationException("missing Review bean variants");
        return highest;
    }

    @Bean
    public Student student1(){
        return new Student("dan", range(), 4, 4);
    }

    @Bean
    public Human human1(){return new Human();}
}
