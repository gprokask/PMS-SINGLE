package de.gp.pms.client;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.NorthSouthContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.menu.Item;

public class MainView extends Viewport implements MainViewPresenter.Display {
	
	private MainMenuBar mainMenuBar;
	
	public MainView() {
		initComponents();
		composeLayout();
	}
	
	private void initComponents() {
		mainMenuBar = new MainMenuBar();
    }
	
	private void composeLayout() {
		final BorderLayoutContainer mainContainer = new BorderLayoutContainer();
		
		final NorthSouthContainer mainMenuBarContainer = new NorthSouthContainer();
		
		BorderLayoutData northData = new BorderLayoutData(28);
	    northData.setMargins(new Margins(1));
	    
	    mainMenuBarContainer.setNorthWidget(mainMenuBar);
		
		mainContainer.setNorthWidget(mainMenuBarContainer, northData);
		
		
		this.setWidget(mainContainer);
	}

	@Override
	public HasSelectionHandlers<Item> getLogoutMenuItem() {
		return mainMenuBar.getLogoutMenuItem();
	}


}
