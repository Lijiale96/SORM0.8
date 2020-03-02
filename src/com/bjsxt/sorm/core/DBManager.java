package com.bjsxt.sorm.core;

import com.bjsxt.pool.DBConnPool;
import com.bjsxt.sorm.bean.Configuration;


import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 */

public class DBManager {
    /**
     * 配置信息
     */
    private static Configuration conf;
    /**
     * 连接池对象
     */
    private static DBConnPool pool;

    static { //静态代码块
        Properties pros = new Properties();

        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        conf = new Configuration();
        conf.setDriver(pros.getProperty("driver"));
        conf.setPoPackage(pros.getProperty("poPackage"));
        conf.setPwd(pros.getProperty("pwd"));
        conf.setSrcPath(pros.getProperty("srcPath"));
        conf.setUrl(pros.getProperty("url"));
        conf.setUser(pros.getProperty("user"));
        conf.setUsingDB(pros.getProperty("usingDB"));
        conf.setQueryClass(pros.getProperty("queryClass"));
        conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
        conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));


        //加载TableContext
        System.out.println(TableContext.class);
    }


    /**
     * 获得Connection对象
     * @return
     */

    public static Connection getConn() {
        if (pool==null){
            pool = new DBConnPool();
        }
        return  pool.getConnection();
    }


    /**
     * 创建新的Connection对象
     * @return
     */

    public static Connection createConn() {
        try {
            Class.forName(conf.getDriver());
            return  DriverManager.getConnection(conf.getUrl()
                    ,conf.getUser(),conf.getPwd()); //直接建立连接，后期增加连接池处理，提高效率
//                Class.forName(pros.getProperty("mysqlDriver"));
//                return  DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
//                        pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭传入的ResultSet、Statement、Connection对象
     * @param rs
     * @param ps
     * @param conn
     */
        public static void close(ResultSet rs,Statement ps,Connection conn){
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
//
//            try {
//                if (conn != null) {
//                    try {
//                        conn.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            pool.close(conn);
        }

    /**
     * 关闭传入的Statement、Connection对象
     * @param ps
     * @param conn
     */
    public static void close(Statement ps,Connection conn){
            try {
                if (ps != null) {
                    ps.close();
                }} catch (SQLException e){
                e.printStackTrace();
            }

//            try {
//            if (conn != null) {
//                conn.close();}
//        } catch (SQLException e){
//            e.printStackTrace();
//        }

        pool.close(conn);
        }

    /**
     * 关闭传入的Connection对象
     * @param conn
     */
    public static void close(Connection conn){
//            try {
//                if (conn != null) {
//                    conn.close();}
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
       pool.close(conn);
        }



    /**
     * 返回configuration对象
     * @return
     */
    public  static Configuration getConf(){
        return conf;
    }
}
