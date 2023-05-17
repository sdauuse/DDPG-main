package cn.itcast.hotel.pojo;

import lombok.Data;

@Data
public class RequestParams {
    //关键词
    private String key;
    //当前页
    private Integer page;
    //每页显示条数
    private Integer size;
    //根据什么字段排序
    private String sortBy;
    //星级
    private String starName;
    //品牌
    private String brand;
    //城市
    private String city;
    //价格区间
    private Integer maxPrice;
    private Integer minPrice;

    //经纬度
    private String location;
}
