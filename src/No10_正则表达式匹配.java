import java.util.ArrayList;
import java.util.List;

public class No10_正则表达式匹配 {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3:
     * <p>
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4:
     * <p>
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5:
     * <p>
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println("isMatch = " + isMatch("a", "aa"));
//        System.out.println("--------------------------------------");
//        System.out.println("isMatch = " + isMatch("aa", "a"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("aa", "a*"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("aa", "ab"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("aab", "a*"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("ab", "."));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("ab", ".*"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("aab", "c*a*b"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("mississippi", "mis*is*p*."));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("ab", ".*c"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("aaaa", "a*a*a"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("aaaa", "a*.*a"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("aaa", "aaaa"));
//        System.out.println("isMatch = " + isMatch("aaab", "aa*aaab"));
//        System.out.println("--------");
//        System.out.println("isMatch = " + isMatch("a", "ab*"));
        System.out.println("isMatch = " + isMatch("aab", "aa*a*b"));
    }


    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        System.out.println("******  s = " + s + ", p = " + p + "  ******");

        boolean isMatch = getMatchIndexs(s, p);

        if (isMatch && pi < pLen) {
//            if (pChar == '*') {
//                si--;
//                pi++;
//                isMatch = getMatchIndexs(s, p);
//            }
            System.out.println("后续处理：");
            while (pi < pLen) {
//                System.out.println("step " + step + " : s(" + PrintUtils.getColorStr(s, si - 1) + ") | p(" +
//                        PrintUtils.getColorStr(p, new PrintUtils.ColorParam[]{
//                                new PrintUtils.ColorParam(pi, PrintUtils.Color.RED)}) + ") -->  step *");
//                if (sChar == hisChar && pChar == '*') {
//                    pi++;
//                    step++;
//                } else if (pi + 1 < pLen && p.charAt(pi + 1) == '*') {
//                    step++;
//                    pi = pi + 2;
//                } else {
//                    break;
//                }
                getMatchIndexs2(s, p);

            }
        }
        System.out.println();
        System.out.println("result : si = " + si + ", pi = " + pi);

        return si >= sLen && pi >= pLen ? true : false;

    }

    static int si = 0;
    static int pi = 0;
    static int hi = 0;
    static char sChar = 0, pChar = 0;
    static char hisChar = 0;
    static int step = 0;
    static List<StringBuilder> group = new ArrayList<>();


    //"a aa b", "a a* aaab"
    //"aaaaa", "a* a* aaaaa"

    public static boolean getMatchIndexs(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean isMatch = false;

        while (si < sLen && pi < pLen) {
            step++;
            sChar = s.charAt(si);
            pChar = p.charAt(pi);
            if (pChar != '*') {
                hisChar = pChar;
                hi = pi;
            }
            if (sChar == pChar) {
                System.out.println("step " + step + " : s(" + PrintUtils.getColorStr(s, si) + ") | p(" + PrintUtils.getColorStr(p, pi) + ") -->  sChar == pChar");
                si++;
                pi++;
                group.add(new StringBuilder().append(sChar));
                printGroup();
                isMatch = true;
            } else {
                if (pChar == '*') {
                    if (sChar == hisChar) {
                        group.get(group.size() - 1).append(sChar);
                        isMatch = true;
                        System.out.println("step " + step + " : s(" + PrintUtils.getColorStr(s, new PrintUtils.ColorParam[]{
                                new PrintUtils.ColorParam(hi, hi + group.get(group.size() - 1).length(), null, PrintUtils.Color.WHITE),
                                new PrintUtils.ColorParam(si)
                        }) + ") | p(" + PrintUtils.getColorStr(p, new PrintUtils.ColorParam[]{new PrintUtils.ColorParam(pi, PrintUtils.Color.RED), new PrintUtils.ColorParam(hi, PrintUtils.Color.DARKGREEN)}) + ") -->  pChar == '*', sChar == hisChar");
                        printGroup();
                        si++;
                    } else {
                        if (hisChar == '.') {
                            si++;
                            isMatch = true;
                            group.get(group.size() - 1).append(sChar);
                            printGroup();
                        } else {
                            System.out.println("step " + step + " : s(" + PrintUtils.getColorStr(s, new PrintUtils.ColorParam[]{
                                    new PrintUtils.ColorParam(hi, hi + group.get(group.size() - 1).length(), null, PrintUtils.Color.WHITE),
                                    new PrintUtils.ColorParam(si)
                            }) + ") | p(" + PrintUtils.getColorStr(p, new PrintUtils.ColorParam[]{new PrintUtils.ColorParam(pi, PrintUtils.Color.RED), new PrintUtils.ColorParam(hi, PrintUtils.Color.DARKGREEN)}) + ") -->  pChar == '*', sChar != hisChar, hisChar != '.'");
                            int stepMin = 0;
                            pi++;
                            while (pi < pLen) {
                                stepMin++;
                                char tempPChar = p.charAt(pi);
                                if (tempPChar == hisChar && stepMin <= group.get(group.size() - 1).length()) {
                                    System.out.println("step " + step + "-" + stepMin + " : s(" + PrintUtils.getColorStr(s, new PrintUtils.ColorParam[]{
                                            new PrintUtils.ColorParam(hi, hi + group.get(group.size() - 1).length(), null, PrintUtils.Color.WHITE),
                                            new PrintUtils.ColorParam(si)
                                    }) + ") | p(" + PrintUtils.getColorStr(p, new PrintUtils.ColorParam[]{new PrintUtils.ColorParam(pi, PrintUtils.Color.RED), new PrintUtils.ColorParam(hi, PrintUtils.Color.DARKGREEN)}) + ") -->  pChar == '*', sChar != hisChar, hisChar != '.'");
                                    pi++;
                                } else {
                                    break;
                                }
                            }
                            isMatch = false;
                            printGroup();
                        }
                    }
                } else if (pChar == '.') {
                    si++;
                    pi++;
                    isMatch = true;
                    group.add(new StringBuilder().append(sChar));
                    printGroup();
                } else {
                    System.out.println("step " + step + " : s(" + PrintUtils.getColorStr(s, si) + ") | p(" + PrintUtils.getColorStr(p, pi) + ") -->  sChar != pChar");
                    if (pi + 1 < pLen && p.charAt(pi + 1) == '*') {
                        pi = pi + 2;
                        isMatch = true;
                    } else {

                        isMatch = false;
                        break;
                    }
                }
            }
        }
        return isMatch;
    }

    public static boolean getMatchIndexs2(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean isMatch = false;

        while (pi < pLen) {
            step++;
            pChar = p.charAt(pi);
            if (pChar != '*') {
                hisChar = pChar;
                hi = pi;
            }
            if (sChar == pChar) {
                System.out.println("step " + step + " : s(" + s + ") | p(" + PrintUtils.getColorStr(p, pi) + ") -->  sChar == pChar");
                pi++;
                isMatch = true;
            } else {
                if (pChar == '*') {
                    if (sChar == hisChar) {
                        isMatch = true;
                        System.out.println("step " + step + " : s(" + s + ") | p(" + PrintUtils.getColorStr(p, new PrintUtils.ColorParam[]{new PrintUtils.ColorParam(pi, PrintUtils.Color.RED), new PrintUtils.ColorParam(hi, PrintUtils.Color.DARKGREEN)}) + ") -->  pChar == '*', sChar == hisChar");
                        pi++;
                    } else {
                        if (hisChar == '.') {
                            pi++;
                            isMatch = true;
                        } else {
                            System.out.println("step " + step + " : s(" + s + ") | p(" + PrintUtils.getColorStr(p, new PrintUtils.ColorParam[]{new PrintUtils.ColorParam(pi, PrintUtils.Color.RED), new PrintUtils.ColorParam(hi, PrintUtils.Color.DARKGREEN)}) + ") -->  pChar == '*', sChar != hisChar, hisChar != '.'");
                            int stepMin = 0;
                            pi++;
//                            while (pi < pLen) {
//                                stepMin++;
//                                char tempPChar = p.charAt(pi);
//                                if (tempPChar == hisChar && stepMin <= group.get(group.size() - 1).length()) {
//                                    System.out.println("step " + step + "-" + stepMin + " : s(" + PrintUtils.getColorStr(s, new PrintUtils.ColorParam[]{
//                                            new PrintUtils.ColorParam(hi, hi + group.get(group.size() - 1).length(), null, PrintUtils.Color.WHITE),
//                                            new PrintUtils.ColorParam(si)
//                                    }) + ") | p(" + PrintUtils.getColorStr(p, new PrintUtils.ColorParam[]{new PrintUtils.ColorParam(pi, PrintUtils.Color.RED), new PrintUtils.ColorParam(hi, PrintUtils.Color.DARKGREEN)}) + ") -->  pChar == '*', sChar != hisChar, hisChar != '.'");
//                                    pi++;
//                                } else {
//                                    break;
//                                }
//                            }
                            isMatch = false;
                        }
                    }
                } else if (pChar == '.') {
                    pi++;
                    isMatch = true;
                } else {
                    System.out.println("step " + step + " : s(" + s + ") | p(" + PrintUtils.getColorStr(p, pi) + ") -->  sChar != pChar");
                    if (pi + 1 < pLen && p.charAt(pi + 1) == '*') {
                        pi = pi + 2;
                        isMatch = true;
                    } else {

                        isMatch = false;
                        break;
                    }
                }
            }
        }
        return isMatch;
    }

    private static void printGroup() {
        for (StringBuilder sb : group) {
            System.out.print(sb.toString() + "  ");
        }
        System.out.println();
        System.out.println("--------------");
    }
}
