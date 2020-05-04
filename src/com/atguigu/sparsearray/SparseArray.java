package com.atguigu.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		//1.����һ����ά����
		int[][] array = new int[11][11];
		array[1][1] = 1;
		array[2][3] = 2;
		array[5][8] = 3;
		int sum = 0;
		
		System.out.println("------ԭʼ��ά����Ϊ------");
		for (int[] is : array) {		
			for (int is2 : is) {
				System.out.print("\t" + is2);
			}
			System.out.println();
		}
		
		//2.��ȡ��ά��������ݵĸ���
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] != 0) {
					sum++;
				}
			}
		}
		
		//��֮ת��Ϊϡ������sparesArray[sum+1][3],��ϡ�����鸳ֵ
		int[][] spareArray = new int[sum+1][3];
		spareArray[0][0] = 11;
		spareArray[0][1] = 11;
		spareArray[0][2] = sum;
		
		int count = 1;
		//��ȡԭ��ά��������������ݵ�λ���Լ�ֵ
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
		System.out.println("ת�����ϡ������Ϊ:");
		for (int i = 0; i < spareArray.length; i++) {
			for (int j = 0; j < spareArray[0].length; j++) {
				System.out.print("\t" + spareArray[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("------------------��ϡ������ת��Ϊ��ά����-------------------");
		//��ȡ��ά��������У�����������
		int[][] array01 = new int[spareArray[0][0]][spareArray[0][1]];
		//��ȡϡ��������value��ֵ�Լ�����λ�ò���ֵ
		for (int i = 1; i < spareArray.length; i++) {
			for (int j = 0; j < spareArray[0].length; j++) {
				array01[spareArray[i][0]][spareArray[i][1]] = spareArray[i][j];
			}
		}
		System.out.println("ת�����ԭʼ��ά����Ϊ:");
		for (int i = 0; i < array01.length; i++) {
			for (int j = 0; j < array01[0].length; j++) {
				System.out.print("\t" + array01[i][j]);
			}
			System.out.println();
		}
		

	}

}
