package leetcode;

/**
 * Created by 申卓 on 2017/8/15.
 * Tag  LinkedList
 */


/**
 * 思路很关键！
 *
 * 没必要去节省小段内存空间！
 */
public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
//        int[] arr1 = {2,4,3};
//        int[] arr2 = {5,6,4};
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = test2.addTwoNumbers2(l2, l1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("END");


    }

    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }


    /**
     * 更换思路
     * 额外采取第三个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {


        ListNode c1 = l1;
        ListNode c2 = l2;

        //head
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;
        int carry = 0;

        while (c1 != null || c2 != null) {
            int i = 0;
            if (c1 != null) {
                i += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                i += c2.val;
                c2 = c2.next;
            }
            int j = i + carry;
            carry = j / 10;

            listNode.next = new ListNode((j) % 10);
            listNode = listNode.next;
        }
        if (carry != 0) {
            listNode.next = new ListNode(carry);
        }
        return result.next;
    }


    /**
     * 思路很简单
     * 考虑情况：
     * 1.两个链表长度不同
     * 2.最高位进位
     * <p>
     * 代码很乱  很烂
     * 主要问题
     * 1. 链表是单向的，如果要操作链表，不能直接读到 null
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = l2;
        /**
         * 因为还有链表后续操作 所以条件判断为 next
         */
        while (l1.next != null && l2.next != null) {
            l2.val += l1.val + carry;
            carry = l2.val / 10;
            l2.val %= 10;
            l1 = l1.next;
            l2 = l2.next;
        }


        l2.val += l1.val + carry;
        carry = l2.val / 10;
        l2.val %= 10;

        /**
         * 三种情况  等长
         *          l1 长
         *          l2 长
         */
        if (l1.next == l2.next && carry != 0) {
            l2.next = new ListNode(carry);
        } else if (l1.next == null) {

            while (l2.next != null) {
                l2.next.val += carry;
                carry = l2.next.val / 10;
                l2.next.val %= 10;
                l2 = l2.next;
            }
            if (carry != 0) {
                l2.next = new ListNode(carry);
            }
        } else {
            l2.next = l1.next;
            while (l1.next != null) {
                l1.next.val += carry;
                carry = l1.next.val / 10;
                l1.next.val %= 10;
                l1 = l1.next;
            }
            if (carry != 0) {
                l1.next = new ListNode(carry);
            }
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}