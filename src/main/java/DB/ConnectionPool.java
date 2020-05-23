package DB;

import com.mchange.v2.c3p0.*;

import java.beans.PropertyVetoException;
import org.apache.commons.pool.impl.GenericObjectPool;


public class ConnectionPool {
    private static ConnectionPool single_instance = null;
    private ComboPooledDataSource comboPooledDataSource;
    private static GenericObjectPool genericObjectPool = null;

    private ConnectionPool() throws PropertyVetoException {
        this.comboPooledDataSource = new ComboPooledDataSource();
        this.comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver ");
        this.comboPooledDataSource.setJdbcUrl( "jdbc:mysql://79.112.59.146:3307/music_albums_diana?" );
        this.comboPooledDataSource.setUser("dbadiana&");
        this.comboPooledDataSource.setPassword("pass");
        this.comboPooledDataSource.setMinPoolSize(5);
        this.comboPooledDataSource.setAcquireIncrement(5);
        this.comboPooledDataSource.setMinPoolSize(30);
    }

    public static ConnectionPool getInstance() throws PropertyVetoException {
        if(single_instance == null)
            single_instance = new ConnectionPool();
        return single_instance;
    }

    public ComboPooledDataSource getComboPooledDataSource() {
        return this.comboPooledDataSource;
    }

    public ConnectionPool setMaxStatements(int maxStatements) {
        this.comboPooledDataSource.setMaxStatements(maxStatements);
        return this;
    }

    public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
        this.comboPooledDataSource = comboPooledDataSource;
    }

    public void close() {
        this.comboPooledDataSource.close();
    }

}
