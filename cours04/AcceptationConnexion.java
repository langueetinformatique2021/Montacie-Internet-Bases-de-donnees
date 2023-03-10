
package cours04;

import java.io.*;
import java.net.*;

public class AcceptationConnexion {

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
		s = ss.accept();
		System.out.println("Connexion etablie entre " +
				s.getLocalSocketAddress() + " et " +
				s.getRemoteSocketAddress());

		}
		catch (IOException exp){
			System.out.println("erreur d'ouverture");
			}
		
//		 Creation des flots
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(s.getOutputStream(), true);
		}
		catch (IOException exp){
			System.out.println("errreur de creation des flots");
		}
		
//		 Communication
		try {
		String ligne = br.readLine();
		System.out.println(ligne);
		pw.println("fin de la communication TCP");
		br.readLine();
		}
		catch (IOException exp){
			System.out.println("erreur d'entee-sortie");
			}
	}
		
	

}
