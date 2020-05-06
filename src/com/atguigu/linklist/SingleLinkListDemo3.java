package com.atguigu.linklist;
/**
 * 根据编号插入
 * @author 16559
 *
 */
public class SingleLinkListDemo3 {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "qqq", "q1");
		HeroNode hero2 = new HeroNode(2, "www", "w1");
		HeroNode hero3 = new HeroNode(3, "eee", "e2");
		HeroNode hero4 = new HeroNode(4, "rrr", "r3");
		HeroNode hero5 = new HeroNode(5, "eeeee", "e3");
		SingleLinkList2 list = new SingleLinkList2();
		
		list.add(hero1);
		list.add(hero2);
		list.add(hero3);
		list.add(hero4);
		list.show();
		list.getLength();
		list.reversal();
		list.show();
//		list.selectKNode(2);
//		System.out.println("修改后");
//		HeroNode hero5 = new HeroNode(3, "eeeee", "e3");
//		list.update(hero5);
//		list.show();
//		System.out.println("删除后：");
//		list.delete(hero2);
//		list.show();
//		list.length();
	}

}

class SingleLinkList2{
	//初始化头节点
	private HeroNode head = new HeroNode(0, "", "");
	
	//单链表的反转
	public void reversal() {
		HeroNode temp = head;
		if (temp.next == null || temp.next.next == null) {
			return;
		}
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		//遍历原来的链表，每遍历一个节点，就将其取出，放在新的链表的最前端
		while(cur != null) {
			next = cur.next;//保存当前节点的下一节点
			cur.next = reverseHead.next;//将cur的下一节点指向新的链表的最前端
			reverseHead.next = cur;//将cur连接到新的链表
			cur = next;//cur后移
		}
		//将head.next 指向reverseHead,实现反转
		head.next = reverseHead.next;
	}
	
	
	//求倒数第K个
	public void selectKNode(int k) {
		
		HeroNode temp = head;
		
		if (temp.next == null) {
			System.out.println("此链表为空");
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
			System.out.println("此链表没有这个值，最大长度为：" + count);
			return;
		}
		
		temp = head;
		for (int i = 0; i <= count - k; i++) {
			temp = temp.next;
			System.out.println(temp);
		}
		System.out.println("最终"+temp);
	}
	
	//判断单链表的长度
	public void getLength() {
		int count = 0;
		HeroNode temp = head;
		while(temp.next != null) {
				count++;
				temp = temp.next;
			
		}
		System.out.println("此链表的长度为：" + count);
	}
	
	//增加
	public void add(HeroNode heroNode) {

		//遍历链表，将之按序号插入
		HeroNode temp = head;
		boolean flag = false;//编号是否存在的标志
		
		while(true) {
			if (temp.next == null) {//temp在链表最后
				break;
			}
			if (temp.next.no > heroNode.no) {//位置找到，就在temp后面
				break;
			}
			if (temp.next.no == heroNode.no) {
				flag = true;//编号存在
				break;
			}
			temp = temp.next;//后移
		}
		if (flag) {
			System.out.println("编号已存在" + heroNode.no);
		}else {
			//插入到链表temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	
	//修改节点
	public void update(HeroNode newHeroNode) {
		HeroNode temp = head;
		boolean flag = false;
		//先判断链表是否为空
		if (temp.next == null) {
			System.out.println("链表为空");
			return;
		}
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;//找到了
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		}else {
			System.out.println("没找到此编号：" + newHeroNode.no);
		}
		
	}
	
	//删除节点
	public void delete(HeroNode newHeroNode) {
		HeroNode temp = head;
		boolean flag = false;
		//先判断链表是否为空
		if (temp.next == null) {
			System.out.println("链表为空");
			return;
		}
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == newHeroNode.no) {
				flag = true;//找到了
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.println("此编号不存在：" + newHeroNode.no);
		}
		
	}
	
	public void show() {
		
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		while(true) {
			//判断链表是否到了最后
			if (temp == null) {
				break;
			}else {
				System.out.println(temp);
				
			}
			temp = temp.next;
			
		}
	}
	
	
	
}


