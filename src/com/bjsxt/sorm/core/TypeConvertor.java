package com.bjsxt.sorm.core;

/**
 * 负责java数据类型和数据库数据类型的互相转换
 */
public interface TypeConvertor {
    /**
     * 将数据库数据类型转化成java的数据类型
     * @param columnType
     * @return
     */
    public String datebaseType2JavaType(String columnType);

    /**
     * 将java数据类型转化成数据库数据类型
     * @param javaDataType
     * @return
     */
    public String javaType2DatebaseType(String javaDataType);
}
