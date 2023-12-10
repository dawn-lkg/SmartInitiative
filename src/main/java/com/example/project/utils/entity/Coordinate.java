package com.example.project.utils.entity;

import lombok.Data;

/**
 * @author chenliming
 * @date 2023/12/7 22:08
 */

@Data
public class Coordinate {
    /**
     * 经度1
     */
    private Double longitude1;
    /**
     * 纬度1
     */
    private Double latitude1;
    /**
     * 经度2
     */
    private Double longitude2;
    /**
     * 纬度2
     */
    private Double latitude2;
}
