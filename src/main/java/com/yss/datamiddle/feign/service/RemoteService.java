package com.yss.datamiddle.feign.service;

import com.yss.datamiddle.vo.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface RemoteService {
    /**
     * 获取用户信息
     * @return
     */
    R<UserInfo> info();

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    R<UserVO> user(Integer id);

    /**
     * 获取用户列表
     * @return
     */
    R<List<ReturnVo>> getUserList();

    /**
     * 查询用户信息通过list
     * @param lists
     * @return
     */
    R<List<ReturnUsers>> usersByList(@RequestBody List<Integer> lists);

    /**
     * 查询全部用户集合分页
     * @param pageSize
     * @param pageNum
     * @return
     */
    R<PageModel> getUserAllPage(@PathVariable("pageSize") String pageSize, @PathVariable("pageNum") String pageNum);

    /**
     * 查询全部角色集合分页
     * @param pageSize
     * @param pageNum
     * @return
     */
    R<PageModel> getRoleAllPage(@PathVariable("pageSize") String pageSize, @PathVariable("pageNum") String pageNum);
}
