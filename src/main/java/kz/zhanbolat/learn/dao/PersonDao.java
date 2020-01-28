package kz.zhanbolat.learn.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import kz.zhanbolat.learn.entity.Person;
import kz.zhanbolat.learn.pool.SqlMapClientPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PersonDao {
    private static final Logger logger = LogManager.getLogger(PersonDao.class);
    private static final String SELECT_ALL_QUERY_ID = "getAllPersons";
    private static final String SELECT_ONE_BY_ID_QUERY_ID = "getPersonById";
    private static final String INSERT_QUERY_ID = "insertPerson";
    private static final String UPDATE_QUERY_ID = "updatePerson";
    private static final String DELETE_QUERY_ID = "deletePerson";
    private SqlMapClient sqlMapClient;

    public PersonDao() {
        sqlMapClient = SqlMapClientPool.INSTANCE.getNewClient();
    }

    public PersonDao(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public List<Person> findAll() {
        try {
            return sqlMapClient.queryForList(SELECT_ALL_QUERY_ID);
        } catch (SQLException e) {
            logger.error("Cannot execute select query: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Person findOne(Integer id) {
        try {
            return (Person) sqlMapClient.queryForObject(SELECT_ONE_BY_ID_QUERY_ID, id);
        } catch (SQLException e) {
            logger.error("Cannot execute select query: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //auto-commit enabled
    public void create(Person entity) {
        try {
            sqlMapClient.insert(INSERT_QUERY_ID, entity);
        } catch (SQLException e) {
            logger.error("Cannot execute insert query: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //auto-commit enabled
    public void update(Person entity) {
        try {
            sqlMapClient.update(UPDATE_QUERY_ID, entity);
        } catch (SQLException e) {
            logger.error("Cannot execute update query: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //auto-commit enabled
    public void delete(Integer id) {
        try {
            sqlMapClient.delete(DELETE_QUERY_ID, id);
        } catch (SQLException e) {
            logger.error("Cannot execute delete query: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
