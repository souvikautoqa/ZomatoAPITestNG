package zomatotest;

import org.testng.annotations.Test;
import zomotolibrary.BaseLibrary;

public class ZomatoTests extends BaseLibrary {

    @Test
    public void TC001() throws Exception {
        getRestaurantCategories();
        getCities("Dublin",5);

    }

}
