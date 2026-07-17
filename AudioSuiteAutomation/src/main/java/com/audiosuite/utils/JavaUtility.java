package com.audiosuite.utils;

import java.time.LocalDateTime;

public class JavaUtility {

	public String getSysystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
}
