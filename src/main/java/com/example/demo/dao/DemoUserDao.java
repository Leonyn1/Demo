package com.example.demo.dao;

import com.example.demo.dao.dto.DemoUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Leon
 */
@Mapper
public interface DemoUserDao {

    /**
     * 根据主键删除记录
     * @param id {@link Integer}主键ID
     * @return 删除结果 大于0即成功
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键全部插入
     * @param record {@link DemoUser}
     * @return 插入结果 大于0即成功
     */
    int insert(DemoUser record);

    /**
     * 根据主键选择插入
     * @param record {@link DemoUser}
     * @return 插入结果 大于0即成功
     */
    int insertSelective(DemoUser record);

    /**
     * 根据主键ID查询数据
     * @param id 主键
     * @return {@link DemoUser}
     */
    DemoUser selectByPrimaryKey(Integer id);

    /**
     * 查询全部数据
     * @return {@link List<DemoUser>}
     */
    List<DemoUser> selectAll();

    /**
     * 根据主键选择更新
     * @param record {@link DemoUser}
     * @return 更新结果 大于0即成功
     */
    int updateByPrimaryKeySelective(DemoUser record);

    /**
     * 根据主键全部更新
     * @param record {@link DemoUser}
     * @return 更新结果 大于0即成功
     */
    int updateByPrimaryKey(DemoUser record);
}