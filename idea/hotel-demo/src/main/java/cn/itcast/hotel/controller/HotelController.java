package cn.itcast.hotel.controller;

import cn.itcast.hotel.pojo.PageResult;
import cn.itcast.hotel.pojo.RequestParams;
import cn.itcast.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private IHotelService hotelService;


    @PostMapping("/list")
    public PageResult search(@RequestBody RequestParams params) throws IOException {

        return hotelService.search(params);
    }

    @PostMapping("/filters")
    public Map<String, List<String>> filters(@RequestBody RequestParams params) throws IOException {

        return hotelService.filters(params);
    }

    /***
     * 自动补全
     *  1)前端传入的参数
     *  2)实现自动补全
     *      2.1)添加一个自动补全功能，并给它命名
     *      2.2)指定自动补全查询的字段
     *      2.3)指定查询的关键词
     *      2.4)跳过重复
     *      2.5)指定查询长度
     */
    @GetMapping(value = "/suggestion")
    public List<String> suggestion(String key) throws IOException {
        return hotelService.suggestion(key);
    }


}
