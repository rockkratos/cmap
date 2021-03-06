package com.fc.cmapweb.dao.frontend.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.frontend.IRestSearchDao;
import com.fc.cmapweb.vo.DishInfoVo;
import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

@Repository("restSearchDao")
public class RestSearchDaoImpl extends CmapBaseDao implements IRestSearchDao {
	
	@Override
	public List<DishInfoVo> getAllDishByRestId(String restId) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT di FROM DishInfoVo di ");
		jpql.append("WHERE di.dishEnabled = true AND di.dishSortVo.dishSortEnabled = true ");
		jpql.append("AND di.dishSortVo.restInfoVo.restId = ? ORDER BY di.dishSortVo.dishSortOrder");
		
		TypedQuery<DishInfoVo> tq = em.createQuery(jpql.toString(), DishInfoVo.class);
		tq.setParameter(1, restId);
		
		return tq.getResultList();
		
	}
	
	@Override
	public int getRestCount(RestSearchFormVo restSearchFormVo) {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("SELECT COUNT(*) ");
		buffer.append("FROM rest_info ");
		buffer.append("WHERE enabled = true ");
		buffer.append("AND (NOW() BETWEEN rest_start_time AND rest_end_time) ");
		buffer.append("AND city_id = ? ");
		buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= take_away_radius * 1000 ");
		
		if (restSearchFormVo.getRestFarAway() != 0) {
			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= " + restSearchFormVo.getRestFarAway() + " ");
		}
		
//		switch (restSearchFormVo.getRestFarAway()) {
//		case CmapValues.REST_FAR_AWAY_HALF_KM: 
//			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= 500 ");
//			break;
//		case CmapValues.REST_FAR_AWAY_1KM: 
//			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= 1000 ");
//			break;
//		case CmapValues.REST_FAR_AWAY_2KM: 
//			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= 2000 ");
//			break;
//		}
		
		if (restSearchFormVo.getCookingTypeId() != 0) {
			buffer.append("AND cooking_type_id = " + restSearchFormVo.getCookingTypeId());
		}
		
		Query rowCountQuery = em.createNativeQuery(buffer.toString());
		rowCountQuery.setParameter(1, restSearchFormVo.getCityId());
		
		return ((BigInteger) rowCountQuery.getSingleResult()).intValue();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RestInfoVo> getRest(RestSearchFormVo restSearchFormVo, int currentPage, int pageSize) {
		
		List<RestInfoVo> back = new ArrayList<RestInfoVo>();
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("SELECT rest_id, ");
		buffer.append("rest_name, ");
		buffer.append("SUBSTRING(rest_open_time FROM '^..') || ':' || SUBSTRING(rest_open_time FROM '..$') AS open_time, ");
		buffer.append("SUBSTRING(rest_close_time FROM '^..') || ':' || SUBSTRING(rest_close_time FROM '..$') AS close_time, ");
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
		
		if (restSearchFormVo.getRestFarAway() != 0) {
			buffer.append("AND GETDISTANCE(rest_lng, rest_lat, " + restSearchFormVo.getCustomerLng() + ", " + restSearchFormVo.getCustomerLat() + ") <= " + restSearchFormVo.getRestFarAway() + " ");
		}
		
		if (restSearchFormVo.getCookingTypeId() != 0) {
			buffer.append("AND cooking_type_id = " + restSearchFormVo.getCookingTypeId());
		}
		
		buffer.append("ORDER BY rest_signed DESC, rest_name ASC");
		
		Query q = em.createNativeQuery(buffer.toString());
		q.setParameter(1, restSearchFormVo.getNowTime());
		q.setParameter(2, restSearchFormVo.getCityId());
		
		List<Object[]> list = q.setFirstResult(currentPage * pageSize).setMaxResults(pageSize).getResultList();
		
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
