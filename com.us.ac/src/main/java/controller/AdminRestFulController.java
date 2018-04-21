package controller;

import entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;

import java.util.List;

/**
 * @author trafalgar
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminRestFulController {

    private static Logger logger = LoggerFactory.getLogger(AdminRestFulController.class);

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Admin> selectAdmins(){
        return adminService.listAdmin();
    }


    @RequestMapping(value = "/{aid}",method = RequestMethod.GET)
    public Admin selectAdminById(@PathVariable("aid")Long id){
        return adminService.selectAdminById(id);
    }

    @RequestMapping(value = "/{aid}",method = RequestMethod.PUT)
    public void insertNewAdmin(@PathVariable("aid")Long id,
                               @Param("authority")String authority,
                               @Param("password")String password){
        Admin admin = new Admin();
        admin.setAid(id);
        admin.setAuthority(authority);
        admin.setPassword(password);
        adminService.updateAdminById(id,admin);
    }

    @RequestMapping(value = "/{aid}",method = RequestMethod.DELETE)
    public void deleteAdminById(@PathVariable("aid")Long id){
        adminService.deleteAdminById(id);
    }

     @RequestMapping(value = "/{aid}",method = RequestMethod.POST)
    public void insertNewAdmin(@PathVariable("aid")Long id,
                               @Param("aname")String aname,
                               @Param("password")String password,
                               @Param("authority")String authority){
        adminService.insertAdmin(aname,password);
    }
}