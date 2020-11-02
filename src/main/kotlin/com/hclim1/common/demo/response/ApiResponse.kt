package com.smilegate.general.mgt.common;

import lombok.Getter;
import lombok.Setter;


class ApiResponse<T>(
		var item: T,
		var message: String = "",
		var isSuccess: Boolean = false
){
}

