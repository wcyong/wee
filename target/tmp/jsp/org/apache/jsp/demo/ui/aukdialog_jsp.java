package org.apache.jsp.demo.ui;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aukdialog_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>GridTable demo</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/ui/css/bootstrap-custom.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/ui/js/jquery.auk.dialog.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#btn\").click(function(){\r\n");
      out.write("\t\t\t$.mydialog(\"hello world\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t/* $(\"#btn\").click(function(){\r\n");
      out.write("\t\t\tvar d = dialog({\r\n");
      out.write("\t\t\t    title: '欢迎',\r\n");
      out.write("\t\t\t    content: '欢迎使用 artDialog 对话框组件！'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\td.show();\r\n");
      out.write("\t\t}); */\r\n");
      out.write("\t\t/* $(\"#btn\").click(function(){\r\n");
      out.write("\t\t\tskynetDialog.alert(\"aaaa\");\r\n");
      out.write("\t\t}); */\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 基础URL\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction getBaseUrl() {\r\n");
      out.write("\t   var cPath = window.document.location.href,\r\n");
      out.write("        pathName = window.document.location.pathname,\r\n");
      out.write("        localPath = cPath.substring(0, cPath.indexOf(pathName)),\r\n");
      out.write("        projectName = pathName.substring(0, pathName.substr(1).indexOf(\"/\") + 1),\r\n");
      out.write("        rootPath = localPath + projectName;\r\n");
      out.write("\t   \r\n");
      out.write("\t    return projectName;\r\n");
      out.write("\t}\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 简单类型空验证\r\n");
      out.write("\t * @param obj\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction isEmpty(obj) {\r\n");
      out.write("\t    if (obj == undefined || obj == null) {\r\n");
      out.write("\t        return true;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (typeof(obj) == \"string\") {\r\n");
      out.write("\t        if (obj.trim().length > 0) {\r\n");
      out.write("\t            return false;\r\n");
      out.write("\t        } else {\r\n");
      out.write("\t            return true;\r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (typeof(obj) === \"number\") {\r\n");
      out.write("\t        return false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (typeof(obj) === \"boolean\") {\r\n");
      out.write("\t        return false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (typeof(obj) === \"function\") {\r\n");
      out.write("\t        return false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (obj instanceof Array && obj.length < 1) {\r\n");
      out.write("\t        return true;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (obj instanceof HTMLElement) {\r\n");
      out.write("\t        return false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (obj['jquery'] && obj['jquery'] != null && obj['jquery'] != \"\" && obj.context instanceof Document) {\r\n");
      out.write("\t        if (typeof(obj.length) === \"number\" && obj.length < 1) {\r\n");
      out.write("\t            return true;\r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\r\n");
      out.write("\t    if (obj instanceof Object) {\r\n");
      out.write("\t        var cnt = 0;\r\n");
      out.write("\t        for (var t in obj) {\r\n");
      out.write("\t            if (!t || t == null) continue;\r\n");
      out.write("\t            if (!obj.hasOwnProperty(t)) continue;\r\n");
      out.write("\t            cnt++;\r\n");
      out.write("\t            if (cnt > 0) break;\r\n");
      out.write("\t        }\r\n");
      out.write("\t        if (cnt > 0) {\r\n");
      out.write("\t            return false;\r\n");
      out.write("\t        } else {\r\n");
      out.write("\t            return true;\r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"div1\">aaaaa</div>\r\n");
      out.write("<input type=\"button\" id=\"btn\" value=\"open\">\r\n");
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
