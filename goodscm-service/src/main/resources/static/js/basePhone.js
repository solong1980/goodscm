/** USB录音盒子测试js **/
var ubox = {
    lines:[],
    isLine:false, // 是否连接上websocket
};
var memberUrl = $("#main_member_url").val();// 跳转页面url

$(function () {
    if(window.WebSocket) {
        ws = new WebSocket('ws://127.0.0.1:8054/');

        ws.onopen = function(ev)  {
            // showLog('open：' + JSON.stringify(ev));
            ubox.isLine = ev.isTrusted;
        };
        ws.onerror = function(ev) {
            ubox.isLine = false;
            // showLog('error：' + JSON.stringify(ev));
        };
        ws.onclose = function(ev) {
            ubox.isLine = false;
            // showLog('close：' + JSON.stringify(ev));
            ws = null;
        };

        ws.onmessage = function (ev) {
            var msg = eval('(' + ev.data + ')');
            if(ubox.isLine) {
                if(msg.event == "plugin") {
                    ubox_Plug_In(msg.handle); // 设备插入
                }  else if(msg.event == "callerId") { // 获取来电号码
                    ubox_CallId(msg.handle, msg.callernumber);
                } else if(msg.event == "joined") {
                    var msg = {
                        "event": "getinfo"
                    };
                    websocket_send_msg(JSON.stringify(msg));
                } else if(msg.event == "getinfo") {
                    if(msg.channels.length > 0)
                    {
                        for(var i=0;i<msg.channels.length;i++)
                        {
                            ubox_Plug_In(msg.channels[i].handle);
                            if(msg.channels[i].deviceError)
                                ubox_DeviceError(msg.channels[i].handle);
                            if(msg.channels[i].deviceAlarm)
                                ubox_DeviceAlarm(msg.channels[i].handle, msg.channels[i].deviceAlarm);
                        }
                    } else {
                        showLog("no usb device  plugin");
                    }
                }
            } else {
                layer.alert('Ubox客户端未开启',{
                    title:'错误提示'
                });
            }
        };
    }
});

// 向服务器发送消息
function websocket_send_msg(msg) {
    ws.send(msg);
}

// 输出调试语句
function showLog(msg)
{
    console.log(msg);
}

// 检测设备是否插入
function ubox_Plug_In(uboxhdl)
{
    if( ubox.lines[uboxhdl] == undefined ){
        ubox.lines[uboxhdl] = {};
    }

    ubox.lines[uboxhdl].handle = uboxhdl;

    var msg = {
        "event": "GetProductID",
        "handle": uboxhdl
    };
    websocket_send_msg(JSON.stringify(msg));

}

// 获取来电号码
function ubox_CallId(uboxHandle,callerNumber)
{
    if(callerNumber) {
        confirmHandle(callerNumber)
    }

}

function ubox_DeviceError(uboxhdl)
{
    var outdata = "设备"+uboxhdl;
    showLog(outdata+" 错误，重启软件");
}

function ubox_DeviceAlarm(uboxhdl, type)
{
    // var outdata = "设备"+uboxhdl;
    //如果软件退出，USB线重新插拔一下，软件再启动还有这个提示，参考常见开发问题文档 问题1和问题2
    if(type == 1) {
        showLog("未能找到ubox 的MIC 设备, 设备警告,重启软件");
    } else if(type == 2) {
        showLog("未能打开ubox 的 MIC 设备, 设备警告,重启软件");
    } else if(type == 3) {
        showLog("未能打开ubox 的放音设备, 设备警告,重启软件");
    } else if(type == 4) {
        showLog("设备故障,设备工作不正常, 重启软件");
    } else if(type == 6) {
        showLog("复位 audio device失败, 设备警告,重启软件");
    }
}

function confirmHandle(phone)
{
    layer.confirm('是否搜索用户：<B>' + phone + '</B>', {
        title:'搜索用户',
        btn: ['确认','取消'], //按钮
        area: '300px',
    }, function(){
        memberUrl += '?keyword=' + phone + '&type=3';
        window.location.href = memberUrl;
    }, function(){

    });
}

