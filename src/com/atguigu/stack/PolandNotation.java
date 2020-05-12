package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	

	public static void main(String[] args) {
		//先定义一个逆波兰表达式,分割后存入list中
		String suffixExpression = "3 4 + 5 * 6 -";
		//(3+4)*5-6===>3 4 + 5 * 6 -
		List<String> list = getListStrings(suffixExpression);
//		System.out.println(list);
		
		int res = calculate(list);
		System.out.println(res);
		
	}
	
	public static int calculate(List<String> list) {
		Stack<String> stack = new Stack<String>();
		int res = 0;
		// 循环遍历list，如果是数字压入栈中，是符号就计算，将结果在压入栈中
		for (String ele : list) {
			if (ele.matches("\\d+")) {
				stack.push(ele);
			} else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				if (ele.equals("+")) {
					res = num1+num2;
				}else if (ele.equals("-")) {
					res = num1-num2;
				}else if (ele.equals("*")) {
					res = num1*num2;
				}else if (ele.equals("/")) {
					res = num1/num2;
				}else {
					throw new RuntimeException("输入逆波兰表达式错误");
				}
				stack.push(""+res);
			}
			
		}
		return Integer.parseInt(stack.pop());	
	}

	public static List<String> getListStrings(String suffixExpression){
		List<String> list = new ArrayList<String>();
		String[] split = suffixExpression.split(" ");
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}
}
