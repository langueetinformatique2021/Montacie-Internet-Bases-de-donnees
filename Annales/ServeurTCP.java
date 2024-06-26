package Annales;

import java.io.*;
import java.net.*;

public class ServeurTCP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 32504;
		InetSocketAddress saddr = null;
		Socket s = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			saddr = new InetSocketAddress(addr, port);
		}
	    catch (UnknownHostException exp){
	    	System.out.println("machine inconnue");
	    }
		
		try {
        // creation d'un ecouteur de connexion
		ServerSocket ss = new ServerSocket();
		// attachement
		ss.bind(saddr);
		// acceptation de la connexion
		while (true) {
			s = ss.accept();
			System.out.println("Connexion etablie entre " +
					s.getLocalSocketAddress() + " et " +
					s.getRemoteSocketAddress());
			new ServeurTCPThread(s);
		}
		}
		catch (IOException exp){
			System.out.println("erreur d'ouvertue");
			}
		
	}

}
