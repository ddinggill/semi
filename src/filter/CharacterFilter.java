package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterFilter implements Filter{
	
	//필터가 웹컨테이너에서 삭제될때 호출ㅎㄴ다.
	@Override
	public void destroy() {
		
	}
	
	//체인을 따라 다음에 존재하는 필터로 이동한다.
	//체인의 가장 마지막에는 클라이언트가 요청한
	//최종 자원이 위치한다.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		//System.out.println("characterfilter start!!");
		chain.doFilter(request, response);
		//System.out.println("characterfilter end!!");
	}

	//필터가 웹 컨테이너에 생성한 후 초기화할때 호출한다.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
