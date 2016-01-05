package org.apache.jsp.demo.angularjs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo13_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>校验用户输入</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    .ng-invalid {\r\n");
      out.write("      border-color: red;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/angular-1.4.8/angular.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar myModule = angular.module(\"myApp\",[]);\r\n");
      out.write("\tmyModule.controller(\"AddUserController\",function($scope){\r\n");
      out.write("\t\t$scope.message = '';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.addUser = function() {\r\n");
      out.write("\t\t\t$scope.message = 'Thanks, ' + $scope.user.first + ', we added you!';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t <h1>Sign Up</h1>\r\n");
      out.write("\t <form name=\"addUserForm\" ng-controller=\"AddUserController\">\r\n");
      out.write("\t \t<div ng-show=\"message\">{{message}}</div>\r\n");
      out.write("\t \t<div>First name:<input name=\"firstName\" ng-model=\"user.first\" required></div>\r\n");
      out.write("\t \t<div>Last name: <input ng-model='user.last' required></div>\r\n");
      out.write("\t \t<div>Email: <input type='email' ng-model='user.email' required></div>\r\n");
      out.write("\t \t<div>Age: <input type='number'\r\n");
      out.write("                       ng-model='user.age'\r\n");
      out.write("                       ng-maxlength='3'\r\n");
      out.write("                       ng-min='1'></div>\r\n");
      out.write("        <div><button ng-click='addUser()'\r\n");
      out.write("                   ng-disabled='!addUserForm.$valid'>Submit</button></div>\r\n");
      out.write("\t </form>\r\n");
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
