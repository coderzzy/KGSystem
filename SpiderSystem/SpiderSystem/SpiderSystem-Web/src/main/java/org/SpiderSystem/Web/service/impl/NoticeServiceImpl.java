package org.SpiderSystem.Web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.SpiderSystem.Web.dao.NoticeMapper;
import org.SpiderSystem.Web.pojo.Notice;
import org.SpiderSystem.Web.service.INoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoticeServiceImpl implements INoticeService{
	
	@Resource
    public NoticeMapper noticeMapper;

	@Override
	public Notice getNoticeById(int noticeId) {
		// TODO Auto-generated method stub
		return noticeMapper.selectByPrimaryKey(noticeId);
	}

	@Override
	public int getNoticesCount() {
		// TODO Auto-generated method stub
		return noticeMapper.getNoticesCount();
	}

	@Override
	public List<Notice> getNoticesPage(int pageNO, int size) {
		// TODO Auto-generated method stub
		int skip=(pageNO-1)*size;
		return noticeMapper.getNoticesPage(skip, size);
	}

	@Override
	public boolean addNotice(int noticeId, String noticeText) {
		// TODO Auto-generated method stub
		int result = noticeMapper.insertSelective(new Notice(noticeId,noticeText));
		if(result <= 0){
			return false;
		}
		return true;
	}

}
