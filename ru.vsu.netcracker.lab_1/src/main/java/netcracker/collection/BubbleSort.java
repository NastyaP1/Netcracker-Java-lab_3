package netcracker.collection;
import java.util.Comparator;

public class BubbleSort<T> implements ISorter<T>{
    /**
     * процедура сортировки пузырьком
     * @param comparator - компаратор
     * @param arr - массив для сортировки
     */
    @Override
    public void sort(Comparator<T> comparator, T[] arr) {
        T person;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[i], arr[j]) < 0) {
                    person = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = person;
                }
            }
        }
    }
}
