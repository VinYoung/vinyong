package com.vin.data.mapper;

import com.vin.web.model.PermissionModel;
import com.vin.web.model.RoleModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IPermissionDao {

    /**
     * 查询该角色的所有权限
     *
     * @return
     */
    public List<PermissionModel> select(RoleModel role);
}
