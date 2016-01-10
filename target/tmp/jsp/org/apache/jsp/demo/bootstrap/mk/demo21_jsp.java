package org.apache.jsp.demo.bootstrap.mk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo21_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<div style=\"text-align: center;\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-default\" data-toggle=\"tooltip\" data-placement=\"left\" data-original-title=\"提示框居左\" title=\"\">提示框居左</button>\r\n");
      out.write("\t\t<button type=\"button\" \r\n");
      out.write("          class=\"btn btn-default\" \r\n");
      out.write("          data-toggle=\"tooltip\" \r\n");
      out.write("          data-placement=\"top\" \r\n");
      out.write("          data-original-title=\"提示框在顶部\">\r\n");
      out.write("   提示框在顶部\r\n");
      out.write("  </button>\r\n");
      out.write("  <button type=\"button\" \r\n");
      out.write("          class=\"btn btn-default\" \r\n");
      out.write("          data-toggle=\"tooltip\" \r\n");
      out.write("          data-placement=\"bottom\" \r\n");
      out.write("          data-original-title=\"提示框在底部\">\r\n");
      out.write("  提示框在底部             \r\n");
      out.write("  </button>\r\n");
      out.write("  <button type=\"button\" \r\n");
      out.write("          class=\"btn btn-default\" \r\n");
      out.write("          data-toggle=\"tooltip\" \r\n");
      out.write("          data-placement=\"right\" \r\n");
      out.write("          data-original-title=\"提示框居右\">\r\n");
      out.write("  提示框居右      \r\n");
      out.write("  </button>\r\n");
      out.write("  <h3>链接制作的提示框</h3>\r\n");
      out.write("  <a class=\"btn btn-primary\" \r\n");
      out.write("     data-toggle=\"tooltip\" \r\n");
      out.write("     data-placement=\"left\" \r\n");
      out.write("     title=\"提示框居左\">\r\n");
      out.write("     提示框居左\r\n");
      out.write("  </a>\r\n");
      out.write("  <a class=\"btn btn-primary\" \r\n");
      out.write("     data-toggle=\"tooltip\" \r\n");
      out.write("     data-placement=\"top\" \r\n");
      out.write("     title=\"提示框在顶部\">\r\n");
      out.write("     提示框在顶部\r\n");
      out.write("  </a>\r\n");
      out.write("  <a class=\"btn btn-primary\" \r\n");
      out.write("     data-toggle=\"tooltip\" \r\n");
      out.write("     data-placement=\"bottom\" \r\n");
      out.write("     title=\"提示框在底部\">\r\n");
      out.write("     提示框在底部\r\n");
      out.write("  </a>\r\n");
      out.write("  <a class=\"btn btn-primary\" \r\n");
      out.write("     data-toggle=\"tooltip\" \r\n");
      out.write("     data-placement=\"right\" \r\n");
      out.write("     title=\"提示框在居右\">\r\n");
      out.write("     提示框居右\r\n");
      out.write("  </a>\r\n");
      out.write("  <a href=\"##\" \r\n");
      out.write("     class=\"btn btn-primary\" \r\n");
      out.write("     id=\"myTooltip\">\r\n");
      out.write("     我是提示框\r\n");
      out.write("  </a>\r\n");
      out.write("  <a href=\"##\" \r\n");
      out.write("     class=\"btn btn-primary\" \r\n");
      out.write("     id=\"myTooltip2\">\r\n");
      out.write("     我是提示框2\r\n");
      out.write("  </a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("  $(function(){\r\n");
      out.write("    $('[data-toggle=\"tooltip\"]').tooltip();\r\n");
      out.write("    $('#myTooltip').tooltip({\r\n");
      out.write("        title:\"我是一个提示框，我在顶部出现\",\r\n");
      out.write("        placement:'top'\r\n");
      out.write("      });\r\n");
      out.write("  });\r\n");
      out.write("  </script>\r\n");
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
