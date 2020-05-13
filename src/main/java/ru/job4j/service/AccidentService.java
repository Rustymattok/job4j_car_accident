package ru.job4j.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepo;
import java.util.List;
/**
 * Logic of application. (Data -> Spring connection)
 */
@Service
public class AccidentService implements AccidentStore {
    private final AccidentRepo accidentRepo;
    @Autowired
    public AccidentService(AccidentRepo accidentRepo) {
        this.accidentRepo = accidentRepo;
    }

    @Override
    @Transactional
    public void add(Accident accident) {
        System.out.println("try to add?");
        System.out.println(accident.getName());
        accidentRepo.save(accident);
    }

    @Override
    @Transactional
    public List<Accident> get() {
        return (List<Accident>) accidentRepo.findAll();
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        accidentRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Integer id) {
      //todo реавлизовать доп метод в Crud.
    }
}
