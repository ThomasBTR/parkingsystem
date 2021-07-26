package com.parkit.parkingsystem.config;

import com.parkit.parkingsystem.util.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

/**
 * The type Data base config.
 */
public class DataBaseConfig {
	/**
	 * The constant logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger("DataBaseConfig");

	/**
	 * The Prop.
	 */
	private final PropertiesReader prop = new PropertiesReader();

	/**
	 * Gets connection.
	 *
	 * @return the connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the sql exception
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		LOGGER.info("Create DB connection");
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test?serverTimezone=UTC", prop.getPropValues(PropertiesReader.DB_USER), prop.getPropValues(PropertiesReader.DB_PASSWORD));
	}

	/**
	 * Close connection.
	 *
	 * @param con the con
	 */
	public void closeConnection(final Connection con) {
		if (con != null) {
			try {
				con.close();
				LOGGER.info("Closing DB connection");
			} catch (SQLException e) {
				LOGGER.error("Error while closing connection", e);
			}
		}
	}

	/**
	 * Close prepared statement.
	 *
	 * @param ps the ps
	 */
	public void closePreparedStatement(final PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
				LOGGER.info("Closing Prepared Statement");
			} catch (SQLException e) {
				LOGGER.error("Error while closing prepared statement", e);
			}
		}
	}

	/**
	 * Close result set.
	 *
	 * @param rs the rs
	 */
	public void closeResultSet(final ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				LOGGER.info("Closing Result Set");
			} catch (SQLException e) {
				LOGGER.error("Error while closing result set", e);
			}
		}
	}
}
