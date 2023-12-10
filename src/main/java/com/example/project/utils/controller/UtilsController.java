package com.example.project.utils.controller;

import com.example.project.common.core.utils.GeoUtils;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.utils.entity.Coordinate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author chenliming
 * @date 2023/12/7 20:39
 */

@RestController
@RequestMapping("/utils")
public class UtilsController extends BaseController {

    @RequestMapping("/coordinate-distance")
    public Result<?> calculateDistance(Coordinate coordinate){
        double v = GeoUtils.calculateDistance(coordinate.getLatitude1(), coordinate.getLongitude1(), coordinate.getLatitude2(), coordinate.getLongitude2());
        return success(v);
    }
}
