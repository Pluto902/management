package com.zhangyan.management.gen.controller;


import cn.hutool.core.convert.Convert;
import com.zhangyan.management.common.util.Result;
import com.zhangyan.management.gen.entity.SysGenTable;
import com.zhangyan.management.gen.entity.SysGenTableColumn;
import com.zhangyan.management.gen.service.IGenTableColumnService;
import com.zhangyan.management.gen.service.IGenTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成 操作处理
 * 
 * @author ZhangYan
 */
@RestController
@RequestMapping("/tool/gen")
@Api(value = "Gen", tags = "代码生成管理")
@Slf4j
public class GenController
{
    @Autowired
    private IGenTableService genTableService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

//    /**
//     * 查询代码生成列表
//     */
//    @GetMapping("/list")
//    public TableDataInfo genList(SysGenTable genTable)
//    {
//        startPage();
//        List<SysGenTable> list = genTableService.selectGenTableList(genTable);
//        return getDataTable(list);
//    }

    /**
     * 修改代码生成业务
     */
    @ApiOperation(value = "根据id获取代码生成业务", notes = "getInfo")
    @GetMapping(value = "/{tableId}")
    public Result getInfo(@PathVariable Long tableId)
    {
        SysGenTable table = genTableService.selectGenTableById(tableId);
        List<SysGenTable> tables = genTableService.selectGenTableAll();
        List<SysGenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("info", table);
        map.put("rows", list);
        map.put("tables", tables);
        return Result.createSuccessResult(map);
    }

//    /**
//     * 查询数据库列表
//     */
//    @GetMapping("/db/list")
//    public TableDataInfo dataList(SysGenTable genTable)
//    {
//        startPage();
//        List<SysGenTable> list = genTableService.selectDbTableList(genTable);
//        return getDataTable(list);
//    }

//    /**
//     * 查询数据表字段列表
//     */
//    @GetMapping(value = "/column/{tableId}")
//    public TableDataInfo columnList(Long tableId)
//    {
//        TableDataInfo dataInfo = new TableDataInfo();
//        List<SysGenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
//        dataInfo.setRows(list);
//        dataInfo.setTotal(list.size());
//        return dataInfo;
//    }

    /**
     * 导入表结构（保存）
     */
    @ApiOperation(value = "导入表结构（保存）", notes = "importTableSave")
    @PostMapping("/importTable")
    public Result importTableSave(String tables)
    {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<SysGenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        genTableService.importGenTable(tableList);
        return Result.createSuccessResult();
    }

    /**
     * 修改保存代码生成业务
     */
    @ApiOperation(value = "修改保存代码生成业务", notes = "editSave")
    @PutMapping
    public Result editSave(@Validated @RequestBody SysGenTable genTable)
    {
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
        return Result.createSuccessResult();
    }

    /**
     * 删除代码生成
     */
    @ApiOperation(value = "删除代码生成", notes = "remove")
    @DeleteMapping("/{tableIds}")
    public Result remove(@PathVariable Long[] tableIds)
    {
        genTableService.deleteGenTableByIds(tableIds);
        return Result.createSuccessResult();
    }

    /**
     * 预览代码
     */
    @ApiOperation(value = "预览代码", notes = "preview")
    @GetMapping("/preview/{tableId}")
    public Result preview(@PathVariable("tableId") Long tableId) throws IOException
    {
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return Result.createSuccessResult(dataMap);
    }

    /**
     * 生成代码（下载方式）
     */
    @ApiOperation(value = "生成代码（下载方式）", notes = "download")
    @GetMapping("/download/{tableName}")
    public void download(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException
    {
        byte[] data = genTableService.downloadCode(tableName);
        genCode(response, data);
    }

    /**
     * 生成代码（自定义路径）
     */
    @ApiOperation(value = "生成代码（自定义路径）", notes = "genCode")
    @GetMapping("/genCode/{tableName}")
    public Result genCode(@PathVariable("tableName") String tableName)
    {
        genTableService.generatorCode(tableName);
        return Result.createSuccessResult();
    }

    /**
     * 同步数据库
     */
    @ApiOperation(value = "同步数据库", notes = "synchDb")
    @GetMapping("/synchDb/{tableName}")
    public Result synchDb(@PathVariable("tableName") String tableName)
    {
        genTableService.synchDb(tableName);
        return Result.createSuccessResult();
    }

    /**
     * 批量生成代码
     */
    @ApiOperation(value = "批量生成代码", notes = "batchGenCode")
    @GetMapping("/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException
    {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.downloadCode(tableNames);
        genCode(response, data);
    }

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException
    {
        response.reset();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-Disposition", "attachment; filename=\"management.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}