/** 
 * 
 * Copyright (C) 2016 Amani Kilumanga
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package io.github.dkaksl.rubiks_cube_simulator;

/**
 * @author Amani Kilumanga
 *
 */
public class Cube {

	private static String[][] up;
	private static String[][] left;
	private static String[][] front;
	private static String[][] right;
	private static String[][] back;
	private static String[][] down;

	public Cube() {
		up = new String[3][3];
		left = new String[3][3];
		front = new String[3][3];
		right = new String[3][3];
		back = new String[3][3];
		down = new String[3][3];

		initializeSides();
	}

	private void initializeSides() {
		initializeSide(up, "White");
		initializeSide(left, "Red");
		initializeSide(front, "Green");
		initializeSide(right, "Blue");
		initializeSide(back, "Yellow");
		initializeSide(down, "Orange");
	}

	private void initializeSide(String[][] side, String color) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j] = color;
			}
		}
	}

	public void printCube() {
		printSide(up);
		printSide(left);
		printSide(front);
		printSide(right);
		printSide(back);
		printSide(down);
	}

	private void printSide(String[][] side) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(side[i][j] + " ");
			}
			System.out.print("\r\n");
		}
	}

	public void turnUp() {

	}

	public void returnUp() {

	}

	public void turnLeft() {

	}

	public void turnFront() {

	}

	public void turnRight() {

	}

	public void turnBack() {

	}

	public void turnDown() {

	}
}
