package com.julian5383.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julian5383.model.SellCommentDto;
import com.julian5383.model.SellDto;
import com.julian5383.service.BoardService;

@Controller
public class MainController implements SellInterface{
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	SellDto dto;
	
	@Autowired
	SellCommentDto dto_c;
	
	List<SellDto> list;
	List<SellCommentDto> list_c;

	@Override
	@RequestMapping("/list")
	public String selectAll_sell(String search,Model model) throws Exception {
		// TODO Auto-generated method stub		
		list = boardService.selectall(search);
		model.addAttribute("board", list);
		
		return "sell/sell";
	}

	@Override
	@RequestMapping("/write")
	public String write_sell() throws Exception {
		// TODO Auto-generated method stub
		return "sell/sell_write";
	}

	@Override
	@RequestMapping("/add")
	public String add_sell(String title, String content, MultipartFile photo, int price, String buyornot, String finornot, String write_id) throws Exception {
		// TODO Auto-generated method stub
		
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPrice(price);
		dto.setBuyornot(buyornot);
		dto.setFinornot(finornot);
		dto.setWrite_id(write_id);
		boardService.insert(dto, photo);	
		
		return "redirect:list";
	}

	@Override
	@GetMapping("/view")
	public ModelAndView view_sell(String sell_no, Model model) throws Exception {
		// TODO Auto-generated method stub
		dto=boardService.select(Integer.parseInt(sell_no));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sell/sell_view");
		mv.addObject("sellview", dto);
		
		list_c = boardService.selectall_sc();
		model.addAttribute("sell_c", list_c);
		
		boardService.viewcount(Integer.parseInt(sell_no));
		return mv;
	}

	@Override
	@PostMapping("/edit")
	public String edit_sell(String sell_no,String title, String content, MultipartFile photo, int price, String buyornot,
			String finornot, RedirectAttributes rttr) throws Exception {
		// TODO Auto-generated method stub
		dto.setSell_no(Integer.parseInt(sell_no));
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPrice(price);
		dto.setBuyornot(buyornot);
		dto.setFinornot(finornot);
		boardService.update(dto,photo);
		rttr.addAttribute("sell_no",sell_no);
		
		
		return "redirect:view";
	}

	@Override
	@GetMapping("/remove")
	public String remove_sell(String sell_no) throws Exception {
		// TODO Auto-generated method stub
		boardService.remove(Integer.parseInt(sell_no));
		return "redirect:list";
	}

	@Override
	@PostMapping("/add_comm_sc")
	public String add_sc(String sell_no, String write_id, String content, RedirectAttributes rttr) throws Exception {
		// TODO Auto-generated method stub
		dto_c.setSell_no(Integer.parseInt(sell_no));
		dto_c.setWrite_id(write_id);
		dto_c.setContent(content);
		boardService.insert_sc(dto_c);
		rttr.addAttribute("sell_no",sell_no);
		return "redirect:view";
	}

	@Override
	@PostMapping("/edit_comm_sc")
	public String edit_sc(String id, String sell_no, String content, RedirectAttributes rttr) throws Exception {
		// TODO Auto-generated method stub
		dto_c.setId(Integer.parseInt(id));
		dto_c.setSell_no(Integer.parseInt(sell_no));
		dto_c.setContent(content);
		boardService.update_sc(dto_c);
		rttr.addAttribute("sell_no",sell_no);
		return "redirect:view";
	}

	@Override
	@GetMapping("/remove_comm_sc")
	public String remove_sc(String id, String sell_no, RedirectAttributes rttr) throws Exception {
		// TODO Auto-generated method stub
		boardService.remove_sc(Integer.parseInt(id));
		rttr.addAttribute("sell_no", sell_no);
		return "redirect:view";
	}
	
	

}
