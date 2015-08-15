<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/resources/tab/Styles/Site.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/resources/tab/Styles/Menu.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/resources/tab/Scripts/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/tab/Scripts/FunctionJS.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/tab/MainFrame.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
    	//GetMenu();
        readyIndex();
        iframeresize();
    });
  //菜单
    var V_JSON = "";
    function GetMenu() {
        var parm = 'action=Menu';
        $("#htmlMenuSelect").empty();
        getAjax('Frame.ashx', parm, function (rs) {
            try {
                V_JSON = rs;
                var j = 0;
                var json = eval("(" + V_JSON + ")");
                var css = "sel";
                for (var i = 0; i < json.MENU.length; i++) {
                    var menu = json.MENU[i];
                    if (menu.PARENTID == 0) {
                        if (j == 0) {
                            css = "selected";
                            GetSeedMenu(this, menu.MENU_ID);
                        } else {
                            css = "";
                        }
                        $("#htmlMenuSelect").append("<div class=\"" + css + "\" onclick=\"GetSeedMenu(this,'" + menu.MENU_ID + "')\"><img src='/Themes/Images/MenuLike.gif' />" + menu.MENU_NAME + "</div>");
                        j++;
                    }
                }
            } catch (e) {
            }
        });
    }
    //子菜单
    function GetSeedMenu(e, menu_id) {
        $("#htmlMenuPanel").empty();
        var j = 0;
        var json = eval("(" + V_JSON + ")");
        for (var i = 0; i < json.MENU.length; i++) {
            var menu = json.MENU[i];
            if (menu.PARENTID == menu_id) {
                $("#htmlMenuPanel").append("<div onclick=\"NavMenu('" + menu.NAVIGATEURL + "','" + menu.MENU_NAME + "')\"><img src=\"/Themes/Images/32/" + menu.MENU_IMG + "\" />" + menu.MENU_NAME + "</div>");
            }
        }
        readyIndex();
    }
    //链接内框架frames
    function NavMenu(url, title) {
        Loading(true);
        if (url != "") {
            $("#titleInfo").empty();
            var info = "&nbsp;>>&nbsp;<a class=\"subtitle\" onclick=\"NavMenuUrl('" + url + "');\">" + title + "</a>";
            $("#titleInfo").html(info);
            NavMenuUrl(url);
        }
    }
    //点击事件
    function NavMenuUrl(url) {
        $("#main").attr("src", url);
        return false;
    }
