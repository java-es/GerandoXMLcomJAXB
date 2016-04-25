package com.wordpress.javaes.controller;

import com.wordpress.javaes.domain.Cliente;
import com.wordpress.javaes.domain.db.ClienteDAO;
import java.util.List;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class ClienteCtr {

    private ClienteDAO dao;

    public ClienteCtr() {
        this.dao = new ClienteDAO();
    }

    public List<Cliente> getClientes() {
        return this.dao.getClientes();
    }
}
