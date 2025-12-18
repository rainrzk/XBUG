package com.xbug.web.controller.system;

import com.xbug.common.annotation.Log;
import com.xbug.common.core.controller.BaseController;
import com.xbug.common.core.domain.AjaxResult;
import com.xbug.common.core.page.TableDataInfo;
import com.xbug.common.enums.BusinessType;
import com.xbug.common.utils.poi.ExcelUtil;
import com.xbug.system.domain.SysUserDefect;
import com.xbug.system.service.ISysUserDefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户缺陷Controller
 * 
 * @author rzk
 * @date 2024-01-10
 */
@RestController
@RequestMapping("/system/defect")
public class SysUserDefectController extends BaseController
{
    @Autowired
    private ISysUserDefectService sysUserDefectService;

    /**
     * 修改用户缺陷
     */
    @PreAuthorize("@ss.hasPermi('system:defect:list') || @ss.hasPermi('system:defect:query')")
    @Log(title = "用户缺陷", businessType = BusinessType.UPDATE)
    @PutMapping("/{defectId}")
    public AjaxResult edit(@PathVariable Long defectId, @RequestBody SysUserDefect sysUserDefect)
    {
        sysUserDefect.setDefectId(defectId);
        return toAjax(sysUserDefectService.updateSysUserDefect(sysUserDefect));
    }
}
