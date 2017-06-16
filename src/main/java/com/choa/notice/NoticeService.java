package com.choa.notice;


import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choa.util.PageMaker;


@Service
//@Service의 의미 : Notice noticeDao =new NoticeDAO(); 와 같은 것 
public class NoticeService {
	
	
	
	@Qualifier
	private NoticeDAO noticeDAO;
	
	public void test(){
		System.out.println(noticeDAO);
	}
	
	
	/*//생성자(Constructor) 방식
	public NoticeService(NoticeDAO noticeDAO) throws Exception{
		this.noticeDAO =noticeDAO;
	}
	
	//setter 방식 
	public void setNoticeDAO(NoticeDAO noticeDAO) throws Exception{
		this.noticeDAO = noticeDAO;
	}*/
	
	
	
	//view 
	public NoticeDTO noticeView(int num)throws Exception{
		return noticeDAO.noticeView(num);
		
	}
	

	//list
	public List<NoticeDTO> noticeList(int curPage)throws Exception{
		int result =noticeDAO.noticeCount();
		PageMaker pageMaker =new PageMaker(curPage);
		return noticeDAO.noticeList(pageMaker.getRowMaker());
	}
	
	//write 
	public int noticeWrite(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.noticeWrite(noticeDTO);
	}
	
	//update
	public int noticeUpdate(NoticeDTO noticeDTO)throws Exception{
		 return noticeDAO.noticeUpdate(noticeDTO);
	}
	//delete
	public int noticeDelete(int num)throws Exception{
		return noticeDAO.noticeDelete(num);
	}
}
