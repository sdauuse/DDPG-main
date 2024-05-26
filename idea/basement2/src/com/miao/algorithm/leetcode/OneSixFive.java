package com.miao.algorithm.leetcode;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-24
 * @Copyright：
 */
public class OneSixFive {
    public static void main(String[] args) {
        String version1 =
                "0.1";
        String version2 =
                "1.1";
        compareVersion(version1, version2);
    }

    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

//        if (split1.length != split2.length) {
//            return 0;
//        }



        for (int i = 0; i < split1.length || i < split2.length; i++) {
            int l = 0;
            int r = 0;
            if(i<split1.length){
                l = Integer.parseInt(split1[i]);
            }
            if (i<split2.length){
                r = Integer.parseInt(split2[i]);
            }
            if (l > r) {
                return 1;
            } else if (l < r) {
                return -1;
            }
        }
        return 0;
    }
}
