import ch.halabi.model.SqliteConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView logoImageview;

    @FXML
    private JFXButton cancelLoginBtn;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private Label loginLabel;


    @FXML
    void cancelLogin(ActionEvent event) {
        Stage stage = (Stage) cancelLoginBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void login(ActionEvent event) throws IOException {

        String signedinAs = usernameField.getText();

        if (SqliteConnection.isValidLogin(usernameField.getText(), passwordField.getText())) {

            loginLabel.setText("");


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MainWindow.fxml"));

            Parent mainWindow = loader.load();
            MainWindowController controller = loader.getController();
            controller.getSignedinAsLabel().setText(controller.getSignedinAsLabel().getText() + " " + signedinAs);

            Stage mainStage = new Stage();
            mainStage.setTitle("Main Window");
            mainStage.setScene(new Scene(mainWindow));
            mainStage.setResizable(false);

            Stage logInStage = (Stage) anchorPane.getScene().getWindow();
            logInStage.close();
            mainStage.show();
        } else {
            loginLabel.setText("Incorrect username or password");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
