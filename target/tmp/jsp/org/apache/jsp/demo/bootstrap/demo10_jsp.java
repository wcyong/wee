package org.apache.jsp.demo.bootstrap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo10_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<title>Starter Template for Bootstrap</title>\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" placeholder=\"Text input\"><br>\r\n");
      out.write("\t\t<textarea class=\"form-control\" rows=\"3\"></textarea>\r\n");
      out.write("\t\t<br> <label class=\"radio-inline\"> <input type=\"radio\"\r\n");
      out.write("\t\t\tname=\"inlineRadioOptions\" id=\"inlineRadio1\" value=\"option1\">\r\n");
      out.write("\t\t\t1\r\n");
      out.write("\t\t</label> <label class=\"radio-inline\"> <input type=\"radio\"\r\n");
      out.write("\t\t\tname=\"inlineRadioOptions\" id=\"inlineRadio2\" value=\"option2\">\r\n");
      out.write("\t\t\t2\r\n");
      out.write("\t\t</label> <label class=\"radio-inline\"> <input type=\"radio\"\r\n");
      out.write("\t\t\tname=\"inlineRadioOptions\" id=\"inlineRadio3\" value=\"option3\">\r\n");
      out.write("\t\t\t3\r\n");
      out.write("\t\t</label>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<form class=\"form-horizontal\">\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label class=\"col-sm-2 control-label\">Email</label>\r\n");
      out.write("\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t<p class=\"form-control-static\">email@example.com</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"inputPassword\" class=\"col-sm-2 control-label\">Password</label>\r\n");
      out.write("\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"inputPassword\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"Password\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" disabled=\"disabled\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Bootstrap core JavaScript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("\t<!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js\"></script>\r\n");
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
