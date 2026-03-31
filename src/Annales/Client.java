
package Annales;

import java.io.*;
import java.net.*;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// creation de la socket
		Socket s = new Socket();
		InetAddress addr1 = null;
		int port1 = 32506, port2 = 32504;
		try {
			addr1 = InetAddress.getLocalHost();
		}
	    catch (UnknownHostException exp){
		System.out.println("machine inconnue");
		}
		
	    try {
	    	
		// attachement
		InetSocketAddress saddr1 = new InetSocketAddress(addr1, port1);
		s.bind(saddr1);
		
		//	adresse de la machine distante
		InetAddress addr2 = InetAddress.getByName("192.168.1.41");
		InetSocketAddress saddr2 = new InetSocketAddress(addr2, port2);
		
		// demande de connexion
		s.connect(saddr2);
		System.out.println("Connexion etablie entre " +
				s.getLocalSocketAddress() + " et " +
				s.getRemoteSocketAddress());
	    }
		catch (IOException exp){
			System.out.println("erreur d'ouverture");
			}
	   
	
	// Creation des flots
	BufferedReader br = null;
	PrintWriter pw = null;
	try {
	br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	pw = new PrintWriter(s.getOutputStream(), true);
	}
	catch (IOException exp){
		System.out.println("erreur de creation des flots");
		}
	
	// Communication
	try {
	
	// 	inscription
	pw.println("inscription Claude");
	System.out.println(br.readLine());
	pw.println("inscription Muriel");
	System.out.println(br.readLine());
	pw.println("inscription Claude");
	System.out.println(br.readLine());
	
	// 	déinscription
	pw.println("déinscription Muriel");
	System.out.println(br.readLine());
	
	// 	envoi
	pw.println("envoi Muriel");
	pw.println("Bonjour c'est moi Lucie");
	System.out.println(br.readLine());
	
	pw.println("envoi Claude");
	pw.println("Bonjour c'est moi Lucie");
	System.out.println(br.readLine());
	
	pw.println("envoi Claude");
	pw.println("Il faut me répondre");
	System.out.println(br.readLine());
	
	// lecture
	pw.println("lecture Claude");
	int nMessages = Integer.parseInt (br.readLine());
	for (int i = 0; i< nMessages;i++)
	System.out.println(br.readLine());
	System.out.println(br.readLine());
	}
	catch (IOException exp){
		System.out.println("erreur d'entee-sortie");
		}
	}

}
