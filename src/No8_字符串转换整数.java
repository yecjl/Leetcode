public class No8_字符串转换整数 {
    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     *
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     *
     * 提示：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *  
     *
     * 示例 1:
     *
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     *
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("myAtoi = " + myAtoi("  -4193 with words  12")); // -4193
        System.out.println("myAtoi = " + myAtoi("-91283472332")); // -2147483648
        System.out.println("myAtoi = " + myAtoi("+1")); // 1
        System.out.println("myAtoi = " + myAtoi("+-2")); // 0
        System.out.println("myAtoi = " + myAtoi("-+2")); // 0
        System.out.println("myAtoi = " + myAtoi("-2-")); // -2
        System.out.println("myAtoi = " + myAtoi("-2+")); // -2
        System.out.println("myAtoi = " + myAtoi("2-")); // 2
        System.out.println("myAtoi = " + myAtoi("2+"));
        System.out.println("myAtoi = " + myAtoi("-")); // 0
        System.out.println("myAtoi = " + myAtoi("+")); // 0
        System.out.println("myAtoi = " + myAtoi("   +0 123")); // 0
        System.out.println("myAtoi = " + myAtoi("2147483646")); // 2147483646
        System.out.println("myAtoi = " + myAtoi("2147483648")); // 2147483647
        System.out.println("myAtoi = " + myAtoi("-2147483648")); // -2147483648
        System.out.println("myAtoi = " + myAtoi("-2147483649")); // -2147483649
    }

    /**
     * 这个是比较好的答案
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int index = 0;
        boolean flag = true; // 是否为正数
        boolean hasSymbol = false; // 有几个符号
        int result = 0;
        while ((index < len) && (chars[index] == ' ' || chars[index] == '-' || chars[index] == '+' || (chars[index] >= 48 && chars[index] <= 57))) {
            if (chars[index] == '-' || chars[index] == '+') {
                // -123-
                if (index > 0 && (chars[index - 1] >= 48 && chars[index - 1] <= 57)) {
                    break;
                }
                // -+12
                if (hasSymbol) {
                    return 0;
                }
                hasSymbol = true;
            }
            if (chars[index] == '-') {
                flag = false;
            }
            if (chars[index] == ' ') {
                // "   +0 123"
                if (index > 0 && (chars[index - 1] != ' ')) {
                    break;
                }
            } else if (chars[index] >= 48 && chars[index] <= 57) {
                int temp = flag ? result : -result;
                if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && (chars[index]-'0') > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE / 10 && (chars[index]-'0') > 8)) {
                    return Integer.MIN_VALUE;
                }

                result = result * 10 + (chars[index] - '0');
            }

            index++;
        }
        return flag ? result : -result;
    }

    public int myAtoi2(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int index = 0;
        boolean flag = true; // 是否为正数
        int symbol = 0; // 有几个符号
        StringBuilder sb = new StringBuilder();
        while ((index < len) && (chars[index] == ' ' || chars[index] == '-' || chars[index] == '+' || (chars[index] >= 48 && chars[index] <= 57))) {
            if (chars[index] == '-' || chars[index] == '+') {
                if (index > 0 && (chars[index - 1] >= 48 && chars[index - 1] <= 57)) {
                    break;
                }
                symbol++;
            }
            if (chars[index] == ' ') {
                if (index > 0 && (chars[index - 1] != ' ')) {
                    break;
                }
            } else {
                sb.append(chars[index]);
            }
            if (chars[index] == '-') {
                flag = false;
            }
            index++;
        }
        String result = sb.toString();
        if (result == null || result.length() == 0 || "-".equals(result) || "+".equals(result) || symbol > 1) {
            return 0;
        }
        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            if (flag) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
