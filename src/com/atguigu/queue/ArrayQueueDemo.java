package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
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

//ʹ������ģ�����
class ArrayQueue{
	private int maxSize;//�����������
	private int front;//����ͷ
	private int rear;//����β
	private int[] arr;//���������ڴ�����ݣ�ģ�����
	
	//�������еĹ�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr =new int[maxSize];
		front = -1;//ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��
		rear = -1;//ָ�����β����ָ�����β�����ݣ������Ƕ������һ�����ݣ�
	}
	
	//�ж϶����Ƿ���
	public boolean isFull() {
		return rear == maxSize - 1;
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
			rear++;
			arr[rear] = num;
		}
		
	}
	
	//ȡ�����ݳ�����
	public void getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}else {
			front++;
			System.out.println(arr[front]);
		}
	}
	
	
	//��ʾ������������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i+"----"+arr[i]);
		}
	}
	
	//��ʾ����ͷ����
	public void showHead() {
		if (isFull()) {
			System.out.println("����Ϊ��");;
		}else {
			System.out.println(arr[front+1]);
		}
		
	}
	
}