//获得当前日期，返回字符串
function getToday() {
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth() + 1;//0表示1月，1表示2月
    var day = today.getDate();
    return (year + "-" + month + "-" + day);
}

//获得指定日期后指定天数的日期
function getSpecifiedDate(date, days) {
    date.setDate(date.getDate() + days);//获取指定天之后的日期
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    return (year + "-" + month + "-" + day);
}



var clock = '';//定时器对象，用于页面30秒倒计时效果
var nums = 30;
var validateCodeButton;

//基于定时器实现30秒倒计时效果
function doLoop() {
    validateCodeButton.disabled = true;//将按钮置为不可点击
    nums--;
    if (nums > 0) {
        validateCodeButton.value = nums + '秒后重新获取';
    } else {
        clearInterval(clock); //清除js定时器
        validateCodeButton.disabled = false;
        validateCodeButton.value = '重新获取验证码';
        nums = 30; //重置时间
    }
}