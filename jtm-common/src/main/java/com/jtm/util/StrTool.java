/**
 * @Copyright ®2017 guobao Co. Ltd. All rights reserved.<br/>
 * 项目名称 : 国宝人寿业务前置平台系统
 * 创建日期 : 2017年5月25日
 * 修改历史 : 
 *     1. [2017年5月25日]创建文件 by guobao
 */
package com.jtm.util;

import java.text.DecimalFormat;


public class StrTool {

    public static final String VISADATEDELIMITER = "-";

    /**
     * 获取子串在主串中出现第 n 次的位置
     * @param strMain String 主字符串
     * @param strSub String 子字符串
     * @param intTimes int 出现次数
     * @return int 位置值,如果子串在主串中没有出现指定次数,则返回-1
     */
    public static int getPos(String strMain, String strSub, int intTimes) {
        int intCounter = 0; // 循环记数
        int intPosition = 0; // 位置记录
        int intLength = strSub.length(); // 子串长度

        if (intTimes <= 0) {
            return -1;
        }
        while (intCounter < intTimes) {
            intPosition = strMain.indexOf(strSub, intPosition);
            if (intPosition == -1) {
                return -1;
            }
            intCounter++;
            intPosition += intLength;
        }
        return intPosition - intLength;
    }

    /**
     * 将输入的字符串进行转换，如果为空，则返回""，如果不空，则返回该字符串去掉前后空格
     * @param tStr 输入字符串
     * @return 如果为空，则返回""，如果不空，则返回该字符串去掉前后空格
     */
    public static String cTrim(String tStr) {
        String ttStr = "";
        if (tStr == null) {
            ttStr = "";
        } else {
            ttStr = tStr.trim();
        }
        return ttStr;
    }
    
	/**
	 * 把数字金额转换为中文大写金额 author: HST
	 * 
	 * @param money
	 *            数字金额(double)
	 * @return 中文大写金额(String)
	 */
	public static String getChnMoney(double money) {
		String ChnMoney = "";
		String s0 = "";

		// 在原来版本的程序中，getChnMoney(585.30)得到的数据是585.29。

		if (money == 0.0) {
			ChnMoney = "人民币零元整";
			return ChnMoney;
		}

		if (money < 0) {
			s0 = "负";
			money *= (-1);
		}

		String sMoney = new DecimalFormat("0").format(money * 100);

		int nLen = sMoney.length();
		String sInteger;
		String sDot;
		if (nLen < 2) {
			// add by JL at 2004-9-14
			sInteger = "";
			if (nLen == 1) {
				sDot = "0" + sMoney.substring(nLen - 1, nLen);
			} else {
				sDot = "0";
			}
		} else {
			sInteger = sMoney.substring(0, nLen - 2);
			sDot = sMoney.substring(nLen - 2, nLen);
		}

		String sFormatStr = formatStr(sInteger);

		String s1 = getChnM(sFormatStr.substring(0, 4), "亿");

		String s2 = getChnM(sFormatStr.substring(4, 8), "万");

		String s3 = getChnM(sFormatStr.substring(8, 12), "");

		String s4 = getDotM(sDot);

		if (s1.length() > 0 && s1.substring(0, 1).equals("0")) {
			s1 = s1.substring(1, s1.length());
		}
		if (s1.length() > 0
				&& s1.substring(s1.length() - 1, s1.length()).equals("0")
				&& s2.length() > 0 && s2.substring(0, 1).equals("0")) {
			s1 = s1.substring(0, s1.length() - 1);
		}
		if (s2.length() > 0
				&& s2.substring(s2.length() - 1, s2.length()).equals("0")
				&& s3.length() > 0 && s3.substring(0, 1).equals("0")) {
			s2 = s2.substring(0, s2.length() - 1);
		}
		if (s4.equals("00")) {
			s4 = "";
			if (s3.length() > 0
					&& s3.substring(s3.length() - 1, s3.length()).equals("0")) {
				s3 = s3.substring(0, s3.length() - 1);
			}
		}
		if (s3.length() > 0
				&& s3.substring(s3.length() - 1, s3.length()).equals("0")
				&& s4.length() > 0 && s4.substring(0, 1).equals("0")) {
			s3 = s3.substring(0, s3.length() - 1);
		}
		if (s4.length() > 0
				&& s4.substring(s4.length() - 1, s4.length()).equals("0")) {
			s4 = s4.substring(0, s4.length() - 1);
		}
		if (s3.equals("0")) {
			s3 = "";
			s4 = "0" + s4;
		}

		ChnMoney = s0 + s1 + s2 + s3 + "元" + s4;
		if (ChnMoney.substring(0, 1).equals("0")) {
			ChnMoney = ChnMoney.substring(1, ChnMoney.length());
		}
		for (int i = 0; i < ChnMoney.length(); i++) {
			if (ChnMoney.substring(i, i + 1).equals("0")) {
				ChnMoney = ChnMoney.substring(0, i) + "零"
						+ ChnMoney.substring(i + 1, ChnMoney.length());
			}
		}

		if (sDot.substring(1, 2).equals("0")) {
			ChnMoney += "整";
		}

		return ChnMoney;
	}
	
