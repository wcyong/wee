package org.apache.jsp.demo.css3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>css3</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("    \t/* 所有角都使用半径为10px的圆角 */ \r\n");
      out.write("    \t.r1 {\r\n");
      out.write("    \t\tborder-radius:10px;\r\n");
      out.write("    \t\tborder: 1px solid;\r\n");
      out.write("    \t\theight: 100px;\r\n");
      out.write("    \t\twidth: 100px;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t/* 四个半径值分别是左上角、右上角、右下角和左下角，顺时针 */ \r\n");
      out.write("    \t.r2 {\r\n");
      out.write("    \t\twidth: 100px;\r\n");
      out.write("    \t\theight: 100px;\r\n");
      out.write("    \t\tborder: 1px solid;\r\n");
      out.write("    \t\tborder-radius:5px 4px 3px 2px;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t.r3 {\r\n");
      out.write("    \t\twidth: 100px;\r\n");
      out.write("    \t\theight: 50px;\r\n");
      out.write("    \t\tborder: 1px solid;\r\n");
      out.write("    \t\tborder-radius:50px 50px 0 0;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t.r4 {\r\n");
      out.write("    \t\twidth: 100px;\r\n");
      out.write("    \t\theight: 100px;\r\n");
      out.write("    \t\tborder: 1px solid;\r\n");
      out.write("    \t\tborder-radius:50px;\r\n");
      out.write("    \t\tbackground: #9da;\r\n");
      out.write("    \t}\r\n");
      out.write("    </style>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write(" <body>\r\n");
      out.write(" \t<div class=\"r1\"></div>\r\n");
      out.write(" \t<div class=\"r2\"></div>\r\n");
      out.write(" \t<div class=\"r3\"></div>\r\n");
      out.write(" \t<div class=\"r4\"></div>\r\n");
      out.write(" </body>\r\n");
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
