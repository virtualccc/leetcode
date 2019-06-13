import java.util.HashMap;
import java.util.Map;
//元组的设计方法
class TwoTuple {
    public char k;
    public int v;

    public TwoTuple(char a, int b) {
        this.k = a;
        this.v = b;
    }
}

public class RomantoInteger {
    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X+ II. The number twenty seven is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X(10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * Example 1:
     * <p>
     * Input: "III"
     * Output: 3
     * Example 2:
     * <p>
     * Input: "IV"
     * Output: 4
     * Example 3:
     * <p>
     * Input: "IX"
     * Output: 9
     * Example 4:
     * <p>
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 5:
     * <p>
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     * @param args
     */
    public static void main(String[] args) {

        RomantoInteger l = new RomantoInteger();
        String s = "MCMXCIV";
        System.out.println(l.RomatoInter(s));

    }

    private int RomatoInter(String s) {
        int res = 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        TwoTuple n1 = new TwoTuple('I', 1);
        TwoTuple n2 = new TwoTuple('V', 5);
        TwoTuple n3 = new TwoTuple('X', 10);
        TwoTuple n4 = new TwoTuple('L', 50);
        TwoTuple n5 = new TwoTuple('C', 100);
        TwoTuple n6 = new TwoTuple('D', 500);
        TwoTuple n7 = new TwoTuple('M', 1000);
        m.put(n1.k, n1.v);
        m.put(n2.k, n2.v);
        m.put(n3.k, n3.v);
        m.put(n4.k, n4.v);
        m.put(n5.k, n5.v);
        m.put(n6.k, n6.v);
        m.put(n7.k, n7.v);
/**
 * 每次跟前面的数字比较，如果小于等于前面的数字，
 * 我们先加上当前的数字，比如 "VI"，第二个字母 'I' 小于第一个字母 'V'，所以要加1。
 * 如果大于的前面的数字，我们加上当前的数字减去二倍前面的数字，
 * 这样可以把在上一个循环多加数减掉，比如 "IX"，我们在 i=0 时，
 * 加上了第一个字母 'I' 的值，此时结果res为1。当 i=1 时，
 * 我们发现字母 'X' 大于前一个字母 'I'，这说明前面的1是要减去的，
 * 而由于我们前一步不但没减，还多加了个1，所以此时要减去2倍的1，就是减2，
 * 所以才能得到9，整个过程是 res = 1 + 10 - 2 = 9
 */
        for (int i = 0; i < s.length(); ++i) {
            if (i == 0 || m.get(s.charAt(i)) <= m.get(s.charAt(i - 1)))
                res += m.get(s.charAt(i));
            else res += m.get(s.charAt(i)) - 2 * m.get(s.charAt(i - 1));
        }
        return res;
    }
}
