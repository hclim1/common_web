package com.hclim1.common.demo.response


class ApiResponse<T>(
		var item: T,
		var message: String = "",
		var isSuccess: Boolean = false
){
}

