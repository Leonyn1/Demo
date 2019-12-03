package com.example.demo.util;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑分页工具
 * @author Leon
 */
public class PageUtil {

    /**
     * 手动分页类
     * @param datas 需要分页的list
     * @param pageSize 每页的数量
     * @param pageNo 当前页码
     * @param <T> 泛型类
     * @return {@link List<T>}
     */
    public static <T> List<T> getPage(List<T> datas, int pageSize, int pageNo){
        //如果没有数据，直接返回空
        if(CollUtil.isEmpty(datas)){
            return new ArrayList<>();
        }
        //起始截取数据位置
        int startNum = (pageNo-1)* pageSize+1 ;
        if(startNum > datas.size()){
            return null;
        }
        List<T> res = new ArrayList<>();
        int rum = datas.size() - startNum;
        if(rum < 0){
            return null;
        }
        //说明正好是最后一个了
        if(rum == 0){
            int index = datas.size() -1;
            res.add(datas.get(index));
            return res;
        }
        //剩下的数据还够1页，返回整页的数据
        if(rum / pageSize >= 1){
            //截取从startNum开始的数据
            for(int i=startNum;i<startNum + pageSize;i++){
                res.add(datas.get(i-1));
            }
            return res;
        }else if(rum / pageSize == 0){
            //不够一页，直接返回剩下数据
            for(int j = startNum ;j<=datas.size();j++){
                res.add(datas.get(j-1));
            }
            return res;
        }else{
            return null;
        }
    }
}
