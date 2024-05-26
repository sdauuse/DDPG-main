package com.miao.algorithm.xiaohongshu2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-12
 * @Copyright：
 */
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Set<String> userIds = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String userId = bf.readLine().trim();
            userIds.add(userId);
        }

        for (String userId : userIds) {
            System.out.println(userId);
        }
    }
}
