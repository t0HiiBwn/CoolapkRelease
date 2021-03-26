package com.coolapk.market.manager;

import android.app.Activity;
import android.content.Intent;
import com.coolapk.market.util.ActivityResultAdapter;
import com.coolapk.market.util.ActivityResultAdapterKt;
import com.coolapk.market.view.photo.PhotoPickerActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ActionManagerCompat.kt */
final class ActionManagerCompat$startPhotoPickerActivityWithCallback$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ int $pickCount;
    final /* synthetic */ List $pickedList;

    ActionManagerCompat$startPhotoPickerActivityWithCallback$1(Activity activity, List list, int i, Function1 function1) {
        this.$activity = activity;
        this.$pickedList = list;
        this.$pickCount = i;
        this.$callback = function1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityResultAdapter findActivityResultAdapter = ActivityResultAdapterKt.findActivityResultAdapter(this.$activity);
        if (findActivityResultAdapter != null) {
            findActivityResultAdapter.startActivityForResult(new Intent(this.$activity, PhotoPickerActivity.class).putStringArrayListExtra("PICKED_PHOTO_PATHS", new ArrayList<>(this.$pickedList)).putExtra("MAX_PICK_COUNT", this.$pickCount), new Function2<Integer, Intent, Unit>(this) {
                /* class com.coolapk.market.manager.ActionManagerCompat$startPhotoPickerActivityWithCallback$1.AnonymousClass1 */
                final /* synthetic */ ActionManagerCompat$startPhotoPickerActivityWithCallback$1 this$0;

                {
                    this.this$0 = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Intent intent) {
                    invoke(num.intValue(), intent);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, Intent intent) {
                    ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("PICKED_PHOTO_PATHS") : null;
                    if (stringArrayListExtra != null) {
                        this.this$0.$callback.invoke(stringArrayListExtra);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
