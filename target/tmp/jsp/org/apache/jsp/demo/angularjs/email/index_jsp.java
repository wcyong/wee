package org.apache.jsp.demo.angularjs.email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html ng-app=\"amail\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>index</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/angular-1.4.8/angular.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/angular-1.4.8/angular-route.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//为核心的AMail服务创建模块\r\n");
      out.write("var aMailServices = angular.module('amail',['ngRoute']);\r\n");
      out.write("\r\n");
      out.write("var messages = [{\r\n");
      out.write("\tid:0,sender:\"675600929@qq.com\",subject:\"坚持运动\",date:\"2015-01-01\",\r\n");
      out.write("\trecipients:[\"aaa@hotmail.com\"],\r\n");
      out.write("\tmessage:\"hey,we should get together for lunch sometime and catch up.\"\r\n");
      out.write("},{\r\n");
      out.write("\tid:1,sender:\"ynljwcy@gmail.com\",subject:\"认真学习\",date:\"2015-01-2\",\r\n");
      out.write("\trecipients:[\"bbb@hotmail.com\"],\r\n");
      out.write("\tmessage:\"i thought you were going to put it in my desk drawer.\"\r\n");
      out.write("},{\r\n");
      out.write("\tid:2,sender:\"ynljwcy@hotmail.com\",subject:\"来一场说走就走的旅行\",date:\"2015-01-03\",\r\n");
      out.write("\trecipients:[\"ccc@hotmail.com\"],\r\n");
      out.write("\tmessage:\"Nobody panic,but my pet python is missing from her cage.\"\r\n");
      out.write("}];\r\n");
      out.write("\r\n");
      out.write("aMailServices.controller(\"ListController\",function($scope){\r\n");
      out.write("\t$scope.messages = messages;\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("aMailServices.controller(\"DetailController\",function($scope,$routeParams){\r\n");
      out.write("\tconsole.log($routeParams.id);\r\n");
      out.write("\t$scope.message = messages[$routeParams.id];\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("//在URL、模板和控制器之间建立映射关系\r\n");
      out.write("//配置我们的路由，以便AMail服务能够找到它\r\n");
      out.write("aMailServices.config(function($routeProvider){\r\n");
      out.write("\t$routeProvider.when('/', {\r\n");
      out.write("      controller: \"ListController\",\r\n");
      out.write("      templateUrl: 'list.jsp'\r\n");
      out.write("    }).when('/view/:id', {\r\n");
      out.write("      controller: \"DetailController\",\r\n");
      out.write("      templateUrl: 'detail.jsp'\r\n");
      out.write("    }).otherwise({\r\n");
      out.write("      redirectTo: '/'\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>a-mail</h1>\r\n");
      out.write("\t<div ng-view></div>\r\n");
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
