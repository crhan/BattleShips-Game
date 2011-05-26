package src;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class BattleShipsFrame extends JFrame {
	public BattleShipsFrame(){
		this.setTitle("Battle Ship");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		BattleShipTableModel model1 = new BattleShipTableModel(size);
		BattleShipTableModel model2 = new BattleShipTableModel(size);
		JTable table1 = new JTable(model1);
		JTable table2 = new JTable(model2);
		table1.setRowSelectionAllowed(false);
		table2.setRowSelectionAllowed(false);
		
		table1.setDefaultRenderer(Color.class, new BattleShipTableRenderer());
		table2.setDefaultRenderer(Color.class, new BattleShipTableRenderer());
		

		this.add(new JScrollPane(table2),BorderLayout.CENTER);
		this.add(table1,BorderLayout.NORTH);
		
	}

	
	private int size=10;
	
	private final static int DEFAULT_WIDTH = 600;
	private final static int DEFAULT_HEIGHT = 300;
}
