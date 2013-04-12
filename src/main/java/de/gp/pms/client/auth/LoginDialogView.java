package de.gp.pms.client.auth;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;

import de.gp.pms.client.ViewLabels;

public class LoginDialogView extends Dialog implements LoginDialogPresenter.Display {
	
	private TextField userid;
    private PasswordField password;
    private TextButton loginButton;
    private Label errorLabel;
    
    private final ViewLabels labels = GWT.create(ViewLabels.class);
    
    public LoginDialogView() {
        initComponents();
        composeLayout();
    }

    private void initComponents() {
        userid = new TextField();
        userid.setValue("");
        userid.addValidator(new MinLengthValidator(1));
        
        password = new PasswordField();
        password.setValue("");
        password.addValidator(new MinLengthValidator(1));
        
        loginButton = new TextButton(labels.login_button());
        errorLabel = new Label();
    }
    
    private void composeLayout() {
        setModal(true);
        setHeadingText(labels.login_title());
        setClosable(false);
        setPredefinedButtons();
        setWidth(300);
        setHeight(170);

        VerticalLayoutContainer vContainer = new VerticalLayoutContainer();
        vContainer.setWidth(300);

        vContainer.add(new FieldLabel(userid, labels.login_userid()));
        vContainer.add(new FieldLabel(password, labels.login_password()));

        vContainer.add(loginButton);
        
        vContainer.add(errorLabel);

        setWidget(vContainer);
    }

	@Override
	public HasSelectHandlers getLoginButton() {
		return loginButton;
	}
	
	@Override
	public HasValue<String> getUseridValue() {
        return userid;
    }

	@Override
    public HasValue<String> getPasswordValue() {
        return password;
    }

	@Override
	public HasText getErrorValue() {
		return errorLabel;
	}

}
