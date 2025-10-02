public class User {

    private String userName;
    private String password;
    private String contactNo;
    private String full_name;

    public User(String userName, String password, String contactNo, String full_name) {
        this.userName = userName;
        this.password = password;
        this.contactNo = contactNo;
        this.full_name = full_name;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                full_name+" ("+userName +")";

    }
}
