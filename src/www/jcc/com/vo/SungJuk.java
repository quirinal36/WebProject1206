package www.jcc.com.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SungJuk {
	String username; // 이름
	int scratch;
	int entry;
	int cLanguage;
	int java;
	int python;
	int math;
	
	public int sum() {
		int result = 0;
		result += this.scratch;
		result += this.entry;
		result += this.cLanguage;
		result += this.java;
		result += this.python;
		result += this.math;
		return result;
	}
	
	public double average() {
		double subjects = 6.0;
		return sum() / subjects;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScratch() {
		return scratch;
	}
	public void setScratch(int scratch) {
		this.scratch = scratch;
	}
	public int getEntry() {
		return entry;
	}
	public void setEntry(int entry) {
		this.entry = entry;
	}
	public int getcLanguage() {
		return cLanguage;
	}
	public void setcLanguage(int cLanguage) {
		this.cLanguage = cLanguage;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getPython() {
		return python;
	}
	public void setPython(int python) {
		this.python = python;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}	
