
public class MergeSort {

    public static void main(String[] args) {
        int numbers[] = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Before sorting:");
        printArray(numbers);

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("After sorting:");
        printArray(numbers);
    }

    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);

            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void merge(int arr[], int left, int middle, int right) {
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        int leftArray[] = new int[sizeLeft];
        int rightArray[] = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < sizeRight) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
