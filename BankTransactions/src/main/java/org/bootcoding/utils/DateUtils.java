package org.bootcoding.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class DateUtils {

    public static Date convertToDate(String datestr) throws Exception{
        if (StringUtils.isEmpty(datestr) || StringUtils.containsIgnoreCase(datestr,"nan")){
            throw new Exception();
        }
        return null;
    }

}
