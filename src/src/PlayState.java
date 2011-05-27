package src;

public abstract class PlayState {
	protected BattleShipTableModel context;
	protected boolean playerOne;
	
	public void setContext(BattleShipTableModel _context){
		this.context = _context;
	}
	
	public void changePlayer(){
		this.playerOne = !playerOne;
	}
	
	public abstract boolean click(BattleShipTableModel model, GridLocation location);
	public abstract void comfirm(BattleShipTableModel model);
	public abstract void showResult();
	
	
}
