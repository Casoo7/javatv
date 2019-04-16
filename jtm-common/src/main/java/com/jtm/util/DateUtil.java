/**
 * @Copyright ®2015 guobao Co. Ltd. All rights reserved.<br/>
 * 项目名称 : 电子商务云服务平台
 * 创建日期 : 2017年3月8日
 * 修改历史 : 
 *     1. [2017年3月8日]更新文件 by chihouliang
 */
package com.jtm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @version 1.0
 */
public class DateUtil extends DateUtils {
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM", "HH:mm:ss" };

	/** 默认日期格式 yyyy-MM-dd */
	public static String FORMAT_DATE_DEFAULT = "yyyy-MM-dd";
	/** 日期格式 yyyyMMddhhmmss */
	public static String FORMAT_DATE_DATE_TIME = "yyyyMMddhhmmss";
	/** 日期格式 yyyy-MM-dd HH:mm:ss */
	public static String FORMAT_HOUR_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	/** 日期格式 yyyy-MM-dd HH:mm:ss:SSS */
	public static String FORMAT_HOUR_DATE_TIME1 = "yyyy-MM-dd HH:mm:ss:SSS";
	/** 日期格式 yyyyMMddHHmmssSSS */
	public static String FORMAT_HOUR_DATE_TIME2 = "yyyyMMddHHmmssSSS";
	/** 日期格式 yyyyMMdd */
	public static String FORMAT_DATE_DATE = "yyyyMMdd";
	/** 日期格式 yyyy */
	public static String FORMAT_DATE_DATE1 = "yyyy";
	/** 时间格式 HH:mm:ss */
	public static String FORMAT_DATE_TIME = "HH:mm:ss";
	/** 时间格式 HHmmss */
	public static String FORMAT_DATE_TIME1 = "HHmmss";
	/** 时间格式 mm:ss */
	public static String FORMAT_DATE_TIME2 = "mmss";
	/** 当前月格式 yyyy-MM */
	public static String FORMAT_CURRENT_MONTH = "yyyy-MM";
	/** 精度到年，例如在时间比较 */
	public static final int ACCURACY_YEAR = 6;
	/** 精度到月 */
	public static final int ACCURACY_MONTH = 5;
	/** 精度到天 */
	public static final int ACCURACY_DAY = 4;
	/** 精度到时 */
	public static final int ACCURACY_HH = 3;
	/** 精度到分 */
	public static final int ACCURACY_MM = 2;
	/** 精度到秒 */
	public static final int ACCURACY_SS = 1;
	/** 自定义错误代码 */
	private static final long ERROR_CODE = 999999996L;

	/**
	 * 获得默认日期格式 yyyy-MM-dd  的当前日期
	 * return String
	 */
	public static String getStringFORMAT_DATE_DEFAULT() {
		String time = DateUtil.getDateStr(DateUtil.getCurrentDate(), DateUtil.FORMAT_DATE_DEFAULT);
		return time;
	}

	/**
	 * 获得时间格式yyyy-MM-dd HH:mm:ss 的当前日期 return String
	 */
	public static String getStringFORMAT_HOUR_DATE_TIME() {
		String time = DateUtil.getDateStr(DateUtil.getCurrentDate(), DateUtil.FORMAT_HOUR_DATE_TIME);
		return time;
	}
	
	/**
	 * 获得时间格式 HH:mm:ss 的当前日期 return String
	 */
	public static String getStringFORMAT_DATE_TIME() {
		String time = DateUtil.getDateStr(DateUtil.getCurrentDate(), DateUtil.FORMAT_DATE_TIME);
		return time;
	}

	/**
	 * 获得yyyy-MM-dd HH:mm:ss 格式的当前日期 return Date
	 */
	public static Date getDateFORMAT_HOUR_DATE_TIME() {
		Date updateTime = DateUtil.getDateByPattern(DateUtil.getCurrentDate(), DateUtil.FORMAT_HOUR_DATE_TIME);
		return updateTime;
	}

	/**
	 * 获得指定格式的 当前日期 字符串
	 * 
	 * @return 获得指定格式的 当前日期 字符串
	 */
	public static String getDateCurrent(String pattern) {
		return getDateStr(new Date(), pattern);
	}

