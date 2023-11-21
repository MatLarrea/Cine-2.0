/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.Controller;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mlarr
 */


//Conexion a la base de datos
public class ConectorDB {
    
    private Connection conn;
    
    public Connection getConn(){
        return conn;
    }
    
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public void creaConexion() throws SQLException{
        final String DB_URL = "jdbc:oracle:thin:@cine_high?TNS_ADMIN=./Wallet_Cine";
        final String DB_USER = "admin";
        String DB_PASSWORD = "Electra77@2000";
        final String CONN_FACTORY_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";
        PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
        
        pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
        pds.setURL(DB_URL);
        pds.setUser(DB_USER);
        pds.setPassword(DB_PASSWORD);
        pds.setConnectionPoolName("JDBC_UCP_POOL");
        
        pds.setInitialPoolSize(5);
        
        pds.setMinPoolSize(5);
        pds.setMaxPoolSize(20);
        
        try{
            this.conn = pds.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }       
        System.out.println("Available connections after checkout: "
                + pds.getAvailableConnectionsCount());
        System.out.println("Borrowed connections after checkout: "
                + pds.getBorrowedConnectionsCount());
        // Perform a database operation

        System.out.println("CONEXION EXITOSA");
        System.out.println("CONECTADO al schema: " + conn.getSchema());
    }
}
