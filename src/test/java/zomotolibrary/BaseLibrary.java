package zomotolibrary;

import core.APIMethods;
import core.Config;
import core.Environments;
import core.RestSession;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class BaseLibrary {

    private RestSession session;

    @BeforeTest
    public void initTest(){
        Environments.load();
    }

    public ResponseBody getRestaurantCategories() throws Exception {
        session = new RestSession();
        Response resp = session.sendRequest(APIMethods.GET_ZOMATO_CATEGORIES, Config.zomatoUserKey);
        Assert.assertEquals(resp.getStatusCode(),200);
        return resp.getBody();
    }


}
