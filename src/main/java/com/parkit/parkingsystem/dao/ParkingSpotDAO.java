package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * The type Parking spot dao.
 */
public class ParkingSpotDAO {
	/**
	 * The constant logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger("ParkingSpotDAO");

	/**
	 * The Data base config.
	 */
	private final DataBaseConfig dataBaseConfig = new DataBaseConfig();

	/**
	 * Gets data base config.
	 *
	 * @return the data base config
	 */
	public DataBaseConfig getDataBaseConfig() {
		return dataBaseConfig;
	}

	/**
	 * Get next available slot int.
	 *
	 * @param parkingType the parking type
	 * @return the int
	 */
	public int getNextAvailableSlot(final ParkingType parkingType) {
		Connection con = null;
		int result = -1;
		try {
			con = dataBaseConfig.getConnection();
			try (PreparedStatement ps = con.prepareStatement(DBConstants.GET_NEXT_PARKING_SPOT.getSqlMessage())) {
				ps.setString(1, parkingType.toString());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					result = rs.getInt(1);
				}
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
			}
		} catch (Exception ex) {
			LOGGER.error("Error fetching next available slot", ex);
		} finally {
			dataBaseConfig.closeConnection(con);
		}
		return result;
	}

	/**
	 * Update parking boolean.
	 *
	 * @param parkingSpot the parking spot
	 * @return the boolean
	 */
	public boolean updateParking(final ParkingSpot parkingSpot) {
		//update the availability fo that parking slot
		Connection con = null;
		try {
			con = dataBaseConfig.getConnection();
			int updateRowCount;
			try (PreparedStatement ps = con.prepareStatement(DBConstants.UPDATE_PARKING_SPOT.getSqlMessage())) {
				ps.setBoolean(1, parkingSpot.isAvailable());
				ps.setInt(2, parkingSpot.getId());
				updateRowCount = ps.executeUpdate();
				dataBaseConfig.closePreparedStatement(ps);
			}
			return (updateRowCount == 1);
		} catch (Exception ex) {
			LOGGER.error("Error updating parking info", ex);
			return false;
		} finally {
			dataBaseConfig.closeConnection(con);
		}
	}

}
