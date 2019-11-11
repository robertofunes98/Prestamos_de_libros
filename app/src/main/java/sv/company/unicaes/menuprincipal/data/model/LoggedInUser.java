package sv.company.unicaes.menuprincipal.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private int userType;

    public LoggedInUser(String userId, String displayName, int userType) {
        this.userId = userId;
        this.displayName = displayName;
        this.userType=userType;
    }

    public int getUserType() {
        return userType;
    }

    public String getDisplayName() {
        return displayName;
    }
}
