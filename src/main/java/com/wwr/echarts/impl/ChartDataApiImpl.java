package com.wwr.echarts.impl;

import com.wwr.echarts.api.ChartDataApi;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Component
public class ChartDataApiImpl implements ChartDataApi {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String[][] getAllChartData(String sql) {
        return executeSql(sql);
    }

    public String[][] executeSql(String sql){
        Query query = em.createNativeQuery(sql);
        List list = query.getResultList();
        try{
            //获取到二维数据时
            Object[] cells = (Object[])list.get(0);
            String [][] source = new String[cells.length][list.size()];
            for (int i=0;i<list.size();i++){
                cells = (Object[])list.get(i);
                for (int j=0;j<cells.length;j++){
                    source[j][i] = cells[j].toString();
                }
            }
            return source;
        }catch (ClassCastException e){
            //获取到一维数组时
            String[][] source = new String[1][list.size()];
            for (int i = 0; i < list.size(); i++) {
                Object cell = list.get(i);
                source[0][i] = cell.toString();
            }
            return source;
        } catch(Exception ex){
            System.out.println("------------------");
            System.out.println(ex.toString());
            return null;
        }
    }

}
