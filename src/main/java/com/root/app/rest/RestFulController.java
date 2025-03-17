package com.root.app.rest;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestFulController {
	
	@RequestMapping("/rest/t1")
	public void f1()throws Exception{
		
		// Server에서 다른 Server로 요청을 보내려 함
		// URL, Method, Parameter, Header
		RestTemplate restTemplate = new RestTemplate();
		
		// 1. Header 생성
		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		// 2. parameter 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "authorization_code");
		// 3. 요청 객체 생성
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		// 4. 요청 전송 결과 처리
//		ResponseEntity<JsonDTO> res = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", JsonDTO.class, params);
		// 1) GET
		JsonDTO res = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JsonDTO.class, params);
		
		// 2) POST
		restTemplate.postForEntity("url", req, JsonDTO.class);
		
		// 3) GET/POST
		ResponseEntity<JsonDTO> response = restTemplate.exchange("url", HttpMethod.POST, req, JsonDTO.class);
		
		// 5. 요청의 결과가 여러개 나올 경우
		List<JsonDTO> r = restTemplate.getForObject("url", List.class, req);
		
		
	}

}
