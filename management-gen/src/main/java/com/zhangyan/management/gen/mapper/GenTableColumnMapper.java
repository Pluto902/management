package com.zhangyan.management.gen.mapper;


import com.zhangyan.management.gen.entity.SysGenTableColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务字段 数据层
 * 
 * @author ZhangYan
 */
@Mapper
public interface GenTableColumnMapper
{
    /**
     * 根据表名称查询列信息
     * 
     * @param tableName 表名称
     * @return 列信息
     */
    public List<SysGenTableColumn> selectDbTableColumnsByName(String tableName);

    /**
     * 查询业务字段列表
     * 
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    public List<SysGenTableColumn> selectGenTableColumnListByTableId(Long tableId);

    /**
     * 新增业务字段
     * 
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    public int insertGenTableColumn(SysGenTableColumn genTableColumn);

    /**
     * 修改业务字段
     * 
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    public int updateGenTableColumn(SysGenTableColumn genTableColumn);

    /**
     * 删除业务字段
     * 
     * @param genTableColumns 列数据
     * @return 结果
     */
    public int deleteGenTableColumns(List<SysGenTableColumn> genTableColumns);

    /**
     * 批量删除业务字段
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGenTableColumnByIds(Long[] ids);
}
