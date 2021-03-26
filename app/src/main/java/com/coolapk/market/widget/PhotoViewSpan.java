package com.coolapk.market.widget;

import android.text.style.ClickableSpan;
import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.UiUtils;

public class PhotoViewSpan extends ClickableSpan {
    private ImageUrl imageUrl;

    public PhotoViewSpan(ImageUrl imageUrl2) {
        this.imageUrl = imageUrl2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.imageUrl != null) {
            ActionManager.startPhotoViewActivity(UiUtils.getActivity(view.getContext()), new String[]{this.imageUrl.getSourceUrl()}, new String[]{this.imageUrl.getCompressedUrl()}, 0);
        }
    }
}
