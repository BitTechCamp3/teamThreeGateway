package com.team.three.gateway.filter;

import com.team.three.gateway.domain.Member;
import com.team.three.gateway.jwt.TokenValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class JwtTokenFilter extends AbstractGatewayFilterFactory<JwtTokenFilter.Config>{

    public JwtTokenFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            // 헤더에 토큰이 존재하지 않을 때
            if(!request.getHeaders().containsKey("token")) {
                ServerHttpResponse response = exchange.getResponse();

                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            //TODO:: 토큰 검증
            // Request Header 에서 token 문자열 받아오기
            List<String> token = request.getHeaders().get("token");
            String tokenString = Objects.requireNonNull(token).get(0);

            TokenValidate tv = new TokenValidate();
            Member member = tv.getMemebrId(tokenString);

            //토큰 일치
            if(member.getResult() == 0) {
                return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info(">>>>>>>>토큰 있음, 로그인 가능>>>>>>>>")));
            } else {
                return handleUnAuthorized(exchange);
            }

        });
    }

    private Mono<Void> handleUnAuthorized(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    public static class Config {

    }

}
