package player_info_application.player_info_application.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class
Connect {
    private static final Logger log = LoggerFactory.getLogger(Connect.class);
    private static final String DB_USERNAME="db.username";
    private static final String DB_PASSWORD="db.password";
    private static final String DB_URL ="db.url";
    private static final String DB_DRIVER_CLASS="driver.class.name";
    private static Properties properties = null;
    private static ComboPooledDataSource dataSource;
    static{
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/database.properties"));

            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(properties.getProperty(DB_DRIVER_CLASS));

            dataSource.setJdbcUrl(properties.getProperty(DB_URL));
            dataSource.setUser(properties.getProperty(DB_USERNAME));
            dataSource.setPassword(properties.getProperty(DB_PASSWORD));

            dataSource.setInitialPoolSize(10);
            dataSource.setMinPoolSize(10);
            dataSource.setMaxPoolSize(12);
            dataSource.setAcquireIncrement(5);

        } catch (IOException | PropertyVetoException e) {
           log.error("Error occurred while creating the connection with db" );
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}