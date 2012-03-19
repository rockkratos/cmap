package com.fc.cmapweb.utils;

public class CmapValues {
	
	public static final int REST_FAR_AWAY_HALF_KM = 1;
	public static final int REST_FAR_AWAY_1KM = 2;
	public static final int REST_FAR_AWAY_2KM = 3;
	
	public static final int REST_LOGO_ALL = 3;
	public static final int REST_LOGO_BIG = 2;
	public static final int REST_LOGO_SMALL = 1;
	
	public static final boolean PRIVILEGE_CHECK = Boolean.valueOf(PropUtil.getPolicy("privilege.check"));
	
	public static final String PREFIX_QUERY = "query";
	public static final String PREFIX_DETAIL = "detail";
	
	public static final String PAGE_INDEX = "pageIndex";
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int SEARCH_REST_PAGE_SIZE = 9;
	
	public static final String HINT_SUCCESS = "success";
	public static final String HINT_MSG = "msg";
	public static final String HINT_WARNING = "warning";
	public static final String HINT_ERROR = "error";
	
	public static final int USR_TYPE_ADMIN = 1;
	public static final int USR_TYPE_CUSTOMER = 2;
	public static final int USR_TYPE_REST = 3;
	public static final int USR_TYPE_SERVICE = 4;
	public static final int USR_TYPE_MARKET = 5;
	public static final int USR_TYPE_BUSINESS = 6;
	
	public static final int HTTP_METHOD_TYPE_GET = 1;
	public static final int HTTP_METHOD_TYPE_POST = 2;
	public static final int HTTP_METHOD_TYPE_PUT = 3;
	public static final int HTTP_METHOD_TYPE_DELETE = 4;
	
	public static final int ORDER_TRANS_TYPE_PHONE = 1;
	public static final int ORDER_TRANS_TYPE_SMS = 2;
	public static final int ORDER_TRANS_TYPE_EMAIL = 3;
	public static final int ORDER_TRANS_TYPE_CLIENT = 4;
	public static final int ORDER_TRANS_TYPE_PRINTER = 5;
	
	public static final int COOKING_TYPE_ZC = 1;
	public static final int COOKING_TYPE_XC = 2;
	public static final int COOKING_TYPE_KC = 3;
	public static final int COOKING_TYPE_RSLL = 4;
	public static final int COOKING_TYPE_HSLL = 5;
	public static final int COOKING_TYPE_QZ = 6;
	public static final int COOKING_TYPE_LSYL = 7;
	public static final int COOKING_TYPE_RDM = 8;
	
}
