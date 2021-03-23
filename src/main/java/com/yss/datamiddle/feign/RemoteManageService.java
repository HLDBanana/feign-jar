package com.yss.datamiddle.feign;

import com.yss.datamiddle.feign.factory.RemoteManageServiceFallbackFactory;
import com.yss.datamiddle.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(contextId = "remoteManageService", value = "yss-datamiddle-manager" , fallbackFactory = RemoteManageServiceFallbackFactory.class)
public interface RemoteManageService {
    /**
     * 获取用户信息
     */
    @GetMapping("/user/info/{username}")
    R<UserInfo> info(@PathVariable("username") String username);


    /**
     * 获取用户信息
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    R<UserVO> user(@PathVariable("id") Integer id);


    /**
     * 获取用户列表
     */
    @GetMapping("/user/getUserList")
    @ResponseBody
    R<List<ReturnVo>> getUserList();


    /**
     * 查询用户信息通过list
     *
     * @return 用户信息
     */
    @ResponseBody
    @PostMapping("/user/usersByList")
    R<List<ReturnUsers>> usersByList(@RequestBody List<Integer> lists);

    /**
     * 查询全部用户集合(分页)
     *
     * @return 用户信息
     */
    @ResponseBody
    @GetMapping("/user/all/{pageSize}/{pageNum}")
    R<PageModel> getUserAllPage(@PathVariable("pageSize") String pageSize, @PathVariable("pageNum") String pageNum);


    /**
     * 分页查询角色信息
     *
     * @return 分页对象
     */
    @ResponseBody
    @GetMapping("/role/all/{pageSize}/{pageNum}")
    R<PageModel> getRoleAllPage(@PathVariable("pageSize") String pageSize, @PathVariable("pageNum") String pageNum);
}
