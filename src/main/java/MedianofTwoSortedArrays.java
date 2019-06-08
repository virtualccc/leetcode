public class MedianofTwoSortedArrays {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     * @param args
     */
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4, 5};
        double middle = searchmid(num1, num2);
        System.out.println(middle);
    }

    /**
     * 要在两个未合并的有序数组之间使用二分法，如果这道题只有一个有序数组，让我们求中位数的话，估计就是个 Easy 题
     * 采用2分法在2个数组中寻找
     * 中位数  ((n+m+1)/2 + (m+n+2)/2 )/2
     *
     * 在奇偶情况下求中位数
     * 1 2 3
     * 3 + 1  /2 =2    3+2  /2 =2  取均值为中位数
     *
     * 1 2 3 4
     * 4+1  /2 = 2      5+1 /2=3   取均值为中位数
     *
     *
     *
     */
    private static double searchmid(int[] nums1, int[] nums2) {
                int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
                //找2个中位数取均值
                return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;

    }

    private static double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        //查看下一个位置是否能寻找到
        int midVal1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 -1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1) < nums2.length ? nums2[j  + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2 , nums2, j, k - k/2);
        } else {
            return findKth(nums1, i , nums2, j + k/2  , k - k/2);
        }




    }


//    private static  int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
//                //在一个数组中如果当前搜索位置大于数组长度，则说明得从另一个数组中找
//                if (i >= nums1.length) return nums2[j + k - 1];
//                if (j >= nums2.length) return nums1[i + k - 1];
//                //k从1/2处从不断二分查找，K为1 取小即可
//        /**
//         * 1 3
//         * 2 4 5
//         * 在2个合并数组中找 5+1 /2 = 3位置的数字
//         * 在每个数组中寻找  3/2 =1 的数字
//         * 出口条件就是 K == 1时，取两个数组中较小的
//         */
//                if (k == 1) return Math.min(nums1[i], nums2[j]);
//                int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
//                int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
////                对比两个数组中寻找到的1/2位置处，谁小就需要向右移动
//                if (midVal1 < midVal2) {
//                    return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
//                } else {
//                    return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
//                }
//            }
        }


