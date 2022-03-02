//package com.brq.utils;
//
//import static org.junit.Assert.assertTrue;
//
//import java.io.IOException;
//import java.net.InetAddress;
//
//import org.junit.Test;
//
//public class PingTest {
//
//	String host = "apphubhml";
//
//	private void test(String host) throws IOException {
//		InetAddress address = InetAddress.getByName(host);
//		boolean reachable = address.isReachable(10000);
//		assertTrue(reachable);
//	}
//
//	@Test
//	public void pingApphubhml() throws IOException {
//		test(host);
//	}
//
//	@Test
//	public void pingTriade() throws IOException {
//		test("apachehml2re");
//	}
//
//	@Test
//	public void pingPortonet() throws IOException {
//		test("portonet");
//	}
//
//	@Test
//	public void todos() throws IOException {
//		pingPortonet();
//		pingTriade();
//		pingPortonet();
//	}
//}
