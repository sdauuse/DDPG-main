package cn.itcast.hotel;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.impl.HotelService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class QueryDemoApplicationTests {

    @Autowired
    public RestHighLevelClient restHighLevelClient;

    @Autowired
    private HotelService hotelService;

    @Test
    void contextLoads() {
    }

    @Test
    void testMatchAll() throws IOException {
//        - 第一步，创建`SearchRequest`对象，指定索引库名
//        - 第二步，利用`request.source()`构建DSL，DSL中可以包含查询、分页、排序、高亮等
//        - `query()`：代表查询条件，利用`QueryBuilders.matchAllQuery()`构建一个match_all查询的DSL
//        - 第三步，利用client.search()发送请求，得到响应

        SearchRequest request = new SearchRequest("hotel");

        //match_all
        //request.source().query(QueryBuilders.matchAllQuery());

        //match
        //request.source().query(QueryBuilders.matchQuery("brand","如家"));

        //multi_match
        //request.source().query(QueryBuilders.multiMatchQuery("外滩如家","name","brand"));

        //term
        //request.source().query(QueryBuilders.termQuery("city","上海"));

        //范围查询
        request.source().query(QueryBuilders.rangeQuery("price").gt(10).lte(500));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        handleResponse(response);

    }

    private void handleResponse(SearchResponse response) {
        // 4.解析响应
        SearchHits searchHits = response.getHits();
        // 4.1.获取总条数
        long total = searchHits.getTotalHits().value;
        System.out.println("共搜索到" + total + "条数据");
        // 4.2.文档数组
        SearchHit[] hits = searchHits.getHits();
        // 4.3.遍历
        for (SearchHit hit : hits) {
            // 获取文档source
            String json = hit.getSourceAsString();
            // 反序列化
            HotelDoc hotelDoc = JSON.parseObject(json, HotelDoc.class);
            System.out.println("hotelDoc = " + hotelDoc);
        }
    }

    @Test
    void testBool() throws IOException {

        // 1.准备Request
        SearchRequest request = new SearchRequest("hotel");
        // 2.准备DSL
        // 2.1.准备BooleanQuery
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        // 2.2.添加term
        boolQuery.must(QueryBuilders.termQuery("city", "上海"));
        // 2.3.添加range
        boolQuery.mustNot(QueryBuilders.rangeQuery("score").lte(35));

        boolQuery.filter(QueryBuilders.rangeQuery("price").gt(10).lt(150));
        request.source().query(boolQuery);
        // 3.发送请
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        // 4.解析响应
        handleResponse(response);

    }

    @Test
    void testSortPage() throws IOException {
        SearchRequest request = new SearchRequest("hotel");

        request.source().query(QueryBuilders.matchAllQuery());

        request.source().from(2).size(6);

        request.source().sort("price", SortOrder.ASC);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        handleResponse(response);
    }
}
