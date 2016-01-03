package org.apache.jsp.demo.angularjs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo09_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t.error {\r\n");
      out.write("\t\t\tbackground: red;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.warning {\r\n");
      out.write("\t\t\tbackground-color: yellow;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div ng-controller=\"HeaderController\">\r\n");
      out.write("\t\t<div ng-class=\"{error:isError,warning:isWarning}\">{{messageText}}</div>\r\n");
      out.write("\t\t<button ng-click=\"showError()\">Error</button>\r\n");
      out.write("\t\t<button ng-click=\"showWarning()\">warning</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/angular-1.4.8/angular.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar myModule = angular.module(\"myApp\",[]);\r\n");
      out.write("\t\tmyModule.controller(\"HeaderController\",function($scope){\r\n");
      out.write("\t\t\t$scope.isError = false;\r\n");
      out.write("\t\t\t$scope.isWarning = false;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$scope.showError = function() {\r\n");
      out.write("\t\t\t\t$scope.isError = true;\r\n");
      out.write("\t\t\t\t$scope.isWarning = false;\r\n");
      out.write("\t\t\t\t$scope.messageText=\"this is an error\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$scope.showWarning = function() {\r\n");
      out.write("\t\t\t\t$scope.isError = false;\r\n");
      out.write("\t\t\t\t$scope.isWarning = true;\r\n");
      out.write("\t\t\t\t$scope.messageText=\"just a warning\";\r\n");
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
