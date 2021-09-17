package com.lzk.springcloud.dao;

import entities.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 13997
 */
@Mapper
public interface PaymentDao {
    /**
     * 新加一个
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 得到id
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") long id);

}
