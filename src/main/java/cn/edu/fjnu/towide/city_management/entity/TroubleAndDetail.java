package cn.edu.fjnu.towide.city_management.entity;

import org.apache.catalina.User;

public class TroubleAndDetail extends TroubleOperation{
	private Trouble trouble;

	public Trouble getTrouble() {
		return trouble;
	}

	public void setTrouble(Trouble trouble) {
		this.trouble = trouble;
	}

	@Override
	public String toString() {
		return "TroubleAndDetail [trouble=" + trouble + "]";
	}
	

}
