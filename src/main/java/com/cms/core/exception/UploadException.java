package com.cms.core.exception;


/**
 * 类名: ServiceException
 * 包名: com.msf.materialproductservice.exception
 * 描述: 业务异常抛出
 * 创建人: sunpenglin
 * 创建时间: 2018/1/15 11:08
 **/
public class UploadException extends Exception{

	private static final long serialVersionUID = 1L;

	public UploadException() {
		super();
	}

	public UploadException(String message) {
		super(message);
	}

	public UploadException(Throwable cause) {
		super(cause);
	}

	public UploadException(String message, Throwable cause) {
		super(message, cause);
	}
}
