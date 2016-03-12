package org.apache.jsp.demo.bootstrap.mk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class carousel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    /* 轮播广告 */\r\n");
      out.write("\r\n");
      out.write("     .carousel {\r\n");
      out.write("         height: 500px;\r\n");
      out.write("         margin-bottom: 60px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .carousel .item {\r\n");
      out.write("         height: 500px;\r\n");
      out.write("         background-color: #000;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .carousel .item img {\r\n");
      out.write("         width: 100%;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .carousel-caption {\r\n");
      out.write("         z-index: 10;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .carousel-caption p {\r\n");
      out.write("         margin-bottom: 20px;\r\n");
      out.write("         font-size: 20px;\r\n");
      out.write("         line-height: 1.8;\r\n");
      out.write("     }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 广告轮播 -->\r\n");
      out.write("\t<div id=\"ad-carousel\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("\t\t<ol class=\"carousel-indicators\">\r\n");
      out.write("\t\t\t<li data-target=\"#ad-carousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("\t\t\t<li data-target=\"#ad-carousel\" data-slide-to=\"1\"></li>\r\n");
      out.write("\t\t\t<li data-target=\"#ad-carousel\" data-slide-to=\"2\"></li>\r\n");
      out.write("\t\t\t<li data-target=\"#ad-carousel\" data-slide-to=\"3\"></li>\r\n");
      out.write("\t\t\t<li data-target=\"#ad-carousel\" data-slide-to=\"4\"></li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t\t <div class=\"carousel-inner\">\r\n");
      out.write("\t\t \t<div class=\"item active\">\r\n");
      out.write("\t            <img src=\"images/chrome-big.jpg\" alt=\"1 slide\">\r\n");
      out.write("\t            <div class=\"container\">\r\n");
      out.write("\t                <div class=\"carousel-caption\">\r\n");
      out.write("\t                    <h1>Chrome</h1>\r\n");
      out.write("\t                    <p>Google Chrome，又称Google浏览器，是一个由Google（谷歌）公司开发的网页浏览器。</p>\r\n");
      out.write("\t                    <p><a class=\"btn btn-lg btn-primary\" href=\"http://www.google.cn/intl/zh-CN/chrome/browser/\"\r\n");
      out.write("\t                          role=\"button\" target=\"_blank\">点我下载</a></p>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        \r\n");
      out.write("            <div class=\"item\">\r\n");
      out.write("\t            <img src=\"images/firefox-big.jpg\" alt=\"2 slide\">\r\n");
      out.write("\t            <div class=\"container\">\r\n");
      out.write("\t                <div class=\"carousel-caption\">\r\n");
      out.write("\t                    <h1>Firefox</h1>\r\n");
      out.write("\t                    <p>Mozilla Firefox，中文名通常称为“火狐”或“火狐浏览器”，是一个开源网页浏览器。</p>\r\n");
      out.write("\t                    <p><a class=\"btn btn-lg btn-primary\" href=\"http://www.firefox.com.cn/download/\" target=\"_blank\"\r\n");
      out.write("\t                          role=\"button\">点我下载</a></p>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("        \r\n");
      out.write("\t        <div class=\"item\">\r\n");
      out.write("\t            <img src=\"images/safari-big.jpg\" alt=\"3 slide\">\r\n");
      out.write("\t            <div class=\"container\">\r\n");
      out.write("\t                <div class=\"carousel-caption\">\r\n");
      out.write("\t                    <h1>Safari</h1>\r\n");
      out.write("\t                    <p>Safari，是苹果计算机的最新操作系统Mac OS X中的浏览器。</p>\r\n");
      out.write("\t                    <p><a class=\"btn btn-lg btn-primary\" href=\"http://www.apple.com/cn/safari/\" target=\"_blank\"\r\n");
      out.write("\t                          role=\"button\">点我下载</a></p>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <div class=\"item\">\r\n");
      out.write("\t            <img src=\"images/opera-big.jpg\" alt=\"4 slide\">\r\n");
      out.write("\t            <div class=\"container\">\r\n");
      out.write("\t                <div class=\"carousel-caption\">\r\n");
      out.write("\t                    <h1>Opera</h1>\r\n");
      out.write("\t                    <p>Opera浏览器，是一款挪威Opera Software ASA公司制作的支持多页面标签式浏览的网络浏览器。</p>\r\n");
      out.write("\t                    <p><a class=\"btn btn-lg btn-primary\" href=\"http://www.opera.com/zh-cn\" target=\"_blank\"\r\n");
      out.write("\t                          role=\"button\">点我下载</a></p>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        \r\n");
      out.write("\t        <div class=\"item\">\r\n");
      out.write("\t            <img src=\"images/ie-big.jpg\" alt=\"5 slide\">\r\n");
      out.write("\t            <div class=\"container\">\r\n");
      out.write("\t                <div class=\"carousel-caption\">\r\n");
      out.write("\t                    <h1>IE</h1>\r\n");
      out.write("\t                    <p>Internet Explorer，简称 IE，是微软公司推出的一款网页浏览器。</p>\r\n");
      out.write("\t                    <p><a class=\"btn btn-lg btn-primary\" href=\"http://ie.microsoft.com/\" target=\"_blank\"\r\n");
      out.write("\t                          role=\"button\">点我下载</a></p>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("        \r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t <a class=\"left carousel-control\" href=\"#ad-carousel\" data-slide=\"prev\"><span\r\n");
      out.write("            class=\"glyphicon glyphicon-chevron-left\"></span></a>\r\n");
      out.write("\t    <a class=\"right carousel-control\" href=\"#ad-carousel\" data-slide=\"next\"><span\r\n");
      out.write("\t            class=\"glyphicon glyphicon-chevron-right\"></span></a>\r\n");
      out.write("\t</div>\r\n");
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
