package ru.job4j.di;
import org.springframework.stereotype.Component;
/**
 * Concle for DI
 */
@Component
public class ConcoleInput {
    public void show(){
        System.out.println("Test show() method");
        System.out.println("All parameters: ");
    }
}
