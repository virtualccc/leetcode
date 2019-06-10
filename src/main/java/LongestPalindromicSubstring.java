import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

    /**
     * Example 1:
     * <p>
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: "cbbd"
     * Output: "bb"
     * <p>
     * 1.那么对于找回文字串的问题，就要以每一个字符为中心，像两边扩散来寻找回文串
     * <p>
     * 2.动态规划
     * <p>
     * 3.马拉车算法 Manacher's Algorithm
     */
    public static void main(String[] args) {
        String str = "babad";
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String out = l.method1(str);
        l.method2(str);
        String out3 = l.method3(str);
        System.out.println(out + "动态规划");
        System.out.println(out3 + "暴力");

    }

    private String method3(String s) {
        if (s.length() <= 1)
            return s;//表示字符串中无回文子串

        for (int i = s.length(); i > 0; i--) {//子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, i + j);//子串位置
                int count = 0;//计数，用来判断是否对称
                for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
                        count++;
                }
                if (count == sub.length() / 2)
                    return sub;
            }
        }
        return "";//表示字符串中无回文子串

    }

    private void method2(String s) {
        List<Character> s_new = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            s_new.add('#');
            s_new.add(s.charAt(i));
        }
        s_new.add('#');
        List<Integer> Len = new ArrayList<Integer>();
        String sub = "";//最长回文子串
        int sub_midd = 0;//表示在i之前所得到的Len数组中的最大值所在位置
        int sub_side = 0;//表示以sub_midd为中心的最长回文子串的最右端在S_new中的位置
        Len.add(1);
        for (int i = 1; i < s_new.size(); i++) {
            if (i < sub_side) {//i < sub_side时，在Len[j]和sub_side - i中取最小值，省去了j的判断
                int j = 2 * sub_midd - i;
                if (j >= 2 * sub_midd - sub_side && Len.get(j) <= sub_side - i) {
                    Len.add(Len.get(j));
                } else
                    Len.add(sub_side - i + 1);
            } else//i >= sub_side时，从头开始匹配
                Len.add(1);
            while ((i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()) && (s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i))))
                Len.set(i, Len.get(i) + 1);//s_new[i]两端开始扩展匹配，直到匹配失败时停止
            if (Len.get(i) >= Len.get(sub_midd)) {//匹配的新回文子串长度大于原有的长度
                sub_side = Len.get(i) + i - 1;
                sub_midd = i;
            }
        }
        sub = s.substring((2 * sub_midd - sub_side) / 2, sub_side / 2);//在s中找到最长回文子串的位置
        System.out.println(sub + "拉马车");
        ;

    }

    /**
     * 其中 dp[i][j] 表示字符串区间 [i, j] 是否为回文串，当 i = j 时，只有一个字符，肯定是回文串
     * 如果 i = j + 1，说明是相邻字符，此时需要判断 s[i] 是否等于 s[j]
     * 如果i和j不相邻，即 i - j >= 2 时，除了判断 s[i] 和 s[j] 相等之外，dp[i + 1][j - 1] 若为真，就是回文串，通过以上分析，可以写出递推式如下：
     有dp关系式：

     dp[i, j] = 1                          if i == j

     = s[i] == s[j]                        if j = i + 1

     = s[i] == s[j] && dp[i + 1][j - 1]    if j > i + 1
     * 这里有个有趣的现象就是如果把下面的代码中的二维数组由 int 改为 vector<vector> 后，就会超时，
     * 这说明 int 型的二维数组访问执行速度完爆 std 的 vector 啊，所以以后尽可能的还是用最原始的数据类型吧。
     */
    private String method1(String s) {
        if (s.isEmpty()) return "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        int left = 0, right = 0, len = 0;

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {//由于对称性只用计算上三角
//               s.charAt(i) == s.charAt(j) 必须满足，  当 i = j+1时，说明相邻则是回文，
//                i>j+1时，说明长度大于2，需要判断dp[j + 1][i - 1]是否是回文
                dp[j][i] = s.charAt(i) == s.charAt(j) && ((i - j == 1) ||  (i - j > 1) && dp[j + 1][i - 1]);

                if (dp[j][i] && len < i - j + 1) {//记录索引，与最大字字符串
                    len = i - j + 1;
                    left = j;
                    right = i;
                }
            }
        }
        return s.substring(left, right - left + 1);
    }
}
