package com.atguigu.linklist;

import java.util.Stack;

/**
 * ���ݱ�Ų���
 * @author 16559
 *
 */
public class SingleLinkListDemo3 {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "qqq", "q1");
		HeroNode hero2 = new HeroNode(3, "www", "w2");
		HeroNode hero3 = new HeroNode(5, "eee", "e3");
		HeroNode hero4 = new HeroNode(21, "rrr", "r4");
		SingleLinkList2 list = new SingleLinkList2();
		list.add(hero1);
		list.add(hero2);
		list.add(hero3);
		list.add(hero4);
		list.show();
		
		System.out.println("----------------------");
		
		HeroNode hero11 = new HeroNode(2, "aaa", "a1");
		HeroNode hero21 = new HeroNode(4, "sss", "s2");
		HeroNode hero31 = new HeroNode(8, "ddd", "d3");
		SingleLinkList2 list1 = new SingleLinkList2();
		list1.add(hero11);
		list1.add(hero21);
		list1.add(hero31);
		list1.show();
		System.out.println("�ϲ�����������");
		SingleLinkList2 list2 = list.merge(list1);
		System.out.println("��ӡ");
		list2.show();
		
		
		
		
//		System.out.println("�����ӡ");
//		list.reversalPrint();
//		list.getLength();
//		list2.reversal();
//		list2.show();
//		list.selectKNode(2);
//		System.out.println("�޸ĺ�");
//		HeroNode hero5 = new HeroNode(3, "eeeee", "e3");
//		list.update(hero5);
//		list.show();
//		System.out.println("ɾ����");
//		list.delete(hero2);
//		list.show();
//		list.length();
	}

}

class SingleLinkList2{
	//��ʼ��ͷ�ڵ�
	private HeroNode head = new HeroNode(0, "", "");
	
	//�ϲ����������б�
	public SingleLinkList2 merge(SingleLinkList2 list1) {
		HeroNode temp = head;
		int size = 0;
		
		while(true) {
			if (temp.next == null) {
				break;
			}else {
				size++;
				temp = temp.next;
//				System.out.println(temp);
			}
		}
		return list1;
	}
	
	//�����ӡ������ʹ��ջstack
	public void reversalPrint() {
		HeroNode temp = head;
		if (temp.next==null) {
			System.out.println("������Ϊ��");
			return;
		}
		
		int size = 0;	
		while(true) {
			if (temp.next == null) {
				break;
			}else {
				size++;
				temp = temp.next;
			}
		}
		
		temp = head;
		Stack<HeroNode> stack = new Stack<HeroNode>();
		for (int i = 0; i < size; i++) {
			temp = temp.next;
			stack.add(temp);
		}
		
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	

	//������ķ�ת
	public void reversal() {
		HeroNode temp = head;
		if (temp.next == null || temp.next.next == null) {
			return;
		}
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		//����ԭ��������ÿ����һ���ڵ㣬�ͽ���ȡ���������µ��������ǰ��
		while(cur != null) {
			next = cur.next;//���浱ǰ�ڵ����һ�ڵ�
			cur.next = reverseHead.next;//��cur����һ�ڵ�ָ���µ��������ǰ��
			reverseHead.next = cur;//��cur���ӵ��µ�����
			cur = next;//cur����
		}
		//��head.next ָ��reverseHead,ʵ�ַ�ת
		head.next = reverseHead.next;
	}
	
	
	//������K��
	public void selectKNode(int k) {
		
		HeroNode temp = head;
		
		if (temp.next == null) {
			System.out.println("������Ϊ��");
			return;
		}
		
		int count = 0;
		
		while(true) {
			if (temp.next == null) {
				break;
			}else {
				count++;
				temp = temp.next;
			}
		}
		System.out.println(count);
		
		if (k > count || k <= 0) {
			System.out.println("������û�����ֵ����󳤶�Ϊ��" + count);
			return;
		}
		
		temp = head;
		for (int i = 0; i <= count - k; i++) {
			temp = temp.next;
			System.out.println(temp);
		}
		System.out.println("����"+temp);
	}
	
	//�жϵ�����ĳ���
	public void getLength() {
		int count = 0;
		HeroNode temp = head;
		while(temp.next != null) {
				count++;
				temp = temp.next;
			
		}
		System.out.println("������ĳ���Ϊ��" + count);
	}
	
	//����
	public void add(HeroNode heroNode) {

		//����������֮����Ų���
		HeroNode temp = head;
		boolean flag = false;//����Ƿ���ڵı�־
		
		while(true) {
			if (temp.next == null) {//temp���������
				break;
			}
			if (temp.next.no > heroNode.no) {//λ���ҵ�������temp����
				break;
			}
			if (temp.next.no == heroNode.no) {
				flag = true;//��Ŵ���
				break;
			}
			temp = temp.next;//����
		}
		if (flag) {
			System.out.println("����Ѵ���" + heroNode.no);
		}else {
			//���뵽����temp�ĺ���
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	
	//�޸Ľڵ�
	public void update(HeroNode newHeroNode) {
		HeroNode temp = head;
		boolean flag = false;
		//���ж������Ƿ�Ϊ��
		if (temp.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;//�ҵ���
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		}else {
			System.out.println("û�ҵ��˱�ţ�" + newHeroNode.no);
		}
		
	}
	
	//ɾ���ڵ�
	public void delete(HeroNode newHeroNode) {
		HeroNode temp = head;
		boolean flag = false;
		//���ж������Ƿ�Ϊ��
		if (temp.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == newHeroNode.no) {
				flag = true;//�ҵ���
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.println("�˱�Ų����ڣ�" + newHeroNode.no);
		}
		
	}
	
	public void show() {
		
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		while(true) {
			//�ж������Ƿ������
			if (temp == null) {
				break;
			}else {
				System.out.println(temp);
				
			}
			temp = temp.next;
			
		}
	}
	
	
	
}


