package com.atguigu.linklist;
/**
 * ���ݱ�Ų���
 * @author 16559
 *
 */
public class SingleLinkListDemo2 {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "qqq", "q1");
		HeroNode hero2 = new HeroNode(2, "www", "w1");
		HeroNode hero3 = new HeroNode(3, "eee", "e2");
		HeroNode hero4 = new HeroNode(4, "rrr", "r3");
		HeroNode hero5 = new HeroNode(5, "eeeee", "e3");
		SingleLinkList1 list = new SingleLinkList1();
		
		list.add(hero1);
		list.add(hero4);
		list.add(hero3);
		list.add(hero2);
		list.show();
//		System.out.println("�޸ĺ�");
//		HeroNode hero5 = new HeroNode(3, "eeeee", "e3");
//		list.update(hero5);
//		list.show();
		System.out.println("ɾ����");
		list.delete(hero5);
		list.show();
	}

}

class SingleLinkList1{
	//��ʼ��ͷ�ڵ�
	private HeroNode head = new HeroNode(0, "", "");
	
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


