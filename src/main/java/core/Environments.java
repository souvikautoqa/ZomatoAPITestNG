package core;



import static core.Config.ENV;

public class Environments {

    private static String zomatoEndPoint;

    public static void load() {
        if (ENV.equalsIgnoreCase("DEV")) {
            zomatoEndPoint = "https://developers.zomato.com/api/v2.1";
        }

        if (ENV.equalsIgnoreCase("INT")) {
            zomatoEndPoint = "https://developers.zomato.com/api/v2.1";
        }

        if (ENV.equalsIgnoreCase("PREPROD")) {
            zomatoEndPoint = "https://developers.zomato.com/api/v2.1";
        }

        if (ENV.equalsIgnoreCase("PROD")) {
            zomatoEndPoint = "https://developers.zomato.com/api/v2.1";
        }
    }

    public static String getZomatoEndPoint() {
        return zomatoEndPoint;
    }


}
