package androiddev1631292.champlain.radioplayer.Models;

public class User {
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";


    // DB create
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_USERNAME + " TEXT"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASSWORD + " TEXT)";


    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User()
    {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUnique (String search)
    {
        if(username == search)
        {
            return true;
        }
        if(password == search)
        {
            return true;
        }

        return false;
    }



}
