package ru.job4j.di;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StartUI {
    @Autowired
    private Store store;
    @Autowired
    private ConcoleInput cl;
//    public StartUI(Store store,ConcoleInput cl) {
//        this.store = store;
//        this.cl = cl;
//    }
    public void add(String value) {
        store.add(value);
    }

    public void print() {
        cl.show();
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}