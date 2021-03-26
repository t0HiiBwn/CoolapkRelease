package com.coolapk.market.event;

import com.coolapk.market.model.UserProfile;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/event/UserProfileEvent;", "", "type", "", "result", "Lcom/coolapk/market/model/UserProfile;", "(Ljava/lang/String;Lcom/coolapk/market/model/UserProfile;)V", "getResult", "()Lcom/coolapk/market/model/UserProfile;", "getType", "()Ljava/lang/String;", "canMatchUpWith", "", "userProfile", "component1", "component2", "copy", "equals", "other", "hashCode", "", "patch", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserProfileEvent.kt */
public final class UserProfileEvent {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_TYPE_ADDRESS = "address_event";
    public static final String EVENT_TYPE_BIRTH = "birth_event";
    public static final String EVENT_TYPE_COVER = "cover_event";
    public static final String EVENT_TYPE_GENDER = "gender_event";
    public static final String EVENT_TYPE_SIGNATURE = "signature_event";
    private final UserProfile result;
    private final String type;

    public static /* synthetic */ UserProfileEvent copy$default(UserProfileEvent userProfileEvent, String str, UserProfile userProfile, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userProfileEvent.type;
        }
        if ((i & 2) != 0) {
            userProfile = userProfileEvent.result;
        }
        return userProfileEvent.copy(str, userProfile);
    }

    @JvmStatic
    public static final void dispatch(String str, UserProfile userProfile) {
        Companion.dispatch(str, userProfile);
    }

    public final String component1() {
        return this.type;
    }

    public final UserProfile component2() {
        return this.result;
    }

    public final UserProfileEvent copy(String str, UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(userProfile, "result");
        return new UserProfileEvent(str, userProfile);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserProfileEvent)) {
            return false;
        }
        UserProfileEvent userProfileEvent = (UserProfileEvent) obj;
        return Intrinsics.areEqual(this.type, userProfileEvent.type) && Intrinsics.areEqual(this.result, userProfileEvent.result);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        UserProfile userProfile = this.result;
        if (userProfile != null) {
            i = userProfile.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "UserProfileEvent(type=" + this.type + ", result=" + this.result + ")";
    }

    public UserProfileEvent(String str, UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(userProfile, "result");
        this.type = str;
        this.result = userProfile;
    }

    public final UserProfile getResult() {
        return this.result;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/event/UserProfileEvent$Companion;", "", "()V", "EVENT_TYPE_ADDRESS", "", "EVENT_TYPE_BIRTH", "EVENT_TYPE_COVER", "EVENT_TYPE_GENDER", "EVENT_TYPE_SIGNATURE", "dispatch", "", "type", "result", "Lcom/coolapk/market/model/UserProfile;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserProfileEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void dispatch(String str, UserProfile userProfile) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(userProfile, "result");
            EventBus.getDefault().post(new UserProfileEvent(str, userProfile));
        }
    }

    public final boolean canMatchUpWith(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "userProfile");
        return Intrinsics.areEqual(this.result.getUid(), userProfile.getUid());
    }

    public final UserProfile patch(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "userProfile");
        if (canMatchUpWith(userProfile)) {
            String str = this.type;
            switch (str.hashCode()) {
                case -410342769:
                    if (!str.equals("address_event")) {
                        return userProfile;
                    }
                    UserProfile build = UserProfile.builder(userProfile).setProvince(this.result.getProvince()).setCity(this.result.getCity()).build();
                    Intrinsics.checkNotNullExpressionValue(build, "UserProfile.builder(user…                 .build()");
                    return build;
                case -348261476:
                    if (!str.equals("gender_event")) {
                        return userProfile;
                    }
                    UserProfile build2 = UserProfile.builder(userProfile).setGender(this.result.getGender()).build();
                    Intrinsics.checkNotNullExpressionValue(build2, "UserProfile.builder(user…                 .build()");
                    return build2;
                case -288816045:
                    if (!str.equals("signature_event")) {
                        return userProfile;
                    }
                    UserProfile build3 = UserProfile.builder(userProfile).setSignature(this.result.getSignature()).build();
                    Intrinsics.checkNotNullExpressionValue(build3, "UserProfile.builder(user…                 .build()");
                    return build3;
                case 169100306:
                    if (!str.equals("cover_event")) {
                        return userProfile;
                    }
                    UserProfile build4 = UserProfile.builder(userProfile).setCover(this.result.getCover()).build();
                    Intrinsics.checkNotNullExpressionValue(build4, "UserProfile.builder(user…                 .build()");
                    return build4;
                case 1872264986:
                    if (!str.equals("birth_event")) {
                        return userProfile;
                    }
                    UserProfile build5 = UserProfile.builder(userProfile).setBirthday(this.result.getBirthday()).setBirthmonth(this.result.getBirthmonth()).setBirthyear(this.result.getBirthyear()).setZodiacSign(this.result.getZodiacSign()).build();
                    Intrinsics.checkNotNullExpressionValue(build5, "UserProfile.builder(user…                 .build()");
                    return build5;
                default:
                    return userProfile;
            }
        } else {
            throw new RuntimeException("YOU NEED TO CHECK canMatchUpWith METHOD FIRST");
        }
    }
}
