package netcracker.IO;

import au.com.bytecode.opencsv.CSVReader;
import netcracker.domain.Division;
import netcracker.domain.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import java.math.BigDecimal;

public class CsvFileLoader<T> {
    /**
     * формат даты
     */
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * список существующих подразделений
     */
    private List<Division> divisions = new ArrayList<>();
    private Integer count = divisions.size();

    /**
     * процедура проверки подразделения на существование, в ином случае
     * @param nameDivision - имя подразделения
     * @return - возвращает подразделение
     */
    public Division setDivision(String nameDivision){
        for(Division division : divisions){
            if(nameDivision.equals(division.getName())){
                return division;
            }
        }
        Division newDivision = new Division(count+1,nameDivision);
        divisions.add(newDivision);
        return newDivision;
    }


    /**
     * процедура чтения CSV файла в список людей
     * @param csvfilename - имя файла
     * @throws Exception
     */
    public void readCsvFile(String csvfilename, IRepository<Person> repository) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(csvfilename), ';', '"', 1);
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                Person person = new Person(Integer.parseInt(nextLine[0]), nextLine[1], "", LocalDate.parse(nextLine[3], FORMAT), Gender.valueOf(nextLine[2].toUpperCase()), setDivision(nextLine[4]), new BigDecimal(nextLine[5]));
                repository.add(person);
            }
        }
    }
}
