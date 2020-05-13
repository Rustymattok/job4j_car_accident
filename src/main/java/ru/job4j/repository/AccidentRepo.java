package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
@Repository
public interface AccidentRepo extends CrudRepository<Accident, Integer> {
}
