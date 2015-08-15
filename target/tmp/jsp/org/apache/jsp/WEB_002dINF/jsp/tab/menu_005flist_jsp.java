package org.apache.jsp.WEB_002dINF.jsp.tab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("/resources/tab/Scripts/TreeTable/jquery.treeTable.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Scripts/TreeTable/css/jquery.treeTable.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/tab/Scripts/FunctionJS.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tdivresize(63);\r\n");
      out.write("\t\tFixedTableHeader(\"#dnd-example\", $(window).height() - 91);\r\n");
      out.write("\t\tGetClickTableValue();\r\n");
      out.write("\t})\r\n");
      out.write("\t/**\r\n");
      out.write("\t获取table TD值\r\n");
      out.write("\t主键ID\r\n");
      out.write("\tcolumn:列名\r\n");
      out.write("\t **/\r\n");
      out.write("\tvar Menu_Id = '';\r\n");
      out.write("\tfunction GetClickTableValue() {\r\n");
      out.write("\r\n");
      out.write("\t\t$('table tr').not('#td').click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(this).find('td').each(function(i) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (i == 6) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tMenu_Id = $(this).text();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#dnd-example\").treeTable({\r\n");
      out.write("\r\n");
      out.write("\t\t\tinitialState : \"expanded\" //collapsed 收缩 expanded展开的\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//新增\r\n");
      out.write("\tfunction add() {\r\n");
      out.write("\r\n");
      out.write("\t\tvar url = \"/RMBase/SysMenu/Menu_Form.aspx?ParentId=\" + Menu_Id;\r\n");
      out.write("\t\ttop.openDialog(url, 'Menu_Form', '导航菜单信息 - 添加', 450, 305, 50, 50);\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//编辑\r\n");
      out.write("\tfunction edit() {\r\n");
      out.write("\r\n");
      out.write("\t\tvar key = Menu_Id;\r\n");
      out.write("\t\tif (IsEditdata(key)) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar url = \"/RMBase/SysMenu/Menu_Form.aspx?key=\" + key;\r\n");
      out.write("\t\t\ttop.openDialog(url, 'Menu_Form', '导航菜单信息 - 编辑', 450, 305, 50, 50);\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//删除\r\n");
      out.write("\tfunction Delete() {\r\n");
      out.write("\r\n");
      out.write("\t\tvar key = Menu_Id;\r\n");
      out.write("\t\tif (IsDelData(key)) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar isExistparm = 'action=IsExist&tableName=Base_SysMenu&pkName=ParentId&pkVal='\r\n");
      out.write("\t\t\t\t\t+ key;\r\n");
      out.write("\t\t\tif (IsExist_Data('/Ajax/Common_Ajax.ashx', isExistparm) > 0) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tshowWarningMsg(\"该数据被关联,0 行受影响！\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar delparm = 'action=Virtualdelete&module=导航菜单&tableName=Base_SysMenu&pkName=Menu_Id&pkVal='\r\n");
      out.write("\t\t\t\t\t+ key;\r\n");
      out.write("\t\t\tdelConfig('/Ajax/Common_Ajax.ashx', delparm)\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//分配按钮\r\n");
      out.write("\tfunction allotButton() {\r\n");
      out.write("\r\n");
      out.write("\t\tvar key = Menu_Id;\r\n");
      out.write("\t\tif (IsEditdata(key)) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar url = \"/RMBase/SysMenu/AllotButton_Form.aspx?key=\" + key;\r\n");
      out.write("\t\t\ttop.openDialog(url, 'AllotButton_Form', '导航菜单信息 - 分配按钮', 580, 370,\r\n");
      out.write("\t\t\t\t\t50, 50);\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form id=\"form1\" runat=\"server\">\r\n");
      out.write("\t\t<div class=\"btnbartitle\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t导航菜单信息 &nbsp;&nbsp;<span style=\"color: Red;\">注：该功能谨慎使用！</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"btnbarcontetn\">\r\n");
      out.write("\t\t\t<div style=\"float: left;\"></div>\r\n");
      out.write("\t\t\t<div style=\"text-align: right\">\r\n");
      out.write("\t\t\t\t<uc1:LoadButton ID=\"LoadButton1\" runat=\"server\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"div-body\">\r\n");
      out.write("\t\t\t<table class=\"example\" id=\"dnd-example\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 230px; padding-left: 20px;\">菜单名称</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 30px; text-align: center;\">图标</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 60px; text-align: center;\">类型</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 60px; text-align: center;\">连接目标</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 60px;\">显示顺序</td>\r\n");
      out.write("\t\t\t\t\t\t<td>连接地址</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
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
