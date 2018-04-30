$(document).ready(function() {
	$("button").click(function() {
		$.ajax({
			type : "POST",
			url : "/login/dologin",
			data : $("form").serialize(),
			dataType : "json",
			success : function(result) {
				if (result.status == 200) {// 登录成功
					parent.location.href = '../login/main';
				} else {

				}
			}
		});
	})
});