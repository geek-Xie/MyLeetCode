/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表400 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 到 3999 的范围内。

 */
public class Solution {
    /**
     * 贪心法。
     * 经过分析，我们会发现罗马数字在转化成阿拉伯数字的时候的一下规律。
     * 每次都从罗马数字的最后一位开始看起，比较左边一位和当前位的大小，如果左边一位比当前位小，则减左边一位；如果左边一位比当前位大，则加左边一位。
     * 例如：XXIV = 24
     * 先看最后一位V是5，往左看是I是1比5小，则5-1=4，然后左边是X=10比I=1大，则4+10=14，再往左看X=X，则14+10=24
     * 程序根据以上思路进行编写即可
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(s.length() - 1));
        sum = preNum;
        for(int i = s.length() - 2;i >= 0; i--) {
            int num = getValue(s.charAt(i));
            if(preNum <= num) {
                sum += num;
            } else {
                sum -= num;
            }
            preNum = num;
        }

        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

