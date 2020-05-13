package ru.job4j.service;
import ru.job4j.model.Accident;
import java.util.List;
/**
 * Common inteface for DataBase.
 */
public interface AccidentStore {
    void add(Accident accident);

    List<Accident> get();

    void remove(Integer id);

    void update(Integer id);
}
