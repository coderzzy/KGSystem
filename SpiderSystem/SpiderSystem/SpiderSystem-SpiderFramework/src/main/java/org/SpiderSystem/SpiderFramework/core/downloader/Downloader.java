package org.SpiderSystem.SpiderFramework.core.downloader;

import org.SpiderSystem.SpiderFramework.model.Page;
import org.SpiderSystem.SpiderFramework.model.UrlSeed;

/**
 * Created by shilei on 2017/4/10.
 * 下载器
 */
public interface Downloader {

    /**
     * @param urlSeed 下载url页面
     * @return Page page
     */
    Page download(UrlSeed urlSeed);
}
