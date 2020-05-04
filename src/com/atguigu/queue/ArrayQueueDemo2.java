package com.atguigu.queue;

import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

public class ArrayQueueDemo2 {

	public static void main(String[] args) {
		ArrayQueue2 queue = new ArrayQueue2(3);
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

//使用数组模拟环形队列
class ArrayQueue2{
	private int maxSize;//数组最大容量
	private int front;//队列头：指向环形队列的第一个数的位置。初始化为0
	private int rear;//队列尾：指向环形队列倒数第二个位置。初始化为0
	private int[] arr;//该数组用于存放数据，模拟队列
	
	//创建队列的构造器
	public ArrayQueue2(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr =new int[maxSize];
	}
	
	//判断队列是否满(rear+1)%maxSize==front
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
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
			
			arr[rear] = num;
			rear = (rear + 1) % maxSize;
		}
		
	}
	
	//取出数据出队列
	public void getQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，没有数据");
		}else {
			//先将front对应的值保存起来，然后将front后移，考虑取模，返回临时变量
			int value = arr[front];
			front = (front + 1) % maxSize;
			System.out.println(value);
		}
	}
	
	
	//显示队列所有数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，没有数据");
		}
		int count = (rear + maxSize - front) % maxSize;
		for (int i = front; i < front + count; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
			//System.out.printf("arr[%d]=%\nd",i %maxSize,arr[i %maxSize]);
		}
	}
	
	//显示队列头数据
	public void showHead() {
		if (isEmpty()) {
			System.out.println("队列为空");;
		}else {
			System.out.println(arr[front]);
		}
		
	}
	
}