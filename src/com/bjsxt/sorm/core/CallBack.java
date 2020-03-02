package com.bjsxt.sorm.core;

import com.bjsxt.sorm.utils.ReflectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public interface CallBack {

    public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs);


}
