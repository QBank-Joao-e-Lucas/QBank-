
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Usuario {
    private String username;
    private String password;
    private boolean isBlocked = false;
    private int failedAttempts = 0;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void incrementFailedAttempts() {
        this.failedAttempts++;
    }

    public void resetFailedAttempts() {
        this.failedAttempts = 0;
    }

    public void blockAccount() {
        this.isBlocked = true;
    }

    public void unblockAccount() {
        this.isBlocked = false;
    }
}


