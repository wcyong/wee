package org.apache.jsp.demo.plugin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class table_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>表格插件测试</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.mytable {\r\n");
      out.write("\t\tborder-spacing: 0px;\r\n");
      out.write("\t\tborder-top: 1px solid #999;\r\n");
      out.write("\t\tborder-left: 1px solid #999;\r\n");
      out.write("\t\tfont-size: 12px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.mytable td,.mytable th {\r\n");
      out.write("\t\tborder-right: 1px solid #999;\r\n");
      out.write("\t\tborder-bottom: 1px solid #999;\r\n");
      out.write("\t\tpadding: 6px 4px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.headBg {\r\n");
      out.write("\t\tbackground:#621;\r\n");
      out.write("\t\tcolor:#fff;\r\n");
      out.write("\t}\r\n");
      out.write("\ttr.evenBg {\r\n");
      out.write("\t\tbackground:#bbb;\r\n");
      out.write("\t}\r\n");
      out.write("\ttr.hoverBg {\r\n");
      out.write("\t\tbackground:#484;\r\n");
      out.write("\t\tcolor:#fff;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/test/plugin/jquery.table.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#mt\").mytable({\r\n");
      out.write("\t\t\twidth:900,\r\n");
      out.write("\t\t\tonComplete:function(mt,elem){\r\n");
      out.write("\t\t\t\t//通过mt和elem可以有效的获取相应的参数，这个参数是在mytable内部\r\n");
      out.write("\t\t\t\tconsole.log(mt.options.width);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tonTdClick:function(event) {\r\n");
      out.write("\t\t\t\tvar mt = event.data.mt;\r\n");
      out.write("\t\t\t\tconsole.log(mt.options.width);\r\n");
      out.write("\t\t\t\tconsole.log($(this).html());\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table id=\"mt\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>编号</th>\r\n");
      out.write("\t\t\t\t<th>姓名</th>\r\n");
      out.write("\t\t\t\t<th>密码</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t<td>张三</td>\r\n");
      out.write("\t\t\t\t<td>1234</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
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
