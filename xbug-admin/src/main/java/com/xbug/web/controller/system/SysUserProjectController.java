package com.xbug.web.controller.system;

import com.xbug.common.annotation.Log;
import com.xbug.common.core.controller.BaseController;
import com.xbug.common.core.domain.AjaxResult;
import com.xbug.common.core.domain.entity.SysUser;
import com.xbug.common.core.page.TableDataInfo;
import com.xbug.common.enums.BusinessType;
import com.xbug.common.utils.MessageUtils;
import com.xbug.framework.web.service.SysLoginService;
import com.xbug.system.domain.SysUserDefect;
import com.xbug.system.domain.vo.BatchUserRoleVo;
import com.xbug.system.service.*;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目Controller
 *
 * @author rzk
 * @date 2023-11-13
 */
@RestController
@RequestMapping("/system/project")
public class SysUserProjectController extends BaseController {

    @Autowired
    private ISysUserProjectService sysUserProjectService;

    @Autowired
    private ISysUserProjectRoleService sysUserProjectRoleService;

    /**
     * 查询项目成员列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:list') || @ss.hasPermi('system:project:member')")
    @GetMapping("/{projectId}/member")
    public TableDataInfo memberListByProjectId(@PathVariable Long projectId, SysUser sysUser)
    {
        startPage();
        List<SysUser> list = sysUserProjectService.selectSysUserListByProjectId(projectId, sysUser);
        list = list.stream().map(u->{
            if(u.getRoles()!=null){
                u.setRoleIds(u.getRoles().stream().map(r->r.getRoleId()).collect(Collectors.toList()).toArray(new Long[]{}));
            }
            return u;
        }).collect(Collectors.toList());
        return getDataTable(list);
    }

    /**
     * 查询非本项目的成员列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:member:add')")
    @GetMapping("/{projectId}/not-member")
    public TableDataInfo notMemberListByProjectId(@PathVariable Long projectId, SysUser sysUser)
    {
        startPage();
        List<SysUser> list = sysUserProjectService.selectNotSysUserListByProjectId(projectId, sysUser);
        return getDataTable(list);
    }

    /**
     * 新增项目成员
     */
    @PreAuthorize("@ss.hasPermi('system:project:member:add')")
    @Log(title = "项目", businessType = BusinessType.INSERT)
    @PostMapping("/{projectId}/member")
    public AjaxResult addMember(@PathVariable Long projectId, @RequestBody BatchUserRoleVo batchUserRoleVo)
    {
        return toAjax(sysUserProjectService.batchInsertSysUserProject(batchUserRoleVo));
    }

    /**
     * 更新成员在项目中的角色
     */
    @PreAuthorize("@ss.hasPermi('system:project:member:update')")
    @Log(title = "项目", businessType = BusinessType.INSERT)
    @PutMapping("/{projectId}/member/{memberId}/role")
    public AjaxResult updateMemberRole(@PathVariable Long projectId,@PathVariable Long memberId, @RequestBody List<Long> roleIds)
    {
        Preconditions.checkState(roleIds!=null && roleIds.size()>0,MessageUtils.message("project.member_role_not_empty"));
        return toAjax(sysUserProjectRoleService.updateSysUserProjectRole(projectId,memberId,roleIds));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('system:project:member:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{projectId}/member/{memberId}")
    public AjaxResult remove(@PathVariable Long projectId,@PathVariable Long memberId)
    {
        if (memberId==getUserId())
        {
            return error(MessageUtils.message("user.user_cannot_deleted"));
        }
        return toAjax(sysUserProjectService.deleteSysUserProjectByProjectIdAndMemberId(projectId, memberId));
    }
}
