package core;

public class APIMethods {

    public static APIMethod GET_ZOMATO_CATEGORIES = new APIMethod(Environments.getZomatoEndPoint(), "categories", HttpMethod.GET);
    public static APIMethod GET_ZOMATO_CITIES = new APIMethod(Environments.getZomatoEndPoint(), "cities", HttpMethod.GET);

}
