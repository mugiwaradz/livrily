package util;

import java.sql.Connection;

public interface DB {

	Connection getConnection();

	void closeConnection(Connection Connection);

}
