package com.coolapk.market.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemReplyLikeListBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.LinkTextUtils;

public class UserReplyLikeViewHolder extends GenericBindHolder<ItemReplyLikeListBinding, FeedReply> {
    public static final int LAYOUT_ID = 2131558904;
    private Context context;

    public UserReplyLikeViewHolder(Context context2, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        this.context = context2;
    }

    public void bindToContent(FeedReply feedReply) {
        ItemReplyLikeListBinding itemReplyLikeListBinding = (ItemReplyLikeListBinding) getBinding();
        int i = 0;
        itemReplyLikeListBinding.textView.setText(this.context.getString(2131886960, EntityUtils.isFeedreply(feedReply.getEntityType()) ? "回复" : "动态"));
        itemReplyLikeListBinding.setClick(this);
        itemReplyLikeListBinding.setModel(feedReply);
        itemReplyLikeListBinding.setTransformer(new CircleTransform());
        itemReplyLikeListBinding.executePendingBindings();
        LinkTextUtils.removeSpannable(itemReplyLikeListBinding.infoView.getText(), URLSpan.class);
        ImageView imageView = itemReplyLikeListBinding.imgView;
        if (TextUtils.isEmpty(feedReply.getPic())) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        FeedReply model = ((ItemReplyLikeListBinding) getBinding()).getModel();
        int id = view.getId();
        if (id == 2131362322) {
            ActionManager.startActivityByUrl(getContext(), model.getUrl());
        } else if (id == 2131363900) {
            ActionManager.startUserSpaceActivity(view, model.getLikeUid(), model.getLikeAvatar());
        }
    }
}
