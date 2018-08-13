package com.example.demo.service.impl;

import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.GroupRightRel;
import com.example.demo.entity.dao.Right;
import com.example.demo.entity.dao.UserGroup;
import com.example.demo.entity.dao.UserGroupRel;
import com.example.demo.mapper.GroupRightRelMapper;
import com.example.demo.mapper.RightMapper;
import com.example.demo.mapper.UserGroupMapper;
import com.example.demo.mapper.UserGroupRelMapper;
import com.example.demo.service.RightService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@Service
public class RightServiceImpl extends ServiceImpl<RightMapper, Right> implements RightService {

    @Autowired
    private UserGroupRelMapper userGroupRelMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private GroupRightRelMapper groupRightRelMapper;

    @Autowired
    private RightMapper rightMapper;

    @Override
    public BaseResponse getRightTree(Integer userId) {
        Map<String,Object> params = new HashMap<>(1);
        params.put("user_id",userId);
        List<UserGroupRel> userGroupRels = userGroupRelMapper.selectByMap(params);

        List<UserGroup> groups = new ArrayList<>();
        for (UserGroupRel rel : userGroupRels){
            groups.add(userGroupMapper.selectById(rel.getGroupId()));
        }

        List<GroupRightRel> groupRightRels = new ArrayList<>();
        for (UserGroup group:groups){
            params = new HashMap<>(1);
            params.put("group_id",group.getId());
            groupRightRels.addAll(groupRightRelMapper.selectByMap(params));
        }

        params = new HashMap<>(2);

        params.put("parent_id",0);
        List<Right> rights = new ArrayList<>();
        for (GroupRightRel rightRel : groupRightRels){
            params.put("id",rightRel.getRightId());
            rights.addAll(rightMapper.selectByMap(params));
        }

        Map<String,Object> result = null;
        List<Right> list = null;
        List<Map<String,Object>> r = new ArrayList<>();
        for (Right right : rights){
            params.put("parent_id",right.getId());
            list = new ArrayList<>();
            for (GroupRightRel rightRel : groupRightRels){
                params.put("id",rightRel.getRightId());
                list.addAll(rightMapper.selectByMap(params));
            }
            result = new HashMap<>(2);
            result.put("children",list);
            result.put("parent",right);
            r.add(result);
        }

        return ResponseUtil.successResponse(r);
    }
}
