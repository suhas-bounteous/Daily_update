package DAY2;
import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {

        int[] arr = {2, 0, 2, 1, 1, 0};

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }

            else if (arr[mid] == 1) {
                mid++;
            }

            else { l
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
