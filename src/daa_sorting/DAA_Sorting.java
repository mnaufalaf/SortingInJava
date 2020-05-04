/*
 * @mnaufalaf
 * Have a nive Day :)
 * 
 */
package daa_sorting;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @odevice
 */
class Sort{
    static int i,j,swap;
    public static void Bubble(int[] array){
    int jumlah = array.length;
    for(i=0; i<(jumlah-1);i++)
    {
        for(j=0;j<jumlah-i-1;j++)
        {
            if (array[j] > array[j+1])
            {
                swap = array[j];
                array[j] = array[j+1];
                array[j+1]=swap;
            }
        }
    }
    }
    
    static void Insertion(int[] array){
    int temp; 
    int jumlah = array.length;
    for (i=1; i<jumlah;i++)
    {
        j=i;
        temp= array[i];
        while (j>0 && temp < array[j-1])
        {
            array[j] = array[j-1];
            j--;
        }
        array[j] = temp;
    }
    }
    static void Merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){
        int i=0,l=0,r = 0;
        while(l<left_size && r<right_size){

            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
          arr[i++] = right_arr[r++];
        }
    }
    public static void mergeSort(int [] arr, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];
      
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);

        Merge(left_arr,right_arr,arr,mid,len-mid);
    }
    static void Quick(int a[], int lo, int hi) {
        
    //  lo adalah index bawah, hi adalah index atas
    //  dari bagian array yang akan di urutkan
        int i=lo, j=hi, h;
        int pivot=a[lo];

    //  pembagian
        do{
            while (a[i]<pivot) i++;
            while (a[j]>pivot) j--;
            if (i<=j)
            {
                h=a[i]; a[i]=a[j]; a[j]=h;//tukar
                i++; j--;
            }
        } while (i<=j);

    //  pengurutan
        if (lo<j) Quick(a, lo, j);
        if (i<hi) Quick(a, i, hi);
    }
    
    static void Heap(int array[]) {
        int n = array.length; 
  
        // Build heap (rearrange array) 
        for (i = n / 2 - 1; i >= 0; i--) 
            heapify(array, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = array[0]; 
            array[0] = array[i]; 
            array[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(array, i, 0); 
        } 
    }
    static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
    
}
public class DAA_Sorting {
    public static void main(String[] args) {
        int jumlah,i,j, swap;

        Random ran = new Random();
        int[] array = new int[100000];
        for (i=0; i < array.length; i++)
        {
            array[i]= ran.nextInt();
        }
        
        int n = array.length;
        
        System.out.println("Banyak Elemen Array : "+n);
        System.out.println("Bilangan sebelum terurut = ");
        for (int x = 0; x < array.length; x++)
            System.out.print(array[x] + "  ");
        System.out.println("\n");

        //memanggil sort pilih salah satu
//        Sort.Bubble(array);
//        System.out.println("-> Dengan menggunakan Bubble Sort ");
//        Sort.Insertion(array);
//        System.out.println("-> Dengan menggunakan Insertion Sort ");
//        Sort.mergeSort(array, array.length);
//        System.out.println("-> Dengan menggunakan Merge Sort ");
//        Sort.Quick(array, 0, n-1);
//        System.out.println("-> Dengan menggunakan Quick Sort ");
        Sort.Heap(array);
        System.out.println("-> Dengan menggunakan Heap Sort ");

        //menampilkan elemen terurut
        System.out.println("\nBilangan sesudah terurut = ");
        for (int x = 0; x < array.length; x++)
            System.out.print(array[x] + "  ");
    }   
}
