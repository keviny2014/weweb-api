package com.weweb.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weweb.common.entity.CodeMessage;
import com.weweb.common.entity.Result;

/**
 * Created by jackshen on 2017/4/4.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error("---DefaultException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(),
				req.getRequestURL(), e.getMessage());
		return new Result(CodeMessage.SERVER_ERROR);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public Result handleError405(Exception e) {
		return new Result(CodeMessage.ERROR405, e.getMessage());
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public Result handleNotValidMethodArgument(HttpServletRequest request, MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		Result result = null;
		for (FieldError error : bindingResult.getFieldErrors()) {
			result = new Result(CodeMessage.INVALID_PARAMETER, error.getDefaultMessage());
			break;
		}
		return result;
	}
}
