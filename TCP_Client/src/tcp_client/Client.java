/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_client;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olgac
 */
public class Client {
    
    String nome;
    String colore;
    Socket socket;
    
    public Client(String nome){
        this.nome = nome;
        //this.colore = colore;
        
    }
    
    public void connetti(String S, int Porta){
        try {
            socket = new Socket(S, Porta);
            System.out.println("Connessione al server avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problemi di connessione");
        }
        
        
    }
    
     public void leggi(){
         InputStream i;
         BufferedReader br;
         String messaggio;

         try {
             i=socket.getInputStream();
             br=new BufferedReader(new InputStreamReader(i));
             messaggio=br.readLine();
             System.out.println("Ricevuto il messaggio: "+messaggio);
         } catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Errore: Messaggio non ricevuto");
         }


     }

       public void scrivi(){
           OutputStream os;
           BufferedWriter bw;
           String messaggio="Client attivo";

           try {
               os=socket.getOutputStream();
               bw=new BufferedWriter(new OutputStreamWriter(os));
               bw.write(messaggio+"\n");
               bw.flush();
           } catch (IOException ex) {
               Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
           }

       }
       
       public void chiudi(){
          // if(socket!=null){
               try {
                   socket.close();
                   System.out.println("");
               } catch (IOException ex) {
                   Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }

