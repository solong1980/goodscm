package com.xlw.goodscm.utils;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

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
		String subCode = String.format("%03d", max + 1);
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
		int maxLevel = 0;
		if (allChildren != null && !allChildren.isEmpty()) {
			final int f_level = level;
			Stream<Integer> map = allChildren.stream().map(new Function<String, Integer>() {
				@Override
				public Integer apply(String t) {
					return Integer.parseInt(getChildrenSubCode(f_level, t));
				}
			});
			Optional<Integer> max = map.max(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
			});
			if (max == null) {
				throw new InvalidParameterException("get max child code error");
			}
			if (max.get() == null)
				maxLevel = 0;
			else
				maxLevel = max.get();
		}
		return createChildrenCode(level, parentCode, maxLevel);
	}
}
