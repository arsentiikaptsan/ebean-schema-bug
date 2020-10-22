<h1>Test project to showcase what seems to be an ebean bug.</h1>
Ebean does not respect schema in connections to PostgresSQL.<br>
Tested on PostgreSQL 12.<br>
User: test_user.<br>
Database: test_db, owned by test_user.<br>
Schema: test_schema.<br>
There was one table: test_db.test_schema.test_table.<br>
![Screenshot](screenshots/proof.png)<br>
Simple query fails with exception org.postgresql.util.PSQLException: ERROR: relation "test_table" does not exist.<br>
More details in code.
