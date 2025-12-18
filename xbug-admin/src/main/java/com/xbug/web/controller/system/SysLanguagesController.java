package com.xbug.web.controller.system;

import com.xbug.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: rzk
 * @CreateTime: 2023-11-15 16:44
 * @Version: 1.0.0
 */
@RestController("languages")
public class SysLanguagesController {
    @GetMapping()
    public AjaxResult changeLanguages(String lang){
        return AjaxResult.success();
    }
}
