package com.coolapk.market.view.feedv8.draft;

import com.coolapk.market.extend.FeedMultiPartExtendsKt;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.view.feedv8.draft.RoughDraft;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ \u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000eJ\b\u0010$\u001a\u00020\u0017H\u0002J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000eJ\u0016\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000eJ\f\u0010,\u001a\u00020(*\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\b¨\u0006."}, d2 = {"Lcom/coolapk/market/view/feedv8/draft/RoughDraftHelper;", "", "()V", "editingDraftId", "", "oldSavePath", "Ljava/io/File;", "getOldSavePath", "()Ljava/io/File;", "oldSavePath$delegate", "Lkotlin/Lazy;", "originDraftId", "roughDraftList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/view/feedv8/draft/RoughDraft;", "Lkotlin/collections/ArrayList;", "getRoughDraftList", "()Ljava/util/ArrayList;", "roughDraftList$delegate", "savedPath", "getSavedPath", "savedPath$delegate", "clearAll", "", "generateDraftID", "getSimilarDraft", "multiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "uiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "jsonToList", "json", "listToJsonString", "loadJsonFromDisk", "remove", "draft", "saveToDisk", "setEditing", "setEditingDraftSaveToDisk", "save", "", "removeIfFromBox", "startEditing", "startEditingFromBox", "isAvailableFile", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RoughDraftHelper.kt */
public final class RoughDraftHelper {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "rough_draft";
    private static final Lazy instance$delegate = LazyKt.lazy(RoughDraftHelper$Companion$instance$2.INSTANCE);
    private String editingDraftId;
    private final Lazy oldSavePath$delegate;
    private String originDraftId;
    private final Lazy roughDraftList$delegate;
    private final Lazy savedPath$delegate;

    public static final RoughDraftHelper getInstance() {
        return Companion.getInstance();
    }

    private final File getOldSavePath() {
        return (File) this.oldSavePath$delegate.getValue();
    }

    private final File getSavedPath() {
        return (File) this.savedPath$delegate.getValue();
    }

    public final ArrayList<RoughDraft> getRoughDraftList() {
        return (ArrayList) this.roughDraftList$delegate.getValue();
    }

    private RoughDraftHelper() {
        this.roughDraftList$delegate = LazyKt.lazy(new RoughDraftHelper$roughDraftList$2(this));
        this.oldSavePath$delegate = LazyKt.lazy(RoughDraftHelper$oldSavePath$2.INSTANCE);
        this.savedPath$delegate = LazyKt.lazy(RoughDraftHelper$savedPath$2.INSTANCE);
    }

    public /* synthetic */ RoughDraftHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feedv8/draft/RoughDraftHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/coolapk/market/view/feedv8/draft/RoughDraftHelper;", "getInstance$annotations", "getInstance", "()Lcom/coolapk/market/view/feedv8/draft/RoughDraftHelper;", "instance$delegate", "Lkotlin/Lazy;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RoughDraftHelper.kt */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        public final RoughDraftHelper getInstance() {
            Lazy lazy = RoughDraftHelper.instance$delegate;
            Companion companion = RoughDraftHelper.Companion;
            return (RoughDraftHelper) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RoughDraftHelper.TAG;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x01bc A[SYNTHETIC] */
    public final RoughDraft getSimilarDraft(FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(feedMultiPart, "multiPart");
        Intrinsics.checkNotNullParameter(feedUIConfig, "uiConfig");
        T t = null;
        if (!feedMultiPart.imageUriList().isEmpty()) {
            return null;
        }
        ArrayList<RoughDraft> roughDraftList = getRoughDraftList();
        if (roughDraftList.size() > 1) {
            CollectionsKt.sortWith(roughDraftList, new RoughDraftHelper$getSimilarDraft$$inlined$sortByDescending$1());
        }
        if ((!Intrinsics.areEqual(feedMultiPart.type(), "feed")) || feedUIConfig.isShowInArticleMode()) {
            return null;
        }
        String targetId = feedMultiPart.targetId();
        Intrinsics.checkNotNullExpressionValue(targetId, "multiPart.targetId()");
        if (targetId.length() > 0) {
            return null;
        }
        String id = feedMultiPart.id();
        Intrinsics.checkNotNullExpressionValue(id, "multiPart.id()");
        if (id.length() > 0) {
            return null;
        }
        Iterator<T> it2 = getRoughDraftList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            T t2 = next;
            FeedMultiPart multiPart = t2.getMultiPart();
            FeedUIConfig uiConfig = t2.getUiConfig();
            if (Intrinsics.areEqual(multiPart.targetId(), feedMultiPart.targetId()) && Intrinsics.areEqual(multiPart.forwardId(), feedMultiPart.forwardId()) && Intrinsics.areEqual(multiPart.feedId(), feedMultiPart.feedId())) {
                String message = multiPart.message();
                Intrinsics.checkNotNullExpressionValue(message, "itsMultiPart.message()");
                String message2 = feedMultiPart.message();
                Intrinsics.checkNotNullExpressionValue(message2, "multiPart.message()");
                if (StringsKt.contains$default((CharSequence) message, (CharSequence) message2, false, 2, (Object) null) && Intrinsics.areEqual(multiPart.messageTitle(), feedMultiPart.messageTitle()) && Intrinsics.areEqual(multiPart.type(), feedMultiPart.type()) && Intrinsics.areEqual(multiPart.extraPic(), feedMultiPart.extraPic()) && Intrinsics.areEqual(multiPart.extraUrl(), feedMultiPart.extraUrl()) && Intrinsics.areEqual(multiPart.extraKey(), feedMultiPart.extraKey()) && multiPart.mediaType() == feedMultiPart.mediaType() && Intrinsics.areEqual(multiPart.mediaUrl(), feedMultiPart.mediaUrl()) && Intrinsics.areEqual(multiPart.dyhId(), feedMultiPart.dyhId()) && Intrinsics.areEqual(multiPart.mediaInfo(), feedMultiPart.mediaInfo()) && Intrinsics.areEqual(multiPart.targetType(), feedMultiPart.targetType()) && multiPart.insertProductMedia() == feedMultiPart.insertProductMedia()) {
                    if (!Intrinsics.areEqual(feedMultiPart.type(), "answer") && uiConfig.isShowInArticleMode() != feedUIConfig.isShowInArticleMode()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2 && Intrinsics.areEqual(uiConfig.topicTitle(), feedUIConfig.topicTitle()) && Intrinsics.areEqual(uiConfig.questionTitle(), feedUIConfig.questionTitle()) && Intrinsics.areEqual(uiConfig.dyhTitle(), feedUIConfig.dyhTitle()) && uiConfig.isPickPhotoContainerVisible() == feedUIConfig.isPickPhotoContainerVisible()) {
                        z = true;
                        continue;
                        if (z) {
                            t = next;
                            break;
                        }
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        return t;
    }

    public final void startEditing(RoughDraft roughDraft) {
        Intrinsics.checkNotNullParameter(roughDraft, "draft");
        String str = null;
        this.editingDraftId = str;
        this.originDraftId = str;
        setEditing(roughDraft);
    }

    public final void startEditingFromBox(RoughDraft roughDraft) {
        T t;
        Intrinsics.checkNotNullParameter(roughDraft, "draft");
        if (!Intrinsics.areEqual(this.editingDraftId, roughDraft.getId()) || this.originDraftId == null) {
            this.editingDraftId = null;
            this.originDraftId = roughDraft.getBackupId();
            while (true) {
                Iterator<T> it2 = getRoughDraftList().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it2.next();
                    if (Intrinsics.areEqual(t.getId(), this.originDraftId)) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 == null) {
                    break;
                }
                this.originDraftId = t2.getBackupId();
            }
            ArrayList<RoughDraft> roughDraftList = getRoughDraftList();
            String str = this.originDraftId;
            if (str == null) {
                str = "";
            }
            roughDraftList.add(0, RoughDraft.copy$default(roughDraft, str, 0, null, null, 14, null));
            setEditing(roughDraft);
        }
    }

    public final void setEditing(RoughDraft roughDraft) {
        Intrinsics.checkNotNullParameter(roughDraft, "draft");
        CollectionsKt.removeAll((List) getRoughDraftList(), (Function1) new RoughDraftHelper$setEditing$1(roughDraft));
        this.editingDraftId = roughDraft.getId();
        getRoughDraftList().add(0, roughDraft);
        saveToDisk();
    }

    public final void setEditingDraftSaveToDisk(boolean z, boolean z2) {
        T t;
        T t2;
        Iterator<T> it2 = getRoughDraftList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (Intrinsics.areEqual(t.getId(), this.editingDraftId)) {
                break;
            }
        }
        T t3 = t;
        Iterator<T> it3 = getRoughDraftList().iterator();
        while (true) {
            if (!it3.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it3.next();
            if (Intrinsics.areEqual(t2.getId(), this.originDraftId)) {
                break;
            }
        }
        T t4 = t2;
        if (t3 != null && !z) {
            getRoughDraftList().remove(t3);
        }
        String str = null;
        this.editingDraftId = str;
        if (t4 != null && z2) {
            getRoughDraftList().remove(t4);
        }
        this.originDraftId = str;
        if (!z && !z2 && t3 != null && t4 != null) {
            getRoughDraftList().remove(t3);
            getRoughDraftList().remove(t4);
            getRoughDraftList().add(RoughDraft.copy$default(t4, t3.getId(), 0, null, null, 14, null));
        }
        ArrayList<RoughDraft> roughDraftList = getRoughDraftList();
        if (roughDraftList.size() > 1) {
            CollectionsKt.sortWith(roughDraftList, new RoughDraftHelper$setEditingDraftSaveToDisk$$inlined$sortByDescending$1());
        }
        saveToDisk();
    }

    public final void remove(RoughDraft roughDraft) {
        Intrinsics.checkNotNullParameter(roughDraft, "draft");
        getRoughDraftList().remove(roughDraft);
        saveToDisk();
    }

    public final void clearAll() {
        getRoughDraftList().clear();
        saveToDisk();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e A[SYNTHETIC, Splitter:B:13:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    private final void saveToDisk() {
        Throwable th;
        String listToJsonString = listToJsonString();
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(listToJsonString, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = listToJsonString.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        OutputStream outputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(getSavedPath()));
            try {
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                try {
                    gZIPOutputStream.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                outputStream = gZIPOutputStream;
                if (outputStream == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = gZIPOutputStream;
                if (outputStream != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a A[SYNTHETIC, Splitter:B:23:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066  */
    public final String loadJsonFromDisk() {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        byte[] bArr = null;
        File savedPath = getSavedPath();
        if (!isAvailableFile(savedPath)) {
            savedPath = getOldSavePath();
            if (!isAvailableFile(savedPath)) {
                return "";
            }
        }
        InputStream inputStream = null;
        try {
            gZIPInputStream = new GZIPInputStream(new FileInputStream(savedPath));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                for (int read = gZIPInputStream.read(bArr2); read > -1; read = gZIPInputStream.read(bArr2)) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    gZIPInputStream.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                inputStream = gZIPInputStream;
                if (inputStream != null) {
                }
                if (bArr == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            if (inputStream != null) {
                inputStream.close();
            }
            if (bArr == null) {
            }
        } catch (Throwable th3) {
            gZIPInputStream = inputStream;
            th = th3;
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        if (bArr == null) {
            return "";
        }
        return new String(bArr, Charsets.UTF_8);
    }

    private final boolean isAvailableFile(File file) {
        return file.exists() && file.isFile() && file.canRead();
    }

    private final String listToJsonString() {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        for (T t : getRoughDraftList()) {
            String component1 = t.component1();
            long component2 = t.component2();
            FeedMultiPart component3 = t.component3();
            FeedUIConfig component4 = t.component4();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = null;
            try {
                jSONObject = FeedMultiPartExtendsKt.toJson(component3);
            } catch (Throwable unused) {
                jSONObject = null;
            }
            try {
                jSONObject3 = FeedMultiPartExtendsKt.toJson(component4);
            } catch (Throwable unused2) {
            }
            if (!(jSONObject == null || jSONObject3 == null)) {
                jSONObject2.put("multiPart", jSONObject);
                jSONObject2.put("uiConfig", jSONObject3);
                jSONObject2.put("time", component2);
                jSONObject2.put("id", component1);
                jSONArray.put(jSONObject2);
            }
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "array.toString()");
        return jSONArray2;
    }

    /* access modifiers changed from: private */
    public final ArrayList<RoughDraft> jsonToList(String str) {
        FeedMultiPart feedMultiPart;
        ArrayList<RoughDraft> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            FeedUIConfig feedUIConfig = null;
            try {
                FeedMultiPart.Builder builder = FeedMultiPart.builder();
                Intrinsics.checkNotNullExpressionValue(builder, "FeedMultiPart.builder()");
                JSONObject jSONObject2 = jSONObject.getJSONObject("multiPart");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObj.getJSONObject(\"multiPart\")");
                feedMultiPart = FeedMultiPartExtendsKt.loadJson(builder, jSONObject2);
            } catch (Throwable th) {
                th.printStackTrace();
                feedMultiPart = null;
            }
            try {
                FeedUIConfig.Builder builder2 = FeedUIConfig.builder();
                Intrinsics.checkNotNullExpressionValue(builder2, "FeedUIConfig.builder()");
                JSONObject jSONObject3 = jSONObject.getJSONObject("uiConfig");
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObj.getJSONObject(\"uiConfig\")");
                feedUIConfig = FeedMultiPartExtendsKt.loadJson(builder2, jSONObject3);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            long optLong = jSONObject.optLong("time", 0);
            String optString = jSONObject.optString("id", String.valueOf(i));
            if (!(feedMultiPart == null || feedUIConfig == null)) {
                RoughDraft.Companion companion = RoughDraft.Companion;
                Intrinsics.checkNotNullExpressionValue(optString, "id");
                arrayList.add(companion.create(optString, feedMultiPart, feedUIConfig, optLong));
            }
        }
        return arrayList;
    }

    public final String generateDraftID() {
        T t;
        String valueOf = String.valueOf(Random.Default.nextInt((getRoughDraftList().size() * 10) + 5));
        Iterator<T> it2 = getRoughDraftList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (Intrinsics.areEqual(t.getId(), valueOf)) {
                break;
            }
        }
        if (t == null) {
            return valueOf;
        }
        return generateDraftID();
    }
}
