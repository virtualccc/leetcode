public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */
    public static void main(String[] args) {
        String[] input  = {"flower","flow","flight"};
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(input));

    }

    private String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int j = 0; j < strs[0].length(); ++j) {//取字符串的每个元素
            for (int i = 0; i < strs.length; ++i) {//依次取3个字符串进行对比
                //如果当前元素位置大于字符串长度，则返回0，j中字符串
                //如果元素和第一个字符串不相等，则返回0，j中字符串
                /**
                 * 首先 strs 0 和 str 0对比第一个元素，然后str 1 str2
                 * 如果不相等则返回当前所对比的strs[i]中的0-j
                 */
                if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0];
    }
}
