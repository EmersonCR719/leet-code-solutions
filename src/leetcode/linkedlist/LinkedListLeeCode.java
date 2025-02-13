package leetcode.linkedlist;

public class LinkedListLeeCode {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1.next == null) {
            return list2;
        }

        if (list2.next == null) {
            return list1;
        }
        System.out.println(list1.toString());
        ListNode temp = new ListNode(list1.val);

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = list2;

        return list1;
    }
}
