package com.miao.component;

import com.miao.dao.JobInfoDao;
import com.miao.entity.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 实现数据持久化
 */
@Component
public class JobPipeline implements Pipeline {
    @Autowired
    private JobInfoDao jobInfoDao;

    @Override
    @Transactional
    public void process(ResultItems resultItems, Task task) {

        JobInfo jobInfo = resultItems.get("jobInfo");

        jobInfoDao.save(jobInfo);
    }
}
