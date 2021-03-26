package com.coolapk.market.view.node.rating;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.network.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003Jñ\u0001\u0010\u000b\u001aÎ\u0001\u0012`\u0012^\u0012(\u0012&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000e \u0010*.\u0012(\u0012&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000e\u0018\u00010\r0\r \u0010*f\u0012`\u0012^\u0012(\u0012&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000e \u0010*.\u0012(\u0012&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000e\u0018\u00010\r0\r\u0018\u00010\f0\f2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "", "initArgs", "Lcom/coolapk/market/view/node/rating/NodeRatingArgs;", "view", "Lcom/coolapk/market/view/node/rating/NodeRatingView;", "(Lcom/coolapk/market/view/node/rating/NodeRatingArgs;Lcom/coolapk/market/view/node/rating/NodeRatingView;)V", "args", "getView", "()Lcom/coolapk/market/view/node/rating/NodeRatingView;", "getArgs", "getNodeRatingList", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/NodeRating;", "kotlin.jvm.PlatformType", "", "page", "", "firstItem", "", "lastItem", "setArgs", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeRatingApi.kt */
public final class NodeRatingPresenter {
    public static final Companion Companion = new Companion(null);
    public static final String NODE_RATING_API = "/feed/nodeRatingList";
    private static final String RATING_TYPE_ALL = null;
    public static final String RATING_TYPE_HAS_COMMENT = "1";
    public static final String RATING_TYPE_NO_COMMENT = "0";
    private static final String STAR_ALL = null;
    private NodeRatingArgs args;
    private final NodeRatingView view;

    public NodeRatingPresenter(NodeRatingArgs nodeRatingArgs, NodeRatingView nodeRatingView) {
        Intrinsics.checkNotNullParameter(nodeRatingArgs, "initArgs");
        Intrinsics.checkNotNullParameter(nodeRatingView, "view");
        this.view = nodeRatingView;
        this.args = nodeRatingArgs;
    }

    public final NodeRatingView getView() {
        return this.view;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/node/rating/NodeRatingPresenter$Companion;", "", "()V", "NODE_RATING_API", "", "RATING_TYPE_ALL", "getRATING_TYPE_ALL", "()Ljava/lang/String;", "RATING_TYPE_HAS_COMMENT", "RATING_TYPE_NO_COMMENT", "STAR_ALL", "getSTAR_ALL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeRatingApi.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getRATING_TYPE_ALL() {
            return NodeRatingPresenter.RATING_TYPE_ALL;
        }

        public final String getSTAR_ALL() {
            return NodeRatingPresenter.STAR_ALL;
        }
    }

    public final void setArgs(NodeRatingArgs nodeRatingArgs) {
        Intrinsics.checkNotNullParameter(nodeRatingArgs, "args");
        if (!Intrinsics.areEqual(this.args, nodeRatingArgs)) {
            this.args = nodeRatingArgs;
            this.view.onNodeRatingArgsChanged(nodeRatingArgs);
        }
    }

    public final NodeRatingArgs getArgs() {
        return this.args;
    }

    public static /* synthetic */ Observable getNodeRatingList$default(NodeRatingPresenter nodeRatingPresenter, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return nodeRatingPresenter.getNodeRatingList(i, str, str2);
    }

    public final Observable<Result<List<NodeRating>>> getNodeRatingList(int i, String str, String str2) {
        DataManager instance = DataManager.getInstance();
        String url = this.args.getUrl();
        String targetType = this.args.getTargetType();
        String id = this.args.getId();
        int i2 = null;
        String targetVersion = this.args.getUseTargetVersion() ? this.args.getTargetVersion() : null;
        String uid = this.args.getUid();
        String ratingType = this.args.getRatingType();
        String star = this.args.getStar();
        int i3 = this.args.getBuyStatusCheck() == 1 ? 1 : null;
        if (this.args.getOwnStatusCheck() == 1) {
            i2 = 1;
        }
        return instance.getNodeRatingList(url, targetType, id, targetVersion, uid, ratingType, star, i3, i2, i, str, str2);
    }
}
