package org.SpiderSystem.SpiderFramework.core.downloader.PreDefine;

import org.SpiderSystem.SpiderFramework.core.downloader.Downloader;
import org.SpiderSystem.SpiderFramework.model.Page;
import org.SpiderSystem.SpiderFramework.model.UrlSeed;
import org.SpiderSystem.SpiderFramework.utils.HttpUtils;

/**
 * Created by shilei on 2017/4/10.
 */
public class HttpClientPoolDownloader implements Downloader {

    public Page download(UrlSeed urlSeed) {
        String html = HttpUtils.getInstance().get(urlSeed.getUrl());
        Page page = new Page(urlSeed, html);
        return page;
    }
}
