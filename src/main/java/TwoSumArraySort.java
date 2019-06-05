public class TwoSumArraySort {
    /**
     * 输入数组有序求目标值
     * 1.二分法搜索 n(nlogn)
     * 2.2个指针一个指向头一个指向尾，相加  o(n)
     */

    public static int flag = 0;

    public static void main(String[] args) {
        TwoSumArraySort sc = new TwoSumArraySort();
        int[] arr = {2, 7, 11, 9};
        int target = 9;
        sc.erfen(arr, target);
        sc.doublezhizhen(arr, target);
        if (flag == 0) {
            System.out.println("不存在");
        }

    }

    private void doublezhizhen(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                System.out.println("双指针结果存在");
                flag = 1;
                break;
            } else if (sum < target) {
                l++;
            } else
                r--;
        }
    }

    private void erfen(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = target - arr[i];
            int low = i + 1;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == tmp) {
                    System.out.println("二分法结果存在");
                    flag = 1;
                    break;
                } else if (arr[mid] < tmp) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
    }

}
