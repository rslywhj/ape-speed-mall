package com.tjetc.admin.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载properties文件
 */
public class PropertiesLoader {
    private Properties p;

    public PropertiesLoader(String propertiesPath) {
        InputStream inputStream = null;
        try {
            //创建db.properties的流
            inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertiesPath);
            //创建Properties对象
            p = new Properties();
            //把数据流读入Properties对象中
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取配置文件对应的属性
     *
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName) {
        return this.p.getProperty(propertyName);
    }
}
