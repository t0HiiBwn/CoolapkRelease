package com.coolapk.market.remote;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.network.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class ModelConverterFactory extends Converter.Factory {
    private final Type entityListType = new TypeToken<Result<List<Entity>>>() {
        /* class com.coolapk.market.remote.ModelConverterFactory.AnonymousClass1 */
    }.getType();
    private final Type entityType = new TypeToken<Result<Entity>>() {
        /* class com.coolapk.market.remote.ModelConverterFactory.AnonymousClass2 */
    }.getType();
    private final Type feedListType = new TypeToken<Result<List<Feed>>>() {
        /* class com.coolapk.market.remote.ModelConverterFactory.AnonymousClass5 */
    }.getType();
    private final Gson gson;
    private final Type jsonArrType = new TypeToken<Result<JSONArray>>() {
        /* class com.coolapk.market.remote.ModelConverterFactory.AnonymousClass4 */
    }.getType();
    private final Type jsonObjType = new TypeToken<Result<JSONObject>>() {
        /* class com.coolapk.market.remote.ModelConverterFactory.AnonymousClass3 */
    }.getType();
    private final Type userProfileType = new TypeToken<Result<UserProfile>>() {
        /* class com.coolapk.market.remote.ModelConverterFactory.AnonymousClass6 */
    }.getType();

    public static ModelConverterFactory create(Gson gson2) {
        return new ModelConverterFactory(gson2);
    }

    private ModelConverterFactory(Gson gson2) {
        this.gson = gson2;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type.equals(this.jsonObjType)) {
            return new JSONObjectResponseBodyConvert();
        }
        if (type.equals(this.jsonArrType)) {
            return new JSONArrayResponseBodyConvert();
        }
        if (type.equals(this.entityListType)) {
            return new EntityListResponseBodyConverter(this.gson);
        }
        if (type.equals(this.entityType)) {
            return new EntityResponseBodyConverter(this.gson);
        }
        if (type.equals(this.userProfileType)) {
            return new UserProfileResponseBodyConvert(this.gson);
        }
        return new GsonResponseBodyConverter(this.gson.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }
}
