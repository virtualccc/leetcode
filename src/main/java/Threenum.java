public class Threenum {
    /**
     * 3数之和，思路：1.排序，固定一个数（对于重复数字不进行计算，搞一个hashset保存数据即可），剩下的数可以通过2数之和求解
     *
     *                2.暴力法求出所有可能解，可以通过递归+剪枝
     */

    public static int flag = 0;
    public static void main(String[] args) {
        Threenum sc =new Threenum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int target= 0;
        sc.search3num(arr, target);

        if (flag == 0) {
            System.out.println("不存在");
        }
    }

    private void search3num(int[] arr, int target) {

    }
}
