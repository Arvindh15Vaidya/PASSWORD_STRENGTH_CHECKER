import java.util.Arrays;
import java.util.List;

public class PasswordTest {

    public static void main(String[] args) {
        List<String> testPasswords = Arrays.asList(
                "123456", 
                "Password", 
                "Strong@1234", 
                "VeryStrongPassword@2024", 
                "Short1"
        );

        for (String password : testPasswords) {
            int strength = PasswordStrengthChecker.checkPasswordStrength(password);
            System.out.println("Password: " + password + " - Strength: " + 
                (strength == 1 ? "Weak" : strength == 2 ? "Moderate" : "Strong"));
        }
    }
}
