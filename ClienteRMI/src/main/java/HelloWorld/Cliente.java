/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author felipe
 */
public class Cliente {
    public static void main(String[] args) {
        String maquinaServidor = "rmi://localhost/";
        int portaServicoNomes = 1099;
        
        try {
            Registry referenciaServicoNomes = LocateRegistry.getRegistry();
            //Registry referenciaServicoNomes = LocateRegistry.getRegistry(maquinaServidor, portaServicoNomes);
            //Obteráareferênciadoservidor,consultandooSN
            
            /*referencia de objeto remota 
            identificacao pra um objeto, a gente so consegue invocar os metodos de um objeto remoto
            se a gente tiver essa referencia
            Qual eh o tipo dessa referencia? Eh a interface remota correspondente 
            */
            InterfaceServ referenciaServidor = (InterfaceServ) referenciaServicoNomes.lookup("HelloWorld");
            CliImpl serventeCliente = new CliImpl(referenciaServidor);
            
            //o programa fica rodando pra sempre mesmo não tendo um while(true)
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
