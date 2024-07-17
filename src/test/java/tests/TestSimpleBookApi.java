package tests;

import io.restassured.response.Response;
import objects.ManageObjects;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSimpleBookApi {

    private ManageObjects manageObjects;

    @BeforeClass
    public void setUp() {
        manageObjects = new ManageObjects();
    }

    @Test
    public void getListOfBooks(){
        Response response = manageObjects.getAuthApi().getListOfBooks();
        manageObjects.getAuthApi().verifyResponseIsNotNull(response);
    }

    @Test
    public void submitOrder(){
        Response response = manageObjects.getAuthApi().submitOrder();
        manageObjects.getAuthApi().verifyResponseIsNotNull(response);
    }
}
