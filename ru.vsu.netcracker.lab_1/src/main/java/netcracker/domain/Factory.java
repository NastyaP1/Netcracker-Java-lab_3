package netcracker.domain;

import netcracker.annotations.Injector;
import netcracker.exceptions.MyException;
import netcracker.repository.Repository;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;
import java.lang.reflect.Array;


public class Factory implements ILabFactory {
    @Override
    public IPerson createPerson() {
        return new Person();
    }

    @Override
    public IDivision createDivision() {
        return new Division();
    }

    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz){
        T[] array = (T[]) Array.newInstance(clazz);
        IRepository rep = null;
        try {
            rep = Injector.inject(rep);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return rep;
    }

    @Override
    public IPersonRepository createPersonRepository() {
        return null;
    }
}
