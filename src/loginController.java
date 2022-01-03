import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sound.sampled.SourceDataLine;

import com.mysql.cj.xdevapi.Statement;
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

public class loginController {

    // Navigation Variables

    private Stage stage;
    private Scene scene;
    private Parent root;


    // Labels

    @FXML
    private Label label_password;

    @FXML
    private Label label_username;
    
    // Buttons

    @FXML
    private Button button_clear;

    @FXML
    private Button button_login;

    // Text Fields

    @FXML
    private TextField field_username;

    @FXML
    private PasswordField field_password;

    // OnAction Events

    @FXML
    void loginMethod(ActionEvent event) {

        // Text/Password Field Values
        String userName = field_username.getText();
        String userPassword = field_password.getText();

        // Create Object of Database Access Class
        mySQLAccess user  = new mySQLAccess(userName, userPassword);

        // Run relevant mySQL class Methods
        try{
        if(user.checkUser() == true){
            root = FXMLLoader.load(getClass().getResource("loggedin.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if(user.checkUser() == false){
            System.out.println("Error: UserName Does Not Exist");
            System.out.println("Please Create A New Account");
        }
        }catch(IOException e){
            e.printStackTrace();
        }
        }

    @FXML
    void clearMethod(ActionEvent event) {
        field_username.clear();
        field_password.clear();
    }

    @FXML
    void navsignup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    

}
