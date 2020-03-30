package zomatotest;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import zomotolibrary.BaseLibrary;

public class ZomatoTests extends BaseLibrary {

   @Test
    public void VerifyZomatoCollectionCount() throws Exception {
        List<HashMap> locations = getCities("Dublin",5);
        Integer cityId = (Integer) locations.get(0).get("id");
        Assert.assertEquals(getCollections(cityId,5).size(), 5,"Unable to retrieve restaurant collections");
    }
    
    @Test
    public void VerifyLocationInfoPopulatedCorrectly() throws Exception {
    	String[] zones = {"Tallaght,Dublin","London"};
    	for(String zone : zones) {
    		HashMap location = getLocationInfo(zone);
    		String entityType = String.valueOf(location.get("entity_type"));
    		int entityId = (Integer) location.get("entity_id");
    		Assert.assertEquals(getLocationDetails(entityId,entityType) >= 1,true,"Unable to retrieve location details");
    	}
    }

}
