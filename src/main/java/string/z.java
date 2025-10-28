package string;

/**
 * @ Author : kn
 * @ Description :  6. Z 字形变换
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 14  012 456 8910 1213
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * @ Date : 2025/10/25 16:32
 */
public class z {
    public static String convert(String s, int numRows) {
        if (numRows<2){
            return s;
        }
        //numRows * 2 - 2= 半个z形占用几个元素
        int i = s.length() / (numRows * 2 - 2);
        int yu = s.length() % (numRows * 2 - 2);
        int width = i * (1 + numRows - 2) + (yu > numRows ? (1 + yu % numRows) : 1);
        Character[][] arr = new Character[numRows][width];

        int row = 0, col = 0, index = 0, l = s.length();
        while (index < l) {
            arr[row][col] = s.charAt(index);
            index++;
            if (index % (numRows * 2 - 2) == 0) {
                row = 0;
                col++;
            } else if (index % (numRows * 2 - 2) < numRows) {
                row++;
            } else {
                row--;
                col++;
            }
        }

        StringBuilder sb=new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr[j].length; k++) {
                Character character = arr[j][k];
                if (character!=null){
                    sb.append(character);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }
}
