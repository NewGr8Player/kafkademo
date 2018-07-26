package com.xavier.api;

import com.alibaba.fastjson.JSON;
import com.xavier.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@PostMapping(path="/send")
	public String send(
			@RequestParam("topic") String topic,
			@RequestParam("message") String message){
		return JSON.toJSONString(this.providerService.sendMessage(topic,message));
	}
}
