package src;

public class ComfirmState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		if (context.isMyTurn()){
			this.context.setCurrentState(BattleShipTableModel.FIRE_STATE);
			return this.context.click(model, location);
		}
		else
			return false;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		for (GridLocation locate:model.getGuess()){
			int _x = locate.getX();
			int _y = locate.getY();
			assert(locate.getType() >= BattleShipTableModel.SEA);
			// if locate.getType return a ship type(>0)
			if(locate.getType()>BattleShipTableModel.SEA){
				// mark as hit!
				model.getGridLocate(_x, _y).setType(BattleShipTableModel.HIT);
				// if hit() return less than 1, means this ship has sank
				if (model.getShip(locate.getType()).hit() <= 0){
					// if BattleShipTableModel.sank(type) return less then zero
					//		That means all ships are sank and should turn to GAMEOVERSTATE
					if (model.sank(locate.getType()) <= 0){
						this.showResult();
					}
				}
			}
			else if (locate.getType() == BattleShipTableModel.SEA){
				model.getGridLocate(_x, _y).setType(BattleShipTableModel.MISS);
			}
		}
		// nothing happened and change the player
		context.changePlayer();
	}

	@Override
	public void showResult() {
		this.context.setCurrentState(BattleShipTableModel.GAMEOVER_STATE);
		this.context.showResult();
	}

}
