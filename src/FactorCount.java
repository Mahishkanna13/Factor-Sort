import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Count
{
    int a;
    int b;
    Count(int a, int b)
    {
        this.a=a;
        this.b=b;

    }

}


class SComparator implements Comparator<Count> {

    public int compare(Count o1, Count o2)
    {
        if (o1.a == o2.a) {
            return 0;
        }
        else if (o1.a < o2.a) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

public class FactorCount {
    static void printSorted(int arr[], int n)
    {
        ArrayList<Count> v = new ArrayList<Count>();
        for (int i = 0; i < n; i++) {


            int count = 0;
            for (int j = 1; j * j <= arr[i]; j++) {


                if (arr[i] % j == 0) {
                    count++;


                    if (arr[i] / j != j)
                        count++;
                }
            }


            v.add(new Count (count, arr[i]));
        }


        Collections.sort(v, new SComparator());


        for (Count i : v)
            System.out.print(i.b+" ");
    }


    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int size= scan.nextInt();

        int arr[] = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = scan.nextInt();
        }


        printSorted(arr, size);
    }


}