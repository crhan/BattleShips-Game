package src;

public class PrepareState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel _model, GridLocation location) {
		BattleShipTableModel model;
		if (!super.context.isMyTurn()) {
			super.context.getAnotherPlayer();
			
			int _type = super.context.getCurrentShipType();
			BattleShip _a = super.context.getShip(_type);
			_a.setVertical(super.context.isShipVertical());
			// if has ship, then try to set the location
			try {
				_a.setLocation(context.getSize(), location, super.context);
				super.context.updateGrid();
				super.context.setCurrentShipType(_type + 1);
				return true;
			} catch (GridOutOfBoundsException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (BattleShipCrossOverException e) {
				e.printStackTrace();
			}
			if (super.context.getCurrentShipType() > 5) {
				super.context.setCurrentState(BattleShipTableModel.FIRE_STATE);
				super.context.changePlayer();
				return true;
			}
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
