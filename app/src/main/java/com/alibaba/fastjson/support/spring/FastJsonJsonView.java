package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

public class FastJsonJsonView extends AbstractView {
    private static final Pattern CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
    public static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";
    public static final String DEFAULT_JSONP_CONTENT_TYPE = "application/javascript";
    @Deprecated
    protected Charset charset = Charset.forName("UTF-8");
    @Deprecated
    protected String dateFormat;
    private boolean disableCaching = true;
    private boolean extractValueFromSingleKeyModel = false;
    private FastJsonConfig fastJsonConfig = new FastJsonConfig();
    @Deprecated
    protected SerializerFeature[] features = new SerializerFeature[0];
    @Deprecated
    protected SerializeFilter[] filters = new SerializeFilter[0];
    private String[] jsonpParameterNames = {"jsonp", "callback"};
    private Set<String> renderedAttributes;
    private boolean updateContentLength = true;

    public FastJsonJsonView() {
        setContentType("application/json;charset=UTF-8");
        setExposePathVariables(false);
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig2) {
        this.fastJsonConfig = fastJsonConfig2;
    }

    @Deprecated
    public void setSerializerFeature(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public void setCharset(Charset charset2) {
        this.fastJsonConfig.setCharset(charset2);
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public void setRenderedAttributes(Set<String> set) {
        this.renderedAttributes = set;
    }

    public boolean isExtractValueFromSingleKeyModel() {
        return this.extractValueFromSingleKeyModel;
    }

    public void setExtractValueFromSingleKeyModel(boolean z) {
        this.extractValueFromSingleKeyModel = z;
    }

    public void setJsonpParameterNames(Set<String> set) {
        Assert.notEmpty(set, "jsonpParameterName cannot be empty");
        this.jsonpParameterNames = (String[]) set.toArray(new String[set.size()]);
    }

    private String getJsonpParameterValue(HttpServletRequest httpServletRequest) {
        String[] strArr = this.jsonpParameterNames;
        if (strArr == null) {
            return null;
        }
        for (String str : strArr) {
            String parameter = httpServletRequest.getParameter(str);
            if (IOUtils.isValidJsonpQueryParam(parameter)) {
                return parameter;
            }
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Ignoring invalid jsonp parameter value: " + parameter);
            }
        }
        return null;
    }

    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JSONPObject jSONPObject;
        Object filterModel = filterModel(map);
        String jsonpParameterValue = getJsonpParameterValue(httpServletRequest);
        if (jsonpParameterValue != null) {
            JSONPObject jSONPObject2 = new JSONPObject(jsonpParameterValue);
            jSONPObject2.addParameter(filterModel);
            jSONPObject = jSONPObject2;
        } else {
            jSONPObject = filterModel;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int writeJSONString = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), jSONPObject, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        if (this.updateContentLength) {
            httpServletResponse.setContentLength(writeJSONString);
        }
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        byteArrayOutputStream.writeTo(outputStream);
        byteArrayOutputStream.close();
        outputStream.flush();
    }

    protected void prepareResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        setResponseContentType(httpServletRequest, httpServletResponse);
        httpServletResponse.setCharacterEncoding(this.fastJsonConfig.getCharset().name());
        if (this.disableCaching) {
            httpServletResponse.addHeader("Pragma", "no-cache");
            httpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
            httpServletResponse.addDateHeader("Expires", 1);
        }
    }

    public void setDisableCaching(boolean z) {
        this.disableCaching = z;
    }

    public void setUpdateContentLength(boolean z) {
        this.updateContentLength = z;
    }

    protected Object filterModel(Map<String, Object> map) {
        Set<String> set;
        HashMap hashMap = new HashMap(map.size());
        if (!CollectionUtils.isEmpty(this.renderedAttributes)) {
            set = this.renderedAttributes;
        } else {
            set = map.keySet();
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!(entry.getValue() instanceof BindingResult) && set.contains(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (this.extractValueFromSingleKeyModel && hashMap.size() == 1) {
            Iterator it2 = hashMap.entrySet().iterator();
            if (it2.hasNext()) {
                return ((Map.Entry) it2.next()).getValue();
            }
        }
        return hashMap;
    }

    protected void setResponseContentType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (getJsonpParameterValue(httpServletRequest) != null) {
            httpServletResponse.setContentType("application/javascript");
        } else {
            FastJsonJsonView.super.setResponseContentType(httpServletRequest, httpServletResponse);
        }
    }
}
