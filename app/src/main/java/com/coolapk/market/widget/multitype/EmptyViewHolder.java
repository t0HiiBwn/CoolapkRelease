package com.coolapk.market.widget.multitype;

import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemArticleViewTextBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.viewholder.BindingViewHolder;

public class EmptyViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558617;

    public EmptyViewHolder(View view) {
        super(view);
        ((ItemArticleViewTextBinding) getBinding()).etTitle.addTextChangedListener(new CommentHelper.EmotionTextModifier());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        ItemArticleViewTextBinding itemArticleViewTextBinding = (ItemArticleViewTextBinding) getBinding();
        if (obj == null) {
            str = "null";
        } else if (obj instanceof Entity) {
            StringBuilder sb = new StringBuilder();
            sb.append("EntityType: ");
            Entity entity = (Entity) obj;
            sb.append(entity.getEntityType());
            sb.append("  EntityTemplate: ");
            sb.append(entity.getEntityTemplate());
            str = sb.toString();
        } else {
            str = obj.toString();
        }
        TextView textView = itemArticleViewTextBinding.etTitle;
        textView.setText("无法解析数据，请处理:\n" + str);
        itemArticleViewTextBinding.etTitle.setTextSize(12.0f);
        itemArticleViewTextBinding.etTitle.setMaxLines(3);
    }
}
