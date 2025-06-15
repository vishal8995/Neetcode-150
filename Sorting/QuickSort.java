package Sorting;

public class QuickSort {

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivotIndex = partition(nums, l, r);// Find correct place for pivot
            quickSort(nums, l, pivotIndex - 1); // Sort left side
            quickSort(nums, pivotIndex + 1, r); // Sort right side
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 8, 9, 1, 5 };
        quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
