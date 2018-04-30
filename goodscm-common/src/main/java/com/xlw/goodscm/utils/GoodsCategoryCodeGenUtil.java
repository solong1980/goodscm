package com.xlw.goodscm.utils;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class GoodsCategoryCodeGenUtil {
	private static String getChildrenSubCode(int level, String code) {
		switch (level) {
		case 1:
			return code.substring(0, 3);
		case 2:
			return code.substring(3, 6);
		case 3:
			return code.substring(6, 9);
		default:
			break;
		}
		return null;
	}

	private static String createChildrenCode(int level, String parentCode, Integer max) {
		String subCode = String.format("%03d", max);
		switch (level) {
		case 1:
			return subCode + "000000";
		case 2:
			return parentCode.substring(0, 3) + subCode + "000";
		case 3:
			return parentCode.substring(0, 6) + subCode;
		default:
			break;
		}
		return "";
	}

	public static String genCode(String parentCode, List<String> allChildren) {
		int level = 0;
		if (parentCode.endsWith("000000000")) {
			level = 1;
		} else if (parentCode.endsWith("000000")) {
			level = 2;
		} else if (parentCode.endsWith("000")) {
			level = 3;
		} else {
			throw new InvalidParameterException("last level can not add child");
		}
		final int f_level = level;
		Optional<Integer> max = allChildren.stream().map(new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(getChildrenSubCode(f_level, t));
			}
		}).sorted().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(02);
			}
		});
		if (max == null) {
			throw new InvalidParameterException("get max child code error");
		}
		return createChildrenCode(level, parentCode, max.get());
	}
}
