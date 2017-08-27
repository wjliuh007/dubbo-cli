package cn.wjliuh.dubbo.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wjliuh.dubbo.itf.HelloWordInterface;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/dubbo")
public class DubboController {

	@Resource
	HelloWordInterface dubboservice;

	@RequestMapping("/hello.json")
	@ResponseBody
	public Object sayHello(String msg) {
		String result = dubboservice.hello(msg);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		return JSON.toJSON(map);

	}
}
