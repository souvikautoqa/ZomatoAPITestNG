package core;


import java.util.HashMap;
import java.util.Map;

public class Config {

    public static String ENV = System.getenv("env");
    public static Map zomatoUserKey = new HashMap() {{put("user-key", "04e2876a83296fdb7e5d606d49c7cf04");}};


}
