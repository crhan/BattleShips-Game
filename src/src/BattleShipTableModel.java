/**
 * 
 */
package src;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;

/**
 * @author crhan
 *
 */
public class BattleShipTableModel extends AbstractTableModel {

	public BattleShipTableModel(int _size){
		this.size = _size;
		cells = new Object[size][size];
		for (int i=0; i<size; i++){
			for (int j=0; j<size; j++){
				cells[i][j] = new GridLocation(i,j);
			}
		}
	}
	
	@Override
	public int getColumnCount() {
		return size;
	}

	@Override
	public int getRowCount() {
		return size;
	}

	
	public Class getColumnClass(int c){
		//TODO 添加返回值
		return cells[0][c].getClass();
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean inBounds(int x, int y){
		if ( x >= size || y>=size){
			return false;
		}
		return true;
	}

	private int size;
	private Object cells[][];
	
	public final static int SEA = 0;
	public final static int HIT = -1;
	public final static int MISS = -2;
	public final static int SANK = -3;
	public final static int GUESS = -4;
	public final static int AIRCRAFT_CARRIER = 5;
	public final static int BATTLESHIP = 4;
	public final static int DESTROYER = 3;
	public final static int SUBMARINE = 2;
	public final static int PATROL_BOAT = 1;
}
