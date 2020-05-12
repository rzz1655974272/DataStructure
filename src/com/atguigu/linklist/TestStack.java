package com.atguigu.linklist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStack {


	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		// ��ջ
		stack.add("qqq");
		stack.add("www");
		stack.add("eee");
		stack.push("rrr");


		// ��ջ
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
		//�����
		Queue<String> queue = new LinkedList<>();
		queue.add("qqq");
		queue.add("www");
		queue.add("eee");
		queue.add("rrr");
		//������
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}

	}

}
