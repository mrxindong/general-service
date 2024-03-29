

package com.znzd.charging.gateway.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author zhoupeilong
 * @date 2018-07-19
 * SwaggerResourceHandler
 */
@Slf4j
@Component
@AllArgsConstructor
public class SwaggerResourceHandler implements HandlerFunction<ServerResponse> {
	private final SwaggerResourcesProvider swaggerResources;

	/**
	 * Handle the given request.
	 *
	 * @param request the request to handler
	 * @return the response
	 */
	@Override
	public Mono<ServerResponse> handle(ServerRequest request) {
		return ServerResponse.status(HttpStatus.OK)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.body(BodyInserters.fromObject(swaggerResources.get()));
	}
}
