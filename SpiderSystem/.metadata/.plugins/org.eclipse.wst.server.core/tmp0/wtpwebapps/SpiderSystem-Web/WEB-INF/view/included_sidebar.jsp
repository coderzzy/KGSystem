<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js fixed-layout">
<head>
  <meta charset="UTF-8">
	
</head>
<body>
  
    <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
      <div class="am-offcanvas-bar admin-offcanvas-bar">
        <ul class="am-list admin-sidebar-list">
          <li>
            <a href="${pageContext.request.contextPath}/admin/index">
              <span class="am-icon-home"></span> 首 页
            </a>
          </li>
          <!--
          <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
              <li><a href="admin-user.html" class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
              <li><a href="admin-help.html"><span class="am-icon-puzzle-piece"></span> 帮助页</a></li>
              <li><a href="admin-gallery.html"><span class="am-icon-th"></span> 相册页面<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
              <li><a href="admin-log.html"><span class="am-icon-calendar"></span> 系统日志</a></li>
              <li><a href="admin-404.html"><span class="am-icon-bug"></span> 404</a></li>
            </ul>
          </li>
          -->
          <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-spider'}">
              <span class="am-icon-bug"></span> 爬虫管理
              <span class="am-icon-angle-right am-fr am-margin-right"></span>
            </a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-spider">
              <li>
                <a href="${pageContext.request.contextPath}/spider/check" class="am-cf">
                  <span class="am-icon-bug"></span> 系统级爬虫
                  <span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span>
                </a>
              </li>
              <!-- 
              <li>
                <a href="#">
                  <span class="am-icon-bug"></span> 用户级爬虫</a>
                </li>
                -->
                <li>
                <a href="${pageContext.request.contextPath}/memory/index">
                  <span class="am-icon-area-chart"></span> 内存信息系统</a>
                </li>
            </ul>
          </li>
          
          <li>
            <a href="${pageContext.request.contextPath}/log/index">
              <span class="am-icon-calendar"></span> 系统日志
            </a>
          </li>

          <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-database'}">
              <span class="am-icon-database"></span> 数据库
              <span class="am-icon-angle-right am-fr am-margin-right"></span>
            </a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-database">
              <li>
                <a href="${pageContext.request.contextPath}/notice/show">
                  <span class="am-icon-pencil-square-o"></span> 公告表
                </a>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/news/show">
                  <span class="am-icon-pencil-square-o"></span> 新闻表
                </a>
              </li>
            </ul>
          </li>
          
          <li>
            <a href="${pageContext.request.contextPath}/newsDataAnalysis/index">
              <span class="am-icon-pie-chart"></span> 数据分析
            </a>
          </li>

          <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-data_operate'}">
              <span class="am-icon-table"></span> 数据处理
              <span class="am-icon-angle-right am-fr am-margin-right"></span>
            </a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-data_operate">
              <li>
                <a href="${pageContext.request.contextPath}/newsDataProcess/index_pre">
                  <span class="am-icon-pencil-square-o"></span> 数据预处理
                </a>
              </li>
              <li>
                <a href="#">
                  <span class="am-icon-pie-chart"></span> 分词与词频统计
                </a>
              </li>
            </ul>
          </li>

        </ul>

        <div class="am-panel am-panel-default admin-sidebar-panel">
          <div class="am-panel-bd">
            <p>
              <span class="am-icon-bookmark"></span> 公 告
            </p>
            <p>${notice.getText()}
            </p>
          </div>
        </div>

        <div class="am-panel am-panel-default admin-sidebar-panel">
          <div class="am-panel-bd">
            <p>
              <span class="am-icon-tag"></span>SpiderSystem
            </p>
            <p>Welcome to the SpiderSystem !</p>
          </div>
        </div>

        <ul class="am-list admin-sidebar-list">
          <li>
            <a href="#">
              <span class="am-icon-sign-out"></span> 注 销
            </a>
          </li>
        </ul>

      </div>
    </div>

</body>
</html>
