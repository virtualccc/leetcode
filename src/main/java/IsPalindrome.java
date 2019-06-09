public class IsPalindrome {

    /**
     * Input: 121
     * Output: true
     * Example 2:
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */
    public static void main(String[] args) {
        int input = 121;
        IsPalindrome l = new IsPalindrome();
        System.out.println(l.ispalindrome(input));

    }

    /**
     * 首先判断x是否为负数
     * 整数的最高位不能是0，所以回文数的最低位也不能为0，数字0除外，所以如果发现某个正数的末尾是0了，也直接返回false即可
     *前后半段是否对称，如果把后半段翻转一下，就看和前半段是否相等就行了
     *
     * 由于回文数的位数可奇可偶
     * 如果是偶数的话，那么revertNum就应该和x相等了
     * 如果是奇数的话，那么最中间的数字就在revertNum的最低位上了
     * 除以10以后应该和x是相等的
     *
     */
    private boolean ispalindrome(int input) {
        if (input < 0 || (input % 10 == 0 && input != 0)) {
            System.out.println("不是");
        }
        int reverNum = 0;
        while (input > reverNum) {
            reverNum = reverNum * 10+ input %10;
            input /= 10;
        }
        return input==reverNum||input ==reverNum/10;
    }
}
