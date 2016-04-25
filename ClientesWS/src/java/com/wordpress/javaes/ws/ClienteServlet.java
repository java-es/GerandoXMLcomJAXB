package com.wordpress.javaes.ws;

import com.wordpress.javaes.controller.ClienteCtr;
import com.wordpress.javaes.domain.Cliente;
import com.wordpress.javaes.domain.ListaCliente;
import com.wordpress.javaes.util.JAXBUtil;
import com.wordpress.javaes.util.ServletUtil;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author https://javaes.wordpress.com/
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ws/*"})
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ClienteCtr clienteCtr = new ClienteCtr();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {

            List<Cliente> clientes = this.clienteCtr.getClientes();
            ListaCliente lista = new ListaCliente(clientes);
            String xml = JAXBUtil.toXML(lista);
            ServletUtil.writeXML(resp, xml);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
