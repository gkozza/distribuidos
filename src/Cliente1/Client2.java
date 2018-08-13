/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author gustavosantos
 */
public class Client2 {
    
    public static void main(String[] args) throws IOException {   
        //Conecta ao socket na porta 4444
        Socket teste = new Socket("localhost",4444);
        //Define qual sera a porta do segundo peer
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual a porta quer utilizar para o outro se conectar?");
        int saida;
        saida = teclado.nextInt();        
        ServerSocket server2 = new ServerSocket(saida);
        //Passa a porta para o peer1
        DataOutputStream dos = new DataOutputStream(teste.getOutputStream());
        dos.writeInt(saida);
        //Aguarda conexao
        while(true){
            Socket peer = server2.accept();
            System.out.println("porta "+ saida + " Nova conexão com o cliente " + 
            peer.getInetAddress().getHostAddress());
        }
            
    }
}
