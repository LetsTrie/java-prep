import java.util.Arrays;

public class MergeSort {
    private static int[] auxiliary;
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public static void mergeSort(int[] array) {
        int length = array.length;
        if(length < 2) return;

        auxiliary = new int[length];
        mergeSort(array, 0, length - 1);
    }

    private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if(leftIndex >= rightIndex) return ;

        if (rightIndex - leftIndex + 1 <= INSERTION_SORT_THRESHOLD) {
            insertionSort(array, leftIndex, rightIndex);
            return;
        }

        int midIndex = (leftIndex + rightIndex) / 2;

        mergeSort(array, leftIndex, midIndex);
        mergeSort(array, midIndex + 1, rightIndex);

        merge(array, leftIndex, midIndex, rightIndex);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int lastNumberOfLeftArray = array[mid];
        int firstNumberOfRightArray = array[mid + 1];
        if (lastNumberOfLeftArray <= firstNumberOfRightArray) return; // Sub-arrays are already sorted, no need to merge

        int leftArrayIndex = low;
        int rightArrayIndex = mid + 1;

        for(int sortedArrayIndex = low; sortedArrayIndex <= high; sortedArrayIndex++) {
            if(leftArrayIndex == mid + 1) auxiliary[sortedArrayIndex] = array[rightArrayIndex++];
            else if(rightArrayIndex == high + 1) auxiliary[sortedArrayIndex] = array[leftArrayIndex++];
            else if(array[leftArrayIndex] < array[rightArrayIndex]) auxiliary[sortedArrayIndex] = array[leftArrayIndex++];
            else auxiliary[sortedArrayIndex] = array[rightArrayIndex++];
        }

        for(int sortedArrayIndex = low; sortedArrayIndex <= high; sortedArrayIndex++) {
            array[sortedArrayIndex] = auxiliary[sortedArrayIndex];
        }
    }

    private static void insertionSort(int[] array, int leftIndex, int rightIndex) {
        for (int index = leftIndex + 1; index <= rightIndex; index++) {
            int currentElement = array[index];
            int ptr = index - 1;

            while (ptr >= leftIndex && array[ptr] > currentElement) {
                array[ptr + 1] = array[ptr];
                ptr--;
            }

            array[ptr + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 4, 2, 7, 5, 1, 8, 3, 6};

        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
