package com.yss.datamiddle.feign.factory;

import com.yss.datamiddle.feign.RemoteManageService;
import com.yss.datamiddle.feign.fallback.ManageServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemoteManageServiceFallbackFactory implements FallbackFactory<RemoteManageService> {

	@Override
	public RemoteManageService create(Throwable throwable) {
		ManageServiceFallbackImpl remoteUserServiceFallback = new ManageServiceFallbackImpl();
		remoteUserServiceFallback.setCause(throwable);
		return remoteUserServiceFallback;
	}
}
