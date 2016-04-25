package com.wordpress.javaes.util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class ServletUtil {

    public static void writeXML(HttpServletResponse response, String xml) throws Exception {
        if (xml != null) {
            PrintWriter writer = response.getWriter();
            response.setContentType("application/xml;charset=UTF-8");
            writer.write(xml);
            writer.close();
        }
    }

    public static void writerJSON(HttpServletResponse response, String json) throws Exception {
        if (json != null) {
            PrintWriter writer = response.getWriter();
            response.setContentType("application/json;charset=UTF-8");
            writer.write(json);
            writer.close();
        }
    }
}
