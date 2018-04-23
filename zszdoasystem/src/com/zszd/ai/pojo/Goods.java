package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private int goodsStock;
	private Date addGoodsTime;
	private String goodsImagesPath;

	public String getGoodsImagesPath() {
		return goodsImagesPath;
	}

	public void setGoodsImagesPath(String goodsImagesPath) {
		this.goodsImagesPath = goodsImagesPath;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}

	public String getAddGoodsTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(addGoodsTime);
	}

	public void setAddGoodsTime(Date addGoodsTime) {
		this.addGoodsTime = addGoodsTime;
	}

}
