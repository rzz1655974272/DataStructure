package com.atguigu.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		//1.创建一个二维数组
		int[][] array = new int[11][11];
		array[1][1] = 1;
		array[2][3] = 2;
		array[5][8] = 3;
		int sum = 0;
		
		System.out.println("------原始二维数组为------");
		for (int[] is : array) {		
			for (int is2 : is) {
				System.out.print("\t" + is2);
			}
			System.out.println();
		}
		
		//2.获取二维数组的数据的个数
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] != 0) {
					sum++;
				}
			}
		}
		
		//将之转化为稀疏数组sparesArray[sum+1][3],给稀疏数组赋值
		int[][] spareArray = new int[sum+1][3];
		spareArray[0][0] = 11;
		spareArray[0][1] = 11;
		spareArray[0][2] = sum;
		
		int count = 1;
		//获取原二维数组中所存放数据的位置以及值
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] != 0) {
					spareArray[count][0] = i;
					spareArray[count][1] = j;
					spareArray[count][2] = array[i][j];
					count++;
				}
			}
		}
		System.out.println("转化后的稀疏数组为:");
		for (int i = 0; i < spareArray.length; i++) {
			for (int j = 0; j < spareArray[0].length; j++) {
				System.out.print("\t" + spareArray[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("------------------将稀疏数组转化为二维数组-------------------");
		//获取二维数组的行列，并创建数组
		int[][] array01 = new int[spareArray[0][0]][spareArray[0][1]];
		//获取稀疏数组中value的值以及所在位置并赋值
		for (int i = 1; i < spareArray.length; i++) {
			for (int j = 0; j < spareArray[0].length; j++) {
				array01[spareArray[i][0]][spareArray[i][1]] = spareArray[i][j];
			}
		}
		System.out.println("转化后的原始二维数组为:");
		for (int i = 0; i < array01.length; i++) {
			for (int j = 0; j < array01[0].length; j++) {
				System.out.print("\t" + array01[i][j]);
			}
			System.out.println();
		}
		

	}

}
