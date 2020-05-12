package com.atguigu.linklist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		Node node1 = new Node(1, "qqq");
		Node node2 = new Node(2, "www");
		Node node3 = new Node(3, "eee");
		Node node4 = new Node(4, "rrr");
		Node node5 = new Node(4, "ttt");
		DoubleLinkedList list = new DoubleLinkedList();
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.show();
		list.delete(node3);
		list.show();
//		list.update(node5);
//		list.show();
	}

}

//双向链表
class DoubleLinkedList{
	//初始化头节点
	private Node head = new Node(0, "");
	
	public void update(Node node) {
		Node temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == node.no) {
				flag = true;//此编号已存在
				break;
			}
			if (temp.next.no > node.no) {
				break;//位置找到
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next.name = node.name;
			
		}else {
			System.out.println("此编号不存在");
		}
	}
	
	public void delete(Node node) {
		Node temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.no == node.no) {
				flag = true;//此编号已存在
				break;
			}
			if (temp.next.no > node.no) {
				break;//位置找到
			}
			temp = temp.next;
		}
		if (flag) {
//			Node cur = temp;
//			temp.next.next.previous = cur;
//			cur.next = cur.next.next;
			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;
			
		}else {
			
			System.out.println("此编号不存在");
		}
		
	}
		
		
	
	public void add(Node node) {
		Node temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == node.no) {
				flag = true;//此编号已存在
				break;
			}
			if (temp.next.no > node.no) {
				break;//位置找到
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("此编号已存在");
		}else {
			temp.next = node;
			node.previous = temp;
		}
		
	}
	
	public void show() {
		Node temp = head;
		while(true) {
			if (temp.next!=null) {
				System.out.println(temp.next);
				temp = temp.next;
			}else {
				break;
			}
		}
//		while(true) {
//			if (temp.next!=null) {
//				temp = temp.next;
//			}else {
//				break;
//			}
//		}
//		System.out.println(111);
//		while(true) {
//			if (temp.previous!=null) {
//				System.out.println(temp);
//				temp = temp.previous;
//			}else {
//				break;
//			}
//		}
		
		
		
		
	}
	
}

//节点
class Node{
	public int no;
	public String name;
	public Node previous;
	public Node next;
	
	public Node(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
	
	
}
