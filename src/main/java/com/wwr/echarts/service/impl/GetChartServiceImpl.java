package com.wwr.echarts.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wwr.echarts.api.ChartDataApi;
import com.wwr.echarts.mapper.ChartMapper;
import com.wwr.echarts.mapper.ChartOptionMapper;
import com.wwr.echarts.model.Chart;
import com.wwr.echarts.service.GetChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("getChartService")
public class GetChartServiceImpl implements GetChartService {

    @Autowired
    private ChartOptionMapper chartOptionMapper;

    @Autowired
    private ChartMapper chartMapper;

    @Autowired
    private ChartDataApi chartDataApi;

    @Override
    public JSONObject getChartJson(int id) {

        Chart chart = chartMapper.getOne(id);
        String type = chart.getType();
        String title = chart.getTitle();
        String sql = chart.getSql_str();

        String [] bList = chart.getBar_name().split("\\|");
        //获取x轴上的参数并将其拼接成特定格式的字符串
        String[] xAxisList =chart.getX_axis().split("\\|");

        System.out.println("++++++++++"+xAxisList.length);
        //获取图数据

        //根据所给类型取出相应的图表配置。
        JSONObject optionJson = JSON.parseObject(chartOptionMapper.getOne(type).getOption());

        JSONObject title1 = JSON.parseObject(optionJson.get("title").toString());
        title1.put("text",title);
        optionJson.put("title",title1);

        //执行sql获取数据
        String [][] source=chartDataApi.getAllChartData(sql);

        if(type.equals("pie")){
            String[][] sour = new String[xAxisList.length+1][2];
            sour[0][0] = "";
            sour[0][1] = "";
            for(int i=1;i<xAxisList.length+1;i++){
                sour[i][0]=xAxisList[i-1];
                sour[i][1]=source[0][i-1];
            }
            JSONObject dataset = new JSONObject();
            dataset.put("source",sour);
            optionJson.put("dataset",dataset);
        }

        else{
            JSONObject xAxis = JSON.parseObject(optionJson.get("xAxis").toString());
            xAxis.put("data",xAxisList);
            //判断是否是bar2类型，进行特殊处理。
            if(type.equals("bar2")){
                optionJson.put("yAxis",xAxis);
            }
            else{
                optionJson.put("xAxis",xAxis);
            }

            JSONArray series = JSON.parseArray(optionJson.get("series").toString());

            for (int i =0; i<bList.length;i++){
                JSONObject bar = new JSONObject();
                //当每列只有一个bar时，设置它的颜色。多个bar则根据默认的设置。
                if (bList.length==1){
                    JSONObject itemStyle = new JSONObject();
                    JSONObject normal = new JSONObject();
                    normal.put("color","#188df0");
                    itemStyle.put("normal",normal);
                    bar.put("itemStyle",itemStyle);
                }
                bar.put("name",bList[i]);

                //判断是否是bar2类型，进行特殊处理。
                if(type.equals("bar2")){
                    bar.put("type","bar");
                }
                else{
                    bar.put("type",type);
                }

                //给每个bar设置数据
                bar.put("data",source[i]);
                series.add(bar);
            }
            optionJson.put("series",series);
        }
        System.out.println(optionJson.toJSONString());
        return optionJson;
    }



    @Override
    //存储特定chart的配置所需数据，并返回该条数据在数据库中的id
    public int saveChart(String org, String sql, String title, String type, String xAxis,String barname, String remake) {

        Chart chart = new Chart(org,sql,title,type,xAxis,barname,remake);
        chartMapper.insertAndGetId(chart);
        int id = chart.getId();
        return id;

    }

    @Override
    //查看数据表中某个特定组织的全部chart配置数据
    public String queryCharts(String org) {
        List<Chart> l = chartMapper.getOrgAll(org);
        String s = "";
        for(Chart i: l){
            System.out.println(i.getSql_str());
            s+=i.toString();
        }
        return s;
    }

//    //执行sql，返回数据
//    public String[][] executeSQl(String sql){
//        List list = chartDataApi.getAllChartData(sql);
//        try{
//            Object[] cells = (Object[])list.get(0);
//            String [][] source = new String[cells.length][list.size()];
//            for (int i=0;i<list.size();i++){
//                cells = (Object[])list.get(i);
//                for (int j=0;j<cells.length;j++){
//                    source[j][i] = cells[j].toString();
//                }
//            }
//            return source;
//        }catch (ClassCastException e){
//            String[][] source = new String[1][list.size()];
//            for (int i = 0; i < list.size(); i++) {
//                Object cell = list.get(i);
//                source[0][i] = cell.toString();
//            }
//            return source;
//        } catch(Exception ex){
//            System.out.println("------------------");
//            System.out.println(ex.toString());
//            return null;
//        }
//    }

}
