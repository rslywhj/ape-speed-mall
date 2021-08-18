package com.tjetc.admin.common;

/**
 * 配置信息
 */
public class CommonConstants {

    private static PropertiesLoader propertiesLoader = new PropertiesLoader("admin.properties");
    //图片基本路径 如：E:/image
    public static final String IMG_BASE_PATH = propertiesLoader.getProperty("img.base.path");
    public static final String IMG_UPLOAD_TYPE = propertiesLoader.getProperty("img.upload.type");
}
