package com.atguigu.queue;

import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

public class ArrayQueueDemo2 {

	public static void main(String[] args) {
		ArrayQueue2 queue = new ArrayQueue2(3);
		Scanner sc = new Scanner(System.in);
		char key = ' ';//�����û�����
		boolean flag = true;
		while(flag) {
			System.out.println("s(showQueue)");
			System.out.println("a(addQueue)");
			System.out.println("g(getQueue)");
			System.out.println("h(showHead)");
			System.out.println("e(exit)");
			key = sc.next().charAt(0);//����һ���ַ�
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������");
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
				System.out.println("�˳��ɹ�");
				break;

			default:
				break;
			}
			
		}
	}

}

//ʹ������ģ�⻷�ζ���
class ArrayQueue2{
	private int maxSize;//�����������
	private int front;//����ͷ��ָ���ζ��еĵ�һ������λ�á���ʼ��Ϊ0
	private int rear;//����β��ָ���ζ��е����ڶ���λ�á���ʼ��Ϊ0
	private int[] arr;//���������ڴ�����ݣ�ģ�����
	
	//�������еĹ�����
	public ArrayQueue2(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr =new int[maxSize];
	}
	
	//�ж϶����Ƿ���(rear+1)%maxSize==front
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	//�ж϶����Ƿ��
	public boolean isEmpty() {
		return front == rear;
	}
	
	//������ݵ�����
	public void addQueue(int num) {
		if(isFull()) {
			System.out.println("��������");
		}else {
			
			arr[rear] = num;
			rear = (rear + 1) % maxSize;
		}
		
	}
	
	//ȡ�����ݳ�����
	public void getQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
		}else {
			//�Ƚ�front��Ӧ��ֵ����������Ȼ��front���ƣ�����ȡģ��������ʱ����
			int value = arr[front];
			front = (front + 1) % maxSize;
			System.out.println(value);
		}
	}
	
	
	//��ʾ������������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
		}
		int count = (rear + maxSize - front) % maxSize;
		for (int i = front; i < front + count; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
			//System.out.printf("arr[%d]=%\nd",i %maxSize,arr[i %maxSize]);
		}
	}
	
	//��ʾ����ͷ����
	public void showHead() {
		if (isEmpty()) {
			System.out.println("����Ϊ��");;
		}else {
			System.out.println(arr[front]);
		}
		
	}
	
}