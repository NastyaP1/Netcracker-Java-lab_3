package netcracker.collection;

import ru.vsu.lab.repository.IRepository;
import java.util.function.Predicate;

public class Searches<T> {
    public IRepository<T> linearSearch(Predicate<T> condition, T[] arr, IRepository<T> searchedpeople) {
        for (int index = 0; index < arr.length; index++) {
            if (condition.test(arr[index]))
            {
                searchedpeople.add(arr[index]);
            }
        }
        return searchedpeople;
    }
}
