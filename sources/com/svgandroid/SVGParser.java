package com.svgandroid;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SVGParser {
    static final String TAG = "SVGAndroid";

    public static SVG getSVGFromInputStream(InputStream inputStream) throws SVGParseException {
        return parse(inputStream, 0, 0, false);
    }

    public static SVG getSVGFromInputStream(InputStream inputStream, int i, int i2) throws SVGParseException {
        return parse(inputStream, 0, 0, false, i, i2);
    }

    public static SVG getSVGFromResource(Resources resources, int i) throws SVGParseException {
        return parse(resources.openRawResource(i), 0, 0, false);
    }

    public static SVG getSVGFromAsset(AssetManager assetManager, String str) throws SVGParseException, IOException {
        InputStream open = assetManager.open(str);
        SVG sVGFromInputStream = getSVGFromInputStream(open);
        open.close();
        return sVGFromInputStream;
    }

    public static SVG getSVGFromInputStream(InputStream inputStream, int i, int i2, int i3, int i4) throws SVGParseException {
        return parse(inputStream, Integer.valueOf(i), Integer.valueOf(i2), false, i3, i4);
    }

    public static SVG getSVGFromString(String str, int i, int i2) throws SVGParseException {
        return parse(new ByteArrayInputStream(str.getBytes()), Integer.valueOf(i), Integer.valueOf(i2), false);
    }

    public static SVG getSVGFromResource(Resources resources, int i, int i2, int i3) throws SVGParseException {
        return parse(resources.openRawResource(i), Integer.valueOf(i2), Integer.valueOf(i3), false);
    }

    public static SVG getSVGFromAsset(AssetManager assetManager, String str, int i, int i2) throws SVGParseException, IOException {
        InputStream open = assetManager.open(str);
        SVG sVGFromInputStream = getSVGFromInputStream(open, i, i2);
        open.close();
        return sVGFromInputStream;
    }

    public static Path parsePath(String str) {
        return doPath(str);
    }

    private static SVG parse(InputStream inputStream, Integer num, Integer num2, boolean z, int i, int i2) throws SVGParseException {
        try {
            System.currentTimeMillis();
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            Picture picture = new Picture();
            SVGHandler sVGHandler = new SVGHandler(picture, i, i2);
            sVGHandler.setColorSwap(num, num2);
            sVGHandler.setWhiteMode(z);
            xMLReader.setContentHandler(sVGHandler);
            xMLReader.parse(new InputSource(inputStream));
            SVG svg = new SVG(picture, sVGHandler.bounds);
            if (!Float.isInfinite(sVGHandler.limits.top)) {
                svg.setLimits(sVGHandler.limits);
            }
            return svg;
        } catch (Exception e) {
            throw new SVGParseException(e);
        }
    }

    private static SVG parse(InputStream inputStream, Integer num, Integer num2, boolean z) throws SVGParseException {
        return parse(inputStream, num, num2, z, 0, 0);
    }

    protected static NumberParse parseNumbers(String str) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 1; i2 < length; i2++) {
            if (z) {
                z = false;
            } else {
                char charAt = str.charAt(i2);
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                    case '-':
                        String substring = str.substring(i, i2);
                        if (substring.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring)));
                            if (charAt == '-') {
                                i = i2;
                                break;
                            } else {
                                i = i2 + 1;
                                z = true;
                                break;
                            }
                        } else {
                            i++;
                            continue;
                        }
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case 'L':
                    case 'M':
                    case 'Q':
                    case 'S':
                    case 'T':
                    case 'V':
                    case 'Z':
                    case 'a':
                    case 'c':
                    case 'h':
                    case 'l':
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case 'v':
                    case 'z':
                        String substring2 = str.substring(i, i2);
                        if (substring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring2)));
                        }
                        return new NumberParse(arrayList, i2);
                }
            }
        }
        String substring3 = str.substring(i);
        if (substring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(substring3)));
            } catch (NumberFormatException unused) {
            }
            i = str.length();
        }
        return new NumberParse(arrayList, i);
    }

    /* access modifiers changed from: private */
    public static Matrix parseTransform(String str) {
        float f;
        float f2 = 0.0f;
        if (str.startsWith("matrix(")) {
            NumberParse parseNumbers = parseNumbers(str.substring(7));
            if (parseNumbers.numbers.size() != 6) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{((Float) parseNumbers.numbers.get(0)).floatValue(), ((Float) parseNumbers.numbers.get(2)).floatValue(), ((Float) parseNumbers.numbers.get(4)).floatValue(), ((Float) parseNumbers.numbers.get(1)).floatValue(), ((Float) parseNumbers.numbers.get(3)).floatValue(), ((Float) parseNumbers.numbers.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
            return matrix;
        } else if (str.startsWith("translate(")) {
            NumberParse parseNumbers2 = parseNumbers(str.substring(10));
            if (parseNumbers2.numbers.isEmpty()) {
                return null;
            }
            float floatValue = ((Float) parseNumbers2.numbers.get(0)).floatValue();
            if (parseNumbers2.numbers.size() > 1) {
                f2 = ((Float) parseNumbers2.numbers.get(1)).floatValue();
            }
            Matrix matrix2 = new Matrix();
            matrix2.postTranslate(floatValue, f2);
            return matrix2;
        } else if (str.startsWith("scale(")) {
            NumberParse parseNumbers3 = parseNumbers(str.substring(6));
            if (parseNumbers3.numbers.isEmpty()) {
                return null;
            }
            float floatValue2 = ((Float) parseNumbers3.numbers.get(0)).floatValue();
            if (parseNumbers3.numbers.size() > 1) {
                f2 = ((Float) parseNumbers3.numbers.get(1)).floatValue();
            }
            Matrix matrix3 = new Matrix();
            matrix3.postScale(floatValue2, f2);
            return matrix3;
        } else if (str.startsWith("skewX(")) {
            NumberParse parseNumbers4 = parseNumbers(str.substring(6));
            if (parseNumbers4.numbers.isEmpty()) {
                return null;
            }
            float floatValue3 = ((Float) parseNumbers4.numbers.get(0)).floatValue();
            Matrix matrix4 = new Matrix();
            matrix4.postSkew((float) Math.tan((double) floatValue3), 0.0f);
            return matrix4;
        } else if (str.startsWith("skewY(")) {
            NumberParse parseNumbers5 = parseNumbers(str.substring(6));
            if (parseNumbers5.numbers.isEmpty()) {
                return null;
            }
            float floatValue4 = ((Float) parseNumbers5.numbers.get(0)).floatValue();
            Matrix matrix5 = new Matrix();
            matrix5.postSkew(0.0f, (float) Math.tan((double) floatValue4));
            return matrix5;
        } else if (!str.startsWith("rotate(")) {
            return null;
        } else {
            NumberParse parseNumbers6 = parseNumbers(str.substring(7));
            if (parseNumbers6.numbers.isEmpty()) {
                return null;
            }
            float floatValue5 = ((Float) parseNumbers6.numbers.get(0)).floatValue();
            if (parseNumbers6.numbers.size() > 2) {
                f2 = ((Float) parseNumbers6.numbers.get(1)).floatValue();
                f = ((Float) parseNumbers6.numbers.get(2)).floatValue();
            } else {
                f = 0.0f;
            }
            Matrix matrix6 = new Matrix();
            matrix6.postTranslate(f2, f);
            matrix6.postRotate(floatValue5);
            matrix6.postTranslate(-f2, -f);
            return matrix6;
        }
    }

    /* access modifiers changed from: private */
    public static Path doPath(String str) {
        Path path = new Path();
        PathParser.parse(str, path);
        return path;
    }

    /* access modifiers changed from: private */
    public static NumberParse getNumberParseAttr(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return parseNumbers(attributes.getValue(i));
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static String getStringAttr(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static Float getFloatAttr(String str, Attributes attributes) {
        return getFloatAttr(str, attributes, null);
    }

    /* access modifiers changed from: private */
    public static Float getFloatAttr(String str, Attributes attributes, Float f) {
        String stringAttr = getStringAttr(str, attributes);
        if (stringAttr == null) {
            return f;
        }
        if (stringAttr.endsWith("px")) {
            stringAttr = stringAttr.substring(0, stringAttr.length() - 2);
        }
        return Float.valueOf(Float.parseFloat(stringAttr));
    }

    protected static Integer getHexAttr(String str, Attributes attributes) {
        String stringAttr = getStringAttr(str, attributes);
        if (stringAttr == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(stringAttr.substring(1), 16));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    protected static class NumberParse {
        private int nextCmd;
        private ArrayList<Float> numbers;

        public NumberParse(ArrayList<Float> arrayList, int i) {
            this.numbers = arrayList;
            this.nextCmd = i;
        }

        public int getNextCmd() {
            return this.nextCmd;
        }

        public float getNumber(int i) {
            return this.numbers.get(i).floatValue();
        }
    }

    private static class Gradient {
        ArrayList<Integer> colors;
        String id;
        boolean isLinear;
        Matrix matrix;
        ArrayList<Float> positions;
        float radius;
        float x;
        float x1;
        float x2;
        String xlink;
        float y;
        float y1;
        float y2;

        private Gradient() {
            this.positions = new ArrayList<>();
            this.colors = new ArrayList<>();
            this.matrix = null;
        }

        public Gradient createChild(Gradient gradient) {
            Gradient gradient2 = new Gradient();
            gradient2.id = gradient.id;
            gradient2.xlink = this.id;
            gradient2.isLinear = gradient.isLinear;
            gradient2.x1 = gradient.x1;
            gradient2.x2 = gradient.x2;
            gradient2.y1 = gradient.y1;
            gradient2.y2 = gradient.y2;
            gradient2.x = gradient.x;
            gradient2.y = gradient.y;
            gradient2.radius = gradient.radius;
            gradient2.positions = this.positions;
            gradient2.colors = this.colors;
            gradient2.matrix = this.matrix;
            Matrix matrix2 = gradient.matrix;
            if (matrix2 != null) {
                if (this.matrix == null) {
                    gradient2.matrix = matrix2;
                } else {
                    Matrix matrix3 = new Matrix(this.matrix);
                    matrix3.preConcat(gradient.matrix);
                    gradient2.matrix = matrix3;
                }
            }
            return gradient2;
        }
    }

    private static class StyleSet {
        HashMap<String, String> styleMap;

        private StyleSet(String str) {
            this.styleMap = new HashMap<>();
            for (String str2 : str.split(";")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    this.styleMap.put(split[0], split[1]);
                }
            }
        }

        public String getStyle(String str) {
            return this.styleMap.get(str);
        }
    }

    protected static class Properties {
        Attributes atts;
        StyleSet styles = null;

        protected Properties(Attributes attributes) {
            this.atts = attributes;
            String stringAttr = SVGParser.getStringAttr("style", attributes);
            if (stringAttr != null) {
                this.styles = new StyleSet(stringAttr);
            }
        }

        public String getAttr(String str) {
            StyleSet styleSet = this.styles;
            String style = styleSet != null ? styleSet.getStyle(str) : null;
            return style == null ? SVGParser.getStringAttr(str, this.atts) : style;
        }

        public String getString(String str) {
            return getAttr(str);
        }

        public Integer getHex(String str) {
            String attr = getAttr(str);
            if (attr != null && attr.startsWith("#")) {
                try {
                    return Integer.valueOf(Integer.parseInt(attr.substring(1), 16));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }

        public Float getFloat(String str, float f) {
            Float f2 = getFloat(str);
            return f2 == null ? Float.valueOf(f) : f2;
        }

        public Float getFloat(String str) {
            String attr = getAttr(str);
            if (attr == null) {
                return null;
            }
            try {
                return Float.valueOf(Float.parseFloat(attr));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
    }

    protected static class SVGHandler extends DefaultHandler {
        RectF bounds;
        private boolean boundsMode;
        Canvas canvas;
        Gradient gradient;
        HashMap<String, Shader> gradientMap;
        HashMap<String, Gradient> gradientRefMap;
        private boolean hidden;
        private int hiddenLevel;
        RectF limits;
        Paint paint;
        Picture picture;
        boolean pushed;
        RectF rect;
        Integer replaceColor;
        Integer searchColor;
        int targetHeight;
        int targetWidth;
        boolean whiteMode;

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        protected SVGHandler(Picture picture2) {
            this.rect = new RectF();
            this.bounds = null;
            this.limits = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
            this.searchColor = null;
            this.replaceColor = null;
            this.whiteMode = false;
            this.pushed = false;
            this.gradientMap = new HashMap<>();
            this.gradientRefMap = new HashMap<>();
            this.gradient = null;
            this.hidden = false;
            this.hiddenLevel = 0;
            this.boundsMode = false;
            this.picture = picture2;
            Paint paint2 = new Paint();
            this.paint = paint2;
            paint2.setAntiAlias(true);
        }

        protected SVGHandler(Picture picture2, int i, int i2) {
            this(picture2);
            this.targetWidth = i;
            this.targetHeight = i2;
        }

        public void setColorSwap(Integer num, Integer num2) {
            this.searchColor = num;
            this.replaceColor = num2;
        }

        public void setWhiteMode(boolean z) {
            this.whiteMode = z;
        }

        protected boolean doFill(Properties properties, HashMap<String, Shader> hashMap) {
            if ("none".equals(properties.getString("display"))) {
                return false;
            }
            if (this.whiteMode) {
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(-1);
                return true;
            }
            String string = properties.getString("fill");
            if (string == null || !string.startsWith("url(#")) {
                this.paint.setShader(null);
                Integer hex = properties.getHex("fill");
                if (hex != null) {
                    doColor(properties, hex, true);
                    this.paint.setStyle(Paint.Style.FILL);
                    return true;
                } else if (properties.getString("fill") != null || properties.getString("stroke") != null) {
                    return false;
                } else {
                    this.paint.setStyle(Paint.Style.FILL);
                    this.paint.setColor(-16777216);
                    return true;
                }
            } else {
                Shader shader = hashMap.get(string.substring(5, string.length() - 1));
                if (shader == null) {
                    return false;
                }
                this.paint.setShader(shader);
                this.paint.setStyle(Paint.Style.FILL);
                return true;
            }
        }

        protected boolean doStroke(Properties properties) {
            Integer hex;
            if (this.whiteMode || "none".equals(properties.getString("display")) || (hex = properties.getHex("stroke")) == null) {
                return false;
            }
            doColor(properties, hex, false);
            Float f = properties.getFloat("stroke-width");
            if (f != null) {
                this.paint.setStrokeWidth(f.floatValue());
            }
            String string = properties.getString("stroke-linecap");
            if ("round".equals(string)) {
                this.paint.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(string)) {
                this.paint.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(string)) {
                this.paint.setStrokeCap(Paint.Cap.BUTT);
            }
            String string2 = properties.getString("stroke-linejoin");
            if ("miter".equals(string2)) {
                this.paint.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(string2)) {
                this.paint.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(string2)) {
                this.paint.setStrokeJoin(Paint.Join.BEVEL);
            }
            this.paint.setStyle(Paint.Style.STROKE);
            return true;
        }

        private Gradient doGradient(boolean z, Attributes attributes) {
            Gradient gradient2 = new Gradient();
            gradient2.id = SVGParser.getStringAttr("id", attributes);
            gradient2.isLinear = z;
            Float valueOf = Float.valueOf(0.0f);
            if (z) {
                gradient2.x1 = SVGParser.getFloatAttr("x1", attributes, valueOf).floatValue();
                gradient2.x2 = SVGParser.getFloatAttr("x2", attributes, valueOf).floatValue();
                gradient2.y1 = SVGParser.getFloatAttr("y1", attributes, valueOf).floatValue();
                gradient2.y2 = SVGParser.getFloatAttr("y2", attributes, valueOf).floatValue();
            } else {
                gradient2.x = SVGParser.getFloatAttr("cx", attributes, valueOf).floatValue();
                gradient2.y = SVGParser.getFloatAttr("cy", attributes, valueOf).floatValue();
                gradient2.radius = SVGParser.getFloatAttr("r", attributes, valueOf).floatValue();
            }
            String stringAttr = SVGParser.getStringAttr("gradientTransform", attributes);
            if (stringAttr != null) {
                gradient2.matrix = SVGParser.parseTransform(stringAttr);
            }
            String stringAttr2 = SVGParser.getStringAttr("href", attributes);
            if (stringAttr2 != null) {
                if (stringAttr2.startsWith("#")) {
                    stringAttr2 = stringAttr2.substring(1);
                }
                gradient2.xlink = stringAttr2;
            }
            return gradient2;
        }

        private void doColor(Properties properties, Integer num, boolean z) {
            int intValue = (num.intValue() & 16777215) | -16777216;
            Integer num2 = this.searchColor;
            if (num2 != null && num2.intValue() == intValue) {
                intValue = this.replaceColor.intValue();
            }
            this.paint.setColor(intValue);
            Float f = properties.getFloat("opacity");
            if (f == null) {
                f = properties.getFloat(z ? "fill-opacity" : "stroke-opacity");
            }
            if (f == null) {
                this.paint.setAlpha(255);
            } else {
                this.paint.setAlpha((int) (f.floatValue() * 255.0f));
            }
        }

        private void doLimits(float f, float f2) {
            if (f < this.limits.left) {
                this.limits.left = f;
            }
            if (f > this.limits.right) {
                this.limits.right = f;
            }
            if (f2 < this.limits.top) {
                this.limits.top = f2;
            }
            if (f2 > this.limits.bottom) {
                this.limits.bottom = f2;
            }
        }

        private void doLimits(float f, float f2, float f3, float f4) {
            doLimits(f, f2);
            doLimits(f + f3, f2 + f4);
        }

        private void doLimits(Path path) {
            path.computeBounds(this.rect, false);
            doLimits(this.rect.left, this.rect.top);
            doLimits(this.rect.right, this.rect.bottom);
        }

        private void pushTransform(Attributes attributes) {
            String stringAttr = SVGParser.getStringAttr("transform", attributes);
            boolean z = stringAttr != null;
            this.pushed = z;
            if (z) {
                Matrix parseTransform = SVGParser.parseTransform(stringAttr);
                this.canvas.save();
                this.canvas.concat(parseTransform);
            }
        }

        private void popTransform() {
            if (this.pushed) {
                this.canvas.restore();
            }
        }

        private Canvas beginRecordingPicture(int i, int i2) {
            int i3;
            int i4 = this.targetWidth;
            if (i4 == 0 || (i3 = this.targetHeight) == 0) {
                return this.picture.beginRecording(i, i2);
            }
            Canvas beginRecording = this.picture.beginRecording(i4, i3);
            prepareScaledCanvas(beginRecording, (float) i, (float) i2);
            return beginRecording;
        }

        private static final void prepareScaledCanvas(Canvas canvas2, float f, float f2) {
            float width = ((float) canvas2.getWidth()) / f;
            float height = ((float) canvas2.getHeight()) / f2;
            if (width > height) {
                canvas2.translate(((width - height) * f) / 2.0f, 0.0f);
                canvas2.scale(height, height);
                return;
            }
            canvas2.translate(0.0f, ((height - width) * f2) / 2.0f);
            canvas2.scale(width, width);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            int i;
            this.paint.setAlpha(255);
            boolean z = this.boundsMode;
            Float valueOf = Float.valueOf(0.0f);
            if (z) {
                if (str2.equals("rect")) {
                    Float floatAttr = SVGParser.getFloatAttr("x", attributes);
                    if (floatAttr == null) {
                        floatAttr = valueOf;
                    }
                    Float floatAttr2 = SVGParser.getFloatAttr("y", attributes);
                    if (floatAttr2 != null) {
                        valueOf = floatAttr2;
                    }
                    Float floatAttr3 = SVGParser.getFloatAttr("width", attributes);
                    SVGParser.getFloatAttr("height", attributes);
                    this.bounds = new RectF(floatAttr.floatValue(), valueOf.floatValue(), floatAttr.floatValue() + floatAttr3.floatValue(), valueOf.floatValue() + floatAttr3.floatValue());
                }
            } else if (str2.equals("svg")) {
                this.canvas = beginRecordingPicture((int) Math.ceil((double) SVGParser.getFloatAttr("width", attributes).floatValue()), (int) Math.ceil((double) SVGParser.getFloatAttr("height", attributes).floatValue()));
            } else if (!str2.equals("defs")) {
                if (str2.equals("linearGradient")) {
                    this.gradient = doGradient(true, attributes);
                } else if (str2.equals("radialGradient")) {
                    this.gradient = doGradient(false, attributes);
                } else if (str2.equals("stop")) {
                    if (this.gradient != null) {
                        float floatValue = SVGParser.getFloatAttr("offset", attributes).floatValue();
                        StyleSet styleSet = new StyleSet(SVGParser.getStringAttr("style", attributes));
                        String style = styleSet.getStyle("stop-color");
                        if (style != null) {
                            i = style.startsWith("#") ? Integer.parseInt(style.substring(1), 16) : Integer.parseInt(style, 16);
                        } else {
                            i = -16777216;
                        }
                        String style2 = styleSet.getStyle("stop-opacity");
                        int round = style2 != null ? i | (Math.round(Float.parseFloat(style2) * 255.0f) << 24) : i | -16777216;
                        this.gradient.positions.add(Float.valueOf(floatValue));
                        this.gradient.colors.add(Integer.valueOf(round));
                    }
                } else if (str2.equals("g")) {
                    if ("bounds".equalsIgnoreCase(SVGParser.getStringAttr("id", attributes))) {
                        this.boundsMode = true;
                    }
                    if (this.hidden) {
                        this.hiddenLevel++;
                    }
                    if ("none".equals(SVGParser.getStringAttr("display", attributes)) && !this.hidden) {
                        this.hidden = true;
                        this.hiddenLevel = 1;
                    }
                } else if (!this.hidden && str2.equals("rect")) {
                    Float floatAttr4 = SVGParser.getFloatAttr("x", attributes);
                    if (floatAttr4 == null) {
                        floatAttr4 = valueOf;
                    }
                    Float floatAttr5 = SVGParser.getFloatAttr("y", attributes);
                    if (floatAttr5 != null) {
                        valueOf = floatAttr5;
                    }
                    Float floatAttr6 = SVGParser.getFloatAttr("width", attributes);
                    Float floatAttr7 = SVGParser.getFloatAttr("height", attributes);
                    pushTransform(attributes);
                    Properties properties = new Properties(attributes);
                    if (doFill(properties, this.gradientMap)) {
                        doLimits(floatAttr4.floatValue(), valueOf.floatValue(), floatAttr6.floatValue(), floatAttr7.floatValue());
                        this.canvas.drawRect(floatAttr4.floatValue(), valueOf.floatValue(), floatAttr4.floatValue() + floatAttr6.floatValue(), valueOf.floatValue() + floatAttr7.floatValue(), this.paint);
                    }
                    if (doStroke(properties)) {
                        this.canvas.drawRect(floatAttr4.floatValue(), valueOf.floatValue(), floatAttr4.floatValue() + floatAttr6.floatValue(), valueOf.floatValue() + floatAttr7.floatValue(), this.paint);
                    }
                    popTransform();
                } else if (!this.hidden && str2.equals("line")) {
                    Float floatAttr8 = SVGParser.getFloatAttr("x1", attributes);
                    Float floatAttr9 = SVGParser.getFloatAttr("x2", attributes);
                    Float floatAttr10 = SVGParser.getFloatAttr("y1", attributes);
                    Float floatAttr11 = SVGParser.getFloatAttr("y2", attributes);
                    if (doStroke(new Properties(attributes))) {
                        pushTransform(attributes);
                        doLimits(floatAttr8.floatValue(), floatAttr10.floatValue());
                        doLimits(floatAttr9.floatValue(), floatAttr11.floatValue());
                        this.canvas.drawLine(floatAttr8.floatValue(), floatAttr10.floatValue(), floatAttr9.floatValue(), floatAttr11.floatValue(), this.paint);
                        popTransform();
                    }
                } else if (!this.hidden && str2.equals("circle")) {
                    Float floatAttr12 = SVGParser.getFloatAttr("cx", attributes);
                    Float floatAttr13 = SVGParser.getFloatAttr("cy", attributes);
                    Float floatAttr14 = SVGParser.getFloatAttr("r", attributes);
                    if (!(floatAttr12 == null || floatAttr13 == null || floatAttr14 == null)) {
                        pushTransform(attributes);
                        Properties properties2 = new Properties(attributes);
                        if (doFill(properties2, this.gradientMap)) {
                            doLimits(floatAttr12.floatValue() - floatAttr14.floatValue(), floatAttr13.floatValue() - floatAttr14.floatValue());
                            doLimits(floatAttr12.floatValue() + floatAttr14.floatValue(), floatAttr13.floatValue() + floatAttr14.floatValue());
                            this.canvas.drawCircle(floatAttr12.floatValue(), floatAttr13.floatValue(), floatAttr14.floatValue(), this.paint);
                        }
                        if (doStroke(properties2)) {
                            this.canvas.drawCircle(floatAttr12.floatValue(), floatAttr13.floatValue(), floatAttr14.floatValue(), this.paint);
                        }
                        popTransform();
                    }
                } else if (!this.hidden && str2.equals("ellipse")) {
                    Float floatAttr15 = SVGParser.getFloatAttr("cx", attributes);
                    Float floatAttr16 = SVGParser.getFloatAttr("cy", attributes);
                    Float floatAttr17 = SVGParser.getFloatAttr("rx", attributes);
                    Float floatAttr18 = SVGParser.getFloatAttr("ry", attributes);
                    if (!(floatAttr15 == null || floatAttr16 == null || floatAttr17 == null || floatAttr18 == null)) {
                        pushTransform(attributes);
                        Properties properties3 = new Properties(attributes);
                        this.rect.set(floatAttr15.floatValue() - floatAttr17.floatValue(), floatAttr16.floatValue() - floatAttr18.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue(), floatAttr16.floatValue() + floatAttr18.floatValue());
                        if (doFill(properties3, this.gradientMap)) {
                            doLimits(floatAttr15.floatValue() - floatAttr17.floatValue(), floatAttr16.floatValue() - floatAttr18.floatValue());
                            doLimits(floatAttr15.floatValue() + floatAttr17.floatValue(), floatAttr16.floatValue() + floatAttr18.floatValue());
                            this.canvas.drawOval(this.rect, this.paint);
                        }
                        if (doStroke(properties3)) {
                            this.canvas.drawOval(this.rect, this.paint);
                        }
                        popTransform();
                    }
                } else if (!this.hidden && (str2.equals("polygon") || str2.equals("polyline"))) {
                    NumberParse numberParseAttr = SVGParser.getNumberParseAttr("points", attributes);
                    if (numberParseAttr != null) {
                        Path path = new Path();
                        ArrayList arrayList = numberParseAttr.numbers;
                        if (arrayList.size() > 1) {
                            pushTransform(attributes);
                            Properties properties4 = new Properties(attributes);
                            path.moveTo(((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue());
                            for (int i2 = 2; i2 < arrayList.size(); i2 += 2) {
                                path.lineTo(((Float) arrayList.get(i2)).floatValue(), ((Float) arrayList.get(i2 + 1)).floatValue());
                            }
                            if (str2.equals("polygon")) {
                                path.close();
                            }
                            if (doFill(properties4, this.gradientMap)) {
                                doLimits(path);
                                this.canvas.drawPath(path, this.paint);
                            }
                            if (doStroke(properties4)) {
                                this.canvas.drawPath(path, this.paint);
                            }
                            popTransform();
                        }
                    }
                } else if (!this.hidden && str2.equals("path")) {
                    Path doPath = SVGParser.doPath(SVGParser.getStringAttr("d", attributes));
                    pushTransform(attributes);
                    Properties properties5 = new Properties(attributes);
                    if (doFill(properties5, this.gradientMap)) {
                        doLimits(doPath);
                        this.canvas.drawPath(doPath, this.paint);
                    }
                    if (doStroke(properties5)) {
                        this.canvas.drawPath(doPath, this.paint);
                    }
                    popTransform();
                } else if (!this.hidden) {
                    Log.d("SVGAndroid", "UNRECOGNIZED SVG COMMAND: " + str2);
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            Gradient gradient2;
            Gradient gradient3;
            Gradient gradient4;
            if (str2.equals("svg")) {
                this.picture.endRecording();
                return;
            }
            int i = 0;
            if (str2.equals("linearGradient")) {
                if (this.gradient.id != null) {
                    if (!(this.gradient.xlink == null || (gradient4 = this.gradientRefMap.get(this.gradient.xlink)) == null)) {
                        this.gradient = gradient4.createChild(this.gradient);
                    }
                    int size = this.gradient.colors.size();
                    int[] iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = this.gradient.colors.get(i2).intValue();
                    }
                    int size2 = this.gradient.positions.size();
                    float[] fArr = new float[size2];
                    while (i < size2) {
                        fArr[i] = this.gradient.positions.get(i).floatValue();
                        i++;
                    }
                    if (size == 0) {
                        Log.d("BAD", "BAD");
                    }
                    LinearGradient linearGradient = new LinearGradient(this.gradient.x1, this.gradient.y1, this.gradient.x2, this.gradient.y2, iArr, fArr, Shader.TileMode.CLAMP);
                    if (this.gradient.matrix != null) {
                        linearGradient.setLocalMatrix(this.gradient.matrix);
                    }
                    this.gradientMap.put(this.gradient.id, linearGradient);
                    this.gradientRefMap.put(this.gradient.id, this.gradient);
                }
            } else if (str2.equals("radialGradient")) {
                if (this.gradient.id != null) {
                    if (!(this.gradient.xlink == null || (gradient3 = this.gradientRefMap.get(this.gradient.xlink)) == null)) {
                        this.gradient = gradient3.createChild(this.gradient);
                    }
                    int size3 = this.gradient.colors.size();
                    int[] iArr2 = new int[size3];
                    for (int i3 = 0; i3 < size3; i3++) {
                        iArr2[i3] = this.gradient.colors.get(i3).intValue();
                    }
                    int size4 = this.gradient.positions.size();
                    float[] fArr2 = new float[size4];
                    while (i < size4) {
                        fArr2[i] = this.gradient.positions.get(i).floatValue();
                        i++;
                    }
                    if (!(this.gradient.xlink == null || (gradient2 = this.gradientRefMap.get(this.gradient.xlink)) == null)) {
                        this.gradient = gradient2.createChild(this.gradient);
                    }
                    RadialGradient radialGradient = new RadialGradient(this.gradient.x, this.gradient.y, this.gradient.radius, iArr2, fArr2, Shader.TileMode.CLAMP);
                    if (this.gradient.matrix != null) {
                        radialGradient.setLocalMatrix(this.gradient.matrix);
                    }
                    this.gradientMap.put(this.gradient.id, radialGradient);
                    this.gradientRefMap.put(this.gradient.id, this.gradient);
                }
            } else if (str2.equals("g")) {
                if (this.boundsMode) {
                    this.boundsMode = false;
                }
                if (this.hidden) {
                    int i4 = this.hiddenLevel - 1;
                    this.hiddenLevel = i4;
                    if (i4 == 0) {
                        this.hidden = false;
                    }
                }
                this.gradientMap.clear();
            }
        }
    }
}
