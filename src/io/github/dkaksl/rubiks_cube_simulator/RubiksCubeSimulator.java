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

	private final JPanel rightPanel;
	private final JPanel topPanel;
	private final JPanel centerPanel;
	private final JPanel bottomPanel;

	private static JButton upButton;
	private static JButton backButton;
	private static JButton leftButton;
	private static JButton frontButton;
	private static JButton rightButton;
	private static JButton downButton;

	private static JButton randomButton;
	private static JButton shuffleButton;

	private static JButton reUpButton;
	private static JButton reBackButton;
	private static JButton reLeftButton;
	private static JButton reFrontButton;
	private static JButton reRightButton;
	private static JButton reDownButton;

	private static JTextArea cubeView;

	private static Cube cube;

	public RubiksCubeSimulator(int width, int height) {
		topPanel = generateTopPanel();
		centerPanel = generateCenterPanel();
		bottomPanel = generateBottomPanel();
		rightPanel = generateRightPanel();

		this.setLayout(new BorderLayout());
		this.setSize(width, height);

		this.getContentPane().add(rightPanel, BorderLayout.EAST);
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

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

	private JPanel generateRightPanel() {
		JPanel jPanel = new JPanel();

		randomButton = new JButton("random");
		shuffleButton = new JButton("shuffle");

		randomButton.addActionListener(this);
		shuffleButton.addActionListener(this);

		jPanel.add(randomButton);
		jPanel.add(shuffleButton);

		return jPanel;
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

	private JPanel generateBottomPanel() {
		JPanel jPanel = new JPanel();

		reUpButton = new JButton("up");
		reBackButton = new JButton("back");
		reLeftButton = new JButton("left");
		reFrontButton = new JButton("front");
		reRightButton = new JButton("right");
		reDownButton = new JButton("down");

		reUpButton.addActionListener(this);
		reBackButton.addActionListener(this);
		reLeftButton.addActionListener(this);
		reFrontButton.addActionListener(this);
		reRightButton.addActionListener(this);
		reDownButton.addActionListener(this);

		jPanel.add(reUpButton);
		jPanel.add(reBackButton);
		jPanel.add(reLeftButton);
		jPanel.add(reFrontButton);
		jPanel.add(reRightButton);
		jPanel.add(reDownButton);

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
		} else if (e.getSource() == reUpButton) {
			cube.returnUp();
		} else if (e.getSource() == reBackButton) {
			cube.returnBack();
		} else if (e.getSource() == reLeftButton) {
			cube.returnLeft();
		} else if (e.getSource() == reFrontButton) {
			cube.returnFront();
		} else if (e.getSource() == reRightButton) {
			cube.returnRight();
		} else if (e.getSource() == reDownButton) {
			cube.returnDown();
		} else if (e.getSource() == randomButton) {
			cube.randomMove();
		} else if (e.getSource() == shuffleButton) {
			cube.shuffleCube();
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
