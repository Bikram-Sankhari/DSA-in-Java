import java.lang.Math;

public class Quick_Sort {
    static int LENGTH = 50;
    static int RANGE = 100;

    static int partition(int [] arr, int low, int high){
        int i = low + 1;
        int j = high;

        while(i < j){
            while(arr[i] <= arr[low] && i < high)
            {
                i++;
            }

            while(arr[j] > arr[low]){
                j--;
            }

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if(arr[low] > arr[j]){
            int temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;
        }

        return j;
    }

    static void quick_sort(int [] arr, int low, int high){
        if((high - low) >= 1) {
            int n = partition(arr, low, high);
            quick_sort(arr,low, (n-1));
            quick_sort(arr, (n + 1), high);
        }

    }

    public static void main(String[] args) {
        int [] arr = new int[LENGTH];
        for(int i = 0; i < LENGTH; i++){
            arr[i] = (int) (Math.random() * (RANGE + 1));
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n---------------After Sorting-----------------");
        quick_sort(arr, 0, (LENGTH-1));

        for(int i = 0; i < LENGTH; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
