package cours04;

import java.io.*;
import java.net.*;

public class AcceptationConnexion {

    public static void main(String[] args) {

        int port = 32505;

        try (ServerSocket ss = new ServerSocket(port)) {

            System.out.println("Serveur en attente sur le port " + port + "...");

            // Acceptation de la connexion
            try (Socket s = ss.accept()) {

                System.out.println("Connexion établie entre " +
                        s.getLocalSocketAddress() + " et " +
                        s.getRemoteSocketAddress());

                // Création des flux
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

                // Communication
                String ligne = br.readLine();
                System.out.println(ligne);

                pw.println("fin de la communication TCP");

            }

        } catch (IOException e) {
            System.out.println("Erreur d'entrée-sortie : " + e.getMessage());
        }
    }
}