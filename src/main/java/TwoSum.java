import java.util.HashMap;

public class TwoSum {


    /**
     * 思路：寻找2数之和等于target
     * 1.暴力解题法，2个For循环遍历寻找
     * 2.以空间换时间，利用一个空间存放数字和坐标，遍历一遍数据，则查找target - a[i]是否存在于除了a[i]外的数组中
     * 查找hashmap快
     */

    public int flag = 0;

    public static void main(String[] args) {
        TwoSum sc = new TwoSum();
        int[] arr = {1, 2, 3, 4, 5, 6, 834, 432, 7, 3, 7, 9, 0, 3, 9, 3, 7, 2};
        int target = 17;
        System.out.printf("是否可以找到目标数字%d", target);
        System.out.println();
        sc.TwoSumsolution(arr, target);


    }

    public void TwoSumsolution(int[] arr, int target) {
        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
//        for (int i = 0; i < arr.length; i++) {
//            a.put(i, arr[i]);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            int res = target - arr[i];
//            if (a.containsValue(res) && a.get(res) != i) {
//                System.out.println("存在");
//                flag = 1;
//                break;
//            }
//        }
        /**
         * 解法2，for循环可以合并。合并后相当于倒推
         */

        for (int i = 0; i < arr.length; i++) {
            int res = target - arr[i];
            if (a.containsValue(res) && a.get(res) != i) {
                System.out.println("存在");
                flag = 1;
                break;
            }
            a.put(i, arr[i]);//后面是能找到对应的数据的
        }


        if (flag == 0) {
            System.out.println("不存在");
        }
    }
}
