package com.example.baitaptuan6.controller;

import com.example.baitaptuan6.Entity.Employee;
import com.example.baitaptuan6.constant.Url;
import com.example.baitaptuan6.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(Url.EmployeeUrl.PRE_FIX)
public class CRUDEmployee {
    @Autowired
    EmployeeService service ;

    @GetMapping(Url.EmployeeUrl.FIND_ALL)
    public String findAll(Model model){
        List<Employee> employees = new ArrayList<>() ;
        employees = service.findAll() ;
        model.addAttribute("employees" , employees) ;
        return "employee" ;
    }



    @GetMapping(value= Url.EmployeeUrl.SELECT_EMPLOYEE)
    public String edit(@RequestParam String id , RedirectAttributes attributes){
        List<Employee> employees = service.findAll() ;
        for(Employee x : employees){
            if(x.getEmployeeId().equals(id)){
                attributes.addFlashAttribute("employeeById" , x) ;
                return "redirect:/employee/get-all" ;
            }
        }
        attributes.addFlashAttribute("employeeById" , null) ;
        return "redirect:/employee/get-all" ;
    }


    @PostMapping(Url.EmployeeUrl.UPD_EMPLOYEE)
    public String updateEmpl(@ModelAttribute Employee employee){
        service.updEmployee(employee) ;
        return "redirect:/employee/get-all" ;
    }

    @RequestMapping(value = Url.EmployeeUrl.DEL_EMPLOYEES, method = RequestMethod.POST)
    public String delEmployee(@RequestParam(required = false) List<String> ids){
        if(ids != null) {
            service.deleteEmployee(ids);
        }
        return "redirect:/employee/get-all" ;
    }
    @RequestMapping(value = Url.EmployeeUrl.DEL_EMPLOYEE, method = RequestMethod.POST)
    public String delEmployeeSingle(@RequestParam String employeeId){
        service.deleteEmployeeSingle(employeeId) ;
        return "redirect:/employee/get-all" ;
    }

    @RequestMapping(value = Url.EmployeeUrl.ADD_EMPLOYEE, method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee){
        service.addEmployee(employee) ;
        return "redirect:/employee/get-all" ;
    }
}
