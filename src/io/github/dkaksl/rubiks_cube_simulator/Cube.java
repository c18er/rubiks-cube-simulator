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

	private static String[][][] upSide;
	private static String[][][] backSide;
	private static String[][][] rightSide;
	private static String[][][] frontSide;
	private static String[][][] leftSide;
	private static String[][][] downSide;

	public Cube() {
		upFace = initializeFace("White");
		backFace = initializeFace("Red");
		rightFace = initializeFace("Green");
		frontFace = initializeFace("Blue");
		leftFace = initializeFace("Yellow");
		downFace = initializeFace("Orange");

		upSide = new String[][][] { backFace, leftFace, upFace, rightFace, frontFace };
		backSide = new String[][][] { downFace, leftFace, backFace, rightFace, upFace };
		rightSide = new String[][][] {};
		frontSide = new String[][][] {};
		leftSide = new String[][][] {};
		downSide = new String[][][] {};
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
		turnSideClockwise("up", upSide);
	}

	public void returnUp() {
		turnSideCounterClockwise("up", upSide);
	}

	public void turnLeft() {
		turnSideClockwise("left", leftSide);
	}

	public void turnFront() {
		turnSideClockwise("front", frontSide);
	}

	public void turnRight() {
		turnSideClockwise("right", rightSide);
	}

	public void turnBack() {
		turnSideClockwise("back", backSide);
	}

	public void turnDown() {
		turnSideClockwise("down", downSide);
	}

	private void turnSideClockwise(String orientation, String[][][] targetSide) {
		Side side = new Side(orientation, targetSide);
		String[][] rotatedSide = side.getSideRotatedClockwise();
		applyRotatedSideToCube(rotatedSide, targetSide);
	}

	private void turnSideCounterClockwise(String orientation, String[][][] targetSide) {
		// TODO: actually turn side clockwise
		turnSideClockwise(orientation, targetSide);
		turnSideClockwise(orientation, targetSide);
		turnSideClockwise(orientation, targetSide);
	}

	private void applyRotatedSideToCube(String[][] rotatedSide, String[][][] side) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[0][i][j] = rotatedSide[i][j + 3];
				side[1][i][j] = rotatedSide[i + 3][j];
				side[2][i][j] = rotatedSide[i + 3][j + 3];
				side[3][i][j] = rotatedSide[i + 3][j + 6];
				side[4][i][j] = rotatedSide[i + 6][j + 3];
			}
		}
	}

	public static String[][] getUpFace() {
		return upFace;
	}

	public static String[][] getBackFace() {
		return backFace;
	}

	public static String[][] getRightFace() {
		return rightFace;
	}

	public static String[][] getFrontFace() {
		return frontFace;
	}

	public static String[][] getLeftFace() {
		return leftFace;
	}

	public static String[][] getDownFace() {
		return downFace;
	}
}
