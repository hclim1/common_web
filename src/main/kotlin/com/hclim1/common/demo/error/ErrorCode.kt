package com.hclim1.common.demo.error

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(val status: Int, val code: String, val message: String) {
	//Http
	BAD_REQUEST(400, "H0001", "잘못된 요청 입니다."),
	UNAUTHORIZED(401, "H0002", "접근 권한이 없습니다."),
	NOT_FOUND(404, "H0003", "찾을수 없는 정보 입니다."),
	METHOD_NOT_ALLOWED(405, "H0004", "허가되지 않은 접속 방법입니다."),
	INTERNAL_SERVER_ERROR(500, "H0005", "서버내 오류가 발생 하였습니다."),
}