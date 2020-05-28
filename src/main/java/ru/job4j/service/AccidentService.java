package ru.job4j.service;
import ru.job4j.model.Accident;
import ru.job4j.model.Role;
import ru.job4j.model.User;

import java.util.List;
import java.util.Set;

/**
 * Common inteface for DataBase. For Crud.
 */
public interface AccidentService {
    void add(Accident accident);

    List<Accident> get();

    List<Accident> findAllByAuthor(User author);

    void remove(Long id);

    void update(Long id);
}
