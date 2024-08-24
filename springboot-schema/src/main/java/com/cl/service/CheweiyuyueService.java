package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheweiyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweiyuyueView;


/**
 * 车位预约
 *
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface CheweiyuyueService extends IService<CheweiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheweiyuyueView> selectListView(Wrapper<CheweiyuyueEntity> wrapper);
   	
   	CheweiyuyueView selectView(@Param("ew") Wrapper<CheweiyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheweiyuyueEntity> wrapper);
   	

}

