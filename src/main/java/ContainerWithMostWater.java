public class ContainerWithMostWater {
        

    /**
     * 需要定义i和j两个指针分别指向数组的左右两端，
     * 然后两个指针向中间搜索，每移动一次算一个值和结果比较取较大的，
     * 容器装水量的算法是找出左右两个边缘中较小的那个乘以两边缘的距离
     * @param args
     *
     * 给定n个非负整数a 1，a 2，…，a n，其中每个表示一个坐标点（i，a i）。
     * n画垂直线，使线i的两个端点位于（i，a i）和（i，0）。
     * 找到两条线，与x轴一起构成一个容器，这样容器中的水就最多了。
     * 注意：不要使容器倾斜。
     */
    public static void main(String[] args) {

        int[] arr = {1, 5, 7, 42, 7, 8, 53, 13, 73, 9};
        ContainerWithMostWater l = new ContainerWithMostWater();
        System.out.println(l.maxArea(arr));
        
    }

    /**
     * 线之间形成的区域总是受限于短线的高度。此外，线越远，所获得的区域就越多。
     * 我们使用两个指针，一个在开头，一个在数组末尾，构成行长度。此外，
     * 我们还保留了一个变量max来存储到目前为止获得的最大面积。
     * 在每步中，我们找到它们之间形成的区域，更新max并将指针指向另一端的指针。
     * 因为木桶原理，容积取决于行长度和最短高度的积，所以，两个端点高度较低的需要移动，
     * 因为高度较高的移动不可能大于原来的两端点积。这样，每次都是高度低的移动
     * ，直到两指针相邻。
     * @param height
     * @return
     */
    private int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max=0;
        while(i!=j){
            if(height[i]<height[j]){//木桶原理，总是小木板是盛水的标志
                max=height[i]*(j-i)>max?height[i]*(j-i):max;
                i++;
            }
            if(height[i]>height[j]){
                max=height[j]*(j-i)>max?height[j]*(j-i):max;
                j--;
            }
        }
        return max;

    }
}
