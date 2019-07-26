package com.wwr.echarts.api;


/**
 * @author wwr
 * @Description
 * @date 2019/7/17
 */
public interface ChartDataApi {
    //获取数据库中绘图的所有数据
    String[][] getAllChartData(String sql);

}
