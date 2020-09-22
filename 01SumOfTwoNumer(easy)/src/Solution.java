import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 简单的暴力解法，思路清晰容易理解，但是缺点就是时间与空间复杂度都很高
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1;i++){
            for (int j = i + 1;j < nums.length;j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }


    /**
     * 使用哈希表来实现一种比较高效的实现方式
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        // 创建一个哈希表来存储，注意此时的哈希表key存储的是数组中的数组，value是该数字的下标
        Map<Integer,Integer> map = new HashMap<>();
        // 对数组进行遍历
        for (int i = 0;i < nums.length;i++){
            // 查看哈希表中是否有满足能与当前位置的数字组合成目标值的数字，这里利用的就是哈希表查找快的特点
            int rest = target - nums[i];
            // 如果存在符合条件的值，就直接将下标保存到结果数组中返回
            if (map.containsKey(rest)){
                res[0] = i;
                res[1] = map.get(rest);
            }
            // 如果当前的哈希表中没有符合条件的数字，则将当前的数字和下标添加到哈希表中，并且继续遍历数组
            map.put(nums[i],i);
        }
        return res;
    }

}
