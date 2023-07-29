package com.julian5383.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.julian5383.model.SellDto;
import com.julian5383.model.SellCommentDto;
import com.julian5383.model.BoardDao;

@Service
public class BoardService {

	@Autowired
	BoardDao dao;
	
	public List<SellDto> selectall(String search){
		List<SellDto> list = dao.selectAll_sell(search);
		return list;
	}
	
	public void insert(SellDto dto, MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String path = "E:\\image\\sell";
			UUID uuid = UUID.randomUUID();
			String filename = uuid+"_"+file.getOriginalFilename();
			File saveFile = new File(path, filename);
			file.transferTo(saveFile);
			dto.setPhoto(filename);
			dto.setPhoto_url("/sell/"+filename);
		}
		dao.insert_sell(dto);
	}
	
	public SellDto select(int sell_no) {
		SellDto dto = dao.select_sell(sell_no);
		return dto;
	}
	
	public void update(SellDto dto, MultipartFile file) throws Exception {
		if(!file.isEmpty()) {
			String path = "E:\\image\\sell";
			UUID uuid = UUID.randomUUID();
			String filename = uuid+"_"+file.getOriginalFilename();
			File saveFile = new File(path, filename);
			file.transferTo(saveFile);
			dto.setPhoto(filename);
			dto.setPhoto_url("/sell/"+filename);
		}
		dao.update_sell(dto);
	}
	
	public void remove(int sell_no) {
		dao.delete_sell(sell_no);
	}
	
	public void viewcount(int sell_no) {
		dao.viewcount(sell_no);
	}
	
	//중고 게시물 댓글
	public List<SellCommentDto> selectall_sc(){
		List<SellCommentDto> list = dao.selectAll_sc();
		return list;
	}
	
	public void insert_sc(SellCommentDto dto) throws Exception {
		dao.insert_sc(dto);
	}
	
	public void update_sc(SellCommentDto dto) throws Exception {
		dao.update_sc(dto);
	}
	
	public void remove_sc(int id) {
		dao.delete_sc(id);
	}
}
