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
public class RubiksCubeSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cube cube = new Cube();
		cube.printCube();

		// cube.turnUp();
		cube.turnBack();
		cube.turnBack();
		cube.turnBack();
		cube.turnBack();
		cube.printCube();

		// TODO: make UI (to help debugging)
	}

}
