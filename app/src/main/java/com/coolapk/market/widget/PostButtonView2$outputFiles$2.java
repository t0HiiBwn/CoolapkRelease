package com.coolapk.market.widget;

import com.coolapk.market.AppHolder;
import com.coolapk.market.util.BitmapUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: PostButtonView2.kt */
final class PostButtonView2$outputFiles$2 extends Lambda implements Function0<File> {
    public static final PostButtonView2$outputFiles$2 INSTANCE = new PostButtonView2$outputFiles$2();

    PostButtonView2$outputFiles$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final File invoke() {
        return new File(BitmapUtil.generateFileOutputPath(AppHolder.getApplication(), "post_button_custom"));
    }
}
