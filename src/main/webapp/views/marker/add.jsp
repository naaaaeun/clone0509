<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let marker_add={
        init:function(){
            $('#register_btn').click(function(){
                marker_add.send();
            });
        },
        send:function(){
            $('#register_form').attr({
                method:'post',
                action:'/marker/addimpl',
                enctype:'multipart/form-data'
            });
            $('#register_form').submit();
        }
    };

    $(function(){
        marker_add.init();
    })
</script>

<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Marker Add</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Marker Add</h6>
        </div>
        <div class="card-body">
            <div id="container">


                <form id="register_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="title">title:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="title 입력" id="title" name="title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="target">target:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="target" placeholder="Enter target" name="target">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="lat">경도:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="lat" placeholder="Enter lat" name="lat">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="lng">위도:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="lng" placeholder="Enter lng" name="lng">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="imgfile">이미지:</label>
                        <div class="col-sm-10">
                            <input type="file" class="form-control" id="imgfile" placeholder="input img" name="imgfile">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="loc">지역:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="loc" placeholder="Enter loc" name="loc">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="register_btn" type="button" class="btn btn-info">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>