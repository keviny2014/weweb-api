package com.weweb.po.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.weweb.po.entity.PoVendor;

@Mapper
public interface PoVendorDao {

    List<PoVendor> listVendors();

}