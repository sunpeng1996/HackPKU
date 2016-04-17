<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>myEvents</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/myEvents.css" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/jalendar_write.js"></script>
    <script type="text/javascript">
    $(function () {
        $('#myId3').jalendar();
    });
    </script>
</head>
<body>
    <div id="pageInfo">
        <div id="myId3" class="jalendar mid">
        </div> 
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
              <div class="modal-dialog">  
                <div class="modal-content">  
                  <div class="modal-header">  
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
                    <h4 class="modal-title">添加任务成员</h4>  
                  </div>  
                  <div class="modal-body">  
                    <div class="btn-group">
                       <button type="button" class="btn btn-default dropdown-toggle" 
                          data-toggle="dropdown">
                          成员 <span class="caret"></span>
                       </button>
                       <ul class="dropdown-menu" role="menu">
                       	   <c:forEach items="${clubMembership }" var="clubmember">
                            <li><a href="javascript:void(0)" id="a_${clubmember.user.userId }">${clubmember.user.username }</a></li> 
                       	   </c:forEach>
                       </ul>
                    </div>  
                    <div class="well modal-well"></div>
                  </div>  
                  <div class="modal-footer">  
                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">确认</button>  
                  </div>  
                </div><!-- /.modal-content -->  
              </div><!-- /.modal-dialog -->  
            </div><!-- /.modal -->  
    </div>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>

               
