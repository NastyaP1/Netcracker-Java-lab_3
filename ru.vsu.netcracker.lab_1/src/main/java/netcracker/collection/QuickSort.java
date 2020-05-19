package netcracker.collection;

import java.util.Comparator;

public class QuickSort<T> implements ISorter<T>{
    /**
     * процедура быстрой сортировки
     * @param array - массив для сортирвоки
     * @param low - нижняя граница
     * @param high - верхняя граница
     */
    private void quickSort(Comparator<T> comparator, T[] array, int low, int high){
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        T opora = array[middle];
        T temp;

        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(array[i], opora) < 0) {
                i++;
            }

            while (comparator.compare(array[j], opora) > 0) {
                j--;
            }

            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(comparator,array, low, j);

        if (high > i)
            quickSort(comparator,array, i, high);
    }

    @Override
    public void sort(Comparator<T> comparator, T[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(comparator, array, low, high);
    }
}
