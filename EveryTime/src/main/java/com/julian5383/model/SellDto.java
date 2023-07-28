package com.julian5383.model;

import org.springframework.stereotype.Component;

@Component
public class SellDto {
	private int sell_no;
	private String title;
	private String content;
	private String photo;
	private String photo_url;
	private int price;
	private String buyornot;
	private String finornot;
	private String write_id;
	private int view;
	private String write_date;
	private String update_date;
	public int getSell_no() {
		return sell_no;
	}
	public void setSell_no(int sell_no) {
		this.sell_no = sell_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBuyornot() {
		return buyornot;
	}
	public void setBuyornot(String buyornot) {
		this.buyornot = buyornot;
	}
	public String getFinornot() {
		return finornot;
	}
	public void setFinornot(String finornot) {
		this.finornot = finornot;
	}
	public String getWrite_id() {
		return write_id;
	}
	public void setWrite_id(String write_id) {
		this.write_id = write_id;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
	
}
