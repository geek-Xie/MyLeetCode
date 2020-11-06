/**
 * 93. 复原IP地址
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 *
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 *
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 *
 *
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 *
 *
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // ip地址一般由四段数字组成
    static final int SEG_COUNT = 4;
    // 存储最终结果的列表
    List<String> res = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        // 使用递归的方法解决问题
        dfs(s, 0, 0);
        return res;
    }

    /**
     * 递归思路
     *
     * @param s        原始字符串
     * @param segId    当前处于的IP地址的段
     * @param segStart 当前遍历到的字符串的下标
     */
    private void dfs(String s, int segId, int segStart) {
        // 如果已经找齐4段IP地址
        if (segId == SEG_COUNT) {
            // 如果此时字符串也已经遍历完了
            if (segStart == s.length()) {
                // 将分段从数组里添加到字符串中，并且除了最后一段的结尾，每段结尾都用"."分隔
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                // 将当前的情况添加到结果列表中
                res.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到4段IP地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            // 进入下一段，并且移动到下一个字符
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            // 如果当前组合大于0且不超过255
            if (addr > 0 && addr <= 255) {
                // 将当前结果添加到当前段
                segments[segId] = addr;
                // 递归到下一段
                dfs(s, segId + 1, segEnd + 1);
            }
            else
                break;
        }
    }
}
