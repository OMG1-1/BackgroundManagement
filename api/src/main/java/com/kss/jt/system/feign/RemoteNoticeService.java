package com.kss.jt.system.feign;

import com.kss.jt.domain.JsonResult;
import com.kss.jt.system.domain.SysNotice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "system",contextId = "remoteNoticeService")
public interface RemoteNoticeService {

    @GetMapping("/notice/")
    JsonResult doSelectNotices(SysNotice sysNotice);
}