</script>
</head>
<body>
<form id="form1" runat="server">
    <div id="Container">
        <div id="Header">
            <div id="HeaderLogo">
            </div>
            <div id="weather">
            </div>
            <div id="Headermenu">
                <table style="padding: 0px; height: 70px;" cellpadding="0" cellspacing="0">
                    <tr valign="bottom">
                        <td id="menutab">
                            <div class="sel" onclick="GetSeedMenu(this,'3e544d7a-d850-4785-9648-feafc4698a3b')">
                                系统应用</div>
                            <div class="removesel" onclick="GetSeedMenu(this,'5477b88b-3393-4d39-ba2d-f219f486bd38')">
                                个人应用</div>
                            <div class="removesel" onclick="GetSeedMenu(this,'e84c0fca-d912-4f5c-a25e-d5765e33b0d2')">
                                生产管理</div>
                            <div class="removesel" onclick="GetSeedMenu(this,'b863d076-37bb-45aa-8318-37942026921e')">
                                项目管理</div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="Headerbotton">
            <div id="left_title">
                <img src="<%=request.getContextPath() %>/resources/tab/Images/clock_32.png" alt="" width="20" height="20" style="vertical-align: middle;
                    padding-bottom: 1px;" />
                <span id="datetime"></span>
            </div>
            <div id="conten_title">
                <div class="Tab-div">
                    <a class="Tab-left Tab-left"><span class="Tab-right Tab-right">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/4963_home.png" width="16" height="16" />欢迎首页</span></a></div>
                <div id="toolbar" style="text-align: right; padding-right: 3px;">
                    &nbsp;&nbsp;&nbsp;<img src="<%=request.getContextPath() %>/resources/tab/Images/refresh.png" title="刷新业务窗口" alt="" onclick="Loading(true);main.window.location.reload();return false;"
                        width="20" height="20" style="padding-top: 1px; cursor: pointer; vertical-align: middle;" />
                    &nbsp;&nbsp;&nbsp;<img src="<%=request.getContextPath() %>/resources/tab/Images/4963_home.png" title="返回首页" alt="" onclick="rePage()"
                        width="20" height="20" style="padding-top: 1px; cursor: pointer; vertical-align: middle;" />
                    &nbsp; &nbsp;<img src="<%=request.getContextPath() %>/resources/tab/Images/button-white-stop.png" title="安全退出" alt=""
                        onclick="IndexOut()" width="20" height="20" style="padding-top: 1px; cursor: pointer;
                        vertical-align: middle;" />
                </div>
            </div>
        </div>
        <div id="MainContent">
            <div class="side_switch" id="side_switch">
            </div>
            <div class="side_switchl" id="side_switchl">
            </div>
            <div class="navigation" id="navigation" style="padding-top: 1px;">
                <div class="line">
                </div>
                <div class="box-title" style="font-weight: bold;">
                    常用功能操作
                </div>
                <div id="htmlMenuPanel" runat="Server" class="navPanelMini">
                    <div onclick="NavMenu('${pageContext.request.contextPath}/tab/menu_list','菜单导航')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/sitemap.png" />菜单导航</div>
                    <div onclick="NavMenu('/RMBase/SysMenu/Button_List.aspx','操作按钮')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/567.png" />操作按钮</div>
                    <div onclick="NavMenu('/RMBase/SysRole/Role_List.aspx','角色管理')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/20130508035646751_easyicon_net_32.png" />角色管理</div>
                    <div onclick="NavMenu('/RMBase/SysOrg/Organization_List.aspx','部门管理')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/20130508035912738_easyicon_net_32.png" />部门管理</div>
                    <div onclick="NavMenu('/RMBase/SysUser/UserInfo_Index.aspx','用户管理')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/userregedit.png" />用户管理</div>
                    <div onclick="NavMenu('/RMBase/SysUserGroup/UserGroup_List.aspx','用户组管理')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/4957_customers.png" />用户组管理</div>
                    <div onclick="NavMenu('/RMBase/SysConfig/Config_Form.aspx','系统配置')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/4968_config.png" />系统配置</div>
                    <div onclick="NavMenu('/RMBase/SysAppend/AppendProperty_Index.aspx','附加属性')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/579.png" />附加属性</div>
                    <div onclick="NavMenu('/RMBase/SysLog/SysLog_Index.aspx','系统日志')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/411.png" />系统日志</div>
                    <div onclick="NavMenu('/RMBase/SysDataCenter/Backup_List.aspx','数据备份')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/20130408024938993_easyicon_net_32.png" />数据备份</div>
                    <div onclick="NavMenu('/RMBase/SysDataCenter/DataCenter_Index.aspx','资源管理')">
                        <img src="<%=request.getContextPath() %>/resources/tab/Images/32/576.png" />资源管理</div>
                </div>
                <div id="htmlMenuSelect" runat="Server" class="navSelect topline">
                    <div class="selected" onclick="GetSeedMenu(this,'3e544d7a-d850-4785-9648-feafc4698a3b')">
                        <img src='<%=request.getContextPath() %>/resources/tab/Images/32/375.png' width='16' height='16' />系统应用</div>
                    <div class="" onclick="GetSeedMenu(this,'5477b88b-3393-4d39-ba2d-f219f486bd38')">
                        <img src='<%=request.getContextPath() %>/resources/tab/Images/32/189.png' width='16' height='16' />个人应用</div>
                    <div class="" onclick="GetSeedMenu(this,'e84c0fca-d912-4f5c-a25e-d5765e33b0d2')">
                        <img src='<%=request.getContextPath() %>/resources/tab/Images/32/189.png' width='16' height='16' />生产管理</div>
                    <div class="" onclick="GetSeedMenu(this,'b863d076-37bb-45aa-8318-37942026921e')">
                        <img src='<%=request.getContextPath() %>/resources/tab/Images/32/636.png' width='16' height='16' />项目管理</div>
                </div>
            </div>
            <div id="Content">
                <iframe id="main" name="main" scrolling="auto" frameborder="0" scrolling="yes" width="100%"
                    height="100%" src="${pageContext.request.contextPath}/tab/homeIndex"></iframe>
            </div>
        </div>
        <div id="botton_toolbar">
            <div style="width: 33%; float: left; text-align: left;">
                当前版本 V2.0
            </div>
            <div style="width: 34%; float: left; text-align: center;">
                xxx信息有限公司
            </div>
            <div style="width: 33%; float: left; text-align: right">
                上午好！管理员(system)
            </div>
        </div>
    </div>
    <div id="loading" onclick="Loading(false);">
        正在处理，请稍待。。。
    </div>
    <div id="Toploading">
    </div>
    </form>
</body>
</html>