package org.example.controller;

import org.example.pojo.Manager;
import org.example.service.SystemManagerService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/systemManager")
public class SystemManagerController {
    @Autowired
    private SystemManagerService systemManagerService;

    //分页查询所有管理员信息
    //传入：currentPage：当前页码，size：页的大小即需要查询的记录条数
    //返回：管理员列表，总条数，页大小，总页数，当前页码
    @ResponseBody
    @RequestMapping("/showAllManagers")
    public Result showAllManagers(@RequestParam("currentPage") int currentPage,@RequestParam("size") int size){
        return systemManagerService.selectManagers(currentPage, size);
    }

    //添加新的管理员
    //传入：manager_type,manager_id,password，注意不需要传入manager_use
    //返回：添加成功！/添加失败！/该管理员已经存在！
    @ResponseBody
    @RequestMapping("/addNewManager")
    public Result addNewManager(@RequestParam("manager_type") Integer manager_type,@RequestParam("manager_id") String manager_id,@RequestParam("password") String password){
        return systemManagerService.addNewManager(manager_type,manager_id,password);
    }

    //修改管理员信息（密码或者类型或者权限）
    //传入：以json格式传入manager(manager_type,manager_id,password,manager_use)
    //返回：修改成功！/修改失败！/该管理员不存在！
    @ResponseBody
    @RequestMapping("/updateManagerInfo")
    public Result updateManagerInfo(@RequestBody Manager manager){
        return systemManagerService.updateManagerInfo(manager);
    }

    //删除管理员
    //传入：manager_id
    //返回：删除成功！/删除失败！/该管理员不存在！
    @ResponseBody
    @RequestMapping("/deleteManager")
    public Result deleteManagerById(@RequestParam("manager_id") String manager_id){
        return systemManagerService.deleteManager(manager_id);
    }
}
