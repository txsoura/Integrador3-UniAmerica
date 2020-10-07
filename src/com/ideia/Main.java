package com.ideia;

import com.sun.net.httpserver.HttpServer;

import com.Http.AddressHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
			ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
			server.createContext("/addresses", new AddressHandler());
			server.setExecutor(threadPoolExecutor);
			server.start();
			Logger.getLogger(" Server started on http://127.0.0.1:8000");

		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
