package org.apache.jsp.demo.angularjs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo07_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<body>\r\n");
      out.write("\t<form ng-controller=\"StudentListController\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li ng-repeat=\"student in students\">\r\n");
      out.write("\t\t\t\t{{$index+1}}、<a href=\"/student/view/{{student.id}}\">{{student.name}}</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<button ng-click=\"addItem()\">add</button>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/angular-1.4.8/angular.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar myModule = angular.module(\"myApp\",[]);\r\n");
      out.write("\t\tvar students = [{name:\"wwss\",id:1},\r\n");
      out.write("\t\t                {name:\"jack\",id:2},\r\n");
      out.write("\t\t                {name:\"lee\",id:3}];\r\n");
      out.write("\t\tmyModule.controller(\"StudentListController\",function($scope){\r\n");
      out.write("\t\t\t$scope.students= students;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$scope.addItem = function() {\r\n");
      out.write("\t\t\t\t$scope.students.splice(1,0,{name:\"tom\",id:4});\r\n");
      out.write("\t\t\t}\r\n");
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
