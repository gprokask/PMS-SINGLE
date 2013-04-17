package de.gp.pms.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuBar;
import com.sencha.gxt.widget.core.client.menu.MenuBarItem;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

public class MainMenuBar implements IsWidget {

	private final MenuItems menuItems = GWT.create(ViewLabels.class);
	
	private MenuItem logoutMenuItem;
	
	@Override
	public Widget asWidget() {
		// Session Menu
		Menu sessionMenu = new Menu();
		logoutMenuItem = new MenuItem(menuItems.session_menu());
		sessionMenu.add(logoutMenuItem);
		
		MenuBar mainmenuBar = new MenuBar();
		mainmenuBar.add(new MenuBarItem(menuItems.logout_menu(), sessionMenu));
		
		return mainmenuBar;
	}
	
	public HasSelectionHandlers<Item> getLogoutMenuItem() {
		return logoutMenuItem;
	}

}
