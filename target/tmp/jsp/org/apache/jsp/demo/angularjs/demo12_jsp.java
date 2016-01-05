package org.apache.jsp.demo.angularjs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo12_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tvar myModule = angular.module(\"myApp\",[]);\r\n");
      out.write("\tmyModule.controller(\"SomeController\",function($scope){\r\n");
      out.write("\t\t$scope.message = {text:'nothing clicked yet'};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.clickUnfocused = function() {\r\n");
      out.write("\t\t\t$scope.message.text = \"unfocused button clicked\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.clickFocused = function() {\r\n");
      out.write("\t\t\t$scope.message.text = \"focus button clicked\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tmyModule.directive(\"ngbkFocus\",function(){\r\n");
      out.write("\t\treturn {\r\n");
      out.write("\t\t\tlink:function(scope,element,attrs,controller) {\r\n");
      out.write("\t\t\t\telement[0].focus();\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body ng-controller=\"SomeController\">\r\n");
      out.write("\t<button ng-click=\"clickUnfocused()\">Not focused!</button>\r\n");
      out.write("\t<button ngbk-focus ng-click=\"clickFocused()\">I'am very focused!</button>\r\n");
      out.write("\t<div>{{message.text}}</div>\r\n");
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
