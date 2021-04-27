package se.hkr;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import se.hkr.core.AuthProvider;
import se.hkr.core.BalanceProvider;

public class Controller extends MockBalanceProvider {

    public TextField username;
    public PasswordField password;
    public Text balance;
    public Button login;

    public void onPressLogin() {
        String username = this.username.getText();
        String password = this.password.getText();

        int id = AuthProvider.getInstance().login(username, password);
        if (id != -1) {
            this.username.setVisible(false);
            this.password.setVisible(false);
            this.login.setVisible(false);

            int balance = BalanceProvider.getInstance().provideBalance(id);
            this.balance.setText(String.format("Welcome %s your balance is %s.", username, balance));
        }
    }
}
