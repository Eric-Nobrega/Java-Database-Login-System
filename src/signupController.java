import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class signupController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button button_login1;

    @FXML
    private Button button_login11;

    @FXML
    private PasswordField field_password;

    @FXML
    private TextField field_username;

    @FXML
    private Label label_password;

    @FXML
    private Label label_username;

    @FXML
    private Label label_username1;

    @FXML
    private Label label_username11;

    @FXML
    void signUp(ActionEvent event) {
        
        // Text/Password Field Values
        String userName = field_username.getText();
        String userPassword = field_password.getText();

        // Create Object of Database Access Class
        mySQLAccess user  = new mySQLAccess(userName, userPassword);

        user.createUser();
    }

    @FXML
    void navBack(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
