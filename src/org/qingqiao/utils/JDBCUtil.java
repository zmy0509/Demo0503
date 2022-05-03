package org.qingqiao.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

// 工具类 提供便利的类 通常都是复制粘贴
public class JDBCUtil {
    private static Connection conn = null;
    public static Connection getConn(){
        try {
            // 创建数据源工厂
            DruidDataSourceFactory factory = new DruidDataSourceFactory();
            // 读取properties文件
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/db.properties"));
            // 从工厂中生成数据源
            DruidDataSource dataSource = (DruidDataSource) factory.createDataSource(properties);
            // 从数据源中生成连接
            conn = dataSource.getConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
