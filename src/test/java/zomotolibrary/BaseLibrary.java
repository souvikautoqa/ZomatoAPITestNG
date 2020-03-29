package zomotolibrary;

import core.APIMethods;
import core.Config;
import core.Environments;
import core.RestSession;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    
    
    public ResponseBody getCities(String cityName, int cityCount) throws Exception {
        session = new RestSession();
        Map params = new HashMap() {{put("q", cityName);put("count", cityCount);}};
        Response resp = session.sendRequest(APIMethods.GET_ZOMATO_CITIES, Config.zomatoUserKey,params);
        Assert.assertEquals(resp.getStatusCode(),200);
        return resp.getBody();
    }
    


}
