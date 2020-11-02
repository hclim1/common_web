package com.hclim1.common.demo.error

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * 에러 처리 클래스 *
 * @author hchulim
 */
@Controller
class ErrorController(errorAttributes: ErrorAttributes) : AbstractErrorController(errorAttributes) {

	/**
	 * JSON 형식의 에러 페이지
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ["/error"])
	@ResponseBody
	fun handleError(request: HttpServletRequest?): Map<String, Any> {
		val attributes = super.getErrorAttributes(request, true)
		attributes.remove("trace")
		return attributes
	}

	override fun getErrorPath(): String {
		return "/error"
	}
}