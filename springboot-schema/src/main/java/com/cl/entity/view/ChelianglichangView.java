package com.cl.entity.view;

import com.cl.entity.ChelianglichangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 车辆离场
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 19:03:50
 */
@TableName("chelianglichang")
public class ChelianglichangView  extends ChelianglichangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChelianglichangView(){
	}
 
 	public ChelianglichangView(ChelianglichangEntity chelianglichangEntity){
 	try {
			BeanUtils.copyProperties(this, chelianglichangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
