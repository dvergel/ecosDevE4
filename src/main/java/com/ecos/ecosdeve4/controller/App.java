package com.ecos.ecosdeve4.controller;

import com.ecos.ecosdeve4.view.MainView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * clase App
 * 
 * modela el controlador de peticiones de la aplicacion web
 * 
 * @author Dev
 * @version 1.0
 * @since 1.0
 */

public class App extends HttpServlet {

    /**
     * metodo doGet
     * 
     * controla las peticiones realizadas por el metodo get
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MainView.showHome(req, resp);
    }

    /**
     * metodo doPost
     * 
     * controla las peticiones por el metodo Post
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            MainView.showHome(req, resp);
        } catch (Exception ex) {
            MainView.error(req, resp, ex);
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * metodo main
     * 
     * configura el controlador embebido del servidor de aplicacion jetty
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        Server server = new Server(80);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception();
        }
    }
}
