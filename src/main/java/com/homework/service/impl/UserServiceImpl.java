package com.homework.service.impl;
//
//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.crypto.SecureUtil;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.entity.User;
import com.homework.mapper.UserMapper;
import com.homework.service.UserService;
//import com.homework.shior.AccountProfile;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author haibo
 * @since 2018-11-19
 */
//@Service
//public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void join(IPage<Map<String, Object>> pageData, String linkfield) {
        List<Map<String, Object>> records = pageData.getRecords();

        records.forEach(map -> {
            String userId = map.get(linkfield).toString();
            User user = this.getById(userId);

            Map<String, Object> author = new HashMap<>();
            author.put("username", user.getUsername());
            author.put("avatar", user.getAvatar());
            author.put("id", user.getId());

            map.put("author", author);
        });
    }

//    @Override
//    public AccountProfile login(String email, String password) {
//        // log.info("------------>进入用户登录判断，获取用户信息步骤");
//
//        User user = this.getOne(new QueryWrapper<User>().eq("email", email));
//        if(user == null) {
//            throw new UnknownAccountException("账户不存在");
//        }
//
//        if(!user.getPassword().equals(password)) {
//            throw new IncorrectCredentialsException("密码错误");
//        }
//
//        //更新最后登录时间
//        user.setLasted(new Date());
//        user.updateById();
//
//        AccountProfile profile = new AccountProfile();
//
//        BeanUtil.copyProperties(user, profile);
//
//        //把通知和私信数量查出来
//
//
//
//        return profile;
//    }
//
//    @Override
//    @Transactional
//    public R register(User user) {
//
//        if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())
//                || StringUtils.isEmpty(user.getUsername())) {
//            return R.failed("必要字段不能为空");
//        }
//
//        User po = this.getOne(new QueryWrapper<User>().eq("email", user.getEmail()));
//        if(po != null) {
//            return R.failed("邮箱已被注册");
//        }
//
//        String passMd5 = SecureUtil.md5(user.getPassword());
//
//        po = new User();
//        po.setEmail(user.getEmail());
//        po.setPassword(passMd5);
//        po.setCreated(new Date());
//        po.setUsername(user.getUsername());
//        po.setAvatar("/images/avatar/default.png");
//        po.setPoint(0);
//
//        return this.save(po)? R.ok("") : R.failed("注册失败");
//
//    }
//
//    @Override
//    public void join(Map<String, Object> map, String field) {
//
//        Map<String, Object> joinColumns = new HashMap<>();
//        //字段的值
//        String linkfieldValue = map.get(field).toString();
//
//        User user = this.getById(linkfieldValue);
//
//        joinColumns.put("username", user.getUsername());
//        joinColumns.put("email", user.getEmail());
//        joinColumns.put("avatar", user.getAvatar());
//        joinColumns.put("id", user.getId());
//
//        map.put("author", joinColumns);
//   }

}
