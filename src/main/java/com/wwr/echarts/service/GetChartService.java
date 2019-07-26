package com.wwr.echarts.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wwr
 * @Description  获取以及保存图数据的服务接口
 * @date 2019/7/17
 */
public interface GetChartService {
    JSONObject getChartJson(int id);

    int saveChart(String org, String sql, String title, String type, String xAxis, String barname, String remake);

    String queryCharts(String org);

}
