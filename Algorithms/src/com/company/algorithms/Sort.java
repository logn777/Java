package com.company.algorithms;

/**
 * functions for sorting an array
 * @author Artem Melentev
 */

public class Sort {
    public static <T> void swapObj(T a, T b) {
        T tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void swapInt(int a, int b) {
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    /**
     * Сортировка выбором (Selection Sort), она имеет квадратичную сложность O(n^2)
     * Каждый проход выбирать самый минимальный элемент и смещать его в начало.
     * При этом каждый новый проход начинать сдвигаясь вправо,
     * то есть первый проход — с первого элемента, второй проход — со второго.
     *
     * Данная сортировка неустойчива, т.к. одинаковые элементы
     * (с точки зрения той характеристики, по которой мы сортируем элементы) могут изменить своё положение.
     *
     * @param array this is integer array for sorting
     */
    public static void selectionSort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swapInt(left, minInd);
        }
    }

    /**
     * Сортировка вставками (Insertion Sort)
     * Сортировка вставками тоже имеет квадратичную сложность - O(n^2), так как опять цикл в цикле.
     * В чём отличие от сортировки выбором? Данная сортировка является "устойчивой".
     * Это значит, что одинаковые элементы не изменят свой порядок.
     * Одинаковые с точки зрения характеристики, по которой мы сортируем.
     *
     * @param array this is integer array for sorting
     */
    public static void insertionSort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
    }

    /**
     * Челночная сортировка (Shuttle Sort)
     *
     * Мне кажется, мы редко говорим про космические челноки, а челночный у нас скорее бег.
     * Поэтому проще представить, как в космос запускаются шаттлы. Вот вам ассоциация с этим алгоритмом.
     *
     * В чём суть алгоритма? Суть алгоритма в том, что мы итерируемся слева направо,
     * при этом при выполнении swap элементов мы выполняем проверку всех остальных элементов,
     * которые остались позади, не нужно ли повторить swap.
     *
     * @param array this is integer array for sorting
     */
    public static void shuttleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swapInt(i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        swapInt(z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Сортировка Шелла (Shell Sort) Суть её похожа на сортировку пузырьком,
     * но каждую итерацию мы имеем разный промежуток между сравниваемыми элементами.
     * Каждую итерацию он уменьшается вдвое.
     *
     * @param array this is integer array for sorting
     */
    public static void shellSort(int[] array) {
        // Высчитываем промежуток между проверяемыми элементами
        int gap = array.length / 2;
        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        swapInt(c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
    }

    /**
     * Cортировка слиянием (merge sort), сложность данного алгоритма — логарифмическая O(n log n)
     * суть сводится к тому, что мы принимаем на вход массив с указанием начала и конца участка для сортировки.
     * При начале сортировки — это начало и конец массива.
     * вычисляем delimiter — положение делителя.
     * Если делитель может разделить на 2 части, значит вызываем рекурсивно сортировку для участков, на которые делитель разбил массив.
     * Подготавливаем дополнительный буферный массив, в котором выделяем отсортированный участок.
     * Далее устанавливаем курсор в начало сортируемого участка и начинаем идти по каждому элементу пустого массива,
     * который мы подготовили, и заполняем его наименьшими элементами. Если элемент, на который указывает курсор меньше,
     * чем элемент, на который указывает делитель — помещаем в буферный массив этот элемент и сдвигаем курсор.
     * В противном случае помещаем в буферный массив элемент, на который указывает разделитель и сдвигаем разделитель.
     * Как только разделитель уйдёт за границы сортируемого участка или мы заполним весь массив, указанный диапазон считается отсортированным.
     *
     * @param array this is integer array for sorting
     * @param left  начало сортировки
     * @param right конец сортировки
     */
    public static void mergeSort(int[] array, int left, int right) {
        // Выберем разделитель, т.е. разделим пополам входной массив
        int delimiter = left + ((right - left) / 2) + 1;
        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(array, left, delimiter - 1);
            mergeSort(array, delimiter, right);
        }
        // Создаём временный массив с нужным размером
        int[] buffer = new int[right - left + 1];
        // Начиная от указанной левой границы идём по каждому элементу
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // Мы используем delimeter чтобы указывать на элемент из правой части
            // Если delimeter > right, значит в правой части не осталось недобавленных элементов
            if (delimiter > right || array[cursor] > array[delimiter]) {
                buffer[i] = array[cursor];
                cursor++;
            } else {
                buffer[i] = array[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, array, left, buffer.length);
    }

    /**
     * Сортировка подсчётом (Counting Sort) и Поразрядная сортировка (Radix Sort)
     * Алгоритмическая сложность в этом случае будет O(n+k), где n — количество элементов, а k — максимальное значение элемента.
     * Есть с алгоритмом одна незадача: нам нужно знать минимальное и максимальное значение в массиве.
     * @param array this is integer array for sort
     * @param maxValue max value
     * @return new sorted array
     */
    public static int[] countingSort(int[] array, int maxValue) {
        // Массив со "счётчиками" размером от 0 до максимального значения
        int[] numCounts = new int[maxValue + 1];
        // В соответствующей ячейке (индекс = значение) увеличиваем счётчик
        for (int num : array) {
            numCounts[num]++;
        }
        // Подготавливаем массив для отсортированного результата
        int[] sortedArray = new int[array.length];
        int currentSortedIndex = 0;
        // идём по массиву со "счётчиками"
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // идём по количеству значений
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }

    /**
     *  в среднем O(n log n) обменов при упорядочении n элементов;
     *
     * @param array this is integer array for sort
     * @param leftBorder нижня граница ортируемого участка этого массива
     * @param rightBorder верхняя граница ортируемого участка этого массива
     */
    public static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(array, leftBorder, rightMarker);
        }
    }
}
