package com.Controller;

import java.sql.SQLException;
import com.Model.DAO.AddressDao;
import com.Model.bean.Address;
import org.json.JSONObject;
import org.json.JSONException;

public class AddressController {
	private final AddressDao addressDao = new AddressDao();

	private Address jsonToObject(JSONObject json) {
		Address object = new Address();
		try {
			object.setId(json.getInt("id"));

			object.setNumber(json.getInt("number"));
			object.setComplement(json.getString("complement"));
			object.setDistrict(json.getString("district"));
			object.setPostcode(json.getInt("postcode"));
			object.setStreet(json.getString("street"));
		} catch (Exception e) {

		}
		return object;
	}

	private JSONObject ObjectToJson(Address object) {
		JSONObject json = new JSONObject();
		try {
			json.put("id", object.getId());
			json.put("number", object.getNumber());
			json.put("complement", object.getComplement());
			json.put("district", object.getDistrict());
			json.put("postcode", object.getPostcode());
			json.put("street", object.getStreet());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}

	public JSONObject index() throws SQLException {
		return ObjectToJson((Address) addressDao.index());
	}

	public void store(JSONObject json) throws SQLException, Exception {
		Address address = jsonToObject(json);
		addressDao.store(address);
	}

	public JSONObject show(int id) throws SQLException {
		return ObjectToJson(addressDao.show(id));
	}

	public void update(JSONObject json) throws SQLException {
		Address address = jsonToObject(json);
		addressDao.update(address);
	}

	public void delete(int id) throws SQLException {
		addressDao.delete(id);
	}

}
