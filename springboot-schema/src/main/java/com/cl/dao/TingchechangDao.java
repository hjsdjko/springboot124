package com.cl.dao;

import com.cl.entity.TingchechangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TingchechangView;


/**
 * 停车场
 * 
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface TingchechangDao extends BaseMapper<TingchechangEntity> {
	
	List<TingchechangView> selectListView(@Param("ew") Wrapper<TingchechangEntity> wrapper);

	List<TingchechangView> selectListView(Pagination page,@Param("ew") Wrapper<TingchechangEntity> wrapper);
	
	TingchechangView selectView(@Param("ew") Wrapper<TingchechangEntity> wrapper);
	

}
