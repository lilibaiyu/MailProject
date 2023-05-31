package org.example.controller;

import org.example.pojo.Type;
import org.example.service.SpecialistService;
import org.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//销售专员管理商品和商品类型
@Controller
@RequestMapping("/specialist")
public class SpecialistController {
    @Autowired
    private SpecialistService specialistService;

    //新建类型
    //传入：type_name
    //返回：创建成功！+Type实例对象/创建失败！/该类型已经存在！
    @ResponseBody
    @RequestMapping("/newType")
    public Result addNewType(@RequestParam("type_name") String type_name){
        //默认id为0后面自增长，默认use为1
        Type type=new Type(0,type_name,1);
        return specialistService.addNewType(type);
    }

    //修改类型名字
    //传入：type_id:要修改的类型id，type_name:修改后的类型名称
    //返回：修改成功！/修改失败！
    @ResponseBody
    @RequestMapping("/updateTypeName")
    public Result updateTypeName(@RequestParam("type_id") Integer type_id,@RequestParam("type_name") String type_name){
        return specialistService.updateTypeName(type_id,type_name);
    }

    //修改类型的禁用启用情况
    //传入：type_name,type_use:修改后的use值
    //返回：修改成功！/修改失败！
    @ResponseBody
    @RequestMapping("/updateTypeUse")
    public Result updateTypeUse(@RequestParam("type_name") String type_name,@RequestParam("type_use") Integer type_use){
        return specialistService.updateTypeUse(type_name,type_use);
    }

    //根据类型名字删除类型
    //传入：type_name
    //返回：删除成功！/删除失败！
    @ResponseBody
    @RequestMapping("/deleteByTypeName")
    public Result deleteByTypeName(@RequestParam("type_name") String type_name){
        return specialistService.deleteByTypeName(type_name);
    }

    //无条件显示所有类型，分页
    //传入：currentPage：当前页码，size：页的大小即需要查询的记录条数
    //返回：类型列表，总条数，页大小，总页数，当前页码
    @ResponseBody
    @RequestMapping("/showAllTypes")
    public Result showAllTypes(@RequestParam("currentPage") int currentPage,@RequestParam("size") int size){
        return specialistService.selectTypes(currentPage, size);
    }

    //指定类型名称关键字查询全部类型，分页
    //传入：currentPage：当前页码，size：页的大小即需要查询的记录条数，keyword：类型名称关键字
    //返回：类型列表，总条数，页大小，总页数，当前页码
    @ResponseBody
    @RequestMapping("/showQueryTypes")
    public Result showQueryTypes(@RequestParam("currentPage") int currentPage,@RequestParam("size") int size,@RequestParam("keyword") String keyword){
        return specialistService.selectTypesByCondition(currentPage,size,keyword);
    }
}
