/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M11
 * Generated at: 2018-05-04 15:22:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memory_005fsystem_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html class=\"no-js fixed-layout\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("\t<title>Admin Index Page | SpiderSystem</title>\n");
      out.write("\t<!-- 以下代码告诉IE浏览器，IE8/9及以后的版本都会以最高版本IE来渲染页面 -->\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\n");
      out.write("  <meta name=\"description\" content=\"the admin_index of SpiderSystem\">\n");
      out.write("  <meta name=\"keywords\" content=\"index SpiderSystem\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit\">\n");
      out.write("\t<!-- 以下代码取消第三方转码 -->\n");
      out.write("\t<meta name=\"Cache-Control\" content=\"no-siteapp\">\n");
      out.write("\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\"\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/amazeui_assets/i/favicon.png\">\n");
      out.write("  <link rel=\"apple-touch-icon-precomposed\"\n");
      out.write("    href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/amazeui_assets/i/app-icon72x72@2x.png\">\n");
      out.write("  <link rel=\"stylesheet\"\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/amazeui_assets/css/amazeui.min.css\">\n");
      out.write("  <link rel=\"stylesheet\"\n");
      out.write("  \thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/amazeui_assets/css/admin.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <!--[if lte IE 9]>\n");
      out.write("  <p class=\"browsehappy\">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href=\"http://browsehappy.com/\" target=\"_blank\">升级浏览器</a>\n");
      out.write("    以获得更好的体验！</p>\n");
      out.write("  <![endif]-->\n");
      out.write("\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "included_header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("  <div class=\"am-cf admin-main\">\n");
      out.write("    <!-- sidebar start-->\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "included_sidebar.jsp", out, false);
      out.write("\n");
      out.write("    <!-- siderbar end -->\n");
      out.write("\n");
      out.write("    <!-- content start-->\n");
      out.write("    <div class=\"admin-content\">\n");
      out.write("      <div class=\"admin-content-body\">\n");
      out.write("\t\t<div id=\"memory_chart\" style=\"width:600px; height: 400px;\"></div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "included_footer.jsp", out, false);
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- content end-->\n");
      out.write("\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!--[if lt IE 9]>\n");
      out.write("  <script src=\"http://libs.baidu.com/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js\"></script>\n");
      out.write("  <script src=\"assets/js/amazeui.ie8polyfill.min.js\"></script>\n");
      out.write("  <![endif]-->\n");
      out.write("\n");
      out.write("  <!--[if (gte IE 9)|!(IE)]><!-->\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/js/jquery.min.js\"></script>\n");
      out.write("  <!--<![endif]-->\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/amazeui_assets/js/amazeui.min.js\"></script>\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/amazeui_assets/js/app.js\"></script>\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/js/echarts.js\"></script>\n");
      out.write("  \n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("  \t/*\n");
      out.write("  \t\t$(function(){\n");
      out.write("  \t\t\tsetInterval(function(){\n");
      out.write("  \t\t\t\t$.ajax({\n");
      out.write("  \t  \t             url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/memory/show\",\n");
      out.write("  \t  \t             type: \"POST\",\n");
      out.write("  \t  \t             dataType: \"json\",\n");
      out.write("  \t  \t             async: false,\n");
      out.write("  \t  \t             success: function(data) {\n");
      out.write("  \t  \t            \t if(data.result == \"success\"){\n");
      out.write("  \t  \t                \t // alert(\"操作成功\");\n");
      out.write("  \t  \t                \t blank_area();\n");
      out.write("  \t  \t                 }else{\n");
      out.write("  \t  \t                \t alert(\"数据读取失败\");\n");
      out.write("  \t  \t                 }\n");
      out.write("  \t  \t             },\n");
      out.write("  \t  \t             error: function() {\n");
      out.write("  \t  \t               alert(\"访问服务器失败，...请检查网络连接，如确实怀疑服务器问题请联系Zzy\");\n");
      out.write("  \t  \t             }\n");
      out.write("  \t  \t           });\n");
      out.write("  \t\t\t}, 5000);\n");
      out.write("  \t\t\t\n");
      out.write("  \t\t});\n");
      out.write("  \t\t\n");
      out.write("  \t\tfunction blank_area(){\n");
      out.write("  \t\t\tvar option = {\n");
      out.write("  \t\t\t\t\txAxis: {\n");
      out.write("  \t\t\t\t        type: 'category',\n");
      out.write("  \t\t\t\t        boundaryGap: false,\n");
      out.write("  \t\t\t\t        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']\n");
      out.write("  \t\t\t\t    },\n");
      out.write("  \t\t\t\t    yAxis: {\n");
      out.write("  \t\t\t\t        type: 'value'\n");
      out.write("  \t\t\t\t    },\n");
      out.write("  \t\t\t\t    series: [{\n");
      out.write("  \t\t\t\t        data: [820, 932, 901, 934, 1290, 1330, 1320],\n");
      out.write("  \t\t\t\t        type: 'line',\n");
      out.write("  \t\t\t\t        areaStyle: {}\n");
      out.write("  \t\t\t\t    }]\n");
      out.write("  \t\t\t\t};\n");
      out.write("  \t\t\t\n");
      out.write("  \t\t\t//初始化echarts实例\n");
      out.write("            var memory_Chart = echarts.init(document.getElementById('memory_chart'));\n");
      out.write("\n");
      out.write("            //使用制定的配置项和数据显示图表\n");
      out.write("            memory_Chart.setOption(option);\n");
      out.write("  \t\t}\n");
      out.write("  \t\t\n");
      out.write("  \t\t*/\n");
      out.write("  \t\t\n");
      out.write("  \t    // 基于准备好的dom，初始化echarts实例  \n");
      out.write("  \t\tvar myChart = echarts.init(document.getElementById('memory_chart'));  \n");
      out.write("  \t\t  \n");
      out.write("  \t\tfunction initData() {  \n");
      out.write("  \t\t    now = now + 1;  \n");
      out.write("  \t\t    value = value + Math.random() * 21 - 10;  \n");
      out.write("  \t\t    return {  \n");
      out.write("  \t\t        name: now.toString(),  \n");
      out.write("  \t\t        value: [  \n");
      out.write("  \t\t            now,  \n");
      out.write("  \t\t            // Math.random() * 100 \n");
      out.write("  \t\t            0\n");
      out.write("  \t\t        ]  \n");
      out.write("  \t\t    }  \n");
      out.write("  \t\t}  \n");
      out.write("  \t\t\n");
      out.write("  \t\tfunction ajaxData() {  \n");
      out.write("  \t\t    now = now + 1;  \n");
      out.write("  \t\t    value = value + Math.random() * 21 - 10;\n");
      out.write("  \t\t    var ajaxValue;\n");
      out.write("  \t\t  \t$.ajax({\n");
      out.write(" \t             url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/memory/show\",\n");
      out.write(" \t             type: \"POST\",\n");
      out.write(" \t             dataType: \"json\",\n");
      out.write(" \t             async: false,\n");
      out.write(" \t             success: function(data) {\n");
      out.write(" \t            \t if(data.result == \"success\"){\n");
      out.write(" \t                \t // alert(\"操作成功\");\n");
      out.write(" \t                \t // alert(data.value);\n");
      out.write(" \t                \t ajaxValue = data.value;\n");
      out.write(" \t                 }else{\n");
      out.write(" \t                \t alert(\"数据读取失败\");\n");
      out.write(" \t                 }\n");
      out.write(" \t             },\n");
      out.write(" \t             error: function() {\n");
      out.write(" \t               alert(\"访问服务器失败，...请检查网络连接，如确实怀疑服务器问题请联系Zzy\");\n");
      out.write(" \t             }\n");
      out.write(" \t           });\n");
      out.write("  \t\t    return {  \n");
      out.write("  \t\t        name: now.toString(),  \n");
      out.write("  \t\t        value: [  \n");
      out.write("  \t\t            now,  \n");
      out.write("  \t\t            // Math.random() * 100 \n");
      out.write("  \t\t            ajaxValue\n");
      out.write("  \t\t        ]  \n");
      out.write("  \t\t    }  \n");
      out.write("  \t\t}  \n");
      out.write("  \t\t  \n");
      out.write("  \t\tvar data = [];  \n");
      out.write("  \t\tvar now = +0;  \n");
      out.write("  \t\tvar oneDay = 1;  \n");
      out.write("  \t\tvar value = Math.random() * 1000;  \n");
      out.write("  \t\tfor (var i = 0; i < 7; i++) {  \n");
      out.write("  \t\t    data.push(initData());  \n");
      out.write("  \t\t}  \n");
      out.write("  \t\t  \n");
      out.write("  \t\toption = {  \n");
      out.write("  \t\t    title: {  \n");
      out.write("  \t\t        text: \"后台可用内存\"  \n");
      out.write("  \t\t    },  \n");
      out.write("  \t\t    tooltip: {  \n");
      out.write("  \t\t        trigger: 'axis',  \n");
      out.write("  \t\t        formatter: function (params) {  \n");
      out.write("  \t\t            params = params[0];  \n");
      out.write("  \t\t            var date = new Date(params.name);  \n");
      out.write("  \t\t            return params.value[1];  \n");
      out.write("  \t\t        },  \n");
      out.write("  \t\t        axisPointer: {  \n");
      out.write("  \t\t            animation: false  \n");
      out.write("  \t\t        }  \n");
      out.write("  \t\t    },  \n");
      out.write("  \t\t    xAxis: {  \n");
      out.write("  \t\t        type: 'value',  \n");
      out.write("  \t\t    },  \n");
      out.write("  \t\t    yAxis: {  \n");
      out.write("  \t\t        type: 'value',  \n");
      out.write("  \t\t    },  \n");
      out.write("  \t\t    series: [{  \n");
      out.write("  \t\t        name: '模拟数据',  \n");
      out.write("  \t\t        type: 'line',  \n");
      out.write("  \t\t        showSymbol: false,  \n");
      out.write("  \t\t        hoverAnimation: false,  \n");
      out.write("  \t\t        //stack: '总量',  \n");
      out.write("  \t\t        data: data  \n");
      out.write("  \t\t    }]  \n");
      out.write("  \t\t};  \n");
      out.write("  \t\t  \n");
      out.write("  \t\tsetInterval(function () {  \n");
      out.write("  \t\t  \n");
      out.write("  \t\t    for (var i = 0; i < 1; i++) {  \n");
      out.write("  \t\t        data.shift();  \n");
      out.write("  \t\t        data.push(ajaxData());  \n");
      out.write("  \t\t    }  \n");
      out.write("  \t\t  \n");
      out.write("  \t\t    myChart.setOption({  \n");
      out.write("  \t\t    series: [{  \n");
      out.write("  \t\t        name: '模拟数据',  \n");
      out.write("  \t\t        type: 'line',  \n");
      out.write("  \t\t        showSymbol: false,  \n");
      out.write("  \t\t        hoverAnimation: false,  \n");
      out.write("  \t\t        //stack: '总量',  \n");
      out.write("  \t\t        data: data  \n");
      out.write("  \t\t    }]  \n");
      out.write("  \t\t    });  \n");
      out.write("  \t\t    myChart.setOption({  \n");
      out.write("  \t\t        xAxis: [{  \n");
      out.write("  \t\t        type: 'value',  \n");
      out.write("  \t\t        splitLine: {  \n");
      out.write("  \t\t            show: false  \n");
      out.write("  \t\t        },  \n");
      out.write("  \t\t        min: +data[0].name\n");
      out.write("  \t\t    }]  \n");
      out.write("  \t\t    });  \n");
      out.write("  \t\t}, 1000);  \n");
      out.write("  \t\t  \n");
      out.write("  \t\t// 使用刚指定的配置项和数据显示图表。  \n");
      out.write("  \t\tmyChart.setOption(option);  \n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