	/**
	 * 获得默认格式的当前日期 格式（yyyy-MM-dd）
	 * 
	 * @return 获得默认格式的当前日期
	 */
	public static String getDateCurrent() {
		return getDateCurrent(DateUtil.FORMAT_DATE_DEFAULT);
	}

	/**
	 * 根据指定日期和格式 返回对应的时间字符串
	 * 
	 * @param date
	 *            日期变量
	 * @param pattern
	 *            日期格式
	 * @return 日期时间字符串
	 */
	public static String getDateStr(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 获取指定日期的 默认格式 字符串， 格式：yyyy-MM-dd
	 * 
	 * @param date
	 *            日期
	 * @param formatStr
	 *            格式
	 * @return 字符串
	 */
	public static String getDateStr(Date date) {
		return getDateStr(date, DateUtil.FORMAT_DATE_DEFAULT);
	}

	/**
	 * 以默认格式返回当前日期， 格式：yyyy-MM-dd
	 * 
	 * @param date
	 *            日期
	 * @param formatStr
	 *            格式
	 * @return Date
	 */
	public static Date getCurrentStr() {
		return parseDate(getDateStr(new Date(), DateUtil.FORMAT_DATE_DEFAULT));
	}

	/**
	 * 获取 符合指定格式的当前日期，格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            日期
	 * @param formatStr
	 *            格式
	 * @return Date
	 */
	public static Date getCurrentDate() {
		return parseDate(getDateStr(new Date(), DateUtil.FORMAT_HOUR_DATE_TIME));
	}

	/**
	 * 获取 按指定格式返回 传入的日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date getDateByPattern(Date date, String pattern) {
		return parseDate(getDateStr(date, pattern));
	}

	/**
	 * 获取当前月 字符串 ，格式：yyyy-MM
	 * 
	 * @return
	 */
	public static String getCurrentMonthStr() {
		return getDateStr(new Date(), DateUtil.FORMAT_CURRENT_MONTH);
	}
	
	/**
	 * 获取当前月 字符串 ，格式：yyyyMMddHHmmssSSS
	 * 
	 * @return
	 */
	public static String getDateStrAll(Date date) {
		return new SimpleDateFormat(DateUtil.FORMAT_HOUR_DATE_TIME2).format(date);
	}

	/**
	 * 字符串转换成时间格式 <br/>
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
	 * "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 * 
	 * @param cStr
	 *            待转换的字符串
	 * @return 转换后的日期
	 */
	public static Date parseDate(String cStr) {
		if (cStr == null) {
			return null;
		}
		try {
			return parseDate(cStr, parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 
	 * 比较两个日期,以天为基本单位:<br/>
	 * 如果第一个日期早于第二个日期，返回1;<br/>
	 * 如果第一个日期等于第二个日期，返回0;<br/>
	 * 如果第一个日期晚于第二个日期，返回-1
	 * 
	 * @param date1
	 *            第一个日期
	 * @param date2
	 *            第二个日期
	 * @return 比较结果，如果参数不对或缺少，返回9
	 */
	public static int compare(Date a, Date b) {
		return compare(a, b, DateUtil.ACCURACY_DAY);
	}

	/**
	 * 
	 * 比较两个日期:<br/>
	 * 如果第一个日期早于第二个日期，返回1;<br/>
	 * 如果第一个日期等于第二个日期，返回0;<br/>
	 * 如果第一个日期晚于第二个日期，返回-1
	 * 
	 * @param date1
	 *            第一个日期
	 * @param date2
	 *            第二个日期
	 * @param accuracy
	 *            精度DateUtil.ACCURACY_YEAR,DateUtil.ACCURACY_DAY....
	 * @return 比较结果，如果参数不对或缺少，返回9
	 */
	public static int compare(Date a, Date b, int accuracy) {
		long distance = getDateDistancePrivate(a, b, accuracy);
		if (distance < 0) {
			return -1;
		} else if (distance > 0 && distance != ERROR_CODE) {
			return 1;
		} else if (distance == 0) {
			return 0;
		} else {
			return 9;
		}
	}
	
	public static Date changeStrToDate(String strDate) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_DEFAULT);
		return dateFormat.parse(strDate);
	}
	
	/**
	 * 
	 * /** 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，舍弃法 author: HST
	 * 起始日期，(String,格式："YYYY-MM-DD")
	 * 
	 * @param startDate
	 *            终止日期，(String,格式："YYYY-MM-DD")
	 * @param endDate
	 *            时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
	 * @param unit
	 *            String 时间间隔,整形变量int
	 * @return int
	 */
	public static int calInterval(Date startDate, Date endDate, String unit) {
		int interval = 0;

		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(Calendar.YEAR);
		int sMonths = sCalendar.get(Calendar.MONTH);
		int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		int eMonths = eCalendar.get(Calendar.MONTH);
		int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

		if (unit.equals("Y")) {
			interval = eYears - sYears;

			if (eMonths < sMonths) {
				interval--;
			} else {
				if (eMonths == sMonths && eDays < sDays) {
					interval--;
					if (eMonths == 1) { // 如果同是2月，校验润年问题
						if ((sYears % 4) == 0 && (eYears % 4) != 0) { // 如果起始年是润年，终止年不是润年
							if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么补一
								interval++;
							}
						}
					}
				}
			}
		}
		if (unit.equals("M")) {
			interval = eYears - sYears;
			// interval = interval * 12;
			interval *= 12;
			// interval = eMonths - sMonths + interval;
			interval += eMonths - sMonths;

			if (eDays < sDays) {
				interval--;
				// eDays如果是月末，则认为是满一个月
				int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
				if (eDays == maxDate) {
					interval++;
				}
			}
		}
		if (unit.equals("D")) {
			sCalendar.set(sYears, sMonths, sDays);
			eCalendar.set(eYears, eMonths, eDays);
			long lInterval = (eCalendar.getTime().getTime() - sCalendar.getTime().getTime()) / 86400000;
			interval = (int) lInterval;
		}
		return interval;
	}

	/*
	 * 计算两个时间差，只为整数，第三个参数是精度。支持时,分,秒,天。不支持年和月<br/>
	 * 
	 * @param a 第一个时间
	 * 
	 * @param b 第二个时间
	 * 
	 * @param accuracy 时间精度
	 * 
	 * @return 时间差，当缺少参数时，返回999999996
	 */
	private static long getDateDistancePrivate(Date a, Date b, int accuracy) {
		if (a == null || b == null) {
			return ERROR_CODE;
		}
		long d1 = a.getTime();// 第一个时间
		long d2 = b.getTime();// 第二个时间
		long distance = d2 - d1;// 时间差
		switch (accuracy) {

		case DateUtil.ACCURACY_DAY:
			distance = distance / 86400000;
			break;
		case DateUtil.ACCURACY_HH:
			distance = distance / 3600000;
			break;
		case DateUtil.ACCURACY_MM:
			distance = distance / 60000;
			break;
		case DateUtil.ACCURACY_SS:
			distance = distance / 1000;
			break;
		default:
			distance = -1;
			break;
		}
		return distance;
	}

	/**
	 * 
	 * 根据生日获取年龄,字符格式的日期
	 * 
	 * @param birthDay
	 *            出生日期
	 * @return 返回年龄，传入时间大于当前时间，返回-1
	 */
	public static int getAge(String birthDay) {
		Date date = parseDate(birthDay);
		return getAge(date);
	}

	/**
	 * 
	 * 根据生日获取年龄
	 * 
	 * @param birthDay
	 *            出生日期
	 * @return 返回年龄，传入时间大于当前时间，返回-1
	 */
	public static int getAge(Date birthDay) {
		int age = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthDay);
		Calendar now = Calendar.getInstance();
		if (calendar.after(now)) {
			return -1;
		}
		age = now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
		calendar.add(Calendar.MONTH, age*12);
		Date dt1 = calendar.getTime(); 
		if (getDateDistancePrivate(dt1,now.getTime(),DateUtil.ACCURACY_SS) < 0) {
			age--;
		} 
		return age;
	}

