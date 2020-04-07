package ru.job4j.di;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StartUI {

    private Store store;
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
    @Autowired
    public void setStore(Store store) {
        this.store = store;
    }
    @Autowired
    public void setCl(ConcoleInput cl) {
        this.cl = cl;
    }
}