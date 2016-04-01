package cn.edu.fjnu.towide.city_management.common;

import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class JSONPInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Writer writer = new OutputStreamWriter(response.getOutputStream());
		writer.write(request.getParameter("callBackParamName") + "(");
		writer.flush();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		Writer writer = new OutputStreamWriter(response.getOutputStream());
		writer.write(')');
		writer.flush();
	}

}
