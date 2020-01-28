package kz.zhanbolat.learn.pool;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public enum SqlMapClientPool {
    INSTANCE;

    private final String CONFIG_FILE_PATH = "./SqlMapConfig.xml";
    private Logger logger = LogManager.getLogger(SqlMapClientPool.class);

    public SqlMapClient getNewClient() {
        Reader resource = null;
        try {
            resource = Resources.getResourceAsReader(CONFIG_FILE_PATH);
        } catch (IOException e) {
            logger.error("No config file in this path: " + CONFIG_FILE_PATH);
        }
        return SqlMapClientBuilder.buildSqlMapClient(resource);
    }
}
