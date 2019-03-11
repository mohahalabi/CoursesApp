import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLauncher extends Application {


    public static void main(String[] args) {
        launch(AppLauncher.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent login = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        stage.setTitle("Logging in");
        stage.setScene(new Scene(login));
        stage.setResizable(false);
        stage.show();
    }
}
