public class CourierWithNullLogin {
    public final String login;
    public final String password;

    public CourierWithNullLogin(String login, String password){
        this.login = login;
        this.password = password;
    }

    public static CourierCredentials from(Courier courier) {
        return new CourierWithNullLogin("",courier.password);
    }
}