	public static Date getDate(String dateStr) {
		Date date = null;
		try {
			if (dateStr.length() == 8 && dateStr.indexOf('-') < 0 && dateStr.indexOf('/') < 0) {
				date = org.apache.commons.lang.time.DateUtils.parseDate(dateStr, new String[] { FORMAT_DATE_DATE });
			} else {
				date = org.apache.commons.lang.time.DateUtils.parseDate(dateStr, parsePatterns);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 传入当前日期,返回当前时分秒
	 * 
	 * @param date
	 * @return
	 */
	public static String getTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME);
		return sdf.format(date);
	}

	/**
	 * 获取以"-"分隔日期值的中文表示
	 * 
	 * @param strDate
	 *            String 日期
	 * @return String YYYY年MM月DD日
	 */
	public static String getChnDate(String strDate) {
		String strReturn = getVisaYear(strDate) + "年" + getVisaMonth(strDate) + "月" + getVisaDay(strDate) + "日";
		return strReturn;
	}

	/**
	 * 获取以"-"分隔日期值中的年份
	 * 
	 * @param strDate
	 *            String 日期
	 * @return String 年
	 */
	public static String getVisaYear(String strDate) {
		int intPosition = 0;
		String strReturn = "";
		int intYear = 0;

		if ((strDate != null) && (strDate.trim().length() > 0)) {
			intPosition = StrTool.getPos(strDate, StrTool.VISADATEDELIMITER, 1);
			if (intPosition > 0) {
				strReturn = strDate.substring(0, intPosition);
				intYear = new Integer(strReturn).intValue();
				if ((intYear <= 0)) {
					strReturn = "";
				} else {
					strReturn = "" + intYear;
				}

				if ((intYear < 10) && (!strReturn.equals(""))) {
					strReturn = "0" + strReturn;
				}
			}
		}
		return strReturn;
	}

	/**
	 * 获取以"-"分隔日期值中的月份
	 * 
	 * @param strDate
	 *            String 日期
	 * @return String 月
	 */
	public static String getVisaMonth(String strDate) {
		int intPosition1 = 0, intPosition2 = 0;
		String strReturn = "";
		int intMonth = 0;
		if ((strDate != null) && (strDate.trim().length() > 0)) {
			intPosition1 = StrTool.getPos(strDate, StrTool.VISADATEDELIMITER, 1);
			intPosition2 = StrTool.getPos(strDate, StrTool.VISADATEDELIMITER, 2);
			if ((intPosition1 > 0) && intPosition2 > intPosition1) {

				strReturn = strDate.substring(intPosition1 + 1, intPosition2);

				intMonth = new Integer(strReturn).intValue();
				if ((intMonth <= 0) || (intMonth > 12)) {
					strReturn = "";
				} else {
					strReturn = "" + intMonth;
				}

				if ((intMonth < 10) && (!strReturn.equals(""))) {
					strReturn = "0" + strReturn;
				}
			}
		}
		return strReturn;
	}

	/**
	 * 获取以"-"分隔日期值中的天
	 * 
	 * @param strDate
	 *            String 日期
	 * @return String 天
	 */
	public static String getVisaDay(String strDate) {
		int intPosition = 0;
		String strReturn = "";
		int intDay = 0;
		if ((strDate != null) && (strDate.trim().length() > 0)) {
			intPosition = StrTool.getPos(strDate, StrTool.VISADATEDELIMITER, 2);
			if (intPosition > 0) {

				strReturn = strDate.substring(intPosition + 1);

				intDay = new Integer(strReturn).intValue();

				if ((intDay <= 0) || (intDay > 31)) {
					strReturn = "";
				} else {
					strReturn = "" + intDay;
				}

				if ((intDay < 10) && (!strReturn.equals(""))) {
					strReturn = "0" + strReturn;
				}
			}
		}
		return strReturn;
	}

	/***
	 * 
	 * 传入date返回当前时间 "yyyy-MM-dd HH:mm:ss";
	 * 
	 * @param date
	 * @return
	 */
	public static String getYmdhms(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_HOUR_DATE_TIME);
		return sdf.format(date);
	}
	
