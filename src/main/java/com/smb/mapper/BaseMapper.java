package com.smb.mapper;

import com.smb.entity.Base;

import java.util.List;

public interface BaseMapper<T> {

    public void add(T t);

    public void update(T t);

    public void updateBySelective(T t);

    public void delete(Object id);

    public int queryByCount(Base modle);

    public List<T> queryByList(Base model);

    public T queryById(Object id);
}
