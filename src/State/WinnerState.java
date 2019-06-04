package State;

import java.awt.Graphics;
import Graphics.Assets;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import UI.UIText;
import game.HandleClass;

public class WinnerState extends State{
	private UIManager uiManager;

	public WinnerState(HandleClass handler) {
		super(handler);
		uiManager=new UIManager(handler);
		
		
		uiManager.addObject(new UIText((int)0,(int)0,900,600,Assets.winner));
		uiManager.addObject(new UIImageButton(380,450,75,75,Assets.button,new ClickListener() {

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				handler.getMouseManager().setUiManager(null);
				State.getState();
			}}));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		uiManager.render(g);
		
	}

}
