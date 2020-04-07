package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();
        Store store = context.getBean(Store.class);
        store.add("Vladimir Makarov");
        store.getAll().forEach(System.out::println);
        //todo почитать что значить ::
        Store another = context.getBean(Store.class);
        another.add("Vladimir Makarov3");
        another.getAll().forEach(System.out::println);
    }
}
