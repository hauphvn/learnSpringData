package com.coderzero.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class MysqlJDBC {
//    @Autowired
//    private DataSource dataSource;
//
//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    //Get connection without using datasource
    public Connection getConn() throws FileNotFoundException {
        Connection conn = null;
        try( InputStream inputStream = getClass().getClassLoader().getResourceAsStream("dbConfig.properties")){
            Properties prop = new Properties();
            prop.load(inputStream);
            conn = DriverManager.getConnection(prop.getProperty("url"),
                    prop.getProperty("user"),
                    prop.getProperty("password"));
        }catch (IOException | SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public  Connection getConnUsingDataSource(){

//        System.out.println("fdfsdf");
//        System.out.println(dataSource);
//        try (Connection connection = dataSource.getConnection()){
//            return connection;
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
        return null;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump -uroot -pdisfgycdvbfg kaykafePos -r " +
                "D:\\hauphvn-ExportDB\\Dropbox\\db\\backupKayPos.sql";

        /*NOTE: Executing the command here*/
        long startTime = System.currentTimeMillis();
        try{
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Execution time in milliseconds: " + (long)(endTime - startTime));

        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/

    }
}
