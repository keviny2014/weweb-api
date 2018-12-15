package com.weweb.po.service;

import java.util.List;

import com.weweb.po.mapper.PoVendorDao;
import org.springframework.beans.factory.annotation.Autowired;

import com.weweb.po.entity.PoVendor;
import org.springframework.stereotype.Service;

@Service
public class PoVendorService {
    @Autowired
    private PoVendorDao poVendorDao;
    public List<PoVendor> listVendors(){
        return poVendorDao.listVendors();
    }
}