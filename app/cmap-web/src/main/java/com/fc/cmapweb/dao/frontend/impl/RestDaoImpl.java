package com.fc.cmapweb.dao.frontend.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.frontend.IRestDao;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

@Repository("usrRestDao")
public class RestDaoImpl extends CmapBaseDao implements IRestDao {

	@Override
	public int getRestCount(RestSearchFormVo restSearchFormVo) {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("SELECT COUNT(*) ");
		buffer.append("FROM rest_info ");
		buffer.append("WHERE enabled = true ");
		buffer.append("AND (NOW() BETWEEN rest_start_time AND rest_end_time) ");
		buffer.append("AND city_id = ? ");
		buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= take_away_radius * 1000 ");
		
		switch (restSearchFormVo.getRestFarAway()) {
		case CmapValues.REST_FAR_AWAY_HALF_KM: 
			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= 500 ");
			break;
		case CmapValues.REST_FAR_AWAY_1KM: 
			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= 1000 ");
			break;
		case CmapValues.REST_FAR_AWAY_2KM:
			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= 2000 ");
			break;
		}
		
		if (restSearchFormVo.getCookingTypeId() != 0) {
			buffer.append("AND cooking_type_id = " + restSearchFormVo.getCookingTypeId());
		}
		
		Query rowCountQuery = em.createNativeQuery(buffer.toString());
		rowCountQuery.setParameter(1, restSearchFormVo.getCityId());
		
		return ((BigInteger) rowCountQuery.getSingleResult()).intValue();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RestInfoVo> getRest(RestSearchFormVo restSearchFormVo) {
		
		List<RestInfoVo> back = new ArrayList<RestInfoVo>();
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("SELECT rest_id, ");
		buffer.append("rest_name, ");
		buffer.append("SUBSTRING(rest_open_time FROM '^..') || ':' || SUBSTRING(rest_open_time FROM '..$'), ");
		buffer.append("SUBSTRING(rest_close_time FROM '^..') || ':' || SUBSTRING(rest_close_time FROM '..$'), ");
		buffer.append("sending_amount, ");
		buffer.append("take_away_fee, ");
		buffer.append("take_away_desc, ");
		buffer.append("take_away_radius, ");
		buffer.append("CASE ");
		buffer.append("WHEN ? BETWEEN rest_open_time AND rest_close_time THEN 1 ");
		buffer.append("ELSE 0 ");
		buffer.append("END AS rest_status, ");
		buffer.append("big_logo_name, ");
		buffer.append("small_logo_name ");
		buffer.append("FROM rest_info ");
		buffer.append("WHERE enabled = true ");
		buffer.append("AND (NOW() BETWEEN rest_start_time AND rest_end_time) ");
		buffer.append("AND city_id = ? ");
		buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= take_away_radius * 1000 ");
		
		if (restSearchFormVo.getCookingTypeId() != 0) {
			buffer.append("AND cooking_type_id = " + restSearchFormVo.getCookingTypeId());
		}
		
		Query q = em.createNativeQuery(buffer.toString());
		q.setParameter(1, restSearchFormVo.getNowTime());
		q.setParameter(2, restSearchFormVo.getCityId());
		
		List<Object[]> list = q.getResultList();
		
		for (Object[] tmp : list) {
			
			RestInfoVo tmpRest = new RestInfoVo();
			tmpRest.setRestId(String.valueOf(tmp[0]));
			tmpRest.setRestName(String.valueOf(tmp[1]));
			tmpRest.setRestOpenTime(String.valueOf(tmp[2]));
			tmpRest.setRestCloseTime(String.valueOf(tmp[3]));
			tmpRest.setSendingAmount(Float.valueOf(String.valueOf(tmp[4])));
			tmpRest.setTakeAwayFee(Float.valueOf(String.valueOf(tmp[5])));
			tmpRest.setTakeAwayDesc(null == tmp[6] ? null : String.valueOf(tmp[6]));
			tmpRest.setTakeAwayRadius(Float.valueOf(String.valueOf(tmp[7])));
			tmpRest.setRestStatus(Integer.valueOf(String.valueOf(tmp[8])));
			tmpRest.setBigLogoName(null == tmp[9] ? null : String.valueOf(tmp[9]));
			tmpRest.setSmallLogoName(null == tmp[10] ? null : String.valueOf(tmp[10]));
			
			back.add(tmpRest);
			
		}
		
		return back;
		
	}

}
