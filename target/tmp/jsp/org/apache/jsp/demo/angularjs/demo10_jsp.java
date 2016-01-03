package org.apache.jsp.demo.angularjs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo10_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>title</title>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t.selected {\r\n");
      out.write("\t\t\tbackground-color: red;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table ng-controller=\"RestaurantTableController\">\r\n");
      out.write("\t\t<tr ng-repeat=\"restaurant in directory\" ng-click=\"selectRestaurant($index)\" ng-class=\"{selected:$index==selectedRow}\">\r\n");
      out.write("\t\t\t<td>{{$index+1}}</td>\r\n");
      out.write("\t\t\t<td>{{restaurant.name}}</td>\r\n");
      out.write("\t\t\t<td>{{restaurant.cuisine}}</td>\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/angular-1.4.8/angular.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar myModule = angular.module(\"myApp\",[]);\r\n");
      out.write("\t\tmyModule.controller(\"RestaurantTableController\",function($scope){\r\n");
      out.write("\t\t\t$scope.directory = [{name:\"the handsome heifer\",cuisine:\"BBQ\"},\r\n");
      out.write("\t\t\t                    {name:\"Green's green greens\",cuisine:\"Salads\"},\r\n");
      out.write("\t\t\t                    {name:\"House of fine fish\",cuisine:\"Seafood\"}];\r\n");
      out.write("\t\t\t$scope.selectRestaurant = function(row) {\r\n");
      out.write("\t\t\t\t$scope.selectedRow = row;\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
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
