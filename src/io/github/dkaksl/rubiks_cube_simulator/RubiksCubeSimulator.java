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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Amani Kilumanga
 *
 */
public class RubiksCubeSimulator extends JFrame implements ActionListener {

	private final JPanel topPanel;
	private final JPanel centerPanel;

	private static JButton upButton;
	private static JButton backButton;
	private static JButton leftButton;
	private static JButton frontButton;
	private static JButton rightButton;
	private static JButton downButton;

	private static JTextArea cubeView;

	private static Cube cube;

	public RubiksCubeSimulator(int width, int height) {
		topPanel = generateTopPanel();
		centerPanel = generateCenterPanel();

		this.setLayout(new BorderLayout());
		this.setSize(width, height);
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		cube = new Cube();

		updateCubeView();
	}

	private static void updateCubeView() {
		String[][] view = cube.getFlatCube();

		cubeView.setText("");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 12; j++) {
				cubeView.append(view[i][j]);
			}
			cubeView.append("\n");
		}
	}

	private JPanel generateTopPanel() {
		JPanel jPanel = new JPanel();

		upButton = new JButton("up");
		backButton = new JButton("back");
		leftButton = new JButton("left");
		frontButton = new JButton("front");
		rightButton = new JButton("right");
		downButton = new JButton("down");

		upButton.addActionListener(this);
		backButton.addActionListener(this);
		leftButton.addActionListener(this);
		frontButton.addActionListener(this);
		rightButton.addActionListener(this);
		downButton.addActionListener(this);

		jPanel.add(upButton);
		jPanel.add(backButton);
		jPanel.add(leftButton);
		jPanel.add(frontButton);
		jPanel.add(rightButton);
		jPanel.add(downButton);

		return jPanel;
	}

	private JPanel generateCenterPanel() {
		JPanel jPanel = new JPanel();

		cubeView = new JTextArea();
		cubeView.setEditable(false);

		jPanel.add(cubeView);

		return jPanel;
	}

	private static void generateMainWindow() {
		RubiksCubeSimulator simulator = new RubiksCubeSimulator(600, 600);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == upButton) {
			cube.turnUp();
		} else if (e.getSource() == backButton) {
			cube.turnBack();
		} else if (e.getSource() == leftButton) {
			cube.turnLeft();
		} else if (e.getSource() == frontButton) {
			cube.turnFront();
		} else if (e.getSource() == rightButton) {
			cube.turnRight();
		} else if (e.getSource() == downButton) {
			cube.turnDown();
		}
		updateCubeView();
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
