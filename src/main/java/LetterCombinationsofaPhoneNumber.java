
import java.util.Arrays;
import java.util.Vector;

public class LetterCombinationsofaPhoneNumber {

    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * <p>
     * 3*3的电话号码
     * <p>
     * **Input:** Digit string "23"
     * **Output:** ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    public static void main(String[] args) {
        String digits = "234";
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        Vector<String> m;
        //Vector<String> dict=new Vector<String>(Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
        //其他list也能如此初始化
        m = l.letterCombinations(digits);
        for (String word : m) {
            System.out.println(word);
        }
    }

    private Vector<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return null;
        Vector<String> res = new Vector<String>();
        Vector<String> dict = new Vector<String>(Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
        letterCombinationsDFS(digits, dict, 0, "", res);
        return res;

    }
    private void letterCombinationsDFS(String digits, Vector<String> dict, int level, String out, Vector<String> res) {
        if (level == digits.length()) {//当拼接的字符串和目标长度一直跳出，将结果保存在vector中
            res.add(out);
            //这里return  可以直接返回到上一级，若当前level为3 ，上一级为2
            //若当前函数中循环都执行完毕，会自动跳出，相当于返回上一级
            return;
        }
        //str为当前拼接的字符串，通过递归的方式在前面的字符串不断增加
        String str = dict.get(digits.charAt(level) - '0');
        for (int i = 0; i < str.length(); ++i) {
            //level + 1为下一层，输出的结果需要out + 当然 拼接的值
            letterCombinationsDFS(digits, dict, level + 1, out + str.charAt(i), res);
        }

    }
}
