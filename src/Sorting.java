import java.util.*;

public class Sorting {
    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *     time complexity: number of operations of while loop times the number of operations of for loop,
     *                      2n*(2n+2) = 4n^2+4n
     *                      and other less significant terms and constants are dropped,
     *                      so, time complexity = O(n^2)
     *     space complexity: less significant terms and constants are dropped,
     *                       so, S(n) = O(1)
     */
    public static <T extends Comparable<T>> void bogoSort(final List<T> list, final Comparator<T> comparator) {
        // TODO
        while(!sorted(list, comparator))// 4n-1
        {
            Random a = new Random();
            int upperbound = list.size();
            for(int i=0; i<list.size(); i++)// 1+n+1+n = 2n+2
            {
                int int_rand = a.nextInt(upperbound);
                swapList(list, int_rand, i);
            }
        }
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     *     time complexity: number of operations of while loop times the number of operations of for loop,
     *                      2n*(2n+2) = 4n^2+4n
     *                      and other less significant terms and constants are dropped,
     *                      so, time complexity = O(n^2)
     *     space complexity: less significant terms and constants are dropped,
     *                       so, S(n) = O(1)
     */
    public static <T extends Comparable<T>> void bogoSort(final T[] array, final Comparator<T> comparator) {
        // TODO
        while(!sorted(array, comparator))// 2n
        {
            Random a = new Random();// 4n-1
            int upperbound = array.length;// 4n-1
            for(int i=0; i<array.length; i++)// 1+n+1+n = 2n+2
            {
                int int_rand = a.nextInt(upperbound);// n
                swapArray(array, int_rand, i);// 4n
            }
        }
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *     time complexity: number of operations of while loop times the number of operations of for loop,
     *                      2n * 2n = 4n^2
     *                      and other less significant terms and constants are dropped,
     *                      so, time complexity = O(n^2)
     *     space complexity: less significant terms and constants are dropped,
     *                       no extra temporary space created,
     *                       so, S(n) = O(1)
     */
    public static <T extends Comparable<T>> void bubbleSort(final List<T> list, final Comparator<T> comparator) {
        // TODO
        T store = list.get(0);
        while(!sorted(list, comparator))// 2n
        {
            for(int i=1; i<list.size(); i++)// 1+n+n-1 = 2n
            {
                if(comparator.compare(store, list.get(i))>0)
                {
                    swapList(list, i-1, i);
                }
                store = list.get(i);
            }
        }
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     *     time complexity: number of operations of while loop times the number of operations of for loop,
     *                      2n * 2n = 4n^2
     *                      and other less significant terms and constants are dropped,
     *                      so, time complexity = O(n^2)
     *     space complexity: less significant terms and constants are dropped,
     *                       no extra temporary space created,
     *                       so, S(n) = O(1)
     */
    public static <T extends Comparable<T>> void bubbleSort(final T[] array, final Comparator<T> comparator) {
        // TODO
        T store = array[0];
        while(!sorted(array, comparator))// 2n
        {
            for(int i=1; i<array.length; i++)// 1+n+n-1 = 2n
            {
                if(comparator.compare(store, array[i])>0)
                {
                    swapArray(array, i-1, i);
                }
                store = array[i];
            }
        }
    }

    /**
     * @param list
     * @param comparator
     * @param <T>
     *     time complexity: number of operations of for loop multiplies the number of operations of for loop,
     *                      2n*(2n+1) = 4n^2+2n
     *                      and other less significant terms and constants are dropped,
     *                      so, time complexity = O(n^2)
     *     space complexity: less significant terms and constants are dropped,
     *                       no extra temporary space created,
     *                       so, S(n) = O(1)
     */
    public static <T extends Comparable<T>> void selectionSort(final List<T> list, final Comparator<T> comparator) {
        // TODO
        int min_index;// 1
        for(int i=0; i<list.size()-1; i++)// 1+n+n-1 = 2n
        {
            min_index = i;// 1
            for(int j=i+1; j< list.size(); j++)// 2+n+n-1 = 2n+1
            {
                if((comparator.compare(list.get(min_index), list.get(j)))>0)// n-1
                {
                    min_index = j;// n-1
                }
            }
            swapList(list, i, min_index);// 4
        }
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     *     time complexity: number of operations of for loop multiplies the number of operations of for loop,
     *                      2n*(2n+1) = 4n^2+2n
     *                      and other less significant terms and constants are dropped,
     *                      so, time complexity = O(n^2)
     *     space complexity: less significant terms and constants are dropped,
     *                       no extra temporary space created,
     *                       so, S(n) = O(1)
     */
    public static <T extends Comparable<T>> void selectionSort(final T[] array, final Comparator<T> comparator) {
        // TODO
        int min_index;// 1
        for(int i=0; i<array.length-1; i++)// 1+n+n-1 = 2n
        {
            min_index = i; // n-1
            for(int j=i+1; j<array.length; j++)// 2+n+n-1 = 2n+1
            {
                if(comparator.compare(array[min_index], array[j])>0)// n-1
                {
                    min_index = j;
                }
            }
            swapArray(array, i, min_index);// 4
        }
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *     time complexity: the levels(heights) of recursive tree is always logN,
     *                      for example, length of array is 8, so 8 becomes: 4 and 4, 4 becomes: 2 and 2, 2 becomes: 1 and 1
     *                      3 levels in total(starts from 0), and log8 = 3,
     *                                  so levels = k ===> n/(2^k) = 1 ===> k = logN
     *                      the number of operations of merge at each level = n
     *                      other less significant terms and constants are dropped,
     *                      so the time complexity = number of levels * the number of operations of merge at each level
     *                      so, time complexity = O(N*logN)
     *     space complexity: at each level, there are always temporary lists created,
     *                       and the space that lists required will be released after merge,
     *                       the maximum total length of lists created is equal to n,
     *                       the space that each recursion requires is unchanged,
     *                       and the total space of complexity is: maximum length of lists + levels of recursion tree
     *                       and the levels of recursion we have already known is logN
     *                       so, S(n) = N + logN ===> so space complexity is equal to O(n)
     */
    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        // TODO/
        int n = list.size();
        if(n<2)
        {
            return;
        }
        int mid = n/2;
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
        for(int i=0; i<mid; i++)
        {
            left.add(i, list.get(i));
        }
        for(int i=mid; i<n; i++)
        {
            right.add(i-mid, list.get(i));
        }
        mergeSort(left, comparator);
        mergeSort(right, comparator);
        mergeList(list, left, right, mid, n-mid, comparator);
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     *     time complexity: the levels(heights) of recursive tree is always logN,
     *                      for example, length of array is 8, so 8 becomes: 4 and 4, 4 becomes: 2 and 2, 2 becomes: 1 and 1
     *                      3 levels in total(starts from 0), and log8 = 3,
     *                                  so levels = k ===> n/(2^k) = 1 ===> k = logN
     *                      the number of operations of merge at each level = n
     *                      other less significant terms and constants are dropped,
     *                      so the time complexity = number of levels * the number of operations of merge at each level
     *                      so, time complexity = O(N*logN)
     *     space complexity: at each level, there are always temporary arrays created,
     *                       and the space that arrays required will be released after merge,
     *                       the maximum total length of arrays created is equal to n,
     *                       the space that each recursion requires is unchanged,
     *                       and the total space of complexity is: maximum length of arrays + levels of recursion tree
     *                       and the levels of recursion we have already known is logN
     *                       so, S(n) = N + logN ===> so space complexity is equal to O(n)
     */
    public static <T extends Comparable<T>> void mergeSort(final T[] array, final Comparator<T> comparator) {
        // TODO
        int n = array.length;
        if(n<2)
        {
            return;
        }
        int mid = n/2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, n);
        mergeSort(left, comparator);
        mergeSort(right, comparator);
        mergeArray(array, left, right, mid, n-mid, comparator);
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     *     time complexity: the levels(heights) of recursive tree is always logN,
     *                      for example, assume we have n elements, every time we call method partitioningList,
     *                      list is divided into two sub-lists,
     *                      list length n is divided into two lists length n/2, n/2 becomes n/4 until becomes 1,
     *                      so the height of the tree k is:
     *                                  height = k ===> n/(2^k) = 1 ===> n = 2^k ===> k = logN
     *                      the number of comparison at each level is n
     *                      other less significant terms and constants are dropped,
     *                      so the time complexity = number of levels * the number of comparison at each level
     *                      so, time complexity = O(N*logN)
     *     space complexity: the space that each recursion requires is unchanged,
     *                       no extra temporary space created,
     *                       and the total space of complexity is the levels of recursion tree
     *                       and the levels of recursion we have already known is logN
     *                       so, S(n) = O(logN)
     */
    public static <T extends Comparable<T>> void quickSort(final List<T> list, final Comparator<T> comparator) {
        // TODO
        Random a = new Random();
        int upperbound = list.size();
        for(int i=0; i< list.size(); i++)
        {
            int int_rand = a.nextInt(upperbound);
            swapList(list, int_rand, i);
        }
        sortList(list, 0, list.size()-1, comparator);
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     *     time complexity: the levels(heights) of recursive tree is always logN,
     *                      for example, assume we have n elements, every time we call method partitioningArray,
     *                      array is divided into two sub-arrays,
     *                      array length n is divided into two arrays length n/2, n/2 becomes n/4 until becomes 1,
     *                      so the height of the tree k is:
     *                                  height = k ===> n/(2^k) = 1 ===> n = 2^k ===> k = logN
     *                      the number of comparison at each level is n
     *                      other less significant terms and constants are dropped,
     *                      so the time complexity = number of levels * the number of comparison at each level
     *                      so, time complexity = O(N*logN)
     *     space complexity: the space that each recursion requires is unchanged,
     *                       no extra temporary space created,
     *                       and the total space of complexity is the levels of recursion tree
     *                       and the levels of recursion we have already known is logN
     *                       so, S(n) = O(logN)
     *     4 potential issues:
     *                       (1): If the array(or list) has already sorted, then the time complexity will not be O(N*logN)
     *                            it will be O(N^2)
     *                            for example we have seven numbers: 6, 7, 9, 10, 11, 14, 12
     *                            after first partition, j will point to 6, we need n comparison
     *                            after second partition, j will point to 7, we need n-1 comparison
     *                            ...after last partition, j will point to 12, we need 1 comparison
     *                            in total, we need n+(n-1)+(n-2)+...+1 = [n(n+1)]/2 comparison
     *                            so time complexity = O(N^2)
     *                            we can choose the median number(median of three random numbers) to solve this problem,
     *                            we choose median = 10 here, and after first partition, j will point to 10,
     *                            and we use recursion by calling method sortArray(or list),
     *                            and 6, 7, 9 will be in the left array(or list), 11, 14, 12 will be in the right array(or list)
     *                            the time complexity will back to O(N*logN) instead of O(N^2).
     *                       (2): Sometimes, it is less efficient to use Quick sort than selection sort or insertion sort.
     *                            When the array(or list) is divided into sub-arrays(or lists),
     *                            if the sub-array(or list) is small enough,
     *                            it is less efficient to use quick sort than selection sort or insertion sort,
     *                            we can set a threshold value, when the length of sub-array(or list) is less than the threshold value,
     *                            we use selection sort or insertion sort.
     *                       (3): Quick sort is unstable, for example, we have numbers: 8, 4, 4, 5, 4, 6, 11, 12, 16
     *                            we can create another array(or list) called Clone,
     *                            we can put all numbers < 8 into Clone array(or list),
     *                            and put other numbers >= 8 in Clone array(or list) after those numbers < 8,
     *                            and at last, we copy these numbers back to original array(or list),
     *                            so it will be stable,
     *                            but the complexity may be changed, because we create new array(or list)
     *                            and use loop to copy numbers between new array(or list) and original array(or list)
     *                       (4): If the first element we choose as pivot is the smallest or biggest element in the array(or list).
     *                            We can randomly choose an element to avoid the smallest and biggest element.
     *                            but this can only reduce the possibility of worst case rather than eliminate it completely.
     */
    public static <T extends Comparable<T>> void quickSort(final T[] array, final Comparator<T> comparator) {
        // TODO
        Random a = new Random();
        int upperbound = array.length;
        for(int i=0; i< array.length; i++)
        {
            int int_rand = a.nextInt(upperbound);
            swapArray(array, int_rand, i);
        }
        sortArray(array, 0, array.length-1, comparator);
    }

    public static <T> void sortList(List<T> list, int lo, int hi, final Comparator<T> comparator)
    {
        if(hi<=lo)
        {
            return;
        }
        int j = partitioningList(list, lo, hi, comparator);
        sortList(list, lo, j-1, comparator);
        sortList(list, j+1, hi, comparator);
    }
    public static <T> void sortArray(T[] array, int lo, int hi, final Comparator<T> comparator)
    {
        if(hi<=lo)
        {
            return;
        }
        int j = partitioningArray(array, lo, hi, comparator);
        sortArray(array, lo, j-1, comparator);
        sortArray(array, j+1, hi, comparator);
    }
    public static <T> int partitioningList(List<T> list, int lo, int hi, final Comparator<T> comparator)
    {
        int i = lo;
        int j = hi+1;
        while(true)
        {
            while(comparator.compare(list.get(++i), list.get(lo))<0)
            {
                if(i==hi)
                {
                    break;
                }
            }
            while(comparator.compare(list.get(lo), list.get(--j))<0)
            {
                if(j==lo)
                {
                    break;
                }
            }
            if(i>=j)
            {
                break;
            }
            swapList(list, i, j);
        }
        swapList(list, lo, j);
        return j;
    }
    public static <T> int partitioningArray(T[] array, int lo, int hi, final Comparator<T> comparator)
    {
        int i = lo;
        int j = hi+1;
        while(true)
        {
            while(comparator.compare(array[++i], array[lo])<0)
            {
                if(i==hi)
                {
                    break;
                }
            }
            while(comparator.compare(array[lo], array[--j])<0)
            {
                if(j==lo)
                {
                    break;
                }
            }
            if(i>=j)
            {
                break;
            }
            swapArray(array, i, j);
        }
        swapArray(array, lo, j);
        return j;
    }
    public static <T> void mergeArray(T[] array, T[] left, T[] right, int l, int r, final Comparator<T> comparator)
    {
        int m = 0;
        int n = 0;
        int q = 0;
        while(m<l && n<r)
        {
            if(comparator.compare(left[m], right[n])<=0)
            {
                array[q++] = left[m++];
            }
            else
            {
                array[q++] = right[n++];
            }
        }
        while(m<l)//T = l-m
        {
            array[q++] = left[m++];
        }
        while(n<r)//T = r-n
        {
            array[q++] = right[n++];
        }
    }
    public static <T> void mergeList(List<T> list, List<T> left, List<T> right, int l, int r, final Comparator<T> comparator)
    {
        int m=0;
        int n=0;
        int q=0;
        while(m<l && n<r)
        {
            if(comparator.compare(left.get(m), right.get(n))<0)
            {
                list.set(q++, left.get(m++));
            }
            else
            {
                list.set(q++, right.get(n++));
            }
        }
        while(m<l)
        {
            list.set(q++, left.get(m++));
        }
        while(n<r)
        {
            list.set(q++, right.get(n++));
        }
    }
    public static <T> void swapArray(T[] array, int i, int min_index )// 4
    {
        T temp;// 1
        temp = array[i];// 1
        array[i] = array[min_index];// 1
        array[min_index] = temp;// 1
    }
    public static <T> void swapList(List<T> list, int i, int min_index)
    {
        T temp;
        temp = list.get(i);
        list.set(i, list.get(min_index));
        list.set(min_index, temp);
    }
    public static <T> boolean sorted(T[] array, final Comparator<T> comparator)
    {
        T store = array[0];// 1
        for(int i=1; i<array.length; i++)// 1+n+n-1 = 2n
        {
            if(comparator.compare(array[i], store)>=0)// n-1
            {
                store = array[i];// n-1
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public static <T> boolean sorted(List<T> list, final Comparator<T> comparator)
    {
        T temp = list.get(0);
        for(int i=1; i<list.size(); i++)// 1+n+n-1 = 2n
        {
            if(comparator.compare(list.get(i), temp)>=0)
            {
                temp = list.get(i);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    /*public static void main(String[] args) {
        Integer[] array = new Integer[7];
        array[0] = 2;
        array[1] = 4;
        array[2] = 8;
        array[3] = 10;
        array[4] = 16;
        array[5] = 18;
        array[6] = 17;
        //Sorting.selectionSort(array, Character::compareTo);
        //Sorting.bogoSort(array, Character::compareTo);
        //Sorting.bubbleSort(array, Character::compareTo);
        //Sorting.mergeSort(array, Integer::compareTo);
        Sorting.quickSort(array, Integer::compareTo);
        System.out.println(Arrays.stream(array).toList());



        *//*List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(0);
        list.add(2);
        list.add(3);
        //Sorting.selectionSort(list, Integer::compareTo);
        //Sorting.bogoSort(list, Integer::compareTo);
        //Sorting.bubbleSort(list, Integer::compareTo);
        //Sorting.mergeSort(list, Integer::compareTo);
        Sorting.quickSort(list, Integer::compareTo);
        System.out.println(list);

        List<Integer> list1 = new LinkedList<>();
        list1.add(7);
        list1.add(1);
        list1.add(12);
        list1.add(5);
        list1.add(26);
        list1.add(7);
        list1.add(14);
        list1.add(3);
        list1.add(7);
        list1.add(2);
        Sorting.quickSort(list1, Integer::compareTo);
        System.out.println(list1);

        Integer[] array = new Integer[5];
        array[0] = 7;
        array[1] = 6;
        array[2] = 8;
        array[3] = 9;
        array[4] = 3;
        //Sorting.selectionSort(array, Character::compareTo);
        //Sorting.bogoSort(array, Character::compareTo);
        //Sorting.bubbleSort(array, Character::compareTo);
        //Sorting.mergeSort(array, Integer::compareTo);
        Sorting.quickSort(array, Integer::compareTo);
        //System.out.println(Arrays.stream(array).toList());

        Integer[] array1 = new Integer[10];
        array1[0] = 7;
        array1[1] = 1;
        array1[2] = 12;
        array1[3] = 5;
        array1[4] = 26;
        array1[5] = 7;
        array1[6] = 14;
        array1[7] = 3;
        array1[8] = 7;
        array1[9] = 2;
        Sorting.quickSort(array1, Integer::compareTo);
        //System.out.println(Arrays.stream(array1).toList());*//*
    }*/
}
