package org.apache.jsp.demo.bootstrap;

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
      out.write("  \t<form class=\"form-inline\">\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("  \t\t\t<label for=\"exampleInputName2\">Name</label>\r\n");
      out.write("    \t\t<input type=\"text\" class=\"form-control\" id=\"exampleInputName2\" placeholder=\"Jane Doe\">\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("  \t\t\t<div class=\"input-group\">\r\n");
      out.write("  \t\t\t\t<div class=\"input-group-addon\">@</div>\r\n");
      out.write("  \t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"enter email\">\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("  \t\t\t<label class=\"sr-only\" for=\"exampleInputPassword3\">Password</label>\r\n");
      out.write("    \t\t<input type=\"password\" class=\"form-control\" id=\"exampleInputPassword3\" placeholder=\"Password\">\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<div class=\"checkbox\">\r\n");
      out.write("\t    <label>\r\n");
      out.write("\t      <input type=\"checkbox\"> Remember me\r\n");
      out.write("\t    </label>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t  <button type=\"submit\" class=\"btn btn-default\">Sign in</button>\r\n");
      out.write("  \t</form>\r\n");
      out.write("  \t\r\n");
      out.write("  \t\r\n");
      out.write("  \t<hr>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<form class=\"form-horizontal\">\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("  \t\t\t<label for=\"exampleInputName2\">Name</label>\r\n");
      out.write("    \t\t<input type=\"text\" class=\"form-control\" id=\"exampleInputName2\" placeholder=\"Jane Doe\">\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("  \t\t\t<div class=\"input-group\">\r\n");
      out.write("  \t\t\t\t<div class=\"input-group-addon\">@</div>\r\n");
      out.write("  \t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"enter email\">\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("  \t\t\t<label class=\"sr-only\" for=\"exampleInputPassword3\">Password</label>\r\n");
      out.write("    \t\t<input type=\"password\" class=\"form-control\" id=\"exampleInputPassword3\" placeholder=\"Password\">\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<div class=\"checkbox\">\r\n");
      out.write("\t    <label>\r\n");
      out.write("\t      <input type=\"checkbox\"> Remember me\r\n");
      out.write("\t    </label>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t  <button type=\"submit\" class=\"btn btn-default\">Sign in</button>\r\n");
      out.write("  \t</form>\r\n");
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
