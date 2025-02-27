/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author olgac
 */
public class TCP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        int numero = 0;

        System.out.println("Quanti host sono interessati alla connessione?");
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        try {
            numero = Integer.parseInt(br.readLine());
            System.out.println("Numero inserito");
        } catch (IOException e) {
            System.err.println("Errore inserimento numero client");
            throw new RuntimeException(e);

        }catch(IllegalArgumentException e){
            System.err.println("Inserimento valore non valido");
        }


        Server s = new Server(1700);

        while(i<numero) {
            s.attendi();
            s.chiudi();
            //s.leggi();
            //s.scrivi();
            s.chiudi();
            i++;
        }
        s.termina();

    }
}

