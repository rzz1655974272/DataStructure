package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		Scanner sc = new Scanner(System.in);
		char key = ' ';//接受用户输入
		boolean flag = true;
		while(flag) {
			System.out.println("s(showQueue)");
			System.out.println("a(addQueue)");
			System.out.println("g(getQueue)");
			System.out.println("h(showHead)");
			System.out.println("e(exit)");
			key = sc.next().charAt(0);//接收一个字符
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数：");
				int num = sc.nextInt();
				queue.addQueue(num);
				break;
			case 'g':
				queue.getQueue();
				break;
			case 'h':
				queue.showHead();
				break;
			case 'e':
				System.out.println("退出成功");
				break;

			default:
				break;
			}
			
		}
	}

}

//使用数组模拟队列
class ArrayQueue{
	private int maxSize;//数组最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//该数组用于存放数据，模拟队列
	
	//创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr =new int[maxSize];
		front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
		rear = -1;//指向队列尾部，指向队列尾的数据（即就是队列最后一个数据）
	}
	
	//判断队列是否满
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	//判断队列是否空
	public boolean isEmpty() {
		return front == rear;
	}
	
	//添加数据到队列
	public void addQueue(int num) {
		if(isFull()) {
			System.out.println("队列已满");
		}else {
			rear++;
			arr[rear] = num;
		}
		
	}
	
	//取出数据出队列
	public void getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}else {
			front++;
			System.out.println(arr[front]);
		}
	}
	
	
	//显示队列所有数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，没有数据");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i+"----"+arr[i]);
		}
	}
	
	//显示队列头数据
	public void showHead() {
		if (isFull()) {
			System.out.println("队列为空");;
		}else {
			System.out.println(arr[front+1]);
		}
		
	}
	
}