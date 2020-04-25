package ru.job4j.service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepository;
import java.util.LinkedList;
import java.util.List;
/**
 * Logic of application. (Data -> Spring connection)
 */
public class AccidentService {
    private static  final AccidentService INSTANCE = new AccidentService();

    private AccidentService() {
    }

    public static AccidentService getINSTANCE() {
        return INSTANCE;
    }

    public List<Accident> accidewtList(){
        List<Accident> list = new LinkedList<>();
        AccidentRepository accidentRepository = AccidentRepository.getINSTANCE();
        list = accidentRepository.get();
        System.out.println(list.size());
        return list;
    }
}
