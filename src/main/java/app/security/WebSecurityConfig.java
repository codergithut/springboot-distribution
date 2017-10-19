package app.security;

import app.service.certificate.web.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/16
 * @description
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()   // 暂时禁用跨域攻击防护，后面有需要再配置
                .authorizeRequests()
                .antMatchers("/test").hasAnyAuthority("system")
                .anyRequest()
                .permitAll()
                .anyRequest().authenticated()//安全验证
                .and()
                .formLogin()
                .loginPage("/login")  //登录页面
                .permitAll()
                .and()
                .rememberMe() //rember me
                .and()
                .httpBasic()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    SecurityService securityService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
               .userDetailsService(new UserDetailsServiceImpl(securityService));
//                .passwordEncoder(new StandardPasswordEncoder("333"));
    }

}