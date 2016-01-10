package org.apache.jsp.demo.bootstrap.mk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo20_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>标题（一）</title>\r\n");
      out.write(" <link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write(" <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<form role=\"form\">\r\n");
      out.write("\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-primary\">首页</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-default\">产品展示</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-default\">案例分析</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-default\">联系我们</button>\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t      \t<button class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\" type=\"button\">关于我们<span class=\"caret\"></span></button>\r\n");
      out.write("\t\t\t    <ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t    \t<li><a href=\"##\">公司简介</a></li>\r\n");
      out.write("\t\t\t    \t<li><a href=\"##\">企业文化</a></li>\r\n");
      out.write("\t\t\t    \t<li><a href=\"##\">组织结构</a></li>\r\n");
      out.write("\t\t\t    \t<li><a href=\"##\">客服服务</a></li>\r\n");
      out.write("\t\t\t    </ul>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\t");
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
