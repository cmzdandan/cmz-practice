package com.cmz.collection;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/12
 * @description 两数之和
 * <p>给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。</p>
 * <p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。</p>
 * <p>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。</p>
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * </p>
 */
// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
// the main function to invoke the method
public class TwoNumbersSum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        if(result == null) {
            return;
        }
        while(result.next != null) {
            System.out.print(result.val);
            System.out.print(" -> ");
            result = result.next;
        }
        // 最后一个元素 result.next = null, 此时输出当前元素的值
        System.out.print(result.val);
    }

    /**
     * 解法一
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int addNum = 0;
        while(q != null) {
            // p的位数少于q的位数，则p的高位补0，便于计算
            if(p.next == null && q.next != null) {
                p.next = new ListNode(0);
            }
            // q的位数少于p的位数，则q的高位补0，便于计算
            if(q.next == null && p.next != null) {
                q.next = new ListNode(0);
            }
            int sumAll = addNum + p.val + q.val;
            // 得到当前位相加后的值(考虑进位；)
            p.val = sumAll % 10;
            addNum = sumAll / 10;
            // 进位的情况
            if(p.next == null && q.next == null && addNum != 0) {
                p.next = new ListNode(addNum);
            }
            p = p.next;
            q = q.next;
        }
        return l1;
    }

    /**
     * 解法二
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return null;
    }
    
}
