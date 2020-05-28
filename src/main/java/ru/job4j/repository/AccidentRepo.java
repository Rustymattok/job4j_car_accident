package ru.job4j.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.model.Role;
import ru.job4j.model.User;

import java.util.List;
import java.util.Set;

@Repository
public interface AccidentRepo extends JpaRepository<Accident, Long> {
        List<Accident> findAllByAuthor( User author);
}
