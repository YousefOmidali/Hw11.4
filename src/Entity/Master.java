package Entity;

public class Master {
    private String userName ;
    private String password ;
    private String firstName ;
    private String lastName ;
    private Integer tedadJalasatTadris;
    private MasterLevel masterLevel;


    public Master(String userName, String password, String firstName, String lastName, Integer tedadJalasatTadris, MasterLevel masterLevel) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tedadJalasatTadris = tedadJalasatTadris;
        this.masterLevel = masterLevel;
    }

    public MasterLevel getMasterLevel() {
        return masterLevel;
    }

    public void setMasterLevel(MasterLevel masterLevel) {
        this.masterLevel = masterLevel;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTedadJalasatTadris() {
        return tedadJalasatTadris;
    }

    public void setTedadJalasatTadris(Integer tedadJalasatTadris) {
        this.tedadJalasatTadris = tedadJalasatTadris;
    }

    @Override
    public String toString() {
        return "Master{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tedadJalasatTadris=" + tedadJalasatTadris +
                ", masterLevel=" + masterLevel +
                '}';
    }
}
