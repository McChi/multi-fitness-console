package com.stylefeng.guns.modular.club.service.impl;

import com.stylefeng.guns.modular.system.model.ClubAdv;
import com.stylefeng.guns.modular.system.dao.ClubAdvMapper;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.club.service.IClubAdvService;
import com.stylefeng.guns.modular.club.warpper.ClubAdvWarpper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告表 服务实现类
 * </p>
 *
 * @author guiyj007123
 * @since 2018-10-10
 */
@Service
public class ClubAdvServiceImpl extends ServiceImpl<ClubAdvMapper, ClubAdv> implements IClubAdvService {
	/**
     * <p>
     * 分页列表查询
     * </p>
     *
     * @param page 分页查询条件
     * @param clubId   俱乐部id
     * @param condition   其他模糊查询条件
     * @return List<>
     */
	@SuppressWarnings("unchecked")
	@Override
	public Page<ClubAdv> pageList(Page<ClubAdv> page, Integer clubId, String condition) {
    	
    	Wrapper<ClubAdv> ew = new EntityWrapper<>();
    	if (ToolUtil.isNotEmpty(clubId) && !clubId.equals(0)) {
    		ew = ew.eq("club_id", clubId);
    	}
    	if (ToolUtil.isNotEmpty(condition)) {
//    		ew = ew.like("nickname", condition).or().like("realname", condition);
    	}
    	
    	List<Map<String, Object>> result = baseMapper.selectMapsPage(page, ew);
        return page.setRecords( (List<ClubAdv>) new ClubAdvWarpper(result).warp());
	}
}
