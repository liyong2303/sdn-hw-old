package com.ky.sdn.hw.common.zx;

import java.util.HashMap;
import java.util.Map;

public class ZxPackageUtil {
	private static final String ZX_10 = "10M";
	private static final String ZX_20 = "20M";
	private static final String ZX_30 = "30M";
	private static final String ZX_50 = "50M";
	private static final String ZX_100 = "100M";
	private static final String ZX_10_MAX = "100M";
	private static final String ZX_20_MAX = "100M";
	private static final String ZX_30_MAX = "100M";
	private static final String ZX_50_MAX = "150M";
	private static final String ZX_100_MAX = "200M";

	public static Map<String, String> getMaxBandwith(String up, String down) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("upBandwidth", up);
		map.put("downBandwidth", down);
		if (up.equals(ZX_10) && down.equals(ZX_10)) {
			map.put("upBandwidth", ZX_10_MAX);
			map.put("downBandwidth", ZX_10_MAX);
		} else if (up.equals(ZX_20) && down.equals(ZX_20)) {
			map.put("upBandwidth", ZX_20_MAX);
			map.put("downBandwidth", ZX_20_MAX);
		} else if (up.equals(ZX_30) && down.equals(ZX_30)) {
			map.put("upBandwidth", ZX_30_MAX);
			map.put("downBandwidth", ZX_30_MAX);
		} else if (up.equals(ZX_50) && down.equals(ZX_50)) {
			map.put("upBandwidth", ZX_50_MAX);
			map.put("downBandwidth", ZX_50_MAX);
		} else if (up.equals(ZX_100) && down.equals(ZX_100)) {
			map.put("upBandwidth", ZX_100_MAX);
			map.put("downBandwidth", ZX_100_MAX);
		}
		return map;
	}
}
