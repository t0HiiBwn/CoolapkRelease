package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_DeviceParams;
import com.coolapk.market.model.C$AutoValue_DeviceParams;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class DeviceParams implements Entity {
    public static final DeviceParams EMPTY_PARAMS = newBuilder().build();

    public static abstract class Builder {
        public abstract DeviceParams build();

        public abstract Builder checkBox(int i);

        public abstract Builder dateline(Long l);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder id(String str);

        public abstract Builder key(String str);

        public abstract Builder lastUpdate(Long l);

        public abstract Builder logo(String str);

        public abstract Builder option(List<String> list);

        public abstract Builder pic(String str);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder url(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract int getCheckBox();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "deviceParams";
    }

    public abstract String getKey();

    public abstract List<String> getOption();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public Builder builder() {
        return newBuilder(this);
    }

    public static Builder newBuilder(DeviceParams deviceParams) {
        return new C$$AutoValue_DeviceParams.Builder(deviceParams);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_DeviceParams.Builder().title("").key("").option(null).checkBox(0);
    }

    public static TypeAdapter<DeviceParams> typeAdapter(Gson gson) {
        return new C$AutoValue_DeviceParams.GsonTypeAdapter(gson);
    }
}
