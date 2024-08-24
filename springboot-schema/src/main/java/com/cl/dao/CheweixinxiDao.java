package com.cl.dao;

import com.cl.entity.CheweixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweixinxiView;


/**
 * 车位信息
 * 
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface CheweixinxiDao extends BaseMapper<CheweixinxiEntity> {
	
	List<CheweixinxiView> selectListView(@Param("ew") Wrapper<CheweixinxiEntity> wrapper);

	List<CheweixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CheweixinxiEntity> wrapper);
	
	CheweixinxiView selectView(@Param("ew") Wrapper<CheweixinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheweixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheweixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheweixinxiEntity> wrapper);



}
