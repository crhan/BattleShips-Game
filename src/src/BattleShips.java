package src;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BattleShips {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				BattleShipsFram frame = new BattleShipsFram();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
