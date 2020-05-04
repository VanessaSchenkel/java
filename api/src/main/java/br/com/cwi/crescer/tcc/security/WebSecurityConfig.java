package br.com.cwi.crescer.tcc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    jsr250Enabled = true,
    prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.public.path}")
    private String publicPath;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers().frameOptions().sameOrigin()
            .and()
            .cors().and().csrf().disable()
            .exceptionHandling()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()

            // tudo que estiver a partir de "/public/**"
            // está permitido, mesmo sem autenticação

            .antMatchers(publicPath, "/h2-console/**")
            .permitAll()

                .antMatchers(HttpMethod.POST, "/public/autenticacao/login")
                .permitAll()

                .antMatchers(HttpMethod.POST, "/usuarios").permitAll()

                .antMatchers(HttpMethod.PUT, "/usuarios/{id-usuario}").permitAll()

                .antMatchers(HttpMethod.PUT, "/postagens/mudar-privacidade/{id-post}").permitAll()

                .antMatchers(HttpMethod.GET, "/usuarios/{id-usuario}").permitAll()

                .antMatchers(HttpMethod.GET, "/usuarios/minhas-informacoes").permitAll()

                .antMatchers(HttpMethod.GET, "/usuarios/buscar/{nome-ou-email}").permitAll()

                .antMatchers(HttpMethod.POST, "/amizades/{id-amigo}").permitAll()

                .antMatchers(HttpMethod.GET, "/amizades/solicitacoes").permitAll()

                .antMatchers(HttpMethod.GET, "/amizades").permitAll()

                .antMatchers(HttpMethod.POST, "/postagens").permitAll()

                .antMatchers(HttpMethod.GET, "/postagens/minhas-postagens").permitAll()

                .antMatchers(HttpMethod.GET, "/postagens/outros/{id-amigo}").permitAll()

                .antMatchers(HttpMethod.GET, "/postagens/todas").permitAll()

                .antMatchers(HttpMethod.POST, "/curtidas").permitAll()

                .antMatchers(HttpMethod.DELETE, "/curtidas/{id-postagem}/{id-curtida}").permitAll()

                .antMatchers(HttpMethod.GET, "/comentarios/{id-postagem}").permitAll()

                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()

            // tudo que estiver a partir de "/admin/**"
            // está permitido apenas para o perfil ADMIN
            .antMatchers("/admin/**")
            .hasRole("ADMIN")

            // qualquer outro request
            // está permitido desde que esteja autenticado
            .anyRequest()
            .authenticated()
        ;

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}