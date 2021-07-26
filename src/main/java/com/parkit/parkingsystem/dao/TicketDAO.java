package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * The type Ticket dao.
 */
public class TicketDAO {

	/**
	 * The constant logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger("TicketDAO");

	/**
	 * The Data base config.
	 */
	private DataBaseConfig dataBaseConfig = new DataBaseConfig();


	/**
	 * Set data base config.
	 *
	 * @param dataBaseConfig the data base config
	 */
	public void setDataBaseConfig(final DataBaseConfig dataBaseConfig) {
		this.dataBaseConfig = dataBaseConfig;
	}

	/**
	 * Save ticket.
	 *
	 * @param ticket the ticket
	 */
	public void saveTicket(final Ticket ticket) {
		Connection con;
		try {
			con = dataBaseConfig.getConnection();
			try (PreparedStatement ps = con.prepareStatement(DBConstants.SAVE_TICKET.getSqlMessage())) {
				ps.setInt(1, ticket.getParkingSpot().getId());
				ps.setString(2, ticket.getVehicleRegNumber());
				ps.setDouble(3, ticket.getPrice());
				ps.setTimestamp(4, Timestamp.valueOf(ticket.getInTime()));
				ps.setTimestamp(5, (ticket.getOutTime() == null) ? null : (Timestamp.valueOf(ticket.getOutTime())));
				ps.execute();
				dataBaseConfig.closePreparedStatement(ps);
			}
			dataBaseConfig.closeConnection(con);
		} catch (Exception ex) {
			LOGGER.error("Error fetching next available slot", ex);
		}
	}

	/**
	 * Gets ticket.
	 *
	 * @param vehicleRegNumber the vehicle reg number
	 * @return the ticket
	 */
	public Ticket getTicket(final String vehicleRegNumber) {
		Connection con;
		Ticket ticket = null;
		try {
			con = dataBaseConfig.getConnection();
			try (PreparedStatement ps = con.prepareStatement(DBConstants.GET_TICKET.getSqlMessage())) {
				//ID, PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME)
				ps.setString(1, vehicleRegNumber);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					ticket = new Ticket();
					ParkingSpot parkingSpot = new ParkingSpot(rs.getInt(1), ParkingType.valueOf(rs.getString(6)), false);
					ticket.setParkingSpot(parkingSpot);
					ticket.setId(rs.getInt(2));
					ticket.setVehicleRegNumber(vehicleRegNumber);
					ticket.setPrice(rs.getDouble(3));
					ticket.setInTime(rs.getTimestamp(4).toLocalDateTime());
					ticket.setOutTime(rs.getTimestamp(5).toLocalDateTime());
				}
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
			}
			dataBaseConfig.closeConnection(con);
		} catch (Exception ex) {
			LOGGER.error("Error fetching next available slot", ex);
		}
		return ticket;
	}

	/**
	 * Update ticket boolean.
	 *
	 * @param ticket the ticket
	 * @return the boolean
	 */
	public boolean updateTicket(final Ticket ticket) {
		Connection con;
		try {
			con = dataBaseConfig.getConnection();
			try (PreparedStatement ps = con.prepareStatement(DBConstants.UPDATE_TICKET.getSqlMessage())) {
				assert ticket != null;
				ps.setDouble(1, ticket.getPrice());
				ps.setTimestamp(2, Timestamp.valueOf(ticket.getOutTime()));
				ps.setInt(3, ticket.getId());
				ps.execute();
				dataBaseConfig.closePreparedStatement(ps);
			}
			dataBaseConfig.closeConnection(con);

		} catch (Exception ex) {
			LOGGER.error("Error saving ticket info", ex);
			return false;
		}
		return true;
	}
}
