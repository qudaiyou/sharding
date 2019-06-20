package com.example.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author: qudy
 * @date: 2019/5/10
 **/
public class TableShardingAlgorithm implements PreciseShardingAlgorithm {


    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        for( Object obj : collection){
            if(obj.toString().contains("user_info")){
                if(preciseShardingValue.getColumnName().equalsIgnoreCase("user_id")){
                    Comparable value = preciseShardingValue.getValue();

                    int a = 25;
                    if ((int) value > 50) {
                        a = 75;
                    }

                    int i = value.compareTo(a);
                    int suffix;
                    if(i <= 0){
                        suffix = 0;
                    }else{
                        suffix = 1;
                    }
                    String s = ("user_info" + suffix);
                    return s;
                }
            }
        }
        return null;
    }

}
