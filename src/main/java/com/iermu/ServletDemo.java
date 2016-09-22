package com.iermu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iermu.dao.MockDao;
import com.iermu.model.Mock;

/**
 * Servlet implementation class ServletDemo
 */
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("开始prepare to do get");
//		request.setCharacterEncoding("UTF-8");

		// 获取URL的地址信息
		String pathInfo = request.getRequestURI().substring(request.getContextPath().length());

		// String tmp = URLDecoder.decode(request.getQueryString(), "utf-8");
		String queryString = request.getQueryString();
		if (queryString != null) {
			queryString = java.net.URLDecoder.decode(queryString,"UTF-8");
		}
		System.out.println(queryString);
		System.out.println(pathInfo);
		MockDao mockDao = new MockDao();
		Mock mock = mockDao.getMethod(pathInfo, queryString);

		setResponseData(response, mock);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String pathInfo = request.getRequestURI().substring(request.getContextPath().length());

		// 转码

		// String formData = java.net.URLDecord.decode(getFormData(request),
		// "UTF8");

		System.out.println("开始打印formData");

		String formData = getFormData(request);
		System.out.println(formData);
		
		// String tmp = URLDecoder.decode(request.getQueryString(), "utf-8");
		String queryString = request.getQueryString();
		if (queryString != null) {
			queryString = java.net.URLDecoder.decode(queryString,"UTF-8");
		}

		MockDao mockDao = new MockDao();
		Mock mock = mockDao.postMethod(pathInfo, queryString, formData);

		setResponseData(response, mock);
	}

	private String getFormData(HttpServletRequest request) {
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return java.net.URLDecoder.decode(jb.toString());

	}

	private void setResponseData(HttpServletResponse response, Mock mock) throws IOException {
		if (mock != null) {

			System.out.println("Mock value isn't null");

			// 设置响应延时
			if (mock.getResponseDelay() != null) {
				System.out.println("Sleeping .... " + mock.getResponseDelay() + " ms");
				try {
					Thread.sleep(mock.getResponseDelay());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// 设置响应格式
			if (mock.getResponseFormat() != null)
				response.setContentType(mock.getResponseFormat());

			// 设置响应状态码
			if (mock.getStatusCode() != null)
				response.setStatus(Integer.parseInt(mock.getStatusCode()));

			// 设置response header, 使用FastJson解析

			if (mock.getResponseHeader() != null) {
				System.out.println("set response header");
				System.out.println(mock.getResponseHeader());
				JSONObject jsonObj = JSON.parseObject(mock.getResponseHeader());
				for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
					System.out.println(entry.getKey() + "...." + entry.getValue());
					response.addHeader(entry.getKey().toString(), entry.getValue().toString());
				}

			}

			// 设置响应消息体
			if (mock.getResponseBody() != null) {

				PrintWriter out = response.getWriter();
				out.println(mock.getResponseBody());
				out.flush();
			}

		}

	}
}
