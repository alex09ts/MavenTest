package filters;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class PathFilter implements Filter {

    private static final Logger logger = Logger.getLogger(PathFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String array[] = request.getServletPath().split("/");
        logger.info(array.length + "is array length");
        PrintWriter out;
        try{
            response.setContentType("text/html");
            out = response.getWriter();
            if (array.length==3) {
                out.println("Path is : "+ request.getServletPath().toString());
                filterChain.doFilter(request, response);
            } else {

                out.println("<h2>Path is incorrect</h2>");
            }
            out.close();

        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }

    public void destroy() {

    }
}
