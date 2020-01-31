package com.CK;

public class Main {

    public static void main(String[] args) {
        new Solution().str2tree("-4(2(3)(1))(6(5))");
    }
}

class Solution {
    public TreeNode str2tree(String s) {
        return helper(s, new int[]{0});
    }

    private TreeNode helper(String s, int[] st) {
        if (s.length() == 0 || st[0] > s.length() || (!Character.isDigit(s.charAt(st[0])) && (s.charAt(st[0])) != '-')) {
            return null;
        }

        int num = 0, i = st[0], sign = 1;
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else {
                num = num * 10 + s.charAt(i) - '0';
                i++;
            }
        }
        num *= sign;

        TreeNode root = new TreeNode(num);
        st[0] = i;
        if (st[0] < s.length() && s.charAt(st[0]) == '(') {
            st[0]++;
            root.left = helper(s, st);
        } else {
            st[0]++;
            return root;
        }
        if (st[0] < s.length() && s.charAt(st[0]) == '(') {
            st[0]++;
            root.right = helper(s, st);
        }
        st[0]++;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}