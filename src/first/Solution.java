package first;


import common.ListNode;
import common.Node;
import common.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println();
        Solution solution = new Solution();
    }

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null && second.next != null) {
            if (first == second) return true;
            first = first.next;
            second = second.next.next;
        }
        return false;
    }

    public int rob(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int first = nums[0], second = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    void backtrack(int[] nums, List<Integer> temp) {
        if (nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(i)) {
                temp.add(i);
                backtrack(nums, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }


}
