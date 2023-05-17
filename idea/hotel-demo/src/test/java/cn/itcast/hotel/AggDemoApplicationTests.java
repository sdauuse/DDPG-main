package cn.itcast.hotel;

import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.impl.HotelService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class AggDemoApplicationTests {

    @Autowired
    public RestHighLevelClient restHighLevelClient;

    @Autowired
    private HotelService hotelService;

    @Test
    void contextLoads() {
    }

    //    GET /hotel/_search
//    {
//        "size": 0,
//            "aggs": {
//        "brandAgg": {
//            "terms": {
//                "field": "business",
//                        "size": 20
//                        , "order": {
//                    "_count": "asc"
//                }
//            }
//        }
//    }
//    }
    @Test
    void testAgg() throws IOException {
        SearchRequest request = new SearchRequest("hotel");
        request.source().size(0);

        request.source().aggregation(AggregationBuilders.terms("brandAgg").size(20).field("business").order(BucketOrder.count(true)));

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        //解析聚合结果
        Aggregations aggregations = response.getAggregations();
        //根据名称获取聚合结果
        Terms brandTerms = aggregations.get("brandAgg");

        List<? extends Terms.Bucket> buckets = brandTerms.getBuckets();

        for (Terms.Bucket bucket : buckets) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println(keyAsString);
        }
    }
}
