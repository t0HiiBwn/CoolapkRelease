package com.rd.draw.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.animation.data.Value;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.type.BasicDrawer;
import com.rd.draw.drawer.type.ColorDrawer;
import com.rd.draw.drawer.type.DropDrawer;
import com.rd.draw.drawer.type.FillDrawer;
import com.rd.draw.drawer.type.ScaleDownDrawer;
import com.rd.draw.drawer.type.ScaleDrawer;
import com.rd.draw.drawer.type.SlideDrawer;
import com.rd.draw.drawer.type.SwapDrawer;
import com.rd.draw.drawer.type.ThinWormDrawer;
import com.rd.draw.drawer.type.WormDrawer;

public class Drawer {
    private BasicDrawer basicDrawer;
    private ColorDrawer colorDrawer;
    private int coordinateX;
    private int coordinateY;
    private DropDrawer dropDrawer;
    private FillDrawer fillDrawer;
    private int position;
    private ScaleDownDrawer scaleDownDrawer;
    private ScaleDrawer scaleDrawer;
    private SlideDrawer slideDrawer;
    private SwapDrawer swapDrawer;
    private ThinWormDrawer thinWormDrawer;
    private WormDrawer wormDrawer;

    public Drawer(Indicator indicator) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.basicDrawer = new BasicDrawer(paint, indicator);
        this.colorDrawer = new ColorDrawer(paint, indicator);
        this.scaleDrawer = new ScaleDrawer(paint, indicator);
        this.wormDrawer = new WormDrawer(paint, indicator);
        this.slideDrawer = new SlideDrawer(paint, indicator);
        this.fillDrawer = new FillDrawer(paint, indicator);
        this.thinWormDrawer = new ThinWormDrawer(paint, indicator);
        this.dropDrawer = new DropDrawer(paint, indicator);
        this.swapDrawer = new SwapDrawer(paint, indicator);
        this.scaleDownDrawer = new ScaleDownDrawer(paint, indicator);
    }

    public void setup(int i, int i2, int i3) {
        this.position = i;
        this.coordinateX = i2;
        this.coordinateY = i3;
    }

    public void drawBasic(Canvas canvas, boolean z) {
        if (this.colorDrawer != null) {
            this.basicDrawer.draw(canvas, this.position, z, this.coordinateX, this.coordinateY);
        }
    }

    public void drawColor(Canvas canvas, Value value) {
        ColorDrawer colorDrawer2 = this.colorDrawer;
        if (colorDrawer2 != null) {
            colorDrawer2.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }

    public void drawScale(Canvas canvas, Value value) {
        ScaleDrawer scaleDrawer2 = this.scaleDrawer;
        if (scaleDrawer2 != null) {
            scaleDrawer2.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }

    public void drawWorm(Canvas canvas, Value value) {
        WormDrawer wormDrawer2 = this.wormDrawer;
        if (wormDrawer2 != null) {
            wormDrawer2.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }

    public void drawSlide(Canvas canvas, Value value) {
        SlideDrawer slideDrawer2 = this.slideDrawer;
        if (slideDrawer2 != null) {
            slideDrawer2.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }

    public void drawFill(Canvas canvas, Value value) {
        FillDrawer fillDrawer2 = this.fillDrawer;
        if (fillDrawer2 != null) {
            fillDrawer2.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }

    public void drawThinWorm(Canvas canvas, Value value) {
        ThinWormDrawer thinWormDrawer2 = this.thinWormDrawer;
        if (thinWormDrawer2 != null) {
            thinWormDrawer2.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }

    public void drawDrop(Canvas canvas, Value value) {
        DropDrawer dropDrawer2 = this.dropDrawer;
        if (dropDrawer2 != null) {
            dropDrawer2.draw(canvas, value, this.coordinateX, this.coordinateY);
        }
    }

    public void drawSwap(Canvas canvas, Value value) {
        SwapDrawer swapDrawer2 = this.swapDrawer;
        if (swapDrawer2 != null) {
            swapDrawer2.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }

    public void drawScaleDown(Canvas canvas, Value value) {
        ScaleDownDrawer scaleDownDrawer2 = this.scaleDownDrawer;
        if (scaleDownDrawer2 != null) {
            scaleDownDrawer2.draw(canvas, value, this.position, this.coordinateX, this.coordinateY);
        }
    }
}
