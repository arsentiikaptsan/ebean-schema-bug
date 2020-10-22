package org.example;

import io.ebean.DB;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import org.example.entity.TestTable;

public class Application {

    public static void main(String[] args) {
        // No luck with programmatic initialization either, same exception
        // initEbeanProgrammatically();

        // Crashes with org.postgresql.util.PSQLException: ERROR: relation "test_table" does not exist.
        // If currentSchema url parameter is set though, it works.
        DB.find(TestTable.class).findCount();

        String search_path = DB.sqlQuery("show search_path").findOne().getString("search_path");
        // Output: Search path: "$user", public
        System.out.println("Search path: " + search_path);
    }

    private static void initEbeanProgrammatically() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:postgresql://localhost:5432/test_db");
        dataSourceConfig.setDriver("org.postgresql.Driver");
        dataSourceConfig.setPassword("12345678");
        dataSourceConfig.setUsername("test_user");
        dataSourceConfig.setSchema("test_schema");

        DatabaseConfig config = new DatabaseConfig();
        config.setDataSourceConfig(dataSourceConfig);
        config.setDefaultServer(true);
        config.setRunMigration(false);

        DatabaseFactory.create(config);
    }
}
