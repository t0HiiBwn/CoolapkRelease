package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.l;
import java.util.List;

/* compiled from: BranchInterceptor */
public abstract class a<IN, OUT> extends l<IN, OUT> {
    protected abstract String a(b<OUT> bVar, IN in);

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.bytedance.sdk.openadsdk.preload.b.b<OUT> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        String a = a(new m(bVar), in);
        l.a aVar = a().get(a);
        if (aVar != null) {
            List<h> list = aVar.a;
            Object a2 = c.a(list, ((i) bVar).a, this).a((b) in);
            if (!a(list)) {
                return a2;
            }
            return bVar.a((b<OUT>) a2);
        }
        throw new IllegalArgumentException("can not found branch, branch name is：" + a);
    }
}
