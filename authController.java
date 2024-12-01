package org.example.librarymanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class authController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lastnameSignup;

    @FXML
    private TextField loginSignin;

    @FXML
    private TextField loginSignup;

    @FXML
    private TextField nameSignup;

    @FXML
    private PasswordField passwordSignin;

    @FXML
    private PasswordField passwordSignup;

    @FXML
    private Button signinButton;

    @FXML
    private Button signupButton;

    @FXML
    void initialize() {
        assert lastnameSignup != null : "fx:id=\"lastnameSignup\" was not injected: check your FXML file 'authorization.fxml'.";
        assert loginSignin != null : "fx:id=\"loginSignin\" was not injected: check your FXML file 'authorization.fxml'.";
        assert loginSignup != null : "fx:id=\"loginSignup\" was not injected: check your FXML file 'authorization.fxml'.";
        assert nameSignup != null : "fx:id=\"nameSignup\" was not injected: check your FXML file 'authorization.fxml'.";
        assert passwordSignin != null : "fx:id=\"passwordSignin\" was not injected: check your FXML file 'authorization.fxml'.";
        assert passwordSignup != null : "fx:id=\"passwordSignup\" was not injected: check your FXML file 'authorization.fxml'.";
        assert signinButton != null : "fx:id=\"signinButton\" was not injected: check your FXML file 'authorization.fxml'.";
        assert signupButton != null : "fx:id=\"signupButton\" was not injected: check your FXML file 'authorization.fxml'.";

    }

}

