package com.wjchen.demo.common.config;

import com.wjchen.demo.model.User;
import com.wjchen.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;

import static com.alibaba.druid.sql.parser.Token.BY;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    @Lazy// 让shiro先于service加载
    private UserService userService;
    /**
     * 权限认证 ，告知shiro当前登录用户拥有的权限及角色信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//获取登录的用户信息
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        if(user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            // 角色与权限字符串集合
//            Collection<String> rolesCollection = new HashSet<>();
//            Collection<String> premissionCollection = new HashSet<>();
//            // 读取并赋值用户角色与权限
//            Set<RoleBean> roles = user.getRole();
//            for(RoleBean role : roles){
//                rolesCollection.add(role.getName());
//                Set<PermissionBean> permissions = role.getPermissions();
//                for (PermissionBean permission : permissions){
//                    premissionCollection.add(permission.getUrl());
//                }
//                info.addStringPermissions(premissionCollection);
//            }
//            info.addRoles(rolesCollection);
            return info;
        }
        return null;
    }

    /**
     * 身份认证 登陆时判定用户身份信息
     * @param authenticationToken 身份令牌
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.authenticationToken 中保存了用户的登陆信息，
        // 即前台登陆页面用户输入的用户名密码
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        //2.根据用户名查询用户信息
        User user = userService.getByUsername(username);
        //如果用户不存在，返回null 登陆验证不通过
        if(user==null){
            throw new UnknownAccountException();
        }
        //3.如果存在，则返回一个AuthenticationInfo对象，
        // shiro会根据返回对象进行身份认证
        /**
         * 身份认证对象构造
         * 参数1：指定需要保存到session中的对象
         * 参数2：数据库中存储的密码
         * 参数3：盐值  md5加密中使用的盐(一个字符串)，该值需要保存到数据库
         * 参数4：realm的名称
         */
        SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(user,user.getPassword(),"");
        return info;

    }


    // 模拟Shiro用户加密，假设用户密码为123456
    public static void main(String[] args){
        // 用户名
        String username = "zhangsan";
        // 用户密码
        String password = "123456";
        // 加密方式
        String hashAlgorithName = "MD5";
        // 加密次数
        int hashIterations = 221;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        Object obj = new SimpleHash(hashAlgorithName, password,
                credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}
