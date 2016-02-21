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
		upFace = initializeFace("Ｗ");
		backFace = initializeFace("Ｒ");
		rightFace = initializeFace("Ｇ");
		frontFace = initializeFace("Ｂ");
		leftFace = initializeFace("Ｙ");
		downFace = initializeFace("Ｏ");
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

	public void turnUp() {
		String[][] tmpUp = applyFace(upFace);
		String[][] tmpLeft = applyFace(leftFace);
		String[][] tmpFront = applyFace(frontFace);
		String[][] tmpRight = applyFace(rightFace);
		String[][] tmpBack = applyFace(backFace);

		rotateArrayClockwise(tmpUp);
		for (int i = 0; i < 3; i++) {
			tmpLeft[0][i] = frontFace[0][i];
			tmpFront[0][i] = rightFace[0][i];
			tmpRight[0][i] = backFace[0][i];
			tmpBack[0][i] = leftFace[0][i];
		}

		upFace = applyFace(tmpUp);
		leftFace = applyFace(tmpLeft);
		frontFace = applyFace(tmpFront);
		rightFace = applyFace(tmpRight);
		backFace = applyFace(tmpBack);
	}

	private String[][] applyFace(String[][] source) {
		String[][] target = new String[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				target[i][j] = source[i][j];
			}
		}

		return target;
	}

	public void returnUp() {
		// turnSideCounterClockwise("up", upSide);
	}

	public void turnLeft() {
		String[][] tmpLeft = applyFace(leftFace);
		String[][] tmpUp = applyFace(upFace);
		String[][] tmpFront = applyFace(frontFace);
		String[][] tmpDown = applyFace(downFace);
		String[][] tmpBack = applyFace(backFace);

		rotateArrayClockwise(tmpLeft);
		for (int i = 0; i < 3; i++) {
			tmpUp[i][0] = backFace[2 - i][2];
			tmpFront[i][0] = upFace[i][0];
			tmpDown[i][0] = frontFace[i][0];
			tmpBack[2 - i][2] = downFace[i][0];
		}

		leftFace = applyFace(tmpLeft);
		upFace = applyFace(tmpUp);
		frontFace = applyFace(tmpFront);
		downFace = applyFace(tmpDown);
		backFace = applyFace(tmpBack);
	}

	public void turnFront() {
		// turnSideClockwise("front", frontSide);
	}

	public void turnRight() {
		// turnSideClockwise("right", rightSide);
	}

	public void turnBack() {
		// turnSideClockwise("back", backSide);
	}

	public void turnDown() {
		// turnSideClockwise("down", downSide);
	}

	private static String[][] rotateArrayClockwise(String[][] array) {
		int rowCount = array.length;
		int columnCount = array[0].length;

		String[][] rotatedArray = new String[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				rotatedArray[j][rowCount - 1 - i] = array[i][j];
			}
		}
		return rotatedArray; // return probably not necessary anywhere
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

	public String[][] getFlatCube() {
		String[][] cube = new String[9][12];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 12; j++) {
				cube[i][j] = "□";
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j + 3] = upFace[i][j];
				cube[i + 3][j] = leftFace[i][j];
				cube[i + 3][j + 3] = frontFace[i][j];
				cube[i + 3][j + 6] = rightFace[i][j];
				cube[i + 3][j + 9] = backFace[i][j];
				cube[i + 6][j + 3] = downFace[i][j];
			}
		}

		return cube;
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
