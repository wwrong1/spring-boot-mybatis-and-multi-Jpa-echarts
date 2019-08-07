package com.wwr.echarts.controller;

import com.wwr.echarts.service.GetChartService;
import com.wwr.echarts.util.HttpRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EchartsController {

    @Autowired
    @Qualifier("getChartService")
    private GetChartService getChartService;

    @ApiOperation(value="查看图表入口", notes="输入id以查看生成的图表")
    @RequestMapping(value="/getChart/{id}", method = RequestMethod.GET)
    public ModelAndView test(/**HttpServletRequest request**/@PathVariable("id")  int id){

        ModelAndView mav = new ModelAndView("test");
        mav.addObject("option",getChartService.getChartJson(id));
        return mav;
    }

    /**将url传到前台，利用ajax访问方法的写法
//    @RequestMapping(value="/testEcharts/{id}", method = RequestMethod.GET)
//    public ModelAndView test(HttpServletRequest request,Model model@PathVariable("id")  int id){
//
//     (1)ModelAndView mav = new ModelAndView("test");
//        mav.addObject("url","/getOption/"+id);
//        return mav;

//     (2)request.setAttribute("url","/getOption/45/bar");
//        model.addAttribute("url","/getOption/"+id);
//        return "test";
//    }

//    @RequestMapping(value="/getOption/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public JSONObject getOption(@PathVariable("id")  int id){
//        return getChartService.getChartJson(id);
//    }
**/

    @ApiOperation(value="保存chart数据", notes="输入所需数据，包括①org组织，②title图表的名字，" +
            "③type图表类型（pie,bar,bar2(横着显示的条形图),line,scatter）,④xAxis所定义的要展示的数据列名（即在二维图中的x轴，如某个银行某个产品）" +
            "数据，注意：程序需要列名之间有且只有一个/隔开！！），⑤bar_name每列要展示的bar的名字,饼状图填null（例如年份，性别等信息，也用/隔开），" +
            "⑥sql语句（根据xAxis查询），⑦remake图的备注信息")
    @RequestMapping(value = "/saveChart/{org}/{title}/{type}/{xAxis}/{bar_name}/{sql}/{remake}",method = RequestMethod.GET)
    @ResponseBody
    public int saveChart(@PathVariable("org")String org, @PathVariable("title")String title,
                         @PathVariable("type")String type, @PathVariable("xAxis")String xAxis,
                         @PathVariable("bar_name") String bar_name, @PathVariable("sql")String sql,
                         @PathVariable("remake") String remake){

        int id = getChartService.saveChart(org,sql,title,type,xAxis,bar_name,remake);
        return id;
    }

    @ApiOperation(value="查看chart表中的数据项", notes="输入组织代码，查看本组织所有的数据项，可以根据自己设置的备注，找到需要展示的图的id")
    @RequestMapping(value="/queryCharts/{org}", method= RequestMethod.GET )
    @ResponseBody
    public String queryCharts(@PathVariable("org") String org){
        String s = getChartService.queryCharts(org);

        return s;
    }


    @RequestMapping(value="/downloadCharts/{org}", method= RequestMethod.GET )
    @ResponseBody
    public String downloadCharts(@PathVariable("org") String org){

        String s =  HttpRequest.sendGet("http://localhost:8080/getChart",org);
        System.out.println(s);

        return s;

    }



}
