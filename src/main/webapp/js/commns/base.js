$package('smb');
var smb = {
    /*弹出框*/
    alert:function(title,msg,icon,callback){
        $.messager.alert(title,msg,icon,callback);
    },
    /*弹出框*/
    confirm:function(title,msg,callback){
        $.messager.confirm(title,msg,callback);
    },
    /*进度条*/
    progress:function(title,msg){
        var win = $.messager.progress({
            title : title || '请等待',
            msg : msg || '加载数据...'
        });
    },
    /*重新登录页面*/
    toLogin:function(){
      window.top.location= urls['smbUrl']+"/login.jsp";
    },
    ajaxSubmit:function(form,option){
        form.ajaxSubmit(option);
    },
    ajaxJson:function(url,option,callback){
        $.ajax(url,{
            type:'post',
            dataType:'json',
            data:option,
            success:function(data){
                //坚持登录
                if ($.isFunction(callback)){
                    callback(data);
                }
            },
            error:function(){
            }
        });
    },
    submitForm:function(form,callback,dataType){
        var option = {
            type:'post',
            dataType:dataType||'json',
            success:function(data){
                if ($.isFunction(callback)){
                    callback(data);
                }
            }
        }
        smb.ajaxSubmit(form,option);
    },
    saveForm:function(form,callback){
        if (form.form('validate')){
            smb.progress('请等待','保存中...')
            //ajax提交form
            smb.submitForm(form,function(data){
                if (data.success){
                    if (callback){
                        callback(data);
                    } else {
                        smb.alert('提示','保存成功','info');
                    }
                } else {
                    smb.alert('提示',data.msg,'error');
                }
            });
        }
    },
    getById:function(url,option,callback){
        smb.progress();
        smb.ajaxJson(url,option,function(data){
            if (data.success){
                if (callback){
                    callback(data);
                }
            } else {
                smb.alert('提示',data.msg,'error');
            }
        });
    },
    deleteForm:function(url,option,callback){
        smb.progress();
        smb.ajaxJson(url,option,function(data){
           if (data.success){
               if (callback){
                   callback(data);
               }
           } else {
               smb.alert('提示',data.msg,'error');
           }
        });
    }
}

/*表单转成json数据*/
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}

