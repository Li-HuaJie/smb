$package('smb.login');
smb.login = function(){
    return {
        toLogin:function(){
            try{
                var form = $("#register-form");
                smb.submitForm(form,function(data){
                    if(data.success){
                        window.location = "main";
                    }else {
                        smb.alert('提示',data.msg,'error');
                    }
                })
            }catch(e){
            }
            return false;
        },
        init:function(){
            if(window.top != window.self){
                window.top.location = window.self.location;
            }
            var form = $("#register-form");
            form.submit(smb.login.toLogin);
        }
    }
}();

$(function(){
    smb.login.init();
});







