package com.kh.menu.model.vo;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

	public enum MenuTaste {
	MILD("mild") , HOT("hot");
	
	private String value;
	MenuTaste(String value){
		this.value=value;
	}
	
	@JsonValue
	public String getValue() {
		return this.value;
	}
	
	public static MenuTaste MenuTasteValueOf(String value) {
		MenuTaste[] menus = MenuTaste.values();
		for(MenuTaste mt : menus) {
			if(mt.value.equals(value)) return mt;
		}
		throw new AssertionError("Unknown Type : "+value);
	}
}
