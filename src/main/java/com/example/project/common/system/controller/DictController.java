package com.example.project.common.system.controller;




import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project.common.core.aop.OperationLog;
import com.example.project.common.core.web.BaseController;
import com.example.project.common.core.web.Result;
import com.example.project.common.system.entity.Dict;
import com.example.project.common.system.param.DictParam;
import com.example.project.common.system.service.DictService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (Dict)表控制层
 *
 * @author clm
 * @since 2023-11-15 22:00:43
 */
@RestController
@RequestMapping("dict")
public class DictController extends BaseController {
    @Resource
    private DictService dictService;

    @OperationLog(module = "字典",operator = "分页查询")
    @GetMapping("/page")
    public Result<?> page(DictParam dictParam){
        LambdaQueryWrapper<Dict> dictLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getId()),Dict::getId,dictParam.getId());
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getLabel()),Dict::getId,dictParam.getLabel());
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getValue()),Dict::getId,dictParam.getValue());
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getStatus()),Dict::getId,dictParam.getStatus());
        Page<Dict> page = dictService.page(new Page<>(dictParam.getPageNum(), dictParam.getPageSize()), dictLambdaQueryWrapper);
        return success(page);
    }

    @OperationLog(module = "字典",operator = "查询所有")
    @GetMapping("list")
    public Result<?> list(DictParam dictParam){
        LambdaQueryWrapper<Dict> dictLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getId()),Dict::getId,dictParam.getId());
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getLabel()),Dict::getId,dictParam.getLabel());
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getValue()),Dict::getId,dictParam.getValue());
        dictLambdaQueryWrapper.eq(Objects.isNull(dictParam.getStatus()),Dict::getId,dictParam.getStatus());
        List<Dict> list = dictService.list(dictLambdaQueryWrapper);
        return success(list);
    }

    @OperationLog(module = "字典",operator = "新增字典")
    @PostMapping
    public Result<?> save(@RequestBody Dict dict){
        if(!dictService.save(dict)){
            return fail("新增字典失败");
        }
        return success("新增成功");
    }

    @OperationLog(module = "字典",operator = "修改字典")
    @PutMapping
    public Result<?> update(@RequestBody Dict dict){
        if(!dictService.updateById( dict)){
            return fail("修改字典失败");
        }
        return success("修改成功");
    }

    @OperationLog(module = "字典",operator = "删除字典")
    @DeleteMapping("{id}")
    public Result<?> delete(@PathVariable String id){
        if(!dictService.removeById(id)){
            return fail("删除字典失败");
        }
        return success("删除成功");
    }
}

