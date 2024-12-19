public class PasswordStrengthChecker {

    public static int checkPasswordStrength(String password) {
        int strength = 0;

        if (password.length() >= 12) strength++;
        if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")) strength++;
        if (password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) strength++;
        if (password.length() >= 16 && password.matches(".*[^\\s].*")) strength++;

        return strength;
    }
}
