package netcracker.domain;

import ru.vsu.lab.entities.IDivision;

/**
 * Класс Подразделения расширяемый интерфейсом IDivision
 */
public class Division implements IDivision {
    /**
     * поле id
     */
    private Integer id;
    /**
     * поле имя
     */
    private String name;

    /**
     * Конструктор - создание нового объекта
     * @param id - id
     * @param name - название
     */
    public Division(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Division() {}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
