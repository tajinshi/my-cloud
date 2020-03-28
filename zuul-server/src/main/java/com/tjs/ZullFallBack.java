package com.tjs;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class ZullFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
        //指定降级的服务，“*”或者null表示所有服务。或者返回指定的服务名
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务器错误，请联系管理员".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                //	headers设定
                HttpHeaders	headers	=	new	HttpHeaders();
                MediaType mt=new MediaType("application","json",	Charset.forName("UTF-8"));																headers.setContentType(mt);
                return	headers;
            }
        };
    }
}
