package core;

import java.util.HashMap;

public class APIMethod implements EndPoint {

    private String hostUrl;
    private String methodName;
    private HttpMethod httpMethod;
    private HashMap<String, String> params = new HashMap<>();
    private ParametersType reqParamType = ParametersType.JSON;
    private String methodUrlWithParam;

    public APIMethod(String hostUrl, String methodName, HttpMethod httpMethod, ParametersType paramType) {
        this.httpMethod = httpMethod;
        this.reqParamType = paramType;
        this.hostUrl = hostUrl;
    }

    public APIMethod(String hostUrl, String methodName, HttpMethod httpMethod) {
        this.methodName = methodName;
        this.httpMethod = httpMethod;
        this.hostUrl = hostUrl;
    }

    public void addMethodParam(String param) {
        if(this.methodUrlWithParam.contains("@@param")){
                this.methodName = this.methodUrlWithParam;
           this.methodName =  this.methodName.replaceFirst("@@param",param);
        }
    }

    @Override
    public String getRestMethodPath() {
        return methodName;
    }

    @Override
    public String getHostUrl() {
        return hostUrl;
    }

    @Override
    public HttpMethod getRestHttpMethodType() {
        return httpMethod;
    }

    @Override
    public ParametersType getRestParametersType() {
        return reqParamType;
    }
}
