package com.choa.ex2;



import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject  //type
	private NoticeService noticeService;
	
	@RequestMapping(value="test")
	public void test(){
		System.out.println(noticeService);
		noticeService.test();
	}
	
	@RequestMapping(value="NoticeList" , method=RequestMethod.GET)
	public void NoticeList(Model model, @RequestParam(defaultValue="1")Integer curPage)throws Exception{
		List<NoticeDTO> ar =noticeService.noticeList(curPage);
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value="NoticeView" , method=RequestMethod.GET)
	public void NoticeView(Model model,Integer num)throws Exception{
	/*	if(num==null){
			
		}*/
		NoticeDTO noticeDTO=noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
		//if 성공 실패
		
	}
	//writeForm
	@RequestMapping(value="NoticeWrite" , method=RequestMethod.GET)
	public void NoticeWrite(Model model){
		
		model.addAttribute("path", "Write");
	}
	
	
	//write
	@RequestMapping(value="NoticeWrite" , method=RequestMethod.POST)
	public String NoticeWrite(NoticeDTO noticeDTO , RedirectAttributes rd)throws Exception{
		int result=noticeService.noticeWrite(noticeDTO);
		String message ="fail";
		if(result>0){
			message ="success";
		}
		//if 성공 실패
		rd.addFlashAttribute("message", message);
		return "redirect:NoticeList?curPage=2";
	}
	//updateForm
		@RequestMapping(value="NoticeUpdate", method=RequestMethod.GET)
		public String noticeUpdate(Integer num, Model model) throws Exception{
			NoticeDTO noticeDTO = noticeService.noticeView(num);
			model.addAttribute("dto", noticeDTO);
			model.addAttribute("path", "Update");
			return "notice/NoticeWrite";
		}
	
	
	//update
	@RequestMapping(value="NoticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd) throws Exception{
		int result = noticeService.noticeUpdate(noticeDTO);
		System.out.println("값:" + noticeDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:NoticeList?curPage=1";
	}
	
	@RequestMapping(value="NoticeDelete" , method=RequestMethod.GET)
	public String NoticeDelete(Integer num , RedirectAttributes rd)throws Exception{
		int result =noticeService.noticeDelete(num);
		String message = "failed";
		//if 성공 실패
		if(result>0){
			message ="success";
		}
		
		rd.addFlashAttribute("message", message);
		return "redirect:NoticeList";
	}

}
