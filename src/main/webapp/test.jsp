<%@ page contentType="text/html;charset=utf8" language="java" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script type="text/javascript" src="/js/echarts.min.js"></script>


</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 800px;height:600px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    myChart.setOption(${option});


    //图片下载的实现思路：
    // 1.通过getDataURL()获取图片的base64编码字符；
    // 2.字符解码，并转换成Blob对象；
    // 3.通过Blob对象创建URL对象；
    // 4.利用<a>触发下载操作


    //base64转blob
    function base64ToBlob(code) {
        let parts = code.split(';base64,');
        let contentType = parts[0].split(':')[1];
        let raw = window.atob(parts[1]);
        let rawLength = raw.length;

        let uInt8Array = new Uint8Array(rawLength);

        for (let i = 0; i < rawLength; ++i) {
            uInt8Array[i] = raw.charCodeAt(i);
        }
        return new Blob([uInt8Array], { type: contentType });
    }

    //设置延时目的是让图片的渲染完成后再进行下载。
    setTimeout(function saveAsImage() {
            let content = myChart.getDataURL({pixelRatio: 5, //导出的图片分辨率比率,默认是1
                backgroundColor: '#fff', //图表背景色
                excludeComponents: [ //保存图表时忽略的工具组件,默认忽略工具栏
                'toolbox'
            ],});

            let aLink = document.createElement('a');
            let blob = this.base64ToBlob(content);
            var type = "png";
            let evt = document.createEvent("HTMLEvents");
            evt.initEvent("click", true, true);
            aLink.download = myChart.getOption().title[0].text + '.' + type;
            aLink.href = URL.createObjectURL(blob);
            aLink.dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true, view: window }));
        }
    ,1000)




</script>
</body>
</html>