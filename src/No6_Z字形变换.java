public class No6_Z字形变换 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：8列
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 2
     * 输出: "LECDIHRNETOESIIG"
     * 解释:
     * L E C D I H R N
     * E T O E S I I G
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 2
     * 输出: "LECDIHRNETOESIIG"
     * 解释:
     * L E C D I H R N
     * E T O E S I I G
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        //  LEE T COD E ISH I RIN G
        //  LEET C O DEIS H I RING
        System.out.println("convert = " + convert("A", 1));

    }

    public static String convert(String s, int numRows) {
        int row = 0, group;
        char[] chars = s.toCharArray();
        int length = s.length();
        if (numRows == 1) {
            return s;
        } else {
            group = numRows + (numRows - 2);
        }
        StringBuilder sb = new StringBuilder();
        while (row < numRows) {
            int indexHead = row, indexBottom = group - row;
            System.out.println("while 1 row = " + row + ", indexHead = " + indexHead + ", indexBottom = " + indexBottom);
            while (indexHead < length) {
                sb.append(chars[indexHead]);
                System.out.println("append = " + chars[indexHead]);
                if (indexBottom < length && row != 0 && row != numRows-1) {
                    sb.append(chars[indexBottom]);
                    System.out.println("append = " + chars[indexBottom]);
                }
                indexHead += group;
                indexBottom += group;
                System.out.println("while 2 row = " + row + ", indexHead = " + indexHead + ", indexBottom = " + indexBottom);
            }
            row++;
            System.out.println("-------------------");
        }
        return sb.toString();
    }

}
