package com.coolapk.market.view.album;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.coolapk.market.event.AlbumItemAddDelEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

public class DeleteDialog extends BaseDialogFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String KEY_ALBUM_ITEM = "ALBUMITEM";

    public static DeleteDialog newInstance(AlbumItem albumItem) {
        DeleteDialog deleteDialog = new DeleteDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ALBUMITEM", albumItem);
        deleteDialog.setArguments(bundle);
        return deleteDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final AlbumItem albumItem = (AlbumItem) getArguments().getParcelable("ALBUMITEM");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog.Builder title = builder.setTitle(getActivity().getString(2131886794));
        title.setMessage(albumItem.getTitle() + "\n" + albumItem.getPackageName()).setPositiveButton(getActivity().getString(2131886770), new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.album.DeleteDialog.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DataManager.getInstance().delApkFromAlbum(albumItem.getAlbumId(), albumItem.getPackageName()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
                    /* class com.coolapk.market.view.album.DeleteDialog.AnonymousClass1.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onCompleted() {
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        Toast.error(DeleteDialog.this.getActivity(), th);
                    }

                    public void onNext(Result<String> result) {
                        if (result.getData() == null) {
                            Toast.show(DeleteDialog.this.getActivity(), result.getMessage());
                        } else {
                            EventBus.getDefault().post(new AlbumItemAddDelEvent(albumItem, false));
                        }
                    }
                });
            }
        }).setNegativeButton(getActivity().getString(2131886768), (DialogInterface.OnClickListener) null);
        return builder.create();
    }
}
