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
        requestClassUrl = "GetRequest"
)
public class GetRequestHandler implements HandlerInterface {

    private static final Logger logger = Logger.getLogger(GetRequestHandler.class);

    @MethodAnnotation(
            requestUrl = "getSome",
            method = "GET"
    )
    public void redirect(HttpServletRequest req, HttpServletResponse resp) {

        logger.info("Path getSome method GET EXECUTED!!!");
        resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            out.println("<h2>Path getSome method GET</h2>");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MethodAnnotation(
            requestUrl = "getSome2",
            method = "GET"
    )
    public void redirect2(HttpServletRequest req, HttpServletResponse resp) {

        logger.info("Path /getSome2 method GET");
//        resp.addHeader("MethodName", "Executed method redirect2 from class GetRequestandler");
        resp.setContentType("text/html");

        try {
            PrintWriter out = resp.getWriter();
            out.println("<h2>Path getSome2 method GET</h2>");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MethodAnnotation(
            requestUrl = "getSome3",
            method = "GET"
    )
    public void redirect3(HttpServletRequest req, HttpServletResponse resp) {

        logger.info("Path getSome3 method GET");
        resp.addHeader("MethodName", "Executed method redirect3 from class GetRequestandler");
        resp.setContentType("text/html");

        try {
            PrintWriter out = resp.getWriter();
            out.println("<h2>Path getSome3 method GET</h2>");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
