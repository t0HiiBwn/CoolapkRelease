package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

public class JsonRpcResponse {
    @JsonProperty
    public JSONObject error;
    @JsonProperty(required = true)
    public long id;
    @JsonProperty
    public JSONObject result;
}
