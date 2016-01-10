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

	// faces
	// should probably separate this into a new class.
	private static String[][] up;
	private static String[][] back;
	private static String[][] right;
	private static String[][] front;
	private static String[][] left;
	private static String[][] down;

	// sides
	// separate these into a new class maybe?
	private static Object[] upSide;
	private static Object[] backSide;
	private static Object[] rightSide;
	private static Object[] frontSide;
	private static Object[] leftSide;
	private static Object[] downSide;

	public Cube() {
		up = new String[3][3];
		left = new String[3][3];
		front = new String[3][3];
		right = new String[3][3];
		back = new String[3][3];
		down = new String[3][3];

		upSide = new Object[] { up, back, right, front, left };

		initializeFaces();
	}

	private void initializeFaces() {
		initializeFace(up, "White");
		initializeFace(back, "Red");
		initializeFace(right, "Green");
		initializeFace(front, "Blue");
		initializeFace(right, "Yellow");
		initializeFace(down, "Orange");
	}

	private void initializeFace(String[][] side, String color) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j] = color;
			}
		}
	}

	public void printCube() {
		printFace(up);
		printFace(back);
		printFace(right);
		printFace(front);
		printFace(left);
		printFace(down);
	}

	private void printFace(String[][] side) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(side[i][j] + " ");
			}
			System.out.print("\r\n");
		}
	}

	public void turnUp() {
		// rotate:
		// bottom row of back ← left column of right
		// left column of right ← top row of bottom
		// top row of bottom ← right column of left
		// right column of left ← bottom row of back
		// then the side itself

		// Object[] sides =

		rotateClockwise(upSide);
	}

	public void returnUp() {
		rotateCounterClockwise(upSide);
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

	private void rotateClockwise(Object[] sides) {
		if (sides.length != 5) {
			// throw exception
		}

		Object[] newSides = new Object[5];
		String[][] newUp = new String[3][3];
		String[][] newBack = new String[3][3];
		String[][] newRight = new String[3][3];
		String[][] newFront = new String[3][3];
		String[][] newLeft = new String[3][3];

		for (int i = 0; i < 3; i++) {
			// newBack
		}
	}

	private void rotateCounterClockwise(Object[] sides) {

	}
}
