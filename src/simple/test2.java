package simple;
import Testing.test1;

import java.util.HashSet;
import java.util.Set;

public class test2 {
    public static void main(String[] args)
    {
        int[] a={1,2,3,4,5};
        int[] b={6,1,2,5,8};
        Set<Integer> result = new HashSet<Integer>();
        for(int i=0;i<a.length;i++){
            result.add(a[i]);
        }
        for(int j=0;j<b.length;j++){
            result.add(b[j]);
        }
        System.out.println(result.toString());

        int[] arr = new int[5];
        arr[0] = 1;

    }

}
