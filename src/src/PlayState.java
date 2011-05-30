package src;

public abstract class PlayState {
	private BattleShipTableModel context;
	
	public void setContext(BattleShipTableModel _context){
		this.context = _context;
	}
	
	protected BattleShipTableModel getContext(){
		if (context.isMyTurn()){
			return context;
		} else {
			return context.getAnotherPlayer();
		}
	}
	
	/**
	 * Add guess after click event
	 * It will check if it's my turn
	 * @param model
	 * @param location
	 * @return true if this is my turn and location valid.
	 */
	public abstract boolean click(BattleShipTableModel model, GridLocation location);
	
	/**
	 * this state will check the guess 
	 * and set the grid type to show the result
	 * @param model
	 */
	public abstract void comfirm(BattleShipTableModel model);
	public abstract void showResult();
	public abstract void button(BattleShipTableModel model);
}
