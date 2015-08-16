package org.apache.jsp.demo.bootstrap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo03_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>Starter Template for Bootstrap</title>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<!-- 按钮 -->\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-default\">按钮</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-primary\">primary</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-success\">确定</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-info\">信息</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-warning\">提示</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-danger\">取消</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-link\">link</button>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<hr>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<!-- 设置按钮大小 -->\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-info btn-lg\">信息</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-warning btn-sm\">提示</button>\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-danger btn-xs\">取消</button>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<hr>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<!-- 其他定义按钮的方式 -->\r\n");
      out.write("  \t<a class=\"btn btn-default\" href=\"#\" role=\"button\">link</a>\r\n");
      out.write("  \t<button class=\"btn btn-default\" type=\"submit\">button</button>\r\n");
      out.write("  \t<input class=\"btn btn-default\" type=\"button\" value=\"input\">\r\n");
      out.write("  \t<input class=\"btn btn-default\" type=\"submit\" value=\"submit\">\r\n");
      out.write("  \t\r\n");
      out.write("  \t<hr>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-upload\"></span>&nbsp;&nbsp;button</button>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("  </body>\r\n");
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
