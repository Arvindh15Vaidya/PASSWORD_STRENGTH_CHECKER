import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        PasswordStrengthUI passwordStrengthUI = new PasswordStrengthUI();
        passwordStrengthUI.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
