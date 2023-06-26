public class Merge_Sort {
    static int LENGTH = 50;
    static int RANGE = 100;

    static void merge(int [] arr, int low1, int high1, int low2, int high2){
        int i = low1, j = low2, k = 0;
        int [] sorted_array = new int[(high1 - low1) + (high2 - low2) + 2];

        while(i <= high1 && j <= high2){
            if(arr[i] <= arr[j]){
                sorted_array[k] = arr[i];
                i++;
            }

            else{
                sorted_array[k] = arr[j];
                j++;
            }

            k++;
        }

        for(;i <= high1; i++){
            sorted_array[k] = arr[i];
            k++;
        }

        for(;j<= high2; j++){
            sorted_array[k] = arr[j];
            k++;
        }

        i = low1;
        for(int element: sorted_array){
            arr[i] = element;
            i++;
        }
    }

    static void merge_sort(int [] arr, int low, int high){
        if(high > low){
            merge_sort(arr, low, (high + low)/2);
            merge_sort(arr, ((high + low) /2 + 1), high);

            merge(arr, low, ((high + low)/2), ((high + low) /2 + 1), high);
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[LENGTH];
        for(int i = 0; i < LENGTH; i++){
            arr[i] = (int) (Math.random() * (RANGE + 1));
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n---------------After Sorting-----------------");
        merge_sort(arr, 0, (LENGTH-1));

        for(int i = 0; i < LENGTH; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
