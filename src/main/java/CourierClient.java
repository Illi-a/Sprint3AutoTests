import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class CourierClient extends RestAssuredClient{
    private static final String COURIER_PATH = "api/v1/courier";

    @Step
    public boolean create(Courier courier){
        return given()
                     .spec(getBaseSpec())
                    .body(courier)
                    .when()
                    .post(COURIER_PATH)
                     .then()
                     .assertThat()
                     .statusCode(201)
                     .extract()
                     .path("ok");
    }
    @Step
    public int login(CourierCredentials credentials) {
        return given()
                    .spec(getBaseSpec())
                    .body(credentials)
                    .when()
                    .post(COURIER_PATH + "login/")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .path("id");
    }
    @Step
    public boolean delete(int courierId){
        return given()
                    .spec(getBaseSpec())
                    .when()
                    .delete(COURIER_PATH + courierId)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .path("ok");
    }
    @Step
    public boolean get(int courierId){
        return given()
                .spec(getBaseSpec())
                .when()
                .get(COURIER_PATH + courierId +"/ordersCount")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");
    }

}
