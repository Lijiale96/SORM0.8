package com.bjsxt.sorm.core;



import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.utils.JDBCUtils;
import com.bjsxt.sorm.utils.ReflectUtils;
import com.bjsxt.sorm.utils.StringUtils;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责针对Mysql数据库的查询
 */
public class MySqlQuery extends Query{




    public static void main(String[] args) {
        //Object obj =new MySqlQuery().queryValue("select count(*) from emp where salary>?",new Object[]{10000});

        //Number obj =(Number)new MySqlQuery().queryNumber("select count(*) from emp where salary>?",new Object[]{1000});
        Number obj =(Number)new MySqlQuery().queryValue("select count(*) from emp where salary>?",new Object[]{10000});
        System.out.println(obj.doubleValue());
       // testQueryRows();

    }

    @Override
    public Object queryPagenate(int pageNum, int size) {
        return null;
    }
}
