package com.coolapk.market.animation.Interpolator;

class EasingProvider {
    private static float getBackInOut(float f, float f2) {
        double d;
        float f3 = (float) (((double) f2) * 1.525d);
        float f4 = f * 2.0f;
        if (f4 < 1.0f) {
            d = (double) (f4 * f4 * (((1.0f + f3) * f4) - f3));
        } else {
            float f5 = f4 - 2.0f;
            d = (double) ((f5 * f5 * (((1.0f + f3) * f5) + f3)) + 2.0f);
        }
        return (float) (d * 0.5d);
    }

    private static float getBounceOut(float f) {
        double d;
        double d2;
        double d3;
        double d4 = (double) f;
        if (d4 < 0.36363636363636365d) {
            d3 = 7.5625d * d4 * d4;
        } else {
            if (d4 < 0.7272727272727273d) {
                double d5 = (double) ((float) (d4 - 0.5454545454545454d));
                d = 7.5625d * d5 * d5;
                d2 = 0.75d;
            } else if (d4 < 0.9090909090909091d) {
                double d6 = (double) ((float) (d4 - 0.8181818181818182d));
                d = 7.5625d * d6 * d6;
                d2 = 0.9375d;
            } else {
                double d7 = (double) ((float) (d4 - 0.9545454545454546d));
                d = 7.5625d * d7 * d7;
                d2 = 0.984375d;
            }
            d3 = d + d2;
        }
        return (float) d3;
    }

    EasingProvider() {
    }

    public static float get(Ease ease, float f) {
        switch (ease) {
            case QUAD_IN:
                return getPowIn(f, 2.0d);
            case QUAD_OUT:
                return getPowOut(f, 2.0d);
            case QUAD_IN_OUT:
                return getPowInOut(f, 2.0d);
            case CUBIC_IN:
                return getPowIn(f, 3.0d);
            case CUBIC_OUT:
                return getPowOut(f, 3.0d);
            case CUBIC_IN_OUT:
                return getPowInOut(f, 3.0d);
            case QUART_IN:
                return getPowIn(f, 4.0d);
            case QUART_OUT:
                return getPowOut(f, 4.0d);
            case QUART_IN_OUT:
                return getPowInOut(f, 4.0d);
            case QUINT_IN:
                return getPowIn(f, 5.0d);
            case QUINT_OUT:
                return getPowOut(f, 5.0d);
            case QUINT_IN_OUT:
                return getPowInOut(f, 5.0d);
            case SINE_IN:
                return (float) (1.0d - Math.cos((((double) f) * 3.141592653589793d) / 2.0d));
            case SINE_OUT:
                return (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
            case SINE_IN_OUT:
                return (float) ((Math.cos(((double) f) * 3.141592653589793d) - 1.0d) * -0.5d);
            case BACK_IN:
                return (float) (((double) (f * f)) * ((((double) f) * 2.7d) - 1.7d));
            case BACK_OUT:
                float f2 = f - 1.0f;
                return (float) ((((double) (f2 * f2)) * ((((double) f2) * 2.7d) + 1.7d)) + 1.0d);
            case BACK_IN_OUT:
                return getBackInOut(f, 1.7f);
            case CIRC_IN:
                return (float) (-(Math.sqrt((double) (1.0f - (f * f))) - 1.0d));
            case CIRC_OUT:
                float f3 = f - 1.0f;
                return (float) Math.sqrt((double) (1.0f - (f3 * f3)));
            case CIRC_IN_OUT:
                float f4 = f * 2.0f;
                if (f4 < 1.0f) {
                    return (float) ((Math.sqrt((double) (1.0f - (f4 * f4))) - 1.0d) * -0.5d);
                }
                float f5 = f4 - 2.0f;
                return (float) ((Math.sqrt((double) (1.0f - (f5 * f5))) + 1.0d) * 0.5d);
            case BOUNCE_IN:
                return getBounceIn(f);
            case BOUNCE_OUT:
                return getBounceOut(f);
            case BOUNCE_IN_OUT:
                if (f < 0.5f) {
                    return getBounceIn(f * 2.0f) * 0.5f;
                }
                return (getBounceOut((f * 2.0f) - 1.0f) * 0.5f) + 0.5f;
            case ELASTIC_IN:
                return getElasticIn(f, 1.0d, 0.3d);
            case ELASTIC_OUT:
                return getElasticOut(f, 1.0d, 0.3d);
            case ELASTIC_IN_OUT:
                return getElasticInOut(f, 1.0d, 0.45d);
            default:
                return f;
        }
    }

    private static float getPowIn(float f, double d) {
        return (float) Math.pow((double) f, d);
    }

    private static float getPowOut(float f, double d) {
        return (float) (1.0d - Math.pow((double) (1.0f - f), d));
    }

    private static float getPowInOut(float f, double d) {
        float f2 = f * 2.0f;
        if (f2 < 1.0f) {
            return (float) (Math.pow((double) f2, d) * 0.5d);
        }
        return (float) (1.0d - (Math.abs(Math.pow((double) (2.0f - f2), d)) * 0.5d));
    }

    private static float getBounceIn(float f) {
        return 1.0f - getBounceOut(1.0f - f);
    }

    private static float getElasticIn(float f, double d, double d2) {
        if (f == 0.0f || f == 1.0f) {
            return f;
        }
        float f2 = f - 1.0f;
        return (float) (-(d * Math.pow(2.0d, (double) (10.0f * f2)) * Math.sin(((((double) f2) - ((d2 / 6.283185307179586d) * Math.asin(1.0d / d))) * 6.283185307179586d) / d2)));
    }

    private static float getElasticOut(float f, double d, double d2) {
        if (f == 0.0f || f == 1.0f) {
            return f;
        }
        return (float) ((d * Math.pow(2.0d, (double) (-10.0f * f)) * Math.sin(((((double) f) - ((d2 / 6.283185307179586d) * Math.asin(1.0d / d))) * 6.283185307179586d) / d2)) + 1.0d);
    }

    private static float getElasticInOut(float f, double d, double d2) {
        double pow;
        double asin = (d2 / 6.283185307179586d) * Math.asin(1.0d / d);
        float f2 = f * 2.0f;
        if (f2 < 1.0f) {
            float f3 = f2 - 1.0f;
            pow = d * Math.pow(2.0d, (double) (10.0f * f3)) * Math.sin(((((double) f3) - asin) * 6.283185307179586d) / d2) * -0.5d;
        } else {
            float f4 = f2 - 1.0f;
            pow = (d * Math.pow(2.0d, (double) (-10.0f * f4)) * Math.sin(((((double) f4) - asin) * 6.283185307179586d) / d2) * 0.5d) + 1.0d;
        }
        return (float) pow;
    }
}
