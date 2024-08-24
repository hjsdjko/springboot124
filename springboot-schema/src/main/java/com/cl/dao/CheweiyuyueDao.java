package com.cl.dao;

import com.cl.entity.CheweiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweiyuyueView;


/**
 * 车位预约
 * 
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface CheweiyuyueDao extends BaseMapper<CheweiyuyueEntity> {
	
	List<CheweiyuyueView> selectListView(@Param("ew") Wrapper<CheweiyuyueEntity> wrapper);

	List<CheweiyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<CheweiyuyueEntity> wrapper);
	
	CheweiyuyueView selectView(@Param("ew") Wrapper<CheweiyuyueEntity> wrapper);
	

}
