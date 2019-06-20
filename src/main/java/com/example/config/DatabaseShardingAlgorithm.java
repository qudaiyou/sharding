package com.example.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author: qudy
 * @date: 2019/5/10
 **/
public class DatabaseShardingAlgorithm implements PreciseShardingAlgorithm {

    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        for( Object obj : availableTargetNames){
            if(obj.toString().contains("user")){
                if(shardingValue.getColumnName().equalsIgnoreCase("user_id")){
                    Comparable value = shardingValue.getValue();
                    int i = value.compareTo(50);
                    int suffix;
                    if (i <= 0){
                        suffix = 0;
                    }else{
                        suffix = 1;
                    }
                    String s = ("user" + suffix);
                    return s;
                }
            }
        }
        return null;
    }

}
