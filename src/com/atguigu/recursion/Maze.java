package com.atguigu.recursion;

/**
 * 迷宫
 * 
 * @author 16559
 *
 */
public class Maze {
	public static void main(String[] args) {

		int[][] map = new int[8][7];
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 1; i < 7; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}

		map[3][1] = 1;
		map[3][2] = 1;
		System.out.println("---------------原始地图---------------");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		setWay(map, 1, 1);
		System.out.println("---------------路径地图---------------");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean setWay(int[][] map, int i, int j) {

		// 1：墙 2：已经走过 3：走不通 0：未走
		if (map[6][5] == 2) {// 走到终点
			return true;
		} else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if (setWay(map, i + 1, j)) {// 向下走
					return true;
				} else if (setWay(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay(map, i, j + 1)) {// 向上走
					return true;
				} else if (setWay(map, i, j + 1)) {// 向左走
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}

		}

	}
}
