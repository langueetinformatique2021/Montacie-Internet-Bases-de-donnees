package cours04;

import java.io.*;
import java.net.*;

public class DemandeConnexion {

    public static void main(String[] args) {

        int port = 32505;

        try (Socket s = new Socket()) {

            // Adresse locale (optionnelle)
            InetAddress addr1 = InetAddress.getLocalHost();
            InetSocketAddress localAddr = new InetSocketAddress(addr1, port);

            // ⚠️ Le bind est optionnel, à supprimer si inutile
            s.bind(localAddr);

            // Adresse distante
            InetAddress addr2 = InetAddress.getByName("192.168.1.41");
            InetSocketAddress remoteAddr = new InetSocketAddress(addr2, port);

            // Connexion
            s.connect(remoteAddr);

            System.out.println("Connexion établie entre " +
                    s.getLocalSocketAddress() + " et " +
                    s.getRemoteSocketAddress());

            // Création des flux
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

            // Communication
            pw.println("debut de la communication TCP");
            String ligne = br.readLine();
            System.out.println(ligne);

        } catch (UnknownHostException e) {
            System.out.println("Machine inconnue");
        } catch (IOException e) {
            System.out.println("Erreur d'entrée-sortie : " + e.getMessage());
        }
    }
}