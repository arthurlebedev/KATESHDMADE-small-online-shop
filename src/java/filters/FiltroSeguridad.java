package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroSeguridad implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest peticion = (HttpServletRequest)request;
        String url = peticion.getRequestURI();
        if (url.contains("account")||url.contains("checkout")){
            HttpSession sesion = peticion.getSession();
            if (sesion.getAttribute("userid")!=null){
                chain.doFilter(request, response);
            }else{
                HttpServletResponse respuesta = (HttpServletResponse) response;
                if(url.contains("checkout")){
                    respuesta.sendRedirect("login.htm?checkout=1");
                }else{
                    respuesta.sendRedirect("login.htm");
                }
            }
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
