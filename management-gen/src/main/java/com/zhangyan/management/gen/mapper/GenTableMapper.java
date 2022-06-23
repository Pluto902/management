package com.zhangyan.management.gen.mapper;


import com.zhangyan.management.gen.entity.SysGenTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务 数据层
 * 
 * @author ZhangYan
 */
@Mapper
public interface GenTableMapper
{
    /**
     * 查询业务列表
     * 
     * @param genTable 业务信息
     * @return 业务集合
     */
    public List<SysGenTable> selectGenTableList(SysGenTable genTable);

    /**
     * 查询据库列表
     * 
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    public List<SysGenTable> selectDbTableList(SysGenTable genTable);

    /**
     * 查询据库列表
     * 
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    public List<SysGenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 查询所有表信息
     * 
     * @return 表信息集合
     */
    public List<SysGenTable> selectGenTableAll();

    /**
     * 查询表ID业务信息
     * 
     * @param id 业务ID
     * @return 业务信息
     */
    public SysGenTable selectGenTableById(Long id);

    /**
     * 查询表名称业务信息
     * 
     * @param tableName 表名称
     * @return 业务信息
     */
    public SysGenTable selectGenTableByName(String tableName);

    /**
     * 新增业务
     * 
     * @param genTable 业务信息
     * @return 结果
     */
    public int insertGenTable(SysGenTable genTable);

    /**
     * 修改业务
     * 
     * @param genTable 业务信息
     * @return 结果
     */
    public int updateGenTable(SysGenTable genTable);

    /**
     * 批量删除业务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGenTableByIds(Long[] ids);
}
