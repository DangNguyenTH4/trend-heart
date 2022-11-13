package com.sunteco.young.loveevent.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class RequestFillter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange,
                             WebFilterChain webFilterChain) {
        System.out.println(serverWebExchange.getRequest().getPath());
        System.out.println(serverWebExchange.getRequest().getQueryParams());
        return webFilterChain.filter(serverWebExchange);
    }
}
