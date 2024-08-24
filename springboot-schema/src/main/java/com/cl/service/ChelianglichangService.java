package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChelianglichangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChelianglichangView;


/**
 * 车辆离场
 *
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
public interface ChelianglichangService extends IService<ChelianglichangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChelianglichangView> selectListView(Wrapper<ChelianglichangEntity> wrapper);
   	
   	ChelianglichangView selectView(@Param("ew") Wrapper<ChelianglichangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChelianglichangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChelianglichangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChelianglichangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChelianglichangEntity> wrapper);



}

