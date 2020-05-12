package com.atguigu.linklist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStack {


	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		// 入栈
		stack.add("qqq");
		stack.add("www");
		stack.add("eee");
		stack.push("rrr");


		// 出栈
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
		//入队列
		Queue<String> queue = new LinkedList<>();
		queue.add("qqq");
		queue.add("www");
		queue.add("eee");
		queue.add("rrr");
		//出队列
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}

	}

}
