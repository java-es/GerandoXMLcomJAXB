package com.wordpress.javaes.util;

import com.wordpress.javaes.domain.Cliente;
import com.wordpress.javaes.domain.ListaCliente;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class JAXBUtil {

    private static JAXBUtil instance;
    private static JAXBContext context;

    public static JAXBUtil getInstance() {
        return instance;
    }

    static {
        try {
            context = JAXBContext.newInstance(ListaCliente.class, Cliente.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toXML(Object object) throws Exception {
        try {
            StringWriter writer = new StringWriter();
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(object, writer);
            String xml = writer.toString();
            return xml;
        } catch (Exception ex) {
            return null;
        }
    }
}
