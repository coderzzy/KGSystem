package org.SpiderSystem.SpiderFramework.core.scheduler;

import org.SpiderSystem.SpiderFramework.model.UrlSeed;

/**
 * 调度器
 * 我们可以自定义调度器。
 * 需要自己实现去重功能！
 * Created by shilei on 2017/4/10.
 */
public interface Scheduler {

    /**
     * 写进去url种子
     *
     * @param urlSeed urlseed
     */
    void push(UrlSeed urlSeed);

    /**
     * poll种子
     *
     * @return UrlSeed
     */
    UrlSeed poll();
}
