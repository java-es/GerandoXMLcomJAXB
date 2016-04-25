/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.wordpress.javaes.controller.ClienteCtr;
import com.wordpress.javaes.domain.Cliente;
import java.util.List;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        ClienteCtr ctr = new ClienteCtr();
        List<Cliente> lista = ctr.getClientes();
        
        System.out.println("clientes: "+lista.size());
    }
}
