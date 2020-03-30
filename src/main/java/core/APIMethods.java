package core;

public class APIMethods {

    public static APIMethod GET_ZOMATO_CATEGORIES = new APIMethod(Environments.getZomatoEndPoint(), "categories", HttpMethod.GET);
    public static APIMethod GET_ZOMATO_CITIES = new APIMethod(Environments.getZomatoEndPoint(), "cities", HttpMethod.GET);
    public static APIMethod GET_ZOMATO_COLLECTIONS = new APIMethod(Environments.getZomatoEndPoint(), "collections", HttpMethod.GET);
    public static APIMethod GET_ZOMATO_LOCATIONS = new APIMethod(Environments.getZomatoEndPoint(), "locations", HttpMethod.GET);
    public static APIMethod GET_ZOMATO_LOCATIONS_DETAILS = new APIMethod(Environments.getZomatoEndPoint(), "location_details", HttpMethod.GET);

}
