package aston.group86.hospitalboot.test;

public class Task50 {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next = new ListNode(4);
    System.out.println(addTwoNumbers(l1, l2));
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    int carry = 0;

    while(l1 != null || l2 != null || carry != 0){
      int sum = carry;
      if(l1 != null){
        sum += l1.val;
        l1 = l1.next;
      }
      if(l2 != null){
        sum += l2.val;
        l2 = l2.next;
      }
      carry = sum/10;
      current.next = new ListNode(sum%10);
      current = current.next;
    }

    return dummyHead.next;
  }

}
