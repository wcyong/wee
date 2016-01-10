package org.apache.jsp.demo.bootstrap.mk;

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
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>标题（一）</title>\r\n");
      out.write(" <link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<form role=\"form\">\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"exampleInputEmail1\">邮箱：</label>\r\n");
      out.write("\t\t\t<input type=\"email\" class=\"form-control\" placeholder=\"请输入邮箱\" id=\"exampleInputEmail1\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label>密码：</label>\r\n");
      out.write("\t\t\t<input type=\"password\" placeholder=\"请输入密码\" class=\"form-control\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"checkbox\">\r\n");
      out.write("\t\t\t<label>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\">记住密码\r\n");
      out.write("\t\t\t</label>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button type=\"submit\" class=\"btn btn-default\">进入邮箱</button>\r\n");
      out.write("\t</form>\r\n");
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
