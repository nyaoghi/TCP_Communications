/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_client;

import java.io.IOException;
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
    
     public void scrivi(){
           
           
       }
       
       public void leggi(){
           
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

