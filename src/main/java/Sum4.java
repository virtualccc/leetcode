import java.util.Arrays;
import java.util.Vector;

public class Sum4 {
    /**
     * Given an array S of n integers, are there elements a , b , c , and d in S such that a + b + c + d = target?
     * Find all unique quadruplets in the array which gives the sum of target.
     * Note:
     * Elements in a quadruplet ( a , b , c , d ) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d )
     * The solution set must not contain duplicate quadruplets.
     * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
     * A solution set is:
     * (-1,  0, 0, 1)
     * (-2, -1, 1, 2)
     * (-2,  0, 0, 2)
     */

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        Sum4 l = new Sum4();
        int target = 0;
        System.out.println(l.fourSum(arr, target));

    }

    private Vector<Vector<Integer>> fourSum(int[] nums, int target) {
        Vector<Vector<Integer>> res = new Vector<Vector<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        Vector<Integer> out = new Vector<Integer>();
                        out.add(nums[i]);
                        out.add(nums[j]);
                        out.add(nums[left]);
                        out.add(nums[right]);
                        res.add(out);
                        while (left < right && nums[left] == nums[left + 1]) ++left;
                        while (left < right && nums[right] == nums[right - 1]) --right;
                        ++left;
                        --right;
                    } else if (sum < target) ++left;
                    else --right;
                }
            }
        }
        return res;
    }
}
