package competitive;

import java.util.LinkedList;

/**
 * 
 * @author Raviteja
You are given two non-empty linked lists representing two non negative integers.
 The digits are stored int reverse order
and each of their nodes contains a single digit. Add the numbers and retuen it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself

Example:
 Input: (2->4->3)+(5->6->4)
 Output: (7->0->8)
 Explanation: 342+465 = 807
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(3);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(5);
		list2.add(6);
		list2.add(4);
		System.out.print(list1+" "+list2);
		LinkedList<Integer> res = addTwoLists(list1,list2);
		System.out.print(res);

	}

	private static LinkedList<Integer> addTwoLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		int x=list1.size()-1,y=list2.size()-1;
		int carry = 0;
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		while(x>=0 || y>=0) {
			int temp = list1.get(x)+list2.get(y)+carry;
			list3.add(temp%10);
			carry = temp/10;
			x--;y--;
		}
		if(x> 0) {
			for(int i=x;i>=0;i--) {
				list3.add(list1.get(i));
			}
		}
		if(y> 0) {
			for(int i=y;i>=0;i--) {
				list3.add(list2.get(i));
			}
		}
		return list3;
	}

}
