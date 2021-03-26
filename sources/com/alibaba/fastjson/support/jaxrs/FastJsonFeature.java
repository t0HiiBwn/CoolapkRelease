package com.alibaba.fastjson.support.jaxrs;

import java.util.Map;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;

public class FastJsonFeature implements Feature {
    private static final String JSON_FEATURE = "FastJsonFeature";

    public boolean configure(FeatureContext featureContext) {
        try {
            Configuration configuration = featureContext.getConfiguration();
            Map properties = configuration.getProperties();
            RuntimeType runtimeType = configuration.getRuntimeType();
            String str = JSON_FEATURE;
            if (!str.equalsIgnoreCase((String) CommonProperties.getValue(properties, runtimeType, "jersey.config.jsonFeature", str, String.class))) {
                return false;
            }
            featureContext.property(PropertiesHelper.getPropertyNameForRuntime("jersey.config.jsonFeature", configuration.getRuntimeType()), str);
            if (!configuration.isRegistered(FastJsonProvider.class)) {
                featureContext.register(FastJsonProvider.class, new Class[]{MessageBodyReader.class, MessageBodyWriter.class});
            }
            return true;
        } catch (NoSuchMethodError unused) {
        }
    }
}
