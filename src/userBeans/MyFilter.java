package userBeans;


	
	import java.io.IOException;
	import javax.servlet.Filter;
	import javax.servlet.FilterChain;
	import javax.servlet.FilterConfig;
	import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	import javax.servlet.http.HttpServletRequest;
	public class MyFilter implements Filter {

	    public MyFilter() {
	    }

	 public void destroy() {
	 }

	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	  String requri = ((HttpServletRequest) request).getRequestURI().substring(((HttpServletRequest) request).getContextPath().length() + 1);
	  System.out.println(requri);
	  //if request uri starts with user/ then system will forward the request to Profile servlet
	     if (requri.startsWith("user/")) {
	         //get userid from request uri
	      String userid=requri.substring(5);
	      System.out.println(userid);
	      
	      //set attribute "user" with userid value
	      request.setAttribute("user", userid);
	   
	      //forward the request to Profile servlet
	      request.getRequestDispatcher("/UserProfile").forward(request, response);
	     } else {
	      chain.doFilter(request, response); 
	     }
	 }

	 public void init(FilterConfig fConfig) throws ServletException {
	 }

	}
	
	
	
	
	
	
	
	
	
	

