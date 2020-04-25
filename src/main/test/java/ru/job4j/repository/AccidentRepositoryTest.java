package ru.job4j.repository;
import org.junit.Test;
import ru.job4j.model.Accident;
public class AccidentRepositoryTest {
    @Test
    public void add() {
        AccidentRepository accidentRepository = AccidentRepository.getINSTANCE();
        accidentRepository.add(new Accident("Mironov","shtraf kakou to","Moscow"));
    }
}
