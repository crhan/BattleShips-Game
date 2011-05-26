package src;

import java.awt.Color;

public class GridLocation {
	public GridLocation(int _x, int _y){
		this.x = _x;
		this.y = _y;
		this.type = BattleShipTableModel.SEA;
		this.placeState = true;
		
	}
	
	
	public Color getColor(){
		switch(type){
		case BattleShipTableModel.HIT:
			return Color.red;
		case BattleShipTableModel.MISS:
			return Color.yellow;
		case BattleShipTableModel.SANK:
			return Color.black;
		case BattleShipTableModel.GUESS:
			return Color.gray;
		case BattleShipTableModel.SEA:
			return Color.blue;
		case BattleShipTableModel.PATROL_BOAT:
		case BattleShipTableModel.SUBMARINE:
		case BattleShipTableModel.DESTROYER:
		case BattleShipTableModel.BATTLESHIP:
		case BattleShipTableModel.AIRCRAFT_CARRIER:
			if (this.placeState)
				return Color.green;
			else
				return Color.blue;
		}
		return null;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setPlaceState(boolean foo){
		this.placeState = foo;
	}

	private int x;
	private int y;
	private int type;
	private boolean placeState=true;

}
