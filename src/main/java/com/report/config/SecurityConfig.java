package com.report.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.report.service.MyAuthenticationProvider;
import com.report.service.MyAuthenticationResultHandler;

//spring security 설정을 위한 Java Config 클래스
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;
	@Autowired
	MyAuthenticationResultHandler myAuthenticationResultHandler;

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/res/**");
		// /res/** 패턴의 URL은 보안 검사를 하지 말고 무시하라는 설정
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // 권한 설정 시작
				//.antMatchers("/professor/**").hasRole("PROFESSOR") // /professor/** 패턴의 URL은 ROLE_PROFESSOR 권한을 소유한 사용자만
																	// 요청할 수 있다는 설정이다.
				//.antMatchers("/student/**").hasRole("STUDENT") // /student/** 패턴의 URL은 ROLE_STUDENT 권한을 소유한 사용자만 요청할 수
																// 있다는 설정이다.
				//.antMatchers("/ta/**").hasRole("TA") // /ta/** 패턴의 URL은 ROLE_TA 권한을 소유한 사용자만 요청할 수 있다는 설정이다.
				.antMatchers("/guest/**").permitAll() // /guest/** 패턴의 URL은 모든 사용자에게 허용된다는 설정이다. 로그인하지 않은 사용자에게도 허용된다.
				//.antMatchers("/").permitAll() // / URL 은 모든 사용자에게 허용된다는 설정이다. 로그인하지 않은 사용자에게도 허용된다
				.antMatchers("/**").authenticated(); // /** 패턴의 URL은 로그인된 사용자에게만 허용된다는 설정이다.

		http.csrf().disable(); // CSRF 공격 검사를 하지 않겠다는 설정이다.

		http.formLogin()
        .loginPage("/guest/login")
        .loginProcessingUrl("/guest/login_processing")
        .failureUrl("/guest/login?error")
        //.defaultSuccessUrl("/")
        .usernameParameter("loginId")
        .passwordParameter("passwd")
        .successHandler(myAuthenticationResultHandler)
        .failureHandler(myAuthenticationResultHandler);
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("logout_processing"))
		.logoutSuccessUrl("/guest/login")
		.invalidateHttpSession(true);

//		if (http.authorizeRequests().antMatchers("/student/**").hasRole("STUDENT") != null) {
//			http.formLogin() // 학생
//					.loginPage("/guest/login").loginProcessingUrl("/guest/login_processing")
//					.failureUrl("/guest/login?error").defaultSuccessUrl("/student/studentMain", true)
//					.usernameParameter("loginId").passwordParameter("passwd");
//			http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/student/logout_processing"))
//					.logoutSuccessUrl("/guest/login").invalidateHttpSession(true);
//		}else if (http.authorizeRequests().antMatchers("/professor/**").hasRole("PROFESSOR") != null) {
//			http.formLogin() // 교수
//					.loginPage("/guest/login").loginProcessingUrl("/guest/login_processing")
//					.failureUrl("/guest/login?error").defaultSuccessUrl("/professor/professorMain", true)
//					.usernameParameter("loginId").passwordParameter("passwd");
//			http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/professor/logout_processing"))
//					.logoutSuccessUrl("/guest/login").invalidateHttpSession(true);
//		}else if (http.authorizeRequests().antMatchers("/ta/**").hasRole("TA") != null) {
//			http.formLogin() // ta
//					.loginPage("/guest/login").loginProcessingUrl("/guest/login_processing")
//					.failureUrl("/guest/login?error").defaultSuccessUrl("/ta/taMain", true).usernameParameter("loginId")
//					.passwordParameter("passwd");
//			http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/ta/logout_processing"))
//					.logoutSuccessUrl("/guest/login").invalidateHttpSession(true);
//		}
		http.authenticationProvider(myAuthenticationProvider);

	}
}
