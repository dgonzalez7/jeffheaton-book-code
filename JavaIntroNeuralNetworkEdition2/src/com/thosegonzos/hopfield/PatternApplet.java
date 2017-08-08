package com.thosegonzos.hopfield;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Panel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

public class PatternApplet extends Applet
	implements java.awt.event.ActionListener, 
               java.awt.event.MouseListener
{
	/**
	 * Serial id for this class.
	 */
	private static final long serialVersionUID = 1882626251007826502L;
	public final int GRID_X = 8;
	public final int GRID_Y = 8;
	public final int CELL_WIDTH = 20;
	public final int CELL_HEIGHT = 20;
	public HopfieldNetwork hopfield;
	private boolean grid[];
	private int margin;
	private Panel buttonPanel;
	private Button buttonTrain;
	private Button buttonGo;
	private Button buttonClear;
	private Button buttonClearMatrix;
	
	public void actionPerformed(final java.awt.event.ActionEvent event)
	{
		final Object object = event.getSource();
		if (object == this.buttonClear)
		{
			clear();
		}
		else if (object == this.buttonClearMatrix)
		{
			clearMatrix();
		}
		else if (object == this.buttonGo)
		{
			go();
		}
		else if (object == this.buttonTrain)
		{
			train();
		}
	}
	
	/**
	 * Clear the grid.
	 */
	public void clear() 
	{
		int index = 0;
		for (int y = 0; y < this.GRID_Y; y++) 
		{
			for (int x = 0; x < this.GRID_X; x++) 
			{
				this.grid[index++] = false;
			}
		}

		repaint();
	}
	
	/**
	 * Clear the weight matrix.
	 */
	private void clearMatrix() 
	{
		this.hopfield.getMatrix().clear();
	}

	/**
	 * Run the neural network.
	 */
	public void go() 
	{
		this.grid = this.hopfield.present(this.grid);
		repaint();
	}
	
	@Override
	public void init() 
	{
		this.grid = new boolean[this.GRID_X * this.GRID_Y];
		this.addMouseListener(this);
		this.buttonTrain = new Button("Train");
		this.buttonGo = new Button("Go");
		this.buttonClear = new Button("Clear");
		this.buttonClearMatrix = new Button("Clear Matrix");
		this.setLayout(new BorderLayout());
		this.buttonPanel = new Panel();
		this.buttonPanel.add(this.buttonTrain);
		this.buttonPanel.add(this.buttonGo);
		this.buttonPanel.add(this.buttonClear);
		this.buttonPanel.add(this.buttonClearMatrix);
		this.add(this.buttonPanel, BorderLayout.SOUTH);

		this.buttonTrain.addActionListener(this);
		this.buttonGo.addActionListener(this);
		this.buttonClear.addActionListener(this);
		this.buttonClearMatrix.addActionListener(this);

		this.hopfield = new HopfieldNetwork(this.GRID_X * this.GRID_Y);
	}
	
	public void mouseClicked(final MouseEvent event) 
	{
		// not used
	}

	public void mouseEntered(final MouseEvent e) 
	{
		// not used
	}

	public void mouseExited(final MouseEvent e) 
	{
		// not used
	}

	public void mousePressed(final MouseEvent e) 
	{
		// not used
	}
	
	public void mouseReleased(final MouseEvent e) 
	{
		final int x = ((e.getX() - this.margin) / this.CELL_WIDTH);
		final int y = e.getY() / this.CELL_HEIGHT;
		if (((x >= 0) && (x < this.GRID_X)) && ((y >= 0) && (y < this.GRID_Y))) 
		{
			final int index = (y * this.GRID_X) + x;
			this.grid[index] = !this.grid[index];
		}
		repaint();
	}

	@Override
	public void paint(final Graphics g) 
	{
		this.margin = (this.getWidth() - (this.CELL_WIDTH * this.GRID_X)) / 2;
		int index = 0;
		for (int y = 0; y < this.GRID_Y; y++) 
		{
			for (int x = 0; x < this.GRID_X; x++) 
			{
				if (this.grid[index++]) {
					g.fillRect(this.margin + (x * this.CELL_WIDTH), y
							* this.CELL_HEIGHT, this.CELL_WIDTH,
							this.CELL_HEIGHT);
				} 
				else 
				{
					g.drawRect(this.margin + (x * this.CELL_WIDTH), y
							* this.CELL_HEIGHT, this.CELL_WIDTH,
							this.CELL_HEIGHT);
				}
			}
		}
	}

	/**
	 * Train the neural network.
	 */
	public void train() 
	{
		this.hopfield.train(this.grid);
	}
}
