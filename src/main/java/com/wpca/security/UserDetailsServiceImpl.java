package com.wpca.security;
import com.wpca.entity.SysUser;
import com.wpca.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.security.UserDetailServiceImpl
 * @Date 2022年07月16日 17:15
 * @Description
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        sysUserService.getByUsername(username);


        SysUser sysUser = sysUserService.getByUsername(username);
        log.info("用户名："+username);
        log.info("通过查到获得数据："+sysUser);

        if(sysUser==null){
            log.info("未查询到数据，用户名或密码不正确");
            throw new UsernameNotFoundException("用户名或密码不正确");
        }



        return new AccountUser(sysUser.getId(),sysUser.getUsername(),sysUser.getPassword(),getUserAuthority(sysUser.getId()));
    }


    //获取用户权限信息 包括菜单
    //通过id进行获取
    public List<GrantedAuthority> getUserAuthority(Long userId){

        //角色管理
        String authority=sysUserService.getUserAuthorityInfo(userId);//ROLE_admin,sys:user:list

        System.out.println(authority);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}
