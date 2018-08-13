/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente1;

/**
 *
 * @author gustavosantos
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws IOException {
        //Define server na porta 4444
        ServerSocket server = new ServerSocket(4444);
        
        while(true){
            //Recebe conexao do segundo peer
            Socket peer = server.accept();
            System.out.println("porta 4444 Nova conexão com o cliente " + 
            peer.getInetAddress().getHostAddress());
            // Após receber a conexao inicial retorna a conexao para a porta informada pelo peer
            DataInputStream dis = new DataInputStream(peer.getInputStream());
            int porta;            
            porta = dis.readInt();
            System.out.println("Conectando de volta a " + peer.getInetAddress().getHostAddress() + " na porta "
                    + porta);
            
            Socket retorna = new Socket(peer.getInetAddress().getHostAddress(), porta);
            
            
        }
        
    }
    
}
