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

	private static String[][] upFace;
	private static String[][] backFace;
	private static String[][] rightFace;
	private static String[][] frontFace;
	private static String[][] leftFace;
	private static String[][] downFace;

	public Cube() {
		upFace = initializeFace("White");
		backFace = initializeFace("Red");
		rightFace = initializeFace("Green");
		frontFace = initializeFace("Blue");
		leftFace = initializeFace("Yellow");
		downFace = initializeFace("Orange");
	}

	private String[][] initializeFace(String color) {
		String[][] side = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j] = color;
			}
		}
		return side;
	}

	public void printCube() {
		printFace(upFace);
		printFace(backFace);
		printFace(rightFace);
		printFace(frontFace);
		printFace(leftFace);
		printFace(downFace);
	}

	private void printFace(String[][] face) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(face[i][j] + " ");
			}
			System.out.print("\r\n");
		}
		System.out.println();
	}

	public void turnUp() {
		Side sideTest = new Side(backFace, leftFace, upFace, rightFace, frontFace);
		String[][] rotatedSide = sideTest.getSideRotatedClockwise();

		// TODO: how to make this a private method
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				backFace[i][j] = rotatedSide[i][j + 3];
				leftFace[i][j] = rotatedSide[i + 3][j];
				upFace[i][j] = rotatedSide[i + 3][j + 3];
				rightFace[i][j] = rotatedSide[i + 3][j + 6];
				frontFace[i][j] = rotatedSide[i + 6][j + 3];
			}
		}
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
