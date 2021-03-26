package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.i;
import com.bytedance.sdk.openadsdk.preload.b.l;
import java.util.List;

/* compiled from: RetryBranchInterceptor */
public abstract class j<IN, OUT> extends l<IN, OUT> {
    private String d;

    protected abstract String a(b<OUT> bVar, IN in);

    protected abstract String a(b<OUT> bVar, IN in, Throwable th, String str);

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.openadsdk.preload.b.b<OUT> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        this.d = a(new m(bVar), in);
        l.a aVar = a().get(this.d);
        while (aVar != null) {
            List<h> list = aVar.a;
            try {
                Object a = c.a(list, ((i) bVar).a, this).a((b) in);
                if (!a(list)) {
                    return a;
                }
                return bVar.a((b<OUT>) a);
            } catch (i.a e) {
                this.d = a(new m(bVar), in, e.getCause(), this.d);
                aVar = a().get(this.d);
            } catch (Throwable th) {
                this.d = a(new m(bVar), in, th, this.d);
                aVar = a().get(this.d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.d);
    }
}
