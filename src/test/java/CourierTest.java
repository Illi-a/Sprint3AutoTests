import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourierTest {

    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @After
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @Test
    public void checkCouriercanBeCreated() {
        // Arrange
        Courier courier = Courier.getRandom();

        // Act
        boolean isCourierCreated = courierClient.create(courier);
        courierId = courierClient.login(CourierCredentials.from(courier));

        // Assert
        assertTrue("Courier is not created", isCourierCreated);
        assertThat("Courier ID is incorrect", courierId, is(not(0)));
    }

    @Test
    public void twoSameCourierCantBeCreated() {
        Courier courier = Courier.getRandom();

        boolean isCourierCreated = courierClient.create(courier);
        courierId = courierClient.login(CourierCredentials.from(courier));
        boolean secondCourierCreated = courierClient.create(courier);

        assertTrue("First courier is not created", isCourierCreated);
        assertFalse("Second courier with same credentials created :|", secondCourierCreated);
    }



        @Test
        public void loginWithCorrectDataTest(){

        Courier courier = Courier.getRandom();

        boolean isCourierCreated = courierClient.create(courier);
        courierId = courierClient.login(CourierCredentials.from(courier));
        assertTrue(isCourierCreated);
    }

    @Test
    public void loginWithNoPassword() {
        Courier courier = Courier.getRandom();

        boolean isCourierCreated = courierClient.create(courier);
        courierId = courierClient.login(CourierWithNullPassword.from(courier));
        assertTrue(isCourierCreated);

    }






    @Test
    public void getStatusCodeTest() {
        Courier courier = Courier.getRandom();
        boolean isCourierCreated = courierClient.create(courier);
        courierId = courierClient.login(CourierCredentials.from(courier));
        boolean isGetWorkingWell = courierClient.get(courierId);

        assertTrue("First courier is not created", isCourierCreated);
        assertTrue("Status code isn't 200", isGetWorkingWell);
    }

}
