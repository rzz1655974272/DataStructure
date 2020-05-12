package com.atguigu.linklist;

public class Josephu {
	public static void main(String[] args) {
		CircleLinkedList list = new CircleLinkedList();
		list.addBoy(5);
		list.showBoy();
		list.showJosephu(1, 2);
	}
}

//����������
class CircleLinkedList {
	// ����һ��first�ڵ�
	private Boy first = null;

	public void showJosephu(int start, int count) {

		if (start < 1) {
			System.out.println("�������ݲ��Ϸ�");
			return;
		}

		int size = 0;
		Boy curBoy = first;
		while (true) {
			size++;
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
		
		Boy helpBoy = null;

		while(true) {
			
			for (int i = 0; i < count - 1; i++) {
				helpBoy = first;
				helpBoy = helpBoy.getNext();
				first.setNext(first.getNext().getNext());
				
				first = helpBoy.getNext();
				System.out.println(helpBoy.getNo());
			}
			
			
			if (helpBoy == first) {
				break;
			}
			
		}
		

	}

	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("�������ݲ��Ϸ�");
			return;
		}
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	public void showBoy() {
		if (first == null) {
			System.out.println("����Ϊ��");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.println("��ţ�" + curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}
}

//�ڵ�
class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
