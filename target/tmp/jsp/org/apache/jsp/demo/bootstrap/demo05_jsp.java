package org.apache.jsp.demo.bootstrap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo05_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \r\n");
      out.write("  \t<!-- 按钮组 -->\r\n");
      out.write("\t<div class=\"btn-group\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-default btn-warning\">左边</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-default btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-default btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-default btn-warning\">右边</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<!-- 按钮组尺寸 -->\r\n");
      out.write("\t<div class=\"btn-group btn-group-lg\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-default btn-warning\">左边</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">右边</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"btn-group btn-group-sm\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">左边</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">右边</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"btn-group btn-group-xs\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">左边</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">右边</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 按钮工具栏 -->\r\n");
      out.write("\t<div class=\"btn-toolbar\">\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-default btn-warning\">左边</button>\r\n");
      out.write("\t  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("\t  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("\t  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">右边</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-warning\">左边</button>\r\n");
      out.write("\t  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">中间</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t  \t\t<button type=\"button btn-info\" class=\"btn btn-warning\">右边</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 嵌套 -->\r\n");
      out.write("\t<div class=\"btn-group\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">1</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">2</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">3</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">4</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">5</button>\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-warning dropdown-toggle\" data-toggle=\"dropdown\" ria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("\t\t\t\tdropdown\r\n");
      out.write("\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Dropdown link</a></li>\r\n");
      out.write("\t      \t\t<li><a href=\"#\">Dropdown link</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<!-- 垂直排列 -->\r\n");
      out.write("\t<div class=\"btn-group-vertical\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">1</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">2</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">3</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">4</button>\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-warning\">5</button>\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-warning dropdown-toggle\" data-toggle=\"dropdown\" ria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("\t\t\t\tdropdown\r\n");
      out.write("\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Dropdown link</a></li>\r\n");
      out.write("\t      \t\t<li><a href=\"#\">Dropdown link</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<!-- 两端对齐 -->\r\n");
      out.write("\t<div class=\"btn-group btn-group-justified\">\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-warning\">left</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-warning\">center</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-warning\">right</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
