package org.apache.jsp.demo.bootstrap.mk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo6_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<h5>普通列表</h5>\r\n");
      out.write("<ul>\r\n");
      out.write("    <li>列表项目</li>\r\n");
      out.write("    <li>列表项目</li>\r\n");
      out.write("    <li>列表项目</li>\r\n");
      out.write("    <li>列表项目</li>\r\n");
      out.write("    <li>列表项目</li>\r\n");
      out.write("</ul>\r\n");
      out.write("<h5>有序列表</h5>\r\n");
      out.write("<ol>\r\n");
      out.write("      <li>项目列表一</li>\r\n");
      out.write("      <li>项目列表二</li>\r\n");
      out.write("      <li>项目列表三</li>\r\n");
      out.write("</ol>\r\n");
      out.write("<h5>有序列表嵌套</h5>\r\n");
      out.write("<ol>\r\n");
      out.write("    <li>有序列表</li>\r\n");
      out.write("    <li>\r\n");
      out.write("    有序列表\r\n");
      out.write("        <ol>\r\n");
      out.write("        <li>有序列表(2)</li>\r\n");
      out.write("        <li>有序列表(2)</li>\r\n");
      out.write("        </ol>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li>有序列表</li>\r\n");
      out.write("</ol>\r\n");
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
