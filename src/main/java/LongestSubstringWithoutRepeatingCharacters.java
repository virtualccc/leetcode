import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke"
     * 注意这里是子串，不是子序列，所以必须是连续的。
     */

    public static void main(String[] args) {
        String str = "abcdcsss";
        LongestSubstringWithoutRepeatingCharacters L = new LongestSubstringWithoutRepeatingCharacters();
        L.method(str);

    }

    /**
     *利用双指针与hashset
     * right如果碰上重复，从左侧开始移除数据直到移除重复数据
     */


    private void method(String s) {
        int maxlength = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<Character>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right));
                right++;
                maxlength = Math.max(maxlength, t.size());
            } else {
                t.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println(maxlength);
    }
}
