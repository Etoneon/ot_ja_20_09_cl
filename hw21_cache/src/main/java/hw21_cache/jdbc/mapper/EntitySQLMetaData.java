package hw21_cache.jdbc.mapper;

/**
 * Создает SQL - запросы
 */
public interface EntitySQLMetaData <T> {
    String getSelectAllSql();

    String getSelectByIdSql();

    String getInsertSql();

    String getUpdateSql();

}
