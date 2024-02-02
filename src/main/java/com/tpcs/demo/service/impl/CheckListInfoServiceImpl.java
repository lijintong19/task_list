package com.tpcs.demo.service.impl;

import com.tpcs.demo.entity.CheckListInfo;
import com.tpcs.demo.mapper.CheckListInfoMapper;
import com.tpcs.demo.service.CheckListInfoService;

import lombok.AllArgsConstructor;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * checkList步骤描述表 服务实现类
 * </p>
 *
 * @author lijt
 * @since 2024-01-09
 */
@Service
@AllArgsConstructor
public class CheckListInfoServiceImpl extends ServiceImpl<CheckListInfoMapper, CheckListInfo> implements CheckListInfoService {

}