	/**
	 * 格式化字符
	 * 
	 * @param sIn
	 *            String
	 * @return String
	 */
	private static String formatStr(String sIn) {
		int n = sIn.length();
		String sOut = sIn;
		// int i = n % 4;

		for (int k = 1; k <= 12 - n; k++) {
			sOut = "0" + sOut;
		}
		return sOut;
	}
	
	/**
	 * 添加仟、佰、拾等单位信息
	 * 
	 * @param strUnit
	 *            String
	 * @param digit
	 *            String
	 * @return String
	 */
	private static String getChnM(String strUnit, String digit) {
		String sMoney = "";
		boolean flag = false;

		if (strUnit.equals("0000")) {
			sMoney += "0";
			return sMoney;
		}
		if (!strUnit.substring(0, 1).equals("0")) {
			sMoney += getNum(strUnit.substring(0, 1)) + "仟";
		} else {
			sMoney += "0";
			flag = true;
		}
		if (!strUnit.substring(1, 2).equals("0")) {
			sMoney += getNum(strUnit.substring(1, 2)) + "佰";
			flag = false;
		} else {
			if (!flag) {
				sMoney += "0";
				flag = true;
			}
		}
		if (!strUnit.substring(2, 3).equals("0")) {
			sMoney += getNum(strUnit.substring(2, 3)) + "拾";
			flag = false;
		} else {
			if (!flag) {
				sMoney += "0";
				flag = true;
			}
		}
		if (!strUnit.substring(3, 4).equals("0")) {
			sMoney += getNum(strUnit.substring(3, 4));
		} else {
			if (!flag) {
				sMoney += "0";
				flag = true;
			}
		}

		if (sMoney.substring(sMoney.length() - 1, sMoney.length()).equals("0")) {
			sMoney = sMoney.substring(0, sMoney.length() - 1) + digit.trim()
					+ "0";
		} else {
			sMoney += digit.trim();
		}
		return sMoney;
	}
	/**
	 * 获取阿拉伯数字和中文数字的对应关系
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	private static String getNum(String value) {
		String sNum = "";
		Integer I = new Integer(value);
		int iValue = I.intValue();
		switch (iValue) {
		case 0:
			sNum = "零";
			break;
		case 1:
			sNum = "壹";
			break;
		case 2:
			sNum = "贰";
			break;
		case 3:
			sNum = "叁";
			break;
		case 4:
			sNum = "肆";
			break;
		case 5:
			sNum = "伍";
			break;
		case 6:
			sNum = "陆";
			break;
		case 7:
			sNum = "柒";
			break;
		case 8:
			sNum = "捌";
			break;
		case 9:
			sNum = "玖";
			break;
		}
		return sNum;
	}
	
	/**
	 * 得到money的角分信息
	 * 
	 * @param sIn
	 *            String
	 * @return String
	 */
	private static String getDotM(String sIn) {
		String sMoney = "";
		if (!sIn.substring(0, 1).equals("0")) {
			sMoney += getNum(sIn.substring(0, 1)) + "角";
		} else {
			sMoney += "0";
		}
		if (!sIn.substring(1, 2).equals("0")) {
			sMoney += getNum(sIn.substring(1, 2)) + "分";
		} else {
			sMoney += "0";
		}

		return sMoney;
	}

}
