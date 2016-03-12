package org.apache.jsp.demo.bootstrap.mk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tabs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<ul class=\"nav nav-tabs\" role=\"tablist\" id=\"feature-tab\">\r\n");
      out.write("        <li class=\"active\"><a href=\"#tab-chrome\" role=\"tab\" data-toggle=\"tab\">Chrome</a></li>\r\n");
      out.write("        <li><a href=\"#tab-firefox\" role=\"tab\" data-toggle=\"tab\">Firefox</a></li>\r\n");
      out.write("        <li><a href=\"#tab-safari\" role=\"tab\" data-toggle=\"tab\">Safari</a></li>\r\n");
      out.write("        <li><a href=\"#tab-opera\" role=\"tab\" data-toggle=\"tab\">Opera</a></li>\r\n");
      out.write("        <li><a href=\"#tab-ie\" role=\"tab\" data-toggle=\"tab\">IE</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"tab-content\">\r\n");
      out.write("        <div class=\"tab-pane active\" id=\"tab-chrome\">\r\n");
      out.write("            <div class=\"row feature\">\r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("\r\n");
      out.write("                    <h2 class=\"feature-heading\">Google Chrome <span\r\n");
      out.write("                            class=\"text-muted\">使用最广的浏览器</span></h2>\r\n");
      out.write("\r\n");
      out.write("                    <p class=\"lead\">Google Chrome，又称Google浏览器，是一个由Google（谷歌）公司开发的网页浏览器。\r\n");
      out.write("                        该浏览器是基于其他开源软件所撰写，包括WebKit，目标是提升稳定性、速度和安全性，并创造出简单且有效率的使用者界面。</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-5\">\r\n");
      out.write("                    <img class=\"feature-image img-responsive\" src=\"images/chrome-logo.jpg\"\r\n");
      out.write("                         alt=\"Chrome\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"tab-pane\" id=\"tab-firefox\">\r\n");
      out.write("            <div class=\"row feature\">\r\n");
      out.write("                <div class=\"col-md-5\">\r\n");
      out.write("                    <img class=\"feature-image img-responsive\" src=\"images/firefox-logo.jpg\"\r\n");
      out.write("                         alt=\"Firefox\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("\r\n");
      out.write("                    <h2 class=\"feature-heading\">Mozilla Firefox <span class=\"text-muted\">美丽的狐狸</span>\r\n");
      out.write("                    </h2>\r\n");
      out.write("\r\n");
      out.write("                    <p class=\"lead\">Mozilla Firefox，中文名通常称为“火狐”或“火狐浏览器”，是一个开源网页浏览器，\r\n");
      out.write("                        使用Gecko引擎（非ie内核），支持多种操作系统如Windows、Mac和linux。</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"tab-pane\" id=\"tab-safari\">\r\n");
      out.write("            <div class=\"row feature\">\r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("\r\n");
      out.write("                    <h2 class=\"feature-heading\">Safari <span class=\"text-muted\">Mac用户首选</span></h2>\r\n");
      out.write("\r\n");
      out.write("                    <p class=\"lead\">Safari，是苹果计算机的最新操作系统Mac OS X中的浏览器，使用了KDE的KHTML作为浏览器的运算核心。\r\n");
      out.write("                        Safari在2003年1月7日首度发行测试版，并成为Mac OS X v10.3与之后的默认浏览器，也是iPhone与IPAD和iPod touch的指定浏览器。</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-5\">\r\n");
      out.write("                    <img class=\"feature-image img-responsive\" src=\"images/safari-logo.jpg\"\r\n");
      out.write("                         alt=\"Safari\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"tab-pane\" id=\"tab-opera\">\r\n");
      out.write("            <div class=\"row feature\">\r\n");
      out.write("                <div class=\"col-md-5\">\r\n");
      out.write("                    <img class=\"feature-image img-responsive\" src=\"images/opera-logo.jpg\"\r\n");
      out.write("                         alt=\"Opera\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("\r\n");
      out.write("                    <h2 class=\"feature-heading\">Opera <span class=\"text-muted\">小众但易用</span>\r\n");
      out.write("                    </h2>\r\n");
      out.write("\r\n");
      out.write("                    <p class=\"lead\">Opera浏览器，是一款挪威Opera Software ASA公司制作的支持多页面标签式浏览的网络浏览器。\r\n");
      out.write("                        是跨平台浏览器可以在Windows、Mac和Linux三个操作系统平台上运行。.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"tab-pane\" id=\"tab-ie\">\r\n");
      out.write("            <div class=\"row feature\">\r\n");
      out.write("                <div class=\"col-md-7\">\r\n");
      out.write("\r\n");
      out.write("                    <h2 class=\"feature-heading\">IE <span class=\"text-muted\">你懂的</span></h2>\r\n");
      out.write("\r\n");
      out.write("                    <p class=\"lead\">Internet Explorer，原称Microsoft Internet Explorer(6版本以前)和Windows Internet\r\n");
      out.write("                        Explorer(7，8，9，10版本)，\r\n");
      out.write("                        简称IE，是美国微软公司推出的一款网页浏览器。它采用的排版引擎(俗称内核)为Trident。</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-5\">\r\n");
      out.write("                    <img class=\"feature-image img-responsive\" src=\"images/ie-logo.jpg\"\r\n");
      out.write("                         alt=\"IE\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
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
