package org.apache.jsp.demo.angularjs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo11_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html ng-app=\"myApp\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>与服务器交互</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/angular-1.4.8/angular.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar userModule = angular.module(\"myApp\",[]);\r\n");
      out.write("\tuserModule.controller(\"UserController\",function($scope,$http){\r\n");
      out.write("\t\t$http.get(\"");
      out.print(request.getContextPath());
      out.write("/angular/testDatas\").success(function(data,status,headers,config){\r\n");
      out.write("\t\t\t$scope.users = data;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body ng-controller=\"UserController\">\r\n");
      out.write("\t<h1>User demo</h1>\r\n");
      out.write("\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t<tr ng-repeat=\"user in users\">\r\n");
      out.write("\t\t\t<td>{{user.id}}</td>\r\n");
      out.write("\t\t\t<td>{{user.usernmae}}</td>\r\n");
      out.write("\t\t\t<td>{{user.birthday}}</td>\r\n");
      out.write("\t\t\t<td>{{user.sex}}</td>\r\n");
      out.write("\t\t\t<td>{{user.address}}</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}