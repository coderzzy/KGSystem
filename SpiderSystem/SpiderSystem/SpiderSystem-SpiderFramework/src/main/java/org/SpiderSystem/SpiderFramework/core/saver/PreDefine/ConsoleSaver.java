package org.SpiderSystem.SpiderFramework.core.saver.PreDefine;

import org.SpiderSystem.SpiderFramework.core.saver.Saver;
import org.SpiderSystem.SpiderFramework.model.Page;

import java.util.Map;

/**
 * Created by shilei on 2017/4/11.
 */
public class ConsoleSaver implements Saver {
    public void save(Page page) {
        Map<Object, Object> map = page.getItems();

        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

}
