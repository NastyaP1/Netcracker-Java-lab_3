package netcracker.domain;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import java.time.LocalDate;
import java.math.BigDecimal;
import ru.vsu.lab.entities.enums.Gender;

/**
 * Класс со свойствами <b>id</b>, <b>fio</b>, <b>birthDate</b> и <b>gender</b>
 */
public class Person implements IPerson {
    /**
     * поле id
     */
    private Integer id;
    /**
     * поле имя
     */
    private String firstName;
    /**
     * поле фамилия
     */
    private String lastName;
    /**
     * поле дата дня рождения
     */
    private LocalDate birthdate;
    /**
     * поле пол человека
     */
    private Gender gender;

    /**
     * поле подразделение
     */
    private IDivision division;

    /**
     * поле зарплата
     */
    private BigDecimal salary;

    /**
     * Конструктор - создание нового объекта
     * @param id - id
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения
     * @param gender - пол человека
     */
    public Person(Integer id, String firstName,String lastName, LocalDate birthDate, Gender gender, IDivision division, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthDate;
        this.gender = gender;

        this.division = division;
        this.salary = salary;
    }

    /**
     * Конструктор - создание нового объекта
     * @param personId - id
     */
    public Person(Integer personId)
    {
        setId(personId);
    }
    public Person() { }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String firstName) {
        this.lastName = lastName;
    }

    @Override
    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public void setBirthdate(java.time.LocalDate localDate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public IDivision getDivision() {
        return division;
    }

    @Override
    public void setDivision(IDivision division) {
        this.division = division;
    }

    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * процедура конвертации объекта в строковое представление
     * @return возвращает строковое представление класса Person
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.id +
                ", Имя=" + this.firstName +
                ", Фамилия=" + this.lastName +
                ", gender=" + this.gender +
                ", birth date=" + this.birthdate +
                ", age=" + getAge() + '}';
    }

    @Override
    public Integer getAge() {
        LocalDate.now();
        int age = LocalDate.now().getYear() - birthdate.getYear();
        return age;
    }

    public Double getDoubleSalary(){
        return getSalary().doubleValue();
    }
}

