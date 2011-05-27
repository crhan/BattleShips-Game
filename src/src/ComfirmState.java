package src;

public class ComfirmState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		this.context.setCurrentState(BattleShipTableModel.FIRESTATE);
		return this.context.click(model, location);
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		for (GridLocation locate:model.getGuess()){
			int _x = locate.getX();
			int _y = locate.getY();
			if(locate.getType()>BattleShipTableModel.SEA){
				model.getGridLocate(_x, _y).setType(BattleShipTableModel.HIT);
			}
			else if (locate.getType() == BattleShipTableModel.SEA){
				model.getGridLocate(_x, _y).setType(BattleShipTableModel.MISS);
			}
		}
	}

	@Override
	public void showResult() {
		this.context.setCurrentState(BattleShipTableModel.GAMEOVERSTATE);
		this.context.showResult();
	}

}
