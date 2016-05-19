package com.danco.training.filter;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.danco.training.api.IActService;
import com.danco.training.entity.Act;
import com.danco.training.entity.User;
import com.danco.training.service.ActService;

public class AuditFilter implements Filter {
	private FilterConfig filterConfig;
	private IActService service;
	
	public AuditFilter(){
		super();
		service = new ActService();
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (filterConfig == null){
            return;
        }
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		String resourse = httpRequest.getRequestURL().toString();
		
		if(session != null && session.getAttribute("act") != null){
			Act act = (Act) session.getAttribute("act");
			act.setLogoutDate(new Date());
			act.setResource(resourse);
			service.addAct(act);
		}
		chain.doFilter(request, response);
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
	
	public void destroy() {
	
	}
}
