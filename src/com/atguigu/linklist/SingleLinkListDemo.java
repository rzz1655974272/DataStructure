package com.atguigu.linklist;

public class SingleLinkListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "qqq", "q1");
		HeroNode hero2 = new HeroNode(2, "www", "w1");
		HeroNode hero3 = new HeroNode(3, "eee", "e2");
		HeroNode hero4 = new HeroNode(4, "rrr", "r3");
		
		SingleLinkList list = new SingleLinkList();
		
		list.add(hero1);
		list.add(hero2);
		list.add(hero3);
		list.add(hero4);
		list.show();
		
	}

}

class SingleLinkList{
	//初始化头节点
	private HeroNode head = new HeroNode(0, "", "");
	
	public void add(HeroNode heroNode) {
		//找到最后一个节点
		HeroNode temp = head;
		
		while(true) {
			if (temp.next == null) {
				break;
			}else {
				//如果不是最后一个节点，则将temp后移
				temp = temp.next;
			}
		}
		temp.next = heroNode;
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

//节点
class HeroNode{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;//下一节点
	
	public HeroNode(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}
