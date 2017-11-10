package cn.collabtech.javafx.controller;

import org.apache.log4j.Logger;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public abstract class BaseController implements Initializable{
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(BaseController.class);
	
	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		if (logger.isInfoEnabled()) {
			logger.info("setPrimaryStage(Stage) - start");
		}
		this.primaryStage = primaryStage;
		if (logger.isInfoEnabled()) {
			logger.info("setPrimaryStage(Stage) - end");
		}
	}
	
	

}
