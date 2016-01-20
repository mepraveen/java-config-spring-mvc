package com.praveen.controller;

/*import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sequoia.controller.dto.ErrorDto;

public abstract class BaseController {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, ErrorDto>> handleRuleVoilationException(
			IllegalArgumentException ex, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, ErrorDto> map = new HashMap<>();
		map.put("error", new ErrorDto(ex.getMessage()));
		return ResponseEntity.badRequest().body(map);// .sendError(HttpServletResponse.SC_BAD_REQUEST,
														// ex.getMessage());
	}
}
*/