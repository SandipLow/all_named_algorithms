import com.sandip.*;


public class Main {
    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 8, 5, 3, 7, 5, 2};

        Sorting.countSort(arr, 0, arr.length-1);

        Utils.printArr(arr);
    }
}
