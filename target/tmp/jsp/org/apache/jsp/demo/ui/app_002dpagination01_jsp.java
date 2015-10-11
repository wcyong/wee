package org.apache.jsp.demo.ui;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class app_002dpagination01_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>分页demo</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/css/bootstrap.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<ul class=\"pagination nav navbar-nav\">\r\n");
      out.write("\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\">10 <b class=\"caret\"></b></a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu\" style=\"min-width: 50px;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">10</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">20</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">30</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">50</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-fast-backward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-step-backward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">1</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">2</a></li>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"#\">3</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">4</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">5</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-step-forward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-fast-forward\"></span></a></li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" style=\"border-radius: 0px;\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control text-center\" size=\"2\" placeholder=\"3\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">GO</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<p class=\"navbar-text pull-right\" style=\"vertical-align: middle;\">每页显示10条\r\n");
      out.write("\t\t\t共5页 50条记录</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<hr>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<ul class=\"pagination pagination-sm nav navbar-nav\">\r\n");
      out.write("\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\">10 <b class=\"caret\"></b></a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu\" style=\"min-width: 50px;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">10</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">20</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">30</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">50</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-fast-backward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-step-backward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">1</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">2</a></li>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"#\">3</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">4</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">5</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-step-forward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-fast-forward\"></span></a></li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"input-group input-group-sm\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" style=\"border-radius: 0px;\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control text-center\" size=\"2\" placeholder=\"3\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">GO</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<p class=\"navbar-text pull-right\">每页显示10条 共5页 50条记录</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<hr>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<ul class=\"pagination pagination-lg nav navbar-nav\">\r\n");
      out.write("\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\">10 <b class=\"caret\"></b></a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu\" style=\"min-width: 50px;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">10</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">20</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">30</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">50</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-fast-backward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-step-backward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">1</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">2</a></li>\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"#\">3</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">4</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">5</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-step-forward\"></span></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-fast-forward\"></span></a></li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"input-group input-group-lg\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" style=\"border-radius: 0px;\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control text-center\" size=\"2\" placeholder=\"3\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">GO</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<p class=\"navbar-text pull-right\">每页显示10条 共5页 50条记录</p>\r\n");
      out.write("\t</div>\r\n");
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