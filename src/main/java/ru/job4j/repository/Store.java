package ru.job4j.repository;
import ru.job4j.model.Accident;
import java.util.List;
/**
 * Common inteface for DataBase.
 */
public interface Store {
    void add(Accident accident);

    List<Accident> get();

    void remove(Integer id);

    void update(Integer id);
}
