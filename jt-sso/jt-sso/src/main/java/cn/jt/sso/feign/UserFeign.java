package cn.jt.sso.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jt.common.vo.SysResult;

@FeignClient("jt-sso-provider")
public interface UserFeign {
	@RequestMapping("/user/check/{param}/{type}")
	public SysResult check(@PathVariable("param") String param,@PathVariable("type") Integer type) ;
}
