package com.g0818.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.g0818.mapper.StartTimeMapper;
import com.g0818.pojo.StartTime;
import com.g0818.service.StartTimeService;
import org.springframework.stereotype.Service;

@Service
public class StartTimeServiceImpl extends ServiceImpl<StartTimeMapper, StartTime> implements StartTimeService {
}
