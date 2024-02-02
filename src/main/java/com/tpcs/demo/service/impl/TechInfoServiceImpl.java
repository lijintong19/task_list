package com.tpcs.demo.service.impl;

import com.tpcs.demo.entity.TechInfo;
import com.tpcs.demo.mapper.TechInfoMapper;
import com.tpcs.demo.service.TechInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 技术节点表 服务实现类
 * </p>
 *
 * @author lijt
 * @since 2024-02-01
 */
@Service
public class TechInfoServiceImpl extends ServiceImpl<TechInfoMapper, TechInfo> implements TechInfoService {

}
