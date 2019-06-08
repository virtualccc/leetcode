
public class ReverseInteger {
    /**
     * Input: 123
     * Output: 321
     * Example 2:
     *
     * Input: -123
     * Output: -321
     * Example 3:
     *
     * Input: 120
     * Output: 21
     */
    public static void main(String[] args) {
        int input = 123;
        ReverseInteger l = new ReverseInteger();
        l.reverseinteger(input);

    }

    private void reverseinteger(int input) {
        int res = 0;
        while (input != 0) {
            //边界条件int型的数值范围是 -2147483648～2147483647， 那么如果我们要翻转 1000000009 这个在范围内的数得到 9000000001，而翻转后的数就超过了范围。
            //如果上一次的值 要比整型/10大，就溢出了，没必要比较
            if (Math.abs(res) > Integer.MAX_VALUE/10) System.out.println(0);;

            res = res * 10 + input % 10;
            input /= 10;
        }
        System.out.println(res);
    }
}
