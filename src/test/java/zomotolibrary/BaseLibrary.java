package zomotolibrary;

import core.APIMethods;
import core.Config;
import core.Environments;
import core.RestSession;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
    
    @SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public List<HashMap> getCities(String cityName, int cityCount) throws Exception {
        session = new RestSession();
        Map params = new HashMap() {{put("q", cityName);put("count", cityCount);}};
        Response resp = session.sendRequest(APIMethods.GET_ZOMATO_CITIES, Config.zomatoUserKey,params);
        Assert.assertEquals(resp.getStatusCode(),200);
        List<Object> locations = resp.jsonPath().getList("location_suggestions");
		List<HashMap> locationMap = (List<HashMap>) (List<?>) locations;
        return locationMap;
    }


    @SuppressWarnings({ "rawtypes", "unchecked", "serial", "unused" })
    public List<HashMap> getCollections(int cityId, int collectionCount) throws Exception {
    	 session = new RestSession();
    	 Map params = new HashMap() {{put("city_id", cityId);put("count", collectionCount);}};
    	 Response resp = session.sendRequest(APIMethods.GET_ZOMATO_COLLECTIONS, Config.zomatoUserKey,params);
    	 Assert.assertEquals(resp.getStatusCode(),200);
    	 List<Object> collections = resp.jsonPath().getList("collections");
    	 List<HashMap> locationMap = new ArrayList();
    	 for(Object collection : collections) {
    		 locationMap.add(((HashMap)((HashMap) collection).get("collection")));
    	 }
    	 return locationMap;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked", "serial", "unused" })
    public HashMap getLocationInfo(String query) throws Exception {
    	 session = new RestSession();
    	 Map params = new HashMap() {{put("query", query);}};
    	 Response resp = session.sendRequest(APIMethods.GET_ZOMATO_LOCATIONS, Config.zomatoUserKey,params);
    	 Assert.assertEquals(resp.getStatusCode(),200);
    	 List<Object> locations = resp.jsonPath().getList("location_suggestions");
    	 return ((HashMap)locations.get(0));
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked", "serial", "unused" })
    public int getLocationDetails(int entityId, String entityType) throws Exception {
    	 session = new RestSession();
    	 Map params = new HashMap() {{put("entity_id", entityId);put("entity_type", entityType);}};
    	 Response resp = session.sendRequest(APIMethods.GET_ZOMATO_LOCATIONS_DETAILS, Config.zomatoUserKey,params);
    	 Assert.assertEquals(resp.getStatusCode(),200);
    	 return ((Integer) resp.jsonPath().get("num_restaurant"));
    }
    


}
