package com.cmz.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/16
 * @description 三数之和
 */
public class ThreeNumbersSum {
    public static void main(String[] args) {
        int[] nums = {-14,-3,11,-3,12,-1,11,13,5,6,-11,-14,-6,11,-4,-15,3,-15,9,-10,13,-10,-9,-13,-12,12,-7,12,12,3,9,5,-14,-3,9,13,11,5,3,-6,-12,-1,-5,-3,-4,-2,-10,6,-10,14,3,-11,11,10,-9,7,-1,-9,4,-12,2,-2,8,3,3,-6,-7,-1,6,12,8,9,-12,10,-8,-1,-7,-3,12,-9,-12,1,-5,6,-12,-7,-2,2,-8,-13,5,9,-7,-10,-3,11,-1,-3,-13,-10,-14,11,6,-10,6,13,4,7,-13,-6,13,12,10,-15,4,13,-7,9,-8,0,4,4,-6,12,9,-2,0};
        long begin = System.currentTimeMillis();
        System.out.println(threeSum(nums));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        // 构造一个全 0 的特殊元素
        List<Integer> special = new ArrayList<>();
        special.add(0);
        special.add(0);
        special.add(0);

        // 确定 a 的循环范围
        for(int i = 0; i <= nums.length - 3; i++) {
            // 确定 b 的循环范围
            for(int j = 1; j <= nums.length -2; j++) {
                // 确定 c 的循环范围
                for(int k = 2; k <= nums.length - 1; k++) {
                    // 不能重复，意味着 i < j < k
                    if(i < j && j < k) {
                        Integer a = nums[i];
                        Integer b = nums[j];
                        Integer c = nums[k];
                        // 假定没有重复的元素
                        boolean flag = true;
                        // 对于三个元素都为 0 的特殊处理
                        if((a + b + c) == 0) {
                            if(a == 0 && b == 0) {
                                if(result.contains(special)) {
                                    flag = false;
                                    break;
                                } else {
                                    result.add(special);
                                    break;
                                }
                            }
                            // 再进一步去重  [[-1,0,1],[-1,2,-1],[0,1,-1]]
                            for(List<Integer> temp : result) {
                                if(temp.contains(a) && temp.contains(b) && temp.contains(c)) {
                                    // 发现重复元素，重置flag标识，并跳出重复检测
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag) {
                                List<Integer> list = new ArrayList<>();
                                list.add(a);
                                list.add(b);
                                list.add(c);
                                result.add(list);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
