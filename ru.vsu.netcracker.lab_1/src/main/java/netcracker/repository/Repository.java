package netcracker.repository;
import netcracker.annotations.LabInjector;
import netcracker.collection.BubbleSort;
import netcracker.collection.Searches;
import ru.vsu.lab.repository.IRepository;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;


/**
 * Класс-репозиторий для хранения всех объектов класса Person
 */
public class Repository<T> implements IRepository<T> {
    /**
     * размер на какой изменяем
     */
    private static final Integer NUMBEROFRESIZE = 10;
    /**
     * Путь к файлу, в котором хранится список людей
     */
    private static final String FILE_NAME = "/Users/anastasiapereslavceva/Downloads/netcracker/ru.vsu.netcracker.lab_1/src/main/resources/persons.csv";
    /**
     * поле instance
     */
    private static Repository instance;
    /**
     * массив объектов класса Person
     */
    private T[] objects;
    private Integer count = 0;
    private Searches<T> search = new Searches<>();

    @LabInjector
    private BubbleSort<T> sort;
    /**
     * конструктор
     */
    public Repository(){
       this.objects = (T[]) new Object[10] ;
    }

    public Repository(T[] people) {
        this.objects = people;
    }

    /**
     * процедура вызова функции readCsvFile
     */
    public void populatePeopleFromFile(){
    }

    @Override
    public void sortBy(Comparator<T> comparator) {
        sort.sort(comparator, objects);
    }

    @Override
    public IRepository<T> searchBy(Predicate<T> condition){

        IRepository<T> searchedpeople = new Repository<>();
        return search.linearSearch(condition, objects, searchedpeople);
    }

    @Override
    public void add(T person) {
        if(objects.length <= count)
            objects = Arrays.copyOf(objects, objects.length + NUMBEROFRESIZE);
        objects[count++] = person;
    }

    @Override
    public T get(int index) {
        if (index>=getLastIndexOfNotNull()+1 || index<0)
            return null;
        return objects[index];
    }

    @Override
    public T delete(int index) {
        if (index>=getLastIndexOfNotNull() + 1 || index<0)
            return null;
        T person=objects[index];
        System.arraycopy(objects, index + 1, objects, index, objects.length-index-1);
        objects[objects.length-1]=null;
        return person;
    }

    @Override
    public T set(int index, T o) {
        if(index>=getLastIndexOfNotNull()+1 || index<0)
            return null;
        return objects[index];
    }

    @Override
    public void add(int index, T person) {
        if (index>getLastIndexOfNotNull() + 1) {
            return;
        }
        T[] arr = (T[]) new Object[objects.length + 1];
        System.arraycopy(objects,0, arr,0,index);
        arr[index] = person;
        System.arraycopy(objects, index, arr, index +1, objects.length-index);
        objects = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public List<T> toList() {
        List<T> obj = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            obj.add(objects[i]);
        }
        return obj;

    }

    private int getLastIndexOfNotNull() {

        for(int i=objects.length-1;i<=0;i--){
            if(objects[i]!=null)
                return i;
        }
        return 0;
    }
}
