/**
 * 
 */
package src;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author crhan
 *
 */
@SuppressWarnings("serial")
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

	
	public Class<Color> getColumnClass(int c){
		return Color.class;
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		GridLocation g= (GridLocation)cells[arg0][arg1];
		return g.getColor();
	}
	
	public boolean inBounds(int x, int y){
		if ( x >= size || y>=size){
			return false;
		}
		return true;
	}
	
	public GridLocation getGridLocate(int _x, int _y){
		if (_x<size && _y<size)
			return (GridLocation) cells[_x][_y];
		else
			return null;
	}
	
	public GridLocation setGrid(int _type, GridLocation grid){
		grid.setType(_type);
		return grid;
	}
	
	public boolean addGuess(GridLocation grid){
		if (grid.canGuess() && guess.add(grid))
			return true;
		else
			return false;
	}
	
	public ArrayList<GridLocation> getGuess() {
		return guess;
	}
	
	
	//functions related to state pattern
	
	public PlayState getCurrentState(){
		return this.currentState;
	}
	
	public void setCurrentState(PlayState _state){
		this.currentState = _state;
		this.currentState.setContext(this);
	}
	
	public boolean click(BattleShipTableModel model, GridLocation location){
		return this.currentState.click(model, location);
	}
	
	public void comfirm(BattleShipTableModel model){
		this.currentState.comfirm(model);
	}
	public void showResult(){
		this.currentState.showResult();
	}
	
	
	// initialize stages
	
	public final static PlayState FIRESTATE = new FireState();
	public final static PlayState COMFIRMSTATE = new ComfirmState();
	public final static PlayState GAMEOVERSTATE = new GameOverState();

	private int size;
	private Object cells[][];
	private ArrayList<GridLocation> guess;
	private PlayState currentState;
	
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
