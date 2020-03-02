package com.bjsxt.sorm.core;


import com.bjsxt.po.Emp;
import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.utils.JDBCUtils;
import com.bjsxt.sorm.utils.ReflectUtils;
import com.bjsxt.sorm.utils.StringUtils;
import com.bjsxt.vo.EmpVO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责针对Mysql数据库的查询
 */
public class MySqlQuery extends Query{

    public static void testDML(){
        Emp e = new Emp();e.setId(4);
        e.setEmpname("Tom");
        e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
        e.setAge(30);
        e.setSalary(56464.0);

        new MySqlQuery().update(e,new String[]{"empname","age","salary"});
//        new MySqlQuery().insert(e);
//          new MySqlQuery().delete(e);
    }

    public static void testQueryRows(){
        List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?",
                Emp.class,new Object[]{20,50000} );

        for (Emp e:list) {
            System.out.println(e.getEmpname());
        }

        String sql2 = " select e.id, e.empname, salary + bonus 'xinshui', age, d.dname 'deptName',d.address 'deptAddr' from emp e " +
                "join dept d on e.deptId = d.id";
        List<EmpVO> list2 = new MySqlQuery().queryRows(sql2,
                EmpVO.class,null );

        for (EmpVO e:list2) {
            System.out.println(e.getEmpname()+"-"+e.getDeptAddr()+"-"+e.getXinshui());
        }

    }

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
