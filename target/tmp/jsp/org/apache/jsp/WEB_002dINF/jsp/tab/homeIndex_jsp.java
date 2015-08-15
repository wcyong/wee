package org.apache.jsp.WEB_002dINF.jsp.tab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homeIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Styles/Site.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Scripts/jquery-1.8.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Scripts/FunctionJS.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#BeautifulGreetings\").text(BeautifulGreetings());\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".shortcuticons {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tborder: solid 1px #fff;\r\n");
      out.write("\twidth: 62px;\r\n");
      out.write("\theight: 55px;\r\n");
      out.write("\tmargin: 5px;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tword-break: keep-all;\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".shortcuticons:hover {\r\n");
      out.write("\tcolor: #FFF;\r\n");
      out.write("\tborder: solid 1px #3399dd;\r\n");
      out.write("\tbackground: #2288cc;\r\n");
      out.write("\tfilter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bbee',\r\n");
      out.write("\t\tendColorstr='#2288cc');\r\n");
      out.write("\tbackground: linear-gradient(top, #33bbee, #2288cc);\r\n");
      out.write("\tbackground: -moz-linear-gradient(top, #33bbee, #2288cc);\r\n");
      out.write("\tbackground: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#33bbee),\r\n");
      out.write("\t\tto(#2288cc));\r\n");
      out.write("\ttext-shadow: -1px -1px 1px #1c6a9e;\r\n");
      out.write("\twidth: 62px;\r\n");
      out.write("\theight: 55px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form id=\"form1\" runat=\"server\">\r\n");
      out.write("    <div class=\"box\">\r\n");
      out.write("        <div class=\"box-title\">\r\n");
      out.write("            <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/sun_2.png\" alt=\"\" width=\"20\" height=\"20\" />\r\n");
      out.write("            <label id=\"BeautifulGreetings\">\r\n");
      out.write("            </label>\r\n");
      out.write("            管理员(system)\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"box-content\">\r\n");
      out.write("            <div onclick=\"ClickShortcut('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/tab/menu_list','菜单管理','Iframe')\" class=\"shortcuticons\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/32/sitemap.png\" alt=\"\" /><br />\r\n");
      out.write("                菜单管理</div>\r\n");
      out.write("            <div onclick=\"ClickShortcut('/RMBase/SysPersonal/CurrentUserManager.aspx','个人信息','Iframe')\"\r\n");
      out.write("                class=\"shortcuticons\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/32/596.png\" alt=\"\" /><br />\r\n");
      out.write("                个人信息</div>\r\n");
      out.write("            <div onclick=\"ClickShortcut('/RMBase/SysPersonal/Login_List.aspx','登录信息','Iframe')\"\r\n");
      out.write("                class=\"shortcuticons\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/32/316.png\" alt=\"\" /><br />\r\n");
      out.write("                登录信息</div>\r\n");
      out.write("            <div onclick=\"ClickShortcut('http://www.weather.com.cn/weather/101020100.shtml','天气预报','Open')\"\r\n");
      out.write("                class=\"shortcuticons\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/32/367.png\" alt=\"\" /><br />\r\n");
      out.write("                天气预报</div>\r\n");
      out.write("            <div onclick=\"ClickShortcut('#','数据统计','Open')\" class=\"shortcuticons\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/32/92.png\" alt=\"\" /><br />\r\n");
      out.write("                数据统计</div>\r\n");
      out.write("            <div onclick=\"ClickShortcut('#','文档管理','Open')\" class=\"shortcuticons\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/32/193.png\" alt=\"\" /><br />\r\n");
      out.write("                文档管理</div>\r\n");
      out.write("            <div onclick=\"ClickShortcut('#','通讯录','Open')\" class=\"shortcuticons\">\r\n");
      out.write("                <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/32/8.png\" alt=\"\" /><br />\r\n");
      out.write("                通讯录</div>\r\n");
      out.write("            <br />\r\n");
      out.write("            <br />\r\n");
      out.write("            <br />\r\n");
      out.write("            <br />\r\n");
      out.write("            <a href=\"javascript:void(0)\" onclick=\"add_HomeShortcut()\" class=\"button green\"><span\r\n");
      out.write("                class=\"icon-botton\" style=\"background: url('");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/world_add.png') no-repeat scroll 0px 4px;\">\r\n");
      out.write("            </span>添加新的快捷功能</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"blank10\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"box\">\r\n");
      out.write("        <div class=\"box-title\">\r\n");
      out.write("            <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/milestone.png\" alt=\"\" width=\"20\" height=\"20\" />当前登录情况（在线人数【1】人）\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"box-content\">\r\n");
      out.write("            本月登录总数：6 次\r\n");
      out.write("            <br />\r\n");
      out.write("            本次登录IP：127.0.0.1<br />\r\n");
      out.write("            本次登录时间：2013-06-03 9:54:46<br />\r\n");
      out.write("            上次登录IP：127.0.0.1<br />\r\n");
      out.write("            上次登录时间：2013-06-03 9:54:19<br />\r\n");
      out.write("            <br />\r\n");
      out.write("            <img src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Images/exclamation_octagon_fram.png\" style=\"vertical-align: middle;\r\n");
      out.write("                margin-bottom: 3px;\" width=\"16\" height=\"16\" alt=\"tip\" />\r\n");
      out.write("            提示：为了账号的安全，如果上面的登录情况不正常，建议您马上 <a href=\"javascript:void(0);\" title=\"修改登录密码\" style=\"text-decoration: underline;\r\n");
      out.write("                color: Blue;\" onclick=\"editpwd()\">密码修改</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"blank10\">\r\n");
      out.write("    </div>\r\n");
      out.write("    </form>\r\n");
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
