<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

    let custinfo_form = {
        init : function(){
            $('#update_btn').click(function(){
                custinfo_form.send();
            });
            $('#delete_btn').click(function(){
                let c=confirm("삭제 하시겠습니까?");
                if(c==true){
                    location.href="/cust/deleteimpl?id=${custinfo.id}";
                }
            });
        },
        send : function(){

            $('#custinfo_form').attr({
                'action':'/cust/updateimpl',//MainController로 요청을 보낸다.
                'method':'post'
            });
            $('#custinfo_form').submit();
        }
    };
    $(function(){
        custinfo_form.init()
    });

</script>

<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Cust Detail</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Cust Detail</h6>
        </div>
        <div class="card-body">
            <div id="container">
                <form id="custinfo_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id">ID:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" value="${custinfo.id}" id="id" name="id" readonly>
                        </div>
                        <div class="col-sm-10">
                            <span id="check_id" class="bg-danger"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="pwd" name="pwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">이름:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" value="${custinfo.name}" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="update_btn" type="button" class="btn btn-info">update</button>
                            <button id="delete_btn" type="button" class="btn btn-info">delete</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>