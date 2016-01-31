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

		// define 9 x 9 array
		String[][] side = new String[9][9];

		// TODO: make private method that takes faces as parameters and returns side
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j + 3] = backFace[i][j];
				side[i + 3][j] = leftFace[i][j];
				side[i + 3][j + 3] = upFace[i][j];
				side[i + 3][j + 6] = rightFace[i][j];
				side[i + 6][j + 3] = frontFace[i][j];
			}
		}

		// rotate center 5 x 5 array
		String[][] centerArray = new String[5][5];

		// TODO: make private method that takes side and returns centerArray
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				centerArray[i][j] = side[i + 2][j + 2];
			}
		}

		centerArray = rotateArray(centerArray);

		// TODO: private method
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				side[i + 2][j + 2] = centerArray[i][j];
			}
		}

		// TODO: replace Cube faces with 3 x 3 arrays found in new 9 x 9 array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				backFace[i][j] = side[i][j + 3];
				leftFace[i][j] = side[i + 3][j];
				upFace[i][j] = side[i + 3][j + 3];
				rightFace[i][j] = side[i + 3][j + 6];
				frontFace[i][j] = side[i + 6][j + 3];
			}
		}
	}

	private void printTmp(String[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				System.out.print(tmp[i][j]);
			}
			System.out.print("\r\n");
		}
	}

	private String[][] rotateArray(String[][] array) {
		int rowCount = array.length;
		int columnCount = array[0].length;

		String[][] rotatedArray = new String[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				rotatedArray[j][rowCount - 1 - i] = array[i][j];
			}

		}
		return rotatedArray;
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
