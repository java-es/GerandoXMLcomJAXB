package com.wordpress.javaes.domain;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author https://javaes.wordpress.com/
 */
@XmlRootElement(name = "clientes")
public class ListaCliente implements Serializable {

    private List<Cliente> clientes;

    public ListaCliente(){}
    
    public ListaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @XmlElement(name = "cliente")
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
