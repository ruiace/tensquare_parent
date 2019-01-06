package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rp on 2018/12/29.
 * 标签controller层
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * /label 增加标签
     */
    @PostMapping
    public Result addLabel(@RequestBody Label label){
        labelService.add(label);
        return Result.ok("添加成功");
    }

    /**
     * /label 标签全部列表
     */
    @GetMapping
    public Result getLabelList(){
        return Result.ok("查询成功",labelService.findAll());
    }

    /**
     * /label/toplist 推荐标签列表
     */
    @GetMapping("/toplist")
    public Result toplist(){
        return Result.ok("查询成功",labelService.toplist());
    }

    /**
     * /label/list 有效标签列表
     */
    @GetMapping("/list")
    public Result list(){
        return Result.ok("查询成功", labelService.list());
    }


    /**
     * /label/{labelId} 根据ID查询
     */
    @GetMapping("/{labelId}")
    public Result getLabel(@PathVariable("labelId") String labelId){
        return Result.ok("查询成功",labelService.findById(labelId));
    }

    /**
     * /label/{labelId}修改标签
     */
    @PutMapping("/{labelId}")
    public Result updateLabel(@PathVariable("labelId") String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return Result.ok("修改成功");
    }


    /**
     * /label/{labelId}根据ID删除label/{labelId}修改标签
     */
    @DeleteMapping("/{labelId}")
    public Result delete(@PathVariable("labelId") String labelId){
        labelService.deleteLabel(labelId);
        return Result.ok("删除成功!");
    }

    /**
     * /label/search/{page}/{size}标签分页
     */
    @PostMapping("/search/{page}/{size}")
    public Result searchLabel(@RequestBody Label label,@PathVariable("page") int page,@PathVariable("size") int size){
        Page<Label> search = labelService.findSearch(label, page, size);
        return Result.ok("查询成功",new PageResult<Label>(search.getTotalElements(),search.getContent()));
    }

    /**
     * /label/search 标签分页
     */
    @PostMapping("/search")
    public Result searchLabel(@RequestBody Label label){
        return Result.ok("查询成功！",labelService.findSearch(label));
    }

}
