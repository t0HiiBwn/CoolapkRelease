package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_EditorInfo;
import com.coolapk.market.model.C$AutoValue_EditorInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class EditorInfo implements CardContent {

    public static abstract class Builder {
        public abstract EditorInfo build();

        public abstract Builder editorLevel(String str);

        public abstract Builder newFollowNum(int i);

        public abstract Builder newSubmitNum(int i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getEditorLevel();

    public abstract int getNewFollowNum();

    public abstract int getNewSubmitNum();

    public static Builder newBuilder() {
        return new C$$AutoValue_EditorInfo.Builder().editorLevel("").newSubmitNum(0).newFollowNum(0);
    }

    public static Builder newBuilder(EditorInfo editorInfo) {
        if (editorInfo == null) {
            return newBuilder();
        }
        return new C$$AutoValue_EditorInfo.Builder(editorInfo);
    }

    public static TypeAdapter<EditorInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_EditorInfo.GsonTypeAdapter(gson);
    }
}
