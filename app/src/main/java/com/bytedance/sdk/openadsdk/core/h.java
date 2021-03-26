package com.bytedance.sdk.openadsdk.core;

/* compiled from: ErrorCode */
public class h {
    public static String a(int i) {
        if (i == 201) {
            return "icon加载response错误";
        }
        if (i == 202) {
            return "icon图标加载失败";
        }
        if (i == 20001) {
            return "没有广告";
        }
        if (i == 50001) {
            return "服务器错误";
        }
        if (i == 60007) {
            return "激励视频验证服务器异常或处理失败";
        }
        switch (i) {
            case -14:
                return "开屏视频加载失败";
            case -13:
                return "广告请求使用了错误代码位";
            case -12:
                return "缓存中没有开屏广告";
            case -11:
                return "缓存过期";
            case -10:
                return "缓存解析失败";
            case -9:
                return "请求实体为空";
            case -8:
                return "广告请求频率过高";
            case -7:
                return "开屏广告图片加载失败";
            case -6:
                return "插屏广告图片加载失败";
            case -5:
                return "Banner广告加载图片失败";
            case -4:
                return "返回数据缺少必要字段";
            case -3:
                return "没有解析到广告";
            case -2:
                return "网络请求失败";
            case -1:
                return "解析失败";
            default:
                switch (i) {
                    case 101:
                        return "渲染结果数据解析失败";
                    case 102:
                        return "主模板无效";
                    case 103:
                        return "模板差量无效";
                    case 104:
                        return "模板物料数据异常";
                    case 105:
                        return "模板数据解析异常";
                    case 106:
                        return "渲染未知报错";
                    case 107:
                        return "渲染超时未回调";
                    case 108:
                        return "模板广告加载超时无返回";
                    case 109:
                        return "模板主引擎加载失败";
                    case 110:
                        return "模板广告请求参数不合法，如传入宽度不大于0";
                    default:
                        switch (i) {
                            case 40000:
                                return "http conent_type错误";
                            case 40001:
                                return "http request pb错误";
                            case 40002:
                                return "请求app不能为空 ";
                            case 40003:
                                return "请求wap不能为空";
                            case 40004:
                                return "广告位不能为空";
                            case 40005:
                                return "广告位尺寸不能为空";
                            case 40006:
                                return "广告位ID不合法";
                            case 40007:
                                return "广告数量错误";
                            case 40008:
                                return "图片尺寸错误";
                            case 40009:
                                return "媒体ID不合法";
                            case 40010:
                                return "媒体类型不合法";
                            case 40011:
                                return "广告类型不合法";
                            case 40012:
                            case 40017:
                                return "媒体接入类型不合法";
                            case 40013:
                                return "开屏广告类型异常";
                            case 40014:
                                return "redirect参数不正确";
                            case 40015:
                                return "媒体整改超过期限，请求非法";
                            case 40016:
                                return "SlotId和AppId匹配异常";
                            case 40018:
                                return "媒体包名异常";
                            case 40019:
                                return "媒体配置adtype和请求不一致";
                            case 40020:
                                return "开发注册新上线广告位超出日请求量限制";
                            case 40021:
                                return "apk签名sha1值与媒体平台录入不一致";
                            case 40022:
                                return "媒体请求素材是否原生与媒体平台录入不一致";
                            case 40023:
                                return "os字段填的不对";
                            case 40024:
                                return "sdk 版本过低不返回广告";
                            default:
                                switch (i) {
                                    case 60001:
                                        return "show event处理错误";
                                    case 60002:
                                        return "click event处理错误";
                                    default:
                                        return "未知报错";
                                }
                        }
                }
        }
    }
}
