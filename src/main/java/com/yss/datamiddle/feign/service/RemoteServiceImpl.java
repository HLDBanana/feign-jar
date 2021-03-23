package com.yss.datamiddle.feign.service;

import com.google.gson.Gson;
import com.yss.datamiddle.feign.RemoteManageService;
import com.yss.datamiddle.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class RemoteServiceImpl implements RemoteService {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RemoteManageService remoteManageService;
    @Override
    public R<UserInfo> info() {
        String principal = decodeUTF8StringBase64(request.getHeader("request_header_token"));
        R<UserInfo> principalUser = remoteManageService.info(principal);
        return principalUser;
    }

    @Override
    public R<UserVO> user(Integer id) {
        return remoteManageService.user(id);
    }


    @Override
    public R<List<ReturnVo>> getUserList() {
        return remoteManageService.getUserList();
    }

    public static String  decodeUTF8StringBase64(String str){
        String decoded = null;
        byte[] bytes = Base64.getDecoder().decode(str);
        try {
            decoded = new String(bytes,"utf-8");
            //将header转成json对象
            Gson g = new Gson();
            Map obj = g.fromJson(decoded, Map.class);
            //用户身份信息
            String principal = obj.get("principal").toString();
            return principal;
        }catch(UnsupportedEncodingException e){
            log.warn("不支持的编码格式",e);
        }
        return null;
    }

    @Override
    public R<List<ReturnUsers>> usersByList(List<Integer> lists) {
        return remoteManageService.usersByList(lists);
    }

    @Override
    public R<PageModel> getUserAllPage(String pageSize, String pageNum) {
        return remoteManageService.getUserAllPage(pageSize,pageNum);
    }

    @Override
    public R<PageModel> getRoleAllPage(String pageSize, String pageNum) {
        return remoteManageService.getRoleAllPage(pageSize,pageNum);
    }
}
