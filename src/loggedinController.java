import java.io.IOError;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

public class loggedinController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button button_signout;

    @FXML
    private Label label_username1;

    @FXML
    void signOut(ActionEvent event) throws IOException{
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

}
