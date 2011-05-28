package src;

public class PrepareState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		BattleShip _a = super.context.getNextShip();
		if ( _a != null ){
			try {
				_a.setLocation(context.getSize(), location);
				super.context.updateGrid();
				return true;
			} catch (GridOutOfBoundsException e) {
				e.printStackTrace();
			}
		} else {
			
		}
		return false;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {

	}

	@Override
	public void showResult() {

	}

}
