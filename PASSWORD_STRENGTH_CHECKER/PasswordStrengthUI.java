import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PasswordStrengthUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Strength Checker");

        Label instructionLabel = new Label("Enter your password:");
        PasswordField passwordField = new PasswordField();
        Button checkButton = new Button("Check Strength");
        Label resultLabel = new Label();

        checkButton.setOnAction(event -> {
            String password = passwordField.getText();
            int strength = PasswordStrengthChecker.checkPasswordStrength(password);
            String strengthMessage;
            switch (strength) {
                case 1:
                    strengthMessage = "Weak";
                    break;
                case 2:
                    strengthMessage = "Moderate";
                    break;
                case 3:
                    strengthMessage = "Strong";
                    break;
                default:
                    strengthMessage = "Very Weak";
                    break;
            }
            resultLabel.setText("Password Strength: " + strengthMessage);
        });

        VBox layout = new VBox(10, instructionLabel, passwordField, checkButton, resultLabel);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class PasswordStrengthChecker {
    public static int checkPasswordStrength(String password) {
        if (password.length() < 6) {
            return 0; // Very Weak
        }
        int strength = 0;

        if (password.length() >= 8) strength++;
        if (password.matches(".*[a-z].*")) strength++;
        if (password.matches(".*[A-Z].*")) strength++;
        if (password.matches(".*\\d.*")) strength++;
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) strength++;

        if (strength <= 1) return 1; // Weak
        if (strength == 2 || strength == 3) return 2; // Moderate
        if (strength > 3) return 3; // Strong

        return 0; // Default to Very Weak
    }
}
