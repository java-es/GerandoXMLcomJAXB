package com.wordpress.javaes.domain.db;

import com.wordpress.javaes.domain.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class ClienteDAO extends BaseDAO {

    public Cliente getClienteById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM cliente WHERE id=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = createCliente(rs);
                rs.close();
                return cliente;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = createCliente(rs);
                clientes.add(cliente);
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return clientes;
    }

    public Cliente createCliente(ResultSet rs) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getLong("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpfcnpj(rs.getString("cpfcnpj"));
        cliente.setEndereco(rs.getString("endereco"));
        cliente.setTelefone(rs.getString("telefone"));

        return cliente;
    }
}
