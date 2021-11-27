package com.study.spring.case02.pagers;

public class Pager2 {
	private Integer id;
	private Color redcolor;
	private Size b5size;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Color getRedcolor() {
		return redcolor;
	}
	public void setRedcolor(Color redcolor) {
		this.redcolor = redcolor;
	}
	public Size getB5size() {
		return b5size;
	}
	public void setB5size(Size b5size) {
		this.b5size = b5size;
	}
	@Override
	public String toString() {
		return "Pager2 [id=" + id + ", redcolor=" + redcolor + ", b5size=" + b5size + "]";
	}
	

	
	
}
