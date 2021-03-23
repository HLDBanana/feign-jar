package com.yss.datamiddle.feign.fallback;

import com.yss.datamiddle.feign.RemoteManageService;
import com.yss.datamiddle.vo.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ManageServiceFallbackImpl implements RemoteManageService {
    @Setter
    private Throwable cause;
    @Override
    public R<UserInfo> info(String username) {
        log.error("调用系统管理服务查询用户信息失败");
        return null;
    }

    @Override
    public R<UserVO> user(Integer id) {
        log.error("调用系统管理服务查询用户信息失败");
        return null;
    }

    @Override
    public R<List<ReturnVo>> getUserList() {
        log.error("调用系统管理服务查询用户信息失败");
        return null;
    }

    @Override
    public R<List<ReturnUsers>> usersByList(List<Integer> lists) {
        log.error("调用系统管理服务查询用户信息失败");
        return null;
    }

    @Override
    public R<PageModel> getUserAllPage(String pageSize, String pageNum) {
        log.error("调用系统管理服务查询用户信息失败");
        return null;
    }

    @Override
    public R<PageModel> getRoleAllPage(String pageSize, String pageNum) {
        log.error("调用系统管理服务查询用户信息失败");
        return null;
    }
}
