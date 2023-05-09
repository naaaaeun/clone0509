<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%-- //jstl을 쓰겠다는 뜻!!
c 로 쓰겠다는것, 그래서 밑에 c:out  으로 쓸 수 있음--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <script>

        let register_form = {
            init : function(){
                $('#register_btn').click(function(){
                    register_form.send();
                });
                $('#level').keyup(() => {

                    let id =$('#id').val();
                    let pwd =$('#pwd').val();
                    let level =$('#level').val();
                    if(id!=""&&pwd!=""&&level!=""){
                        $('#register_btn').removeClass('disabled');
                    }
                });
                $('#id').keyup(() => {
                    $('#register_btn').addClass('disabled');
                    var txt_id = $('#id').val();
                    if(txt_id.length <= 3){
                        $('#check_id').text('4자리 이상이어야 합니다.');
                        return;
                    }
                    $.ajax({
                        url : '/checkid',
                        data : {id:txt_id},
                        success:function(result){
                            if(result == 0){
                                $('#check_id').text('사용가능합니다.')
                                $('#pwd').focus();
                            } else{
                                $('#check_id').text('사용불가능합니다.')
                            }
                        }
                    })
                });
            },
            send : function(){
                let id =$('#id').val();
                let pwd =$('#pwd').val();
                let level =$('#level').val();
                if(pwd==''){
                    $('#pwd').focus();
                    return;
                }
                if(level==''){
                    $('#level').focus();
                    return;
                }
                $('#register_form').attr({
                    'action':'/registerimpl',//MainController로 요청을 보낸다.
                    'method':'post'
                });
                $('#register_form').submit();
            }
        };
        $(function(){
            register_form.init()
        });

    </script>
</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form id="register_form" class="user">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" name="id" id="id" placeholder="Enter id">
                                </div>
                                <div class="col-sm-6">
                                    <span id = "check_id"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-user" name="pwd"  id="pwd" placeholder="Enter password">
                            </div>
                            <div class="form-group">
                                <input type="number" class="form-control form-control-user" name="level"  id="level" placeholder="Enter level">
                            </div>
                            <button id="register_btn" type="button" class="btn btn-primary btn-user btn-block">Register</button>
                            <hr>
                            <a href="index.html" class="btn btn-google btn-user btn-block">
                                <i class="fab fa-google fa-fw"></i> Register with Google
                            </a>
                            <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                            </a>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="/login">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

</body>

</html>