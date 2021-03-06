package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import javax.annotation.Nullable;

public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
    private Descriptor<? super E> mSuper;

    protected void onGetAttributes(E e, AttributeAccumulator attributeAccumulator) {
    }

    protected void onGetChildren(E e, Accumulator<Object> accumulator) {
    }

    protected void onGetComputedStyles(E e, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    protected void onGetStyleRuleNames(E e, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    protected void onGetStyles(E e, String str, StyleAccumulator styleAccumulator) {
    }

    protected void onHook(E e) {
    }

    protected void onSetStyle(E e, String str, String str2, String str3) {
    }

    protected void onUnhook(E e) {
    }

    @Override // com.facebook.stetho.inspector.elements.ChainedDescriptor
    public void setSuper(Descriptor<? super E> descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor<? super E> descriptor2 = this.mSuper;
        if (descriptor == descriptor2) {
            return;
        }
        if (descriptor2 == null) {
            this.mSuper = descriptor;
            return;
        }
        throw new IllegalStateException();
    }

    final Descriptor<? super E> getSuper() {
        return this.mSuper;
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void hook(E e) {
        verifyThreadAccess();
        this.mSuper.hook(e);
        onHook(e);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void unhook(E e) {
        verifyThreadAccess();
        onUnhook(e);
        this.mSuper.unhook(e);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final NodeType getNodeType(E e) {
        return onGetNodeType(e);
    }

    protected NodeType onGetNodeType(E e) {
        return this.mSuper.getNodeType(e);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeName(E e) {
        return onGetNodeName(e);
    }

    protected String onGetNodeName(E e) {
        return this.mSuper.getNodeName(e);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getLocalName(E e) {
        return onGetLocalName(e);
    }

    protected String onGetLocalName(E e) {
        return this.mSuper.getLocalName(e);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeValue(E e) {
        return onGetNodeValue(e);
    }

    @Nullable
    public String onGetNodeValue(E e) {
        return this.mSuper.getNodeValue(e);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getChildren(E e, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(e, accumulator);
        onGetChildren(e, accumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getAttributes(E e, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(e, attributeAccumulator);
        onGetAttributes(e, attributeAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setAttributesAsText(E e, String str) {
        onSetAttributesAsText(e, str);
    }

    protected void onSetAttributesAsText(E e, String str) {
        this.mSuper.setAttributesAsText(e, str);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyleRuleNames(E e, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        this.mSuper.getStyleRuleNames(e, styleRuleNameAccumulator);
        onGetStyleRuleNames(e, styleRuleNameAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyles(E e, String str, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(e, str, styleAccumulator);
        onGetStyles(e, str, styleAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setStyle(E e, String str, String str2, String str3) {
        this.mSuper.setStyle(e, str, str2, str3);
        onSetStyle(e, str, str2, str3);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getComputedStyles(E e, ComputedStyleAccumulator computedStyleAccumulator) {
        this.mSuper.getComputedStyles(e, computedStyleAccumulator);
        onGetComputedStyles(e, computedStyleAccumulator);
    }
}
