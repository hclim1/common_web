package com.smilegate.general.mgt.common;

import lombok.Getter;
import lombok.Setter;


class ApiResponse<T>(
		private var item: T,
		private var message: String = "",
		private var isSuccess: Boolean = false
)
