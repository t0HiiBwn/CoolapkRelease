package net.lingala.zip4j.tasks;

import java.util.Comparator;
import net.lingala.zip4j.model.FileHeader;

/* renamed from: net.lingala.zip4j.tasks.-$$Lambda$AbstractModifyFileTask$Pb5YDsqiBqkvoAOriKWyPWYFZ8E  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AbstractModifyFileTask$Pb5YDsqiBqkvoAOriKWyPWYFZ8E implements Comparator {
    public static final /* synthetic */ $$Lambda$AbstractModifyFileTask$Pb5YDsqiBqkvoAOriKWyPWYFZ8E INSTANCE = new $$Lambda$AbstractModifyFileTask$Pb5YDsqiBqkvoAOriKWyPWYFZ8E();

    private /* synthetic */ $$Lambda$AbstractModifyFileTask$Pb5YDsqiBqkvoAOriKWyPWYFZ8E() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return AbstractModifyFileTask.lambda$cloneAndSortFileHeadersByOffset$0((FileHeader) obj, (FileHeader) obj2);
    }
}
