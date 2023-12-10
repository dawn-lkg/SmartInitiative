package com.example.project.common.core.utils;

/**
 * @author chenliming
 * @date 2023/12/7 20:32
 */
public class GeoUtils {

    /**
     * 地球班级 单位千米
     */
    private static final double EARTH_RADIUS = 6371;

    /**
     * 计算两个经纬度之间的距离
     *
     * @param lat1 第一个点的纬度
     * @param lon1 第一个点的经度
     * @param lat2 第二个点的纬度
     * @param lon2 第二个点的经度
     * @return 两点之间的距离，单位千米
     */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将经纬度转换为弧度
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // 计算经纬度差值
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;

        // 使用Haversine公式计算距离
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // 距离乘以地球半径，得到最终结果
        return EARTH_RADIUS * c;
    }
}

