package com.mintic.terra_software.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, estatus from empleados where username=?")
                .authoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up " +
                        "inner join empleados u on u.id = up.idUsuario " +
                        "inner join Perfiles p on p.id = up.idPerfil " +
                        "where u.username = ?");
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
                        "/bcrypt/**",
                        "/about",
                        "/empleados/crear/**",
                        "/empleados/guardar/**").permitAll()

                .antMatchers("/enterprises/**").hasAnyAuthority("OPERADOR","ADMINISTRADOR","SUPERADMINISTRADOR")
                .antMatchers("/empleados/**").hasAnyAuthority("ADMINISTRADOR", "SUPERADMINISTRADOR")
                .antMatchers("/movimientos/**").hasAnyAuthority("OPERADOR","ADMINISTRADOR","SUPERADMINISTRADOR","USUARIO")

                // Todas las demás URLs de la Aplicación requieren autenticación
                .anyRequest().authenticated()
                // El formulario de Login no requiere autenticacion
                .and().formLogin().loginPage("/login").permitAll()

                .and().logout().permitAll();
    }

    /**
     *  Implementación de Spring Security que encripta passwords con el algoritmo Bcrypt
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}