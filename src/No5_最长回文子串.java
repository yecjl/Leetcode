import java.util.List;

public class No5_最长回文子串 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("longestPalindrome = " + longestPalindrome("cbbd"));

    }


    public static String longestPalindrome(String s) {
        int indexLeft, indexRight;
        int maxLeft = 0, maxRight = 0;
        boolean flag;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char arg = chars[i];
            indexLeft = i - 1;
            indexRight = i + 1;
            flag = true;
            while (indexRight < s.length()) {
                char left, right;
                right = s.charAt(indexRight);
                if (flag && (arg == right)) {
                    indexRight++;
                } else {
                    if (indexLeft >= 0) {
                        left = s.charAt(indexLeft);
                        if (left == right) {
                            indexRight++;
                            indexLeft--;
                            flag = false;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (maxRight - maxLeft < indexRight - indexLeft) {
                maxLeft = indexLeft;
                maxRight = indexRight;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxLeft + 1; i < maxRight; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();

    }


//    public static String longestPalindrome(String s) {
//        int indexLeft, indexRight;
//        int lenMax = 0, maxLeft = 0, maxRight = 0;
//        boolean flag;
//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s);
//            char arg = s.charAt(i);
//            System.out.println("i = " + i + ", charAt = " + arg);
//            indexLeft = i - 1;
//            indexRight = i + 1;
//            list.clear();
//            list.add(arg);
//            flag = true;
//            while (indexRight < s.length()) {
//                char left, right;
//                right = s.charAt(indexRight);
//                System.out.println("charAt==  indexRight = " + indexRight + ", right = " + right + ", indexLeft = " + indexLeft + ", left = " + null);
//                if (flag && (arg == right)) {
//                    list.add(right);
//                    indexRight++;
//                    System.out.println("arg == right");
//                    System.out.println("indexRight = " + indexRight + ", right = " + right + ", indexLeft = " + indexLeft + ", left = " + null);
//                } else {
//                    if (indexLeft >= 0) {
//                        left = s.charAt(indexLeft);
//                        System.out.println("indexLeft >= 0");
//                        System.out.println("charAt== indexRight = " + indexRight + ", right = " + right + ", indexLeft = " + indexLeft + ", left = " + left);
//                        if (left == right) {
//                            list.add(right);
//                            list.add(0, left);
//                            indexRight++;
//                            indexLeft--;
//                            flag = false;
//                            System.out.println("left == right");
//                            System.out.println("indexRight = " + indexRight + ", right = " + right + ", indexLeft = " + indexLeft + ", left = " + left);
//                        } else {
//                            break;
//                        }
//                    } else {
//                        break;
//                    }
//                }
//            }
//
//            if (lenMax < indexRight - indexLeft - 1) {
//                lenMax = indexRight - indexLeft - 1;
//                maxLeft = indexLeft;
//                maxRight = indexRight;
//            }
//
//            System.out.println("indexLeft = " + indexLeft + ", indexRight = " + indexRight);
//            System.out.println(list);
//            System.out.println(s.substring(indexLeft + 1, indexRight));
//            System.out.println("length = " +(indexRight - indexLeft - 1));
//            System.out.println("--------------------------");
//
//        }
//        return s.substring(maxLeft + 1, maxRight);
//
//    }


    public static String getString(List<Character> list) {
        StringBuilder builder = new StringBuilder();
        for (char s : list) {
            builder.append(s);
        }
        return builder.toString();
    }

}
