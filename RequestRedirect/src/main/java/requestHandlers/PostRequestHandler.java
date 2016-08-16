package requestHandlers;

import annotations.ClassAnnotation;
import annotations.MethodAnnotation;
import org.apache.log4j.Logger;
import requestInterface.HandlerInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ClassAnnotation(
        requestClassUrl = "/PostRequest"
)
public class PostRequestHandler implements HandlerInterface {

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

    @MethodAnnotation(
            requestUrl = "getSome",
            method = "POST"
    )
    public void redirect(HttpServletRequest req, HttpServletResponse resp){

        logger.info("Path /getSome method POST");
        resp.addHeader("MethodName", "Executed method redirect from class PostRequestandler");


        try {
            resp.sendRedirect("redirect2.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MethodAnnotation(
            requestUrl = "getSome2",
            method = "POST"
    )
    public void redirect2(HttpServletRequest req, HttpServletResponse resp){

        logger.info("Path /getSome2 method POST");
        resp.setContentType("text/html");
        resp.addHeader("MethodName", "Executed method redirect2 from class PostRequestHandler");

        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println("<title>Example</title>" +
                "<body bgcolor=FFFFFF>");

        out.println("<h2>Path /getSome2 method POST</h2>");
        out.close();
    }
}
