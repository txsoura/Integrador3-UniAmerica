package com.Http;

import com.Controller.AddressController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange) {
		String  requestParamValue  = null;

		if (null == httpExchange.getRequestMethod()) {

		} else
			try {
				switch (httpExchange.getRequestMethod()) {

				case "GET" -> handleGetRequest(httpExchange);
				case "POST" -> handlePostRequest(httpExchange);
				case "PUT" -> handlePutRequest(httpExchange);
				case "DELETE" -> handleDeleteRequest(httpExchange);
				default -> {
				}

				}
			} catch (IOException e) {// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {// TODO Auto-generated catch block
				e.printStackTrace();
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
			}

	}

	private void handleGetRequest(HttpExchange httpExchange) throws IOException, SQLException{
		AddressController controller = new AddressController();
		String request_uri = httpExchange.getRequestURI().toString();
		OutputStream outStream = httpExchange.getResponseBody();
		JSONObject json;
		int id = 0;

		if (request_uri.split("/").length <= 2) {
			JSONObject json_array = null;

			json_array =  controller.index();
			httpExchange.sendResponseHeaders(200, json_array.toString().length());
			outStream.write(json_array.toString().getBytes());

			outStream.flush();
			outStream.close();
		} else {

			id = Integer.valueOf(request_uri.split("/")[2]);
			json = controller.show(id);
			httpExchange.sendResponseHeaders(200, json.toString().length());

			outStream.write(json.toString().getBytes());
			outStream.flush();
			outStream.close();
		}

	}

	private void handlePostRequest(HttpExchange httpExchange) throws IOException {
		OutputStream outStream = httpExchange.getResponseBody();
		httpExchange.sendResponseHeaders(200, "teste".length());
		outStream.write("teste".getBytes());
		InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		StringBuilder buf = new StringBuilder();

		int b;
		while ((b = br.read()) != -1) {
			buf.append((char) b);
		}
		br.close();
		isr.close();

		System.out.println(buf.toString());
		outStream.flush();
		outStream.close();

	}

	private void handlePutRequest(HttpExchange httpExchange) {
		// TODO
	}

	private void handleDeleteRequest(HttpExchange httpExchange) throws IOException,SQLException {
		AddressController controller = new AddressController();
		String request_uri = httpExchange.getRequestURI().toString();
		OutputStream outStream = httpExchange.getResponseBody();
		JSONObject json;
		int id = 0;

		if (request_uri.split("/").length >= 2) {

			id = Integer.valueOf(request_uri.split("/")[2]);
			controller.delete(id);
			try {
			json = new JSONObject();
			
				json.put("status", "removido");
				httpExchange.sendResponseHeaders(200, json.toString().length());
				outStream.write(json.toString().getBytes());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
		try {	json = new JSONObject();
			json.put("status", "erro no servidor");
			outStream.write(json.toString().getBytes());
			httpExchange.sendResponseHeaders(500, json.toString().length());
			outStream.write(json.toString().getBytes());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}

		outStream.flush();
		outStream.close();

	}
}
