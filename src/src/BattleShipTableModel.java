/**
 * 
 */
package src;

import java.awt.Color;
import java.util.*;

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
		// initializing five ships
		ships = new ArrayList<BattleShip>();
		for (int i=0; i<5; i++){
			ships.add(new BattleShip(i+1));
		}
		shipLeft = 5;
		currentShip = ships.iterator();
	}
	
	public void initGrid(){
		GridLocation _x;
		for (int i=0; i<this.size; i++){
			for (int j=0; j<this.size; j++){
				_x = (GridLocation) cells[i][j];
				_x.setType(BattleShipTableModel.SEA);
			}
		}
	}
	
	@Override
	public int getColumnCount() { return size; }

	@Override
	public int getRowCount() { return size; }

	@Override
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
	
	public void updateGrid(){
		this.initGrid();
		Iterator<BattleShip> _a = ships.iterator();
		if(_a.hasNext()){
			_a.next().updateLocation((GridLocation[][]) cells);
		}
	}
	
	
	public BattleShipTableModel getAnotherPlayer() {
		return this.anotherPlayer;
	}

	public void setAnotherPlayer(BattleShipTableModel _Player) {
		this.anotherPlayer = _Player;
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
	
	/**
	 * Add a cloned GridLocation to ArrayList 
	 * and make the original one to GUESS type
	 * @param grid
	 * @return true" if all goes fine
	 */
	public boolean addGuess(GridLocation grid){
		if (grid.canGuess() && guess.add((GridLocation) grid.clone())){
			grid.setType(BattleShipTableModel.GUESS);
			return true;
		} else { return false;}
	}
	
	public ArrayList<GridLocation> getGuess() { return guess; }
	
	/**
	 * return the ship of the given type
	 * @param type
	 * @return BattleShip
	 */
	public BattleShip getShip(int type){ return ships.get(type-1); }
	
	/**
	 * invoke function from {@link BattleShip}.sank
	 * which marks the ships grid as SANK
	 * @param type
	 * @return shipLeft
	 */
	public int sank(int type){
		shipLeft--;
		this.getShip(type).sank(this);
		
		return shipLeft;
	}
	
	//functions related to state pattern
	public PlayState getCurrentState(){ return this.currentState; }
	
	public void setCurrentState(PlayState _state){
		this.currentState = _state;
		this.currentState.setContext(this);
	}
	
	public boolean click(BattleShipTableModel model, GridLocation location){
		return this.currentState.click(model, location);
	}
	
	public void comfirm(BattleShipTableModel model){ this.currentState.comfirm(model); }
	
	public void showResult(){ this.currentState.showResult(); }
	
	public void changePlayer(){
		this.getAnotherPlayer().setTurn(this.myTurn);
		this.setTurn(!this.myTurn);
	}
	
	public void setTurn(boolean turn){ this.myTurn = turn; }
	
	public boolean getTurn(){ return this.myTurn; }
	
	public int getShipLeft() { return shipLeft; }
	
	public void setShipLeft(int shipLeft) { this.shipLeft = shipLeft; }

	public int getSize() { return size; }

	public void setSize(int size) { this.size = size; }
	
	public BattleShip getNextShip() {
		if(currentShip.hasNext())
			return currentShip.next();
		else
			return null;
	}

	// initialize stages
	public final static PlayState FIRE_STATE = new FireState();
	public final static PlayState COMFIRM_STATE = new ComfirmState();
	public final static PlayState GAMEOVER_STATE = new GameOverState();

	private int size;
	private int shipLeft;
	private boolean myTurn;
	private Object cells[][];
	private ArrayList<GridLocation> guess;
	private PlayState currentState;
	private ArrayList<BattleShip> ships;
	private Iterator<BattleShip> currentShip;
	


	private BattleShipTableModel anotherPlayer;
	
	public final static int SEA = 0;
	public final static int HIT = -1;
	public final static int MISS = -2;
	public final static int SANK = -3;
	public final static int GUESS = -4;
	public final static int WIN = -5;
	public final static int LOSE = -6;
	public final static int AIRCRAFT_CARRIER = 5;
	public final static int BATTLESHIP = 4;
	public final static int DESTROYER = 3;
	public final static int SUBMARINE = 2;
	public final static int PATROL_BOAT = 1;
}
