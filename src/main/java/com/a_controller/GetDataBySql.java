package com.a_controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collect")
public class GetDataBySql {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetDataBySql.class);

    @RequestMapping(value = "/mjxx", method = RequestMethod.POST)
    public JSONObject collectmjxx(@RequestParam(name = "accesskey", required = true) String accesskey,
                                  @RequestParam(name = "securitykey", required = true) String securitykey,
                                  @RequestParam(name = "apiname", required = true) String apiname,
                                  @RequestParam(name = "starttime", required = true) String starttime,
                                  @RequestParam(name = "endtime", required = true) String endtime,
                                  @RequestParam(name = "pageno", required = true) String pageno) {
        String APINAME = "MJXX";
        return getdata(APINAME, apiname, accesskey, securitykey, starttime, endtime, pageno);
    }

    @RequestMapping(value = "/jgxx", method = RequestMethod.POST)
    public JSONObject collectjgxx(@RequestParam(name = "accesskey", required = true) String accesskey,
                                  @RequestParam(name = "securitykey", required = true) String securitykey,
                                  @RequestParam(name = "apiname", required = true) String apiname,
                                  @RequestParam(name = "starttime", required = true) String starttime,
                                  @RequestParam(name = "endtime", required = true) String endtime,
                                  @RequestParam(name = "pageno", required = true) String pageno) {
        String APINAME = "JGXX";
        return getdata(APINAME, apiname, accesskey, securitykey, starttime, endtime, pageno);
    }


    private JSONObject getdata(String APINAME, String apiname, String accesskey, String securitykey, String starttime, String endtime, String pageno) {
        JSONArray ja = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0000");
        jsonObject.put("message", "获取成功");
        jsonObject.put("params", ja);
        //参数检测

        try {
//            ja = querysql(starttime, endtime, APINAME, pageno);
            jsonObject.put("message", "获取:" + ja.size() + "条");
            jsonObject.put("params", ja);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonObject.put("code", "2000");
            jsonObject.put("message", "MYSQL错误:" + e.getMessage());
        }
        return jsonObject;

    }


    public static void main(String[] args) {
        GetDataBySql a = new GetDataBySql();
        JSONObject b = a.collectmjxx("023299564B0DB47D5F3E476A254D0C21", "0A1753D11185129F63067CFBA3F2903A", "MJXX", "2019-10-16 15:00:00", "2030-10-16 17:00:00", "1");
        System.out.println(b);
    }
}
