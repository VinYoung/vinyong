package com.vin.data.mapper;

import com.vin.web.model.RoleModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleDao {

    /**
     * 查询所有角色
     *
     * @return
     */
    public RoleModel select();
}
