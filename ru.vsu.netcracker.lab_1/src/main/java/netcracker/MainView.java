package netcracker;

import netcracker.IO.CsvFileLoader;
import netcracker.domain.Person;
import netcracker.repository.Repository;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainView {
    private CsvFileLoader csvFileLoader = new CsvFileLoader();
    private IRepository<Person> repository = new Repository<>();
    private final String FILENAME = "/Users/anastasiapereslavceva/Downloads/netcracker/ru.vsu.netcracker.lab_1/src/main/resources/persons.csv";

    public void Filter() throws IOException {
        csvFileLoader.readCsvFile(FILENAME, repository);
        List<Person> people = repository.toList();

        List<Person> result1 = people.stream().filter(p -> p.getFirstName().contains("A") && p.getAge() > 30 && (p.getSalary().compareTo(new BigDecimal("5000"))) > 0).collect(Collectors.toList());
        for (Person person : result1) {
            System.out.println(person);
        }

        Map<IDivision, Double> result2 = people.stream().collect(Collectors.groupingBy(Person::getDivision,
                Collectors.summingDouble(Person::getDoubleSalary)));

        for(Map.Entry<IDivision, Double> item : result2.entrySet()){

           System.out.println(item.getKey().toString() + "|" + item.getValue().toString());
       }

        Map<Integer, Long> result3 = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        for(Map.Entry<Integer, Long> item : result3.entrySet()){

            System.out.println(item.getKey().toString() + "|" + item.getValue().toString());
        }
    }
}
