package src;

public class ComfirmState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		this.context.setCurrentState(context.FIRESTATE);
		return this.context.click(model, location);
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		model.GUESS
	}

	@Override
	public void showResult() {
		this.context.setCurrentState(context.GAMEOVERSTATE);
		this.context.showResult();
	}

}
