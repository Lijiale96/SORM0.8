package com.bjsxt.sorm.bean;

/**
 * 封装表中一个字段的信息
 * @auther  Lijiale
 */
public class ColumnInfo {
    /**
     * 字段名称
     */
   private String name;

    /**
     * 字段的数据类型
     */
    private String dataTypes;

    /**
     *字段的键类型（0：普通；1：主键；2：外键）
     */
    private int keyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(String dataTypes) {
        this.dataTypes = dataTypes;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }

    public ColumnInfo(String name, String dataTypes, int keyType) {
        this.name = name;
        this.dataTypes = dataTypes;
        this.keyType = keyType;
    }
    public ColumnInfo(){

    }
}
