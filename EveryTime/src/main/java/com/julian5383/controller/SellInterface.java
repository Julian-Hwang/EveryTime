package com.julian5383.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SellInterface {
	public String selectAll_sell(String search,Model model) throws Exception;
	
	public String write_sell() throws Exception;
	
	public String add_sell(
			@RequestParam(value="title")String title,
			@RequestParam(value="content")String content,
			@RequestParam(value="photo")MultipartFile photo,
			@RequestParam(value="price")int price,
			@RequestParam(value="buyornot")String buyornot,
			@RequestParam(value="finornot") String finornot,
			@RequestParam(value="write_id") String write_id) throws Exception;
	
	public ModelAndView view_sell(@RequestParam(value="sell_no")String sell_no, Model model) throws Exception;
	
	public String edit_sell(
			@RequestParam(value="id")String sell_no,
			@RequestParam(value="title")String title,
			@RequestParam(value="content")String content,
			@RequestParam(value="photo")MultipartFile photo,
			@RequestParam(value="price")int price,
			@RequestParam(value="buyornot")String buyornot,
			@RequestParam(value="finornot")String finornot,
			RedirectAttributes rttr) throws Exception;
	
	public String remove_sell(@RequestParam(value="sell_no")String sell_no) throws Exception;
	
	public String add_sc(
			@RequestParam(value="id")String sell_no,
			@RequestParam(value="writer")String write_id,
			@RequestParam(value="com_con")String content,
			RedirectAttributes rttr) throws Exception;

	public String edit_sc(
			@RequestParam(value="id")String id,
			@RequestParam(value="sell_no")String sell_no,
			@RequestParam(value="com_con")String content,
			RedirectAttributes rttr) throws Exception;
	
	public String remove_sc(
			@RequestParam(value="id")String id,
			@RequestParam(value="sell_no")String sell_no,
			RedirectAttributes rttr) throws Exception;
}
