<%--
  Created by IntelliJ IDEA.
  User: rootm
  Date: 2017/3/4
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <div class="pace  pace-inactive">
        <div class="pace-progress" data-progress-text="100%" data-progress="99"
             style="transform: translate3d(100%, 0px, 0px);">
            <div class="pace-progress-inner"></div>
        </div>
        <div class="pace-activity"></div>
    </div>
    <jsp:include page="<%=defaultPage%>"></jsp:include>
</div>
<!-- /.content-wrapper -->