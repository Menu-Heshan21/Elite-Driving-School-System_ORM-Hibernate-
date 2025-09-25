package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.util.AdminManager;

import java.io.IOException;

public class AdminLoginController {

    public TextField txtUsername;
    public PasswordField txtPassword;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD_HASH = "$2a$10$p2imblLJjoi1k7KGSN2S2OLJ9rHz4C9TZpgbQtT2Ezjm1lmUNldgG";


    public void btnLoginOnAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.equals(ADMIN_USERNAME) && AdminManager.checkPassword(password, ADMIN_PASSWORD_HASH)) {
            try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
                Parent root = loader.load();

                DashboardController dashboardController = loader.getController();
                dashboardController.initialize("admin");

                Scene scene = new Scene(root);
                stage.setTitle("Driving school - Admin Dashboard");
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Failed to load dashboard!").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid Username or Password!").show();
        }
    }
}