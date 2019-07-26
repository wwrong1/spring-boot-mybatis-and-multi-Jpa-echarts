package com.wwr.echarts.repository;


import com.alibaba.fastjson.JSONObject;
import com.wwr.echarts.api.ChartDataApi;
import com.wwr.echarts.mapper.ChartMapper;
import com.wwr.echarts.mapper.ChartOptionMapper;
import com.wwr.echarts.service.GetChartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private GetChartService getChartService;

    @Autowired
    private ChartDataApi chartDataApi;

    @Autowired
    private ChartOptionMapper chartOptionMapper;

    @Autowired
    private ChartMapper chartMapper;



    @Test
    public void test(){
        System.out.println("==============");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("s","fd");
        int []s ={1,2,3};
        jsonObject.put("f",s);

        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void testChartoption(){
//        System.out.println(chartOptionMapper.getOne("pie").toString());
//        ChartOption chartOption = new ChartOption(1,"4545","1");
//        chartOptionMapper.delete(6);
//        StringBuffer s = new StringBuffer("123456789");
//        System.out.println(s.indexOf("56"));
//        s.insert(4,"123");
//        System.out.println(s);



//        chartMapper.insert(new Chart(1,"test","test","test","test","test","test"));
//        chartMapper.update(new Chart(1,"test3","test2","test","test","test","test"));
//        chartMapper.delete(1);
//        System.out.println(chartMapper.getOne(1));

//        String s = getChartService.queryCharts("test3");
//        System.out.println(s);
//
//        System.out.println(chartMapper.getOne(1).getSql_str());
//        System.out.println(getChartService.saveChart("test4","test4","test","test","test","test"));

    }

    @Test
    public void chartDataApi(){
        String [][] source = chartDataApi.getAllChartData("select x,y from chart_data where x=1");
        String s="";
        for (int i=0;i<source.length;i++){
            for (int j=0;j<source[i].length;j++){
                s+=source[i][j]+",";
            }
            s+="\n";
        }
        System.out.println(s);
    }

}
