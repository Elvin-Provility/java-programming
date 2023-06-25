package Testing;

import java.util.*;
import java.util.Scanner;

public class newTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array length");
        int []arr1 = new int[]{1,2,3,4,5};
        int []arr2 = new int[]{1,6,3,7,5};
        for (int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr2[j] != arr1[i]){
                    System.out.print(arr1[i]);
                    break;
                }
            }
        }
        Map<Integer, Boolean> res = new HashMap<Integer, Boolean>();
        for(int i=0;i<arr1.length;i++){
            res.put(arr1[i], true);
        }
        res.forEach((key,value)->{

        });
        for(int j=0;j<arr2.length;j++){
            res.put(arr2[j], true);
        }
        System.out.println(res);
    }
}
