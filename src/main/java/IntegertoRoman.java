import java.util.Vector;

public class IntegertoRoman {

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M(1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     *
     * Input: 3
     * Output: "III"
     * Example 2:
     *
     * Input: 4
     * Output: "IV"
     * Example 3:
     *
     * Input: 9
     * Output: "IX"
     * Example 4:
     *
     * Input: 58
     * Output: "LVIII"
     * Explanation: L = 50, V = 5, III = 3.
     * @param args
     */
    public static void main(String[] args) {
        IntegertoRoman l = new IntegertoRoman();
        int input = 2437;
        System.out.println(l.IntertoRoma(input));

    }

    private String IntertoRoma(int num) {
        String[] v1={"", "M", "MM", "MMM"};
        String[] v2={"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] v3={"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] v4={"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return v1[num / 1000] + v2[(num % 1000) / 100] + v3[(num % 100) / 10] + v4[num % 10];
    }

    /**
     * 例如整数 1437 的罗马数字为 MCDXXXVII，
     * 我们不难发现，千位，百位，十位和个位上的数分别用罗马数字表示了。
     * 1000 - M, 400 - CD, 30 - XXX, 7 - VII。
     * 所以我们要做的就是用取商法分别提取各个位上的数字，然后分别表示出来：
     *
     * 100 - C
     *
     * 200 - CC
     *
     * 300 - CCC
     *
     * 400 - CD
     *
     * 500 - D
     *
     * 600 - DC
     *
     * 700 - DCC
     *
     * 800 - DCCC
     *
     * 900 - CM
     *
     * 我们可以分为四类，
     * 100到300一类，
     * 400一类，
     * 500到800一类，
     * 900最后一类。每一位上的情况都是类似的
     */
}
