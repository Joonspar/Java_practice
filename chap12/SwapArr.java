package joonseo.chap12;

public class SwapArr {
    public static <T> void swap(T[] arr, int i1 , int i2){
        T temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }



}