	public static String getYmd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_DEFAULT);
		return sdf.format(date);
	}
	
	/**
	 * 重载计算日期，参数见楼上，
	 * 
	 * @param baseDate
	 *            String 起始日期
	 * @param interval
	 *            int 数量
	 * @param unit
	 *            String 单位
	 * @return String
	 */
	public static Date newCalDate(Date baseDate, int interval, String unit) {
		Date returnDate = null;

		GregorianCalendar tBaseCalendar = new GregorianCalendar();
		tBaseCalendar.setTime(baseDate);

		if (unit.equals("Y")) {
			tBaseCalendar.add(Calendar.YEAR, interval);
		}
		if (unit.equals("M")) {
			tBaseCalendar.add(Calendar.MONTH, interval);
		}
		if (unit.equals("D")) {
			tBaseCalendar.add(Calendar.DATE, interval);
		}
		returnDate = tBaseCalendar.getTime();
		tBaseCalendar = null;

		return returnDate;
	}
	
	/**
	 * 重载计算日期，参数见楼上，
	 * 
	 * @param baseDate
	 *            String 起始日期
	 * @param interval
	 *            int 数量
	 * @param unit
	 *            String 单位
	 * @param compareDate
	 *            String
	 * @return String
	 */
	public static String calDate(String baseDate, int interval, String unit, String compareDate) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATE_DEFAULT);
			Date bDate = df.parse(baseDate);
			Date cDate = df.parse(compareDate);
			return df.format(calDate(bDate, interval, unit, cDate));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Date calDate(Date baseDate, int interval, String unit, Date compareDate) {
		Date returnDate = null;

		GregorianCalendar tBaseCalendar = new GregorianCalendar();
		tBaseCalendar.setTime(baseDate);

		if (unit.equals("Y")) {
			tBaseCalendar.add(Calendar.YEAR, interval);
		}
		if (unit.equals("M")) {
			tBaseCalendar.add(Calendar.MONTH, interval);
		}
		if (unit.equals("D")) {
			tBaseCalendar.add(Calendar.DATE, interval);
		}

		if (compareDate != null) {
			GregorianCalendar tCompCalendar = new GregorianCalendar();
			tCompCalendar.setTime(compareDate);
			int nBaseYears = tBaseCalendar.get(Calendar.YEAR);
			int nBaseMonths = tBaseCalendar.get(Calendar.MONTH);
			int nCompMonths = tCompCalendar.get(Calendar.MONTH);
			int nCompDays = tCompCalendar.get(Calendar.DATE);

			if (unit.equals("Y")) {
				tCompCalendar.set(nBaseYears, nCompMonths, nCompDays);
				if (tCompCalendar.before(tBaseCalendar)) {
					tBaseCalendar.set(nBaseYears + 1, nCompMonths, nCompDays);
					returnDate = tBaseCalendar.getTime();
				} else {
					returnDate = tCompCalendar.getTime();
				}
			}
			if (unit.equals("M")) {
				tCompCalendar.set(nBaseYears, nBaseMonths, nCompDays);
				if (tCompCalendar.before(tBaseCalendar)) {
					tBaseCalendar.set(nBaseYears, nBaseMonths + 1, nCompDays);
					returnDate = tBaseCalendar.getTime();
				} else {
					returnDate = tCompCalendar.getTime();
				}
			}
			if (unit.equals("D")) {
				returnDate = tBaseCalendar.getTime();
			}
			tCompCalendar = null;
		} else {
			returnDate = tBaseCalendar.getTime();
			GregorianCalendar tLeapCalendar = new GregorianCalendar();
			tLeapCalendar.setTime(returnDate);
			tLeapCalendar = null;
		}
		tBaseCalendar = null;

		return returnDate;
	}

	/***
	 * 
	 * 年数和日期相加;
	 * 
	 * @param date
	 * @return
	 */
	public static String getYears(Date Date, int year) {
		String strDate = getDateStr(Date);
		String str1 = strDate.substring(0, 4);
		String str2 = strDate.substring(4, 10);
		int a = Integer.parseInt(str1);
		int i = a + year;
		return i + str2;
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param startTime
	 * @param endTime
	 * @param dateFormat
	 * @return
	 */
	public static long getDateNum(String startTime, String endTime, String dateFormat) {
		SimpleDateFormat ft = new SimpleDateFormat(dateFormat);
		long quot = 0;
		try {
			Date date1 = ft.parse(startTime);
			Date date2 = ft.parse(endTime);
			quot = date2.getTime() - date1.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}
}
