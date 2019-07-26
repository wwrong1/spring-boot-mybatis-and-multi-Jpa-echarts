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

    /**利用ajax接收后台传来的url访问controller方法获取option，再生成图表。
    $.get("${url}",function (option) {
        myChart.setOption(option);
    })

    $.ajax({
        type: "get",
        url: "${url}",<%--"<%=request.getAttribute("url")%>"--%>
        data: {},
        success: function (result) {
            console.log(result);
            myChart.setOption(result)
        },
        error: function (error) {
            console.log(error);
        }
    })**/

</script>
</body>
</html>