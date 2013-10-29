package com.example.mastermind;

import android.app.Application;

public final class  UserScoreState extends Application {
	
	private static UserScoreState scoreStateData;
	private static score userScore;
	

	public score getLogin() {
		return userScore;
	}

	public void setLogin(score userScore) {
		this.userScore = userScore;
	}

	
	@Override
	public void onCreate() {
		super.onCreate();
		scoreStateData = this;
	}

	public static UserScoreState getInstance() {
		return scoreStateData;
	}
}
