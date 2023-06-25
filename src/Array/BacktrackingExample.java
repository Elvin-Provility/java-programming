package Array;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingExample {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    private static void backtrack(int[] nums, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            System.out.println(tempList);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(nums, tempList, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
