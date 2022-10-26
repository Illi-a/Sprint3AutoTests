public class CourierWithNullPassword {
    public final String login;
    public final String password;

    public CourierWithNullPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CourierCredentials from(Courier courier) {
        return new CourierWithNullPassword(courier.login, "");
    }
}

