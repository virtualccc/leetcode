public class ZigZag {
    /**
     * 比如有一个字符串 “0123456789ABCDEF”，转为zigzag
     *
     * 当 n = 2 时：
     *
     * 0 2 4 6 8 A C E
     *
     * 1 3 5 7 9 B D F
     *
     * 当 n = 3 时：
     *
     * 0   4    8     C  4
     *
     * 1 3 5 7 9 B D F   2
     *
     * 2    6   A     E  4
     *
     * 当 n = 4 时：
     *
     * 0     6        C     6
     * 1   5 7   B  D       4 2
     * 2 4   8 A    E       2
     * 3      9       F     6
     */

    /**
     * 首位两行中相邻两个元素的index之差跟行数是相关的，为 2nRows - 2,( 0 ,3 首尾行)
     * 根据这个特点，我们可以按顺序找到所有的黑色元素在元字符串的位置，将他们按顺序加到新字符串里面。
     * 对于红色元素出现的位置也是有规律的，每个红色元素的位置为 j + 2nRows-2 - 2i,
     * 其中，j为前一个黑色元素的列数，i为当前行数。
     * 比如当n = 4中的那个红色5，它的位置为 1 + 24-2 - 2*1 = 5，为原字符串的正确位置。
     * 当我们知道所有黑色元素和红色元素位置的正确算法，我们就可以一次性的把它们按顺序都加到新的字符串里面。
     */
    public static void main(String[] args) {
        String str = "0123456789ABCDEF";
        String[] s= str.split("");
        ZigZag l = new ZigZag();
        int nRows = 4;//排列多少行
        l.Zig(s, nRows);
    }

    private void Zig(String[] s, int nRows) {
        if (nRows <= 1) System.out.println(s);
        String res = "";
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; ++i) {
            for (int j = i; j <s.length; j += size) {
                res += s[j];
                //i为行数，j为第i行中的各个数字
                int tmp = size + j - 2 * i;
                if (i != 0 && i != nRows - 1 && tmp < s.length)
                    res += s[tmp];
            }
        }
        System.out.println(res);
    }
}
