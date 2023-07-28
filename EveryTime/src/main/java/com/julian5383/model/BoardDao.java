package com.julian5383.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDao {
	//게시물 관리
	public List<SellDto> selectAll_sell(String search) throws DataAccessException;
	
	public void insert_sell(SellDto dto)throws DataAccessException;
	
	public SellDto select_sell(int sell_no)throws DataAccessException;
	
	public void update_sell(SellDto dto)throws DataAccessException;
	
	public void delete_sell(int sell_no)throws DataAccessException;
	
	public void viewcount(int sell_no) throws DataAccessException;
	
	// 댓글관리
	public List<SellCommentDto> selectAll_sc() throws DataAccessException;
	
	public void insert_sc(SellCommentDto dto)throws DataAccessException;
	
	public SellCommentDto select_sc(int id)throws DataAccessException;
	
	public void update_sc(SellCommentDto dto)throws DataAccessException;
	
	public void delete_sc(int id)throws DataAccessException;
}
