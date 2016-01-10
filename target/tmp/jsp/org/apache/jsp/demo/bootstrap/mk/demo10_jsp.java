package org.apache.jsp.demo.bootstrap.mk;

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
      out.write("<h1>基础表格</h1>\r\n");
      out.write("<table class=\"table\">\r\n");
      out.write("   <thead>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </thead>\r\n");
      out.write("   <tbody>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write("<h1>斑马线表格</h1>\r\n");
      out.write("<table class=\"table table-striped\">\r\n");
      out.write("   <thead>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </thead>\r\n");
      out.write("   <tbody>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write("<h1>带边框的表格</h1>\r\n");
      out.write(" <table class=\"table table-bordered\">\r\n");
      out.write("   <thead>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </thead>\r\n");
      out.write("   <tbody>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write("<h1>鼠标悬浮高亮的表格</h1>\r\n");
      out.write("<table class=\"table table-striped table-bordered table-hover\">\r\n");
      out.write("   <thead>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </thead>\r\n");
      out.write("   <tbody>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write(" <h1>紧凑型表格</h1>\r\n");
      out.write("  <table class=\"table table-condensed\">\r\n");
      out.write("   <thead>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </thead>\r\n");
      out.write("   <tbody>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write(" <h1>响应式表格</h1>\r\n");
      out.write(" <div class=\"table-responsive\">\r\n");
      out.write("   <table class=\"table table-bordered\">\r\n");
      out.write("   <thead>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("       <th>表格标题</th>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </thead>\r\n");
      out.write("   <tbody>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("       <td>表格单元格</td>\r\n");
      out.write("     </tr>\r\n");
      out.write("   </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write("</div>\r\n");
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
