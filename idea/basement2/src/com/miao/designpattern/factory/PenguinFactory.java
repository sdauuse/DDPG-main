package com.miao.designpattern.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-18
 * @Copyright：
 */
public class PenguinFactory {
    private static final Map<String, Penguin> map = new HashMap<>();

    static {
        map.put("littlePenguin", new LittlePenguin());
        map.put("middlePenguin", new MiddlePenguin());
        map.put("bigPenguin", new BigPenguin());
    }

    public static Penguin getPenguin(String name) {
        return map.get(name);
    }
}
