package src;

import java.rmi.registry.LocateRegistry;

public class BattleShip {
	public BattleShip(int _type) {
		switch (_type) {
		case BattleShipTableModel.AIRCRAFT_CARRIER:
			this.length = 5;
			break;
		case BattleShipTableModel.BATTLESHIP:
			this.length = 4;
			break;
		case BattleShipTableModel.DESTROYER:
			this.length = 3;
			break;
		case BattleShipTableModel.SUBMARINE:
		case BattleShipTableModel.PATROL_BOAT:
			this.length = 2;
			break;
		default:
			assert (false);
		}

		this.type = _type;
		horizontal = true;
		hitLeft = length;
	}

	public GridLocation getLocation() {
		return location;
	}

	public int getLenth() {
		return length;
	}

	/**
	 * This function check if the location is inbounds and then set the location
	 * to ship
	 * 
	 * @param size
	 * @param _location
	 * @throws GridOutOfBoundsException
	 */
	public void setLocation(int size, GridLocation _location)
			throws GridOutOfBoundsException {
		// check if in bound of the cells
		if (this.horizontal) {
			if (_location.getX() + this.length < size) {
				this.location = _location; // in bound and set the location
			} else {
				throw new GridOutOfBoundsException(); // out of bounds and throw
														// the exception
			}
		} else {
			if (_location.getY() + this.length < size) {
				this.location = _location;
			} else {
				throw new GridOutOfBoundsException(); // out of bounds and throw
														// the exception
			}
		}
	}

	/**
	 * This function change the cells type
	 * 
	 * @param cells
	 */
	public void updateLocation(GridLocation[][] cells) {
		if (this.location != null) {
			
			int _x = this.location.getX();
			int _y = this.location.getY();

			if (this.horizontal) {
				for (int i = _x; i < _x + this.length; i++) {
					cells[i][_y].setType(this.type);
				}
			} else {
				for (int i = _y; i < _y + this.length; i++) {
					cells[_x][i].setType(this.type);
				}
			}
		}
	}

	/**
	 * Ship get hit and hitLeft minus one
	 * 
	 * @return hitLeft
	 */
	public int hit() {
		this.hitLeft--;
		return this.hitLeft;
	}

	/**
	 * Sign the ship to {@link BattleShipTableModel}.SANK
	 * 
	 * @param model
	 */
	public void sank(BattleShipTableModel model) {
		int _x = this.location.getX();
		int _y = this.location.getY();
		if (this.horizontal) {
			for (int i = _x; i < _x + this.length; i++) {
				model.getGridLocate(i, _y).setType(BattleShipTableModel.SANK);
			}
		} else {
			for (int i = _y; i < _y + this.length; i++) {
				model.getGridLocate(_x, i).setType(BattleShipTableModel.SANK);
			}
		}
	}

	public boolean isHorizontal() { return horizontal; }

	public void setHorizontal(boolean horizontal) { this.horizontal = horizontal; }
	
	public String toString(){ return "This is the ship of "+this.type; }

	private boolean horizontal;
	private int length;
	private int hitLeft;
	private int type;
	private GridLocation location;
}
