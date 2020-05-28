package ru.job4j.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.Accident;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.repository.AccidentRepo;
import java.util.List;
import java.util.Set;

/**
 * Logic of application. (Data -> Spring connection)
 */
@Service
public class AccidentServiceImp implements AccidentService {
    private  AccidentRepo accidentRepo;

    @Autowired
    public AccidentServiceImp(AccidentRepo accidentRepo) {
        this.accidentRepo = accidentRepo;
    }

    @Override
    @Transactional
    public void add(Accident accident) {
        accidentRepo.save(accident);
    }

    @Override
    @Transactional
    public List<Accident> get() {
        return accidentRepo.findAll();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        accidentRepo.deleteById(id);
    }

    @Override
    @Transactional
    public List<Accident> findAllByAuthor(User author) {
        return accidentRepo.findAllByAuthor(author);
    }

    @Override
    @Transactional
    public void update(Long id) {
      //todo реавлизовать доп метод в Crud.
    }
}
