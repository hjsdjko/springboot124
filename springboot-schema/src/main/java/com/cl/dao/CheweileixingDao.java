package com.cl.dao;

import com.cl.entity.CheweileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweileixingView;


/**
 * 车位类型
 * 
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface CheweileixingDao extends BaseMapper<CheweileixingEntity> {
	
	List<CheweileixingView> selectListView(@Param("ew") Wrapper<CheweileixingEntity> wrapper);

	List<CheweileixingView> selectListView(Pagination page,@Param("ew") Wrapper<CheweileixingEntity> wrapper);
	
	CheweileixingView selectView(@Param("ew") Wrapper<CheweileixingEntity> wrapper);
	

}
