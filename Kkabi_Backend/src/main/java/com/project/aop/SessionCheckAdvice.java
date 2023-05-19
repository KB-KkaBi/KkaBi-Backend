//package com.project.aop;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
///**
// *  board/* 의 등록 수정 삭제 다운로드 검색 조회등은 반드시 로그인된 사용자만 접근가능하도록 체크
// *   : 만약 인증을 안했다면 오류페이지로 이동 할수 있도록한다. 
// * */
//
//@Service // 생성
//@Aspect
//public class SessionCheckAdvice {
//
//	/**
//	 *  Controller영역에서(joinPoint) 매개변수로 HttpSession을 전달하지 않고
//	 *  Service or dao 영역에서 HttpServletRequest정보를 사용 할수 있도록 할수 있는 방법
//	 *    : Spring에서 2.x 이상에서 부터 Service or dao 영역에서 HttpServletRequest를 사용할수 있도록
//	 *      RequestContextHolder를 제공한다.
//	 *  
//	 * */
//	@Before("execution(public * com.project.controller.FreeBoardController.*(..))")
//	public void before(JoinPoint joinPoint) {
//		//세션의 정보가 있는지 체크한다. 
//		//HttpSession session=???
//		RequestAttributes requestAttr = RequestContextHolder.getRequestAttributes();
//		ServletRequestAttributes sra = (ServletRequestAttributes)requestAttr;
//		HttpServletRequest request = sra.getRequest();
//		
//		HttpSession session = request.getSession();
//		
//		if(session ==null || session.getAttribute("loginUser") == null) {
//			throw new RuntimeException("로그인하고 이용해주세요.");
//		}
//		
//	}
//}
//
//
//
//
//
//
//
//
//
//
