package State;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Assets;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import UI.UIText;
import game.HandleClass;

public class EndingState extends State{
	private UIManager uiManager;

	public EndingState(HandleClass handler) {
		super(handler);
		uiManager=new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		uiManager.addObject(new UIText((int)0,(int)0,900,600,Assets.gameover));
		//handler.getGame().getG().setColor(Color.WHITE);
		//handler.getGame().getG().drawString("YOUR SCORE" + handler.getGame().getScore(), 60,100 ); 
		uiManager.addObject(new UIImageButton(410,450,90,90,Assets.button,new ClickListener() {

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				
				handler.getMouseManager().setUiManager(null);
				
				handler.getGame().init();
				
				
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
