package com.mintic.terra_software.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select nombreempleado, password, estado from empleados where nombreempleado=?")
				.authoritiesByUsernameQuery("select nombreempleado, rolempleado from empleados where nombreempleado = ?");

	}

	/**
	 * Personalizamos el Acceso a las URLs de la aplicación
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				// Los recursos estáticos no requieren autenticación
				.antMatchers(
						"/bootstrap/**",
						"/images/**",
						"/tinymce/**",
						"/logos/**",
						"/assets/**").permitAll()

				// Las vistas públicas no requieren autenticación
				.antMatchers("/login",
						"/signup",
						"/about",
						"/bcrypt/**",
						"/about").permitAll()
				.antMatchers("/enterprises/**").hasAnyAuthority("0")

				// Todas las demás URLs de la Aplicación requieren autenticación
				.anyRequest().authenticated()
				// El formulario de Login no requiere autenticacion
				.and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll();
	}


}