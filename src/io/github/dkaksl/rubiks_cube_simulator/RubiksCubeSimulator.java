/** 
 * 
 * Copyright (C) 2016 Amani Kilumanga
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package io.github.dkaksl.rubiks_cube_simulator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Amani Kilumanga
 *
 */
public class RubiksCubeSimulator extends JFrame implements ActionListener {

	private final JPanel centerPanel;

	private static Cube cube;

	public RubiksCubeSimulator(int width, int height) {
		centerPanel = generateCenterPanel();

		this.setLayout(new BorderLayout());
		this.setSize(width, height);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		cube = new Cube();
	}

	private static JPanel generateCenterPanel() {
		JPanel jPanel = new JPanel();

		return jPanel;
	}

	private static void generateMainWindow() {
		RubiksCubeSimulator simulator = new RubiksCubeSimulator(600, 600);
	}

	public void actionPerformed(ActionEvent e) {
		// if (e.equals(objectA)) { // do stuff }

		/*
		 * Cube cube = new Cube(); cube.printCube(); // cube.turnUp(); cube.printCube();
		 */
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				generateMainWindow();
			}
		});
	}

}
