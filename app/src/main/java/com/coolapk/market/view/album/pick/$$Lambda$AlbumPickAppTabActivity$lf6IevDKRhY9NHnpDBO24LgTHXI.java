package com.coolapk.market.view.album.pick;

import com.coolapk.market.model.AlbumItem;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/* renamed from: com.coolapk.market.view.album.pick.-$$Lambda$AlbumPickAppTabActivity$lf6IevDKRhY9NHnpDBO24LgTHXI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AlbumPickAppTabActivity$lf6IevDKRhY9NHnpDBO24LgTHXI implements Comparator {
    public static final /* synthetic */ $$Lambda$AlbumPickAppTabActivity$lf6IevDKRhY9NHnpDBO24LgTHXI INSTANCE = new $$Lambda$AlbumPickAppTabActivity$lf6IevDKRhY9NHnpDBO24LgTHXI();

    private /* synthetic */ $$Lambda$AlbumPickAppTabActivity$lf6IevDKRhY9NHnpDBO24LgTHXI() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Collator.getInstance(Locale.getDefault()).compare(((AlbumItem) obj).getTitle(), ((AlbumItem) obj2).getTitle());
    }
}
