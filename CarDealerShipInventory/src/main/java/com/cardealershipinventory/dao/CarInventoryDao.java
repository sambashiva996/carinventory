package com.cardealershipinventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cardealershipinventory.model.CarInventory;

public class CarInventoryDao {

	@Autowired
	private JdbcTemplate template;

	public String save(CarInventory car) {

		String insertCar = "insert into carinvent values('" + car.getMake() + "','" + car.getModel() + "',"
				+ car.getYear() + "," + car.getSalePrice() + ")";

		template.update(insertCar);

		return "Saved Successfully";
	}

	public String delete(int year) {

		String deleteCar = "delete from carinvent where year =" + year;

		template.update(deleteCar);

		return "Deleted Successfully";
	}

	public List<CarInventory> getListOfCar() {
		return template.query("select * from carinvent", new RowMapper() {

			public CarInventory mapRow(ResultSet rs, int rowNum) throws SQLException {

				CarInventory carInvnetory = new CarInventory();

				carInvnetory.setMake(rs.getString(1));
				carInvnetory.setModel(rs.getString(2));
				carInvnetory.setYear(rs.getInt(3));
				carInvnetory.setSalePrice(rs.getInt(4));
				return carInvnetory;

			}

		});

	}

}
