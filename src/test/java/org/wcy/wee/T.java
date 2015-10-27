package org.wcy.wee;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class T {

	public static void main(String[] args) throws UnknownHostException, SocketException {
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress();//获得本机IP
		String address=addr.getHostName();//获得本机名称
		getAddress();
	}
	
	private static InetAddress getAddress() {
        try {
            for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                if (addresses.hasMoreElements()) {
                	System.out.println(addresses.nextElement());
                    return addresses.nextElement();
                }
            }
        } catch (SocketException e) {
        }
        return null;
    }
}
