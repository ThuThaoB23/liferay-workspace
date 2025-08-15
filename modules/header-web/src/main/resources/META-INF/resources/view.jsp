<%@ page import="java.util.List" %>
<%@ page import="com.example.header.api.HeaderNavContributor.NavItem" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />

<%
	List<NavItem> items = (List<NavItem>)request.getAttribute("headerNavItems");
	if (items == null) items = java.util.Collections.emptyList();
%>

<div class="header-portlet">
	<div class="gov-banner">
		<div class="logo-area">
			<span class="logo-circle"></span>
			<div class="titles">
				<div class="title-vi">THANH TRA CHÍNH PHỦ</div>
				<div class="title-en">The Government Inspectorate of Vietnam</div>
			</div>
		</div>
		<div class="search-lang">
			<form class="search-form" action="#">
				<input type="text" placeholder="Tìm kiếm" />
				<button type="submit">Tìm</button>
			</form>
			<div class="lang-switch">Ngôn ngữ</div>
		</div>
	</div>
	<div class="navbar">
		<a class="nav-item active" href="#">TRANG CHỦ</a>
		<a class="nav-item" href="#">GIỚI THIỆU</a>
		<a class="nav-item" href="#">TIN TỨC - SỰ KIỆN</a>
		<a class="nav-item" href="#">VĂN BẢN PHÁP LUẬT</a>
		<a class="nav-item" href="#">KẾT LUẬN THANH TRA</a>
		<a class="nav-item" href="#">LIÊN HỆ</a>
		<% for (NavItem item : items) { %>
			<a class="nav-item" href="<%= item.href %>"><%= item.label %></a>
		<% } %>
		<div class="navbar-right">
			<a class="nav-btn" href="#">Email</a>
		</div>
	</div>
	<div class="ticker">
		<div class="ticker-item">Công bố quyết định thanh tra tỉnh Hải Dương</div>
		<div class="ticker-item">Sơ kết 5 năm thực hiện quy chế phối hợp...</div>
	</div>
</div>

<style>
.header-portlet { font-family: system-ui, -apple-system, Segoe UI, Roboto, Arial, sans-serif; }
.gov-banner { display: flex; justify-content: space-between; align-items: center; background: #2196F3; color: #fff; padding: 12px 16px; }
.logo-area { display: flex; align-items: center; gap: 12px; }
.logo-circle { width: 48px; height: 48px; border-radius: 50%; background: radial-gradient(circle at 30% 30%, #ffd54f, #f57c00); border: 3px solid #fff; box-shadow: 0 0 0 2px rgba(0,0,0,.05); }
.titles { line-height: 1.15; }
.title-vi { font-weight: 700; font-size: 18px; letter-spacing: .3px; }
.title-en { font-size: 12px; opacity: .9; }
.search-lang { display: flex; align-items: center; gap: 12px; }
.search-form { display: flex; gap: 8px; background: rgba(255,255,255,.15); padding: 6px 8px; border-radius: 6px; }
.search-form input { border: 0; outline: none; background: transparent; color: #fff; width: 220px; }
.search-form button { background: #1976D2; border: 0; color: #fff; padding: 6px 10px; border-radius: 4px; cursor: pointer; }
.lang-switch { background: rgba(255,255,255,.15); padding: 6px 10px; border-radius: 6px; }

.navbar { display: flex; align-items: center; gap: 16px; background: #E3F2FD; color: #0D47A1; padding: 8px 16px; border-bottom: 1px solid #BBDEFB; }
.nav-item { color: #0D47A1; text-decoration: none; padding: 8px 10px; border-radius: 4px; font-weight: 600; font-size: 14px; }
.nav-item:hover { background: #BBDEFB; }
.nav-item.active { background: #90CAF9; color: #0D47A1; }
.navbar-right { margin-left: auto; }
.nav-btn { background: #1976D2; color: #fff; padding: 6px 10px; border-radius: 4px; text-decoration: none; }

.ticker { display: flex; gap: 16px; padding: 10px 16px; background: #FAFAFA; color: #333; border-top: 1px solid #eee; }
.ticker-item { display: flex; align-items: center; gap: 8px; }
.ticker-item:before { content: "\25CF"; color: #E53935; font-size: 10px; }
</style>